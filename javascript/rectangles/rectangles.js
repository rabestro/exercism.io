export function count(diagram) {
    const board = new Board(diagram);
    return board.rectangles();
}

class Board {
    constructor(diagram) {
        this._diagram = diagram;
        this._rows = diagram.length;
        this._cols = diagram[0]?.length ?? 0;
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
        if (this.isNotCross(rowA, colA)) {
            return 0;
        }

        let total = 0;
        for (let colB = colA + 1; this.isHorizontalSymbol(rowA, colB); ++colB) {
            total += this.cornerB(rowA, colA, colB)
        }
        return total
    }

    cornerB(rowA, colA, colB, rowC) {
        if (this.isNotCross(rowA, colB)) {
            return 0;
        }

        let total = 0;
        for (rowC = rowA + 1; this.isVerticalSymbol(rowC, colB); ++rowC) {
            total += this.cornerC(rowA, colA, colB, rowC)
        }
        return total
    }

    cornerC(rowA, colA, colB, rowC) {
        if (this.isNotCross(rowC, colA)) return 0;

        for (let i = colB - 1; i > colA; --i) {
            if (!this.isHorizontalSymbol(rowC, i)) return 0
        }
        for (let i = rowC - 1; i > rowA; --i) {
            if (!this.isVerticalSymbol(i, colA)) return 0
        }

        return 1
    }

    symbol(row, col) {
        const line = this._diagram.at(row);
        return line.charAt(col);
    }

    isNotCross(row, col) {
        return this.symbol(row, col) !== '+'
    }

    isHorizontalSymbol(row, col) {
        return col < this._cols && '-+'.includes(this.symbol(row, col));
    }

    isVerticalSymbol(row, col) {
        return row < this._rows && '|+'.includes(this.symbol(row, col));
    }
}
