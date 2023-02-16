{
    Board[NR] = $0
}
END {
    for (row in Board)
        for (col = length(Board[row]); col > 0; --col)
            totalSquares += squares(row, col)

    print +totalSquares
}

function squares(row, col) {
    return 0
}

function symbol(row, col) {
    return substr(Board[row], col, 1)
}

function isCross(row, col) {
    return symbol(row, col) == "+"
}

function isLine(row, col) {
    return symbol(row, col) ~ /\|\+-/
}
