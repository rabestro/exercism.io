class ArmstrongNumbers {

    boolean isArmstrongNumber(int numberToCheck) {
        for (int i = numberToCheck, pow = (i + "").length(); i > 0; i /= 10) {
            final int digit = i % 10;
            int power = 1;
            for (int j = 0; j < pow; j++) {
                power *= digit;
            }
            numberToCheck -= power;
        }
        return numberToCheck == 0;
    }

}
