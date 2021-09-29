public class CarsAssemble {

    public double productionRatePerHour(int speed) {
        return cars(speed) / 100.0;
    }

    public int workingItemsPerMinute(int speed) {
        return cars(speed) / 6000;
    }

    private int cars(int speed) {
        int successRate = speed < 5 ? 100
                : speed < 9 ? 90
                : speed < 10 ? 80
                : 77;
        return successRate * 221 * speed;
    }
}
