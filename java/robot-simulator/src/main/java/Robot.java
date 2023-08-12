class Robot {

    private GridPosition gridPosition;
    private Orientation orientation;

    public Robot(GridPosition initialGridPosition, Orientation initialOrientation) {
        gridPosition = initialGridPosition;
        orientation = initialOrientation;
    }

    public Orientation getOrientation() {
        return orientation;
    }

    public GridPosition getGridPosition() {
        return gridPosition;
    }

    public void turnRight() {
        orientation = switch (orientation) {
            case EAST -> Orientation.SOUTH;
            case WEST -> Orientation.NORTH;
            case SOUTH -> Orientation.WEST;
            case NORTH -> Orientation.EAST;
        };
    }

    public void turnLeft() {
        orientation = switch (orientation) {
            case NORTH -> Orientation.WEST;
            case SOUTH -> Orientation.EAST;
            case WEST -> Orientation.SOUTH;
            case EAST -> Orientation.NORTH;
        };
    }

    public void advance() {
        gridPosition = switch (orientation) {
            case NORTH -> new GridPosition(gridPosition.x, gridPosition.y + 1);
            case SOUTH -> new GridPosition(gridPosition.x, gridPosition.y - 1);
            case WEST -> new GridPosition(gridPosition.x - 1, gridPosition.y);
            case EAST -> new GridPosition(gridPosition.x + 1, gridPosition.y);
        };
    }

    public void simulate(String action) {
        for (char c : action.toCharArray()) {
            switch (c) {
                case 'R' -> turnRight();
                case 'L' -> turnLeft();
                case 'A' -> advance();
            }
        }
    }
}
