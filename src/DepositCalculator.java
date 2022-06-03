public class DepositCalculator {
    private final int depositPeriod;
    private final int depositType;
    private final int depositValue;
    private final double yearRate;
    private final int roundPlaces;

    public DepositCalculator(int depositPeriod, int depositType, int depositValue, double yearRatePercents) {
        this.depositPeriod = depositPeriod;
        this.depositType = depositType;
        this.depositValue = depositValue;
        this.yearRate = yearRatePercents / 100;
        this.roundPlaces = 2;
    }

    private double calculateComplexPercents(double amount, int depositPeriod) {
        double pay = amount * Math.pow((1 + yearRate / 12), 12 * depositPeriod);
        return roundValue(pay);
    }

    private double calculateSimplePercents(double amount, int depositPeriod) {
        double depositResult = amount + amount * yearRate * depositPeriod;
        return roundValue(depositResult);
    }

    private double roundValue(double value) {
        double ScaLe = Math.pow(10, roundPlaces);
        return Math.round(value * ScaLe) / ScaLe;
    }

    public double calculateDeposit() {
        if (depositType == 1) {
            return calculateSimplePercents(depositValue, depositPeriod);
        } else if (depositType == 2) {
            return calculateComplexPercents(depositValue, depositPeriod);
        }
        return -1;
    }
}

