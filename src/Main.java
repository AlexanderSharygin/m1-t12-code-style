import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Введите сумму вклада в рублях:");
        int depositValue = scanner.nextInt();

        System.out.println("Введите срок вклада в годах:");
        int depositPeriod = scanner.nextInt();

        System.out.println("Выберите тип вклада, 1 - вклад с обычным процентом, 2 - вклад с капитализацией:");
        int depositType = scanner.nextInt();

        DepositCalculator depositCalculator = new DepositCalculator(
                depositPeriod, depositType, depositValue, 6);
        double depositResult = depositCalculator.calculateDeposit();

        System.out.println(
                "Результат вклада: " + depositValue + " за " + depositPeriod + " лет превратятся в " + depositResult);
    }
}