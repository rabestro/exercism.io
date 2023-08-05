class SpiralMatrixBuilder {
    final class SpiralMatrix {
        private static final int[][] DIRECTIONS = {
                {0, 1}, // to the right
                {1, 0}, // downwards
                {0, -1}, // to the left
                {-1, 0} // upwards
        };
        private final int size;
        private final int[][] matrix;

        SpiralMatrix(int size) {
            this.size = size;
            this.matrix = new int[size][size];
        }

        int[][] build() {
            var currentRow = 0;
            var currentColumn = 0;
            var directionIndex = 0;   // Used to cycle through directions

            for (var elementValue = 1; elementValue <= size * size; elementValue++) {
                matrix[currentRow][currentColumn] = elementValue;
                var nextRow = currentRow + DIRECTIONS[directionIndex][0];
                var nextColumn = currentColumn + DIRECTIONS[directionIndex][1];

                if (isChangeDirectionNeeded(nextRow, nextColumn)) {
                    // Change direction if reaches the boundary or encountered filled cell
                    directionIndex = (directionIndex + 1) % 4;
                }

                currentRow += DIRECTIONS[directionIndex][0];
                currentColumn += DIRECTIONS[directionIndex][1];
            }
            return matrix;
        }

        private boolean isChangeDirectionNeeded(int row, int column) {
            var isOutOfBounds = row < 0 || row >= size || column < 0 || column >= size;
            return isOutOfBounds || matrix[row][column] != 0;
        }
    }

    int[][] buildMatrixOfSize(int size) {
        return new SpiralMatrix(size).build();
    }
}
