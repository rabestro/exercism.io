class SpiralMatrixBuilder {
    private static final int[][] DELTA = {
            {0, 1}, // right
            {1, 0}, // down
            {0, -1}, // left
            {-1, 0} // up
    };

    int[][] buildMatrixOfSize(int size) {
        var matrix = new int[size][size];
        var row = 0;
        var col = 0;
        var direction = 0;

        for (var i = 1; i <= size * size; i++) {
            matrix[row][col] = i;
            var nextRow = row + DELTA[direction][0];
            var nextCol = col + DELTA[direction][1];
            var isOutOfBounds = nextRow < 0 || nextRow >= size || nextCol < 0 || nextCol >= size;
            if (isOutOfBounds || matrix[nextRow][nextCol] != 0) {
                direction = (direction + 1) % 4;
            }
            row += DELTA[direction][0];
            col += DELTA[direction][1];
        }
        return matrix;
    }

}
