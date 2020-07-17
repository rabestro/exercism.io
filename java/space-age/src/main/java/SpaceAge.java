class SpaceAge {
    private final double seconds;

    SpaceAge(double seconds) {
        this.seconds = seconds;
    }

    double getSeconds() {
        return seconds;
    }

    double onEarth() {
        return seconds / 31557600;
    }

    double onMercury() {
        return onEarth() / 0.2408467;
    }

    double onVenus() {
        return onEarth() / 0.61519726;
    }

    double onMars() {
        throw new UnsupportedOperationException("Delete this statement and write your own implementation.");
    }

    double onJupiter() {
        throw new UnsupportedOperationException("Delete this statement and write your own implementation.");
    }

    double onSaturn() {
        throw new UnsupportedOperationException("Delete this statement and write your own implementation.");
    }

    double onUranus() {
        throw new UnsupportedOperationException("Delete this statement and write your own implementation.");
    }

    double onNeptune() {
        throw new UnsupportedOperationException("Delete this statement and write your own implementation.");
    }

}
