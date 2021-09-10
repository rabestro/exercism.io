public class CarsAssemble {

    public double productionRatePerHour(int speed) {
        return successRate(speed) * 221 * speed / 100.0;

    }

    public int workingItemsPerMinute(int speed) {
        return successRate(speed) * 221 * speed / 6000;
    }

    private int successRate(int speed) {
        return speed < 5 ? 100
                : speed < 9 ? 90
                : speed < 10 ? 80
                : 77;
    }
}
