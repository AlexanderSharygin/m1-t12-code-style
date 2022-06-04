import java.util.Scanner;

public class DepositCalculator {
    double calculateComplexPercent(double summ, double yearRate, int period) {
        double pay = summ * Math.pow((1 + yearRate / 12), 12 * period);
        return calculateRound(pay, 2);
    }

    double calculateSimplePercent(double summ, double yearRate, int depositPeriod) {
        return calculateRound(summ + summ * yearRate * depositPeriod, 2);
    }

    double calculateRound(double value, int signs) {
        double scaLe = Math.pow(10, signs);
        return Math.round(value * scaLe) / scaLe;
    }

    void calculateDepositParameters() {
        int period;
        int action;
        int amount;
        double out;
        Scanner input = new Scanner(System.in);

        System.out.println("Введите сумму вклада в рублях:");
        amount = input.nextInt();
        System.out.println("Введите срок вклада в годах:");
        period = input.nextInt();
        System.out.println("Выберите тип вклада, 1 - вклад с обычным процентом, 2 - вклад с капитализацией:");
        action = input.nextInt();
        out = 0;
        if (action == 1) {
            out = calculateSimplePercent(amount, 0.06, period);
        } else if (action == 2) {
            out = calculateComplexPercent(amount, 0.06, period);
        }
        System.out.println("Результат вклада: " + amount + " за " + period + " лет превратятся в " + out);
    }

    public static void main(String[] args) {
        new DepositCalculator().calculateDepositParameters();
    }
}
