BEGIN {
    VerticalLine = @/[|+]/
    HorizontalLine = @/[-+]/
    delete Board
}
{
    Board[NR] = $0
}
END {
    Height = length(Board)

    for (row in Board) {
        Width = length(Board[row])
        for (col = 1; col <= Width; ++col) {
            total += cornerA(row, col)
        }
    }
    print +total
}

function cornerA(rowA, colA,   total,colB) {
    if (!isCross(rowA, colA)) return 0
    for (colB = colA + 1; isHorizontalLine(rowA, colB); ++colB) {
        total += cornerB(rowA, colA, colB)
    }
    return +total
}

function cornerB(rowA, colA, colB,   rowC,total) {
    if (!isCross(rowA, colB)) return 0
    for (rowC = rowA + 1; isVerticalLine(rowC, colB); ++rowC) {
        total += cornerC(rowA, colA, colB, rowC)
    }
    return +total
}

function cornerC(rowA, colA, colB, rowC) {
    if (!isCross(rowC, colA)) return 0
    return 1
}

function symbol(row, col) {
    return substr(Board[row], col, 1)
}

function isCross(row, col) {
    return symbol(row, col) == "+"
}

function isVerticalLine(row, col) {
    return row <= Height && symbol(row, col) ~ VerticalLine
}

function isHorizontalLine(row, col) {
    return col <= Width && symbol(row, col) ~ HorizontalLine
}
