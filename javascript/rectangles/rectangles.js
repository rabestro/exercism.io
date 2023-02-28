export function count(diagram) {
    return new Board(diagram).rectangles();
}

const HYPHEN = 45;
const PLUS_SIGN = 43;
const VERTICAL_BAR = 124;

class Board {
    /**
     * Can handle an unlimited number of lines
     * But no more than 64 characters per line
     *
     * @param diagram
     */
    constructor(diagram) {
        this._rows = diagram.length;
        this._cols = diagram[0]?.length ?? 0;
        this._horizontal = [];
        this._vertical = [];
        for (let row = 0; row < this._rows; ++row) {
            for (let col = 0; col < this._cols; ++col) {
                const symbol = diagram[row].codePointAt(col);
                if (symbol === PLUS_SIGN || symbol === HYPHEN)
                    this._horizontal[row] |= 1 << col;
                if (symbol === PLUS_SIGN || symbol === VERTICAL_BAR)
                    this._vertical[row] |= 1 << col;
            }
        }
    }

    rectangles() {
        let rectanglesCount = 0;
        for (let row = 0; row < this._rows; ++row) {
            for (let col = 0; col < this._cols; ++col) {
                rectanglesCount += this.cornerA(row, col);
            }
        }
        return rectanglesCount;
    }

    cornerA(rowA, colA) {
        if (this.isNotCross(rowA, colA)) return 0;
        let total = 0;
        for (let colB = colA + 1; this.isHorizontalSymbol(rowA, colB); ++colB) {
            total += this.cornerB(rowA, colA, colB)
        }
        return total
    }

    cornerB(rowA, colA, colB, rowC) {
        if (this.isNotCross(rowA, colB)) return 0;
        let total = 0;
        for (rowC = rowA + 1; this.isVerticalSymbol(rowC, colA) && this.isVerticalSymbol(rowC, colB); ++rowC) {
            total += this.cornerC(rowA, colA, colB, rowC)
        }
        return total
    }

    cornerC(rowA, colA, colB, rowC) {
        if (this.isNotCross(rowC, colB) || this.isNotCross(rowC, colA)) return 0;
        for (let i = colB - 1; i > colA; --i) {
            if (!this.isHorizontalSymbol(rowC, i)) return 0
        }
        return 1
    }

    isNotCross(row, col) {
        return !(this.isHorizontalSymbol(row, col) && this.isVerticalSymbol(row, col));
    }

    isHorizontalSymbol(row, col) {
        return col < this._cols && (this._horizontal[row] & 1 << col)
    }

    isVerticalSymbol(row, col) {
        return row < this._rows && (this._vertical[row] & 1 << col)
    }
}
