import java.util.Scanner;

public class DepositCalculator {
    // в названии метода на мой вщгляд правильнее указать Percents + пропущен модификатор досутпности
    double calculateComplexPercent(double summ, double yearRate, int period) {
        double pay = summ * Math.pow((1 + yearRate / 12), 12 * period);
        return calculateRound(pay, 2);
    }

      // в названии метода на мой вщгляд правильнее указать Percents + пропущен модификатор досутпности
    double calculateSimplePercent(double summ, double yearRate, int depositPeriod) {
        return calculateRound(summ + summ * yearRate * depositPeriod, 2);
    }

      // пропущен модификатор досутпности. Название переменной scale не совсем точно отражает её суть. Думаю result было бы лучше
    double calculateRound(double value, int signs) {
        double scaLe = Math.pow(10, signs);
        return Math.round(value * scaLe) / scaLe;
    }
    
  // пропущен модификатор досутпности. На мой взгляд лучше назвать метод calculateDeposit - это более точно отобразит то, что в этом методе происходит 
    //(всё же мы рассчитваем результпаты депозита а не его параметры)
    void calculateDepositParameters() {
        int period;
        int action;
        int amount;
        // название перпеменной out... Я бы назвал что то вроде depositResult (мне кажется это точнее отображает её суть)
        double out;
        Scanner input = new Scanner(System.in);

        System.out.println("Введите сумму вклада в рублях:");
        amount = input.nextInt();
        System.out.println("Введите срок вклада в годах:");
        period = input.nextInt();
        System.out.println("Выберите тип вклада, 1 - вклад с обычным процентом, 2 - вклад с капитализацией:");
        action = input.nextInt();
        // инициализацию переменной лучше произвести в месте её объявления
        out = 0;
        if (action == 1) {
            out = calculateSimplePercent(amount, 0.06, period);
        } else if (action == 2) {
            out = calculateComplexPercent(amount, 0.06, period);
        }
        System.out.println("Результат вклада: " + amount + " за " + period + " лет превратятся в " + out);
    }

    public static void main(String[] args) {
        // на мой вщгляд лучше выполнить объявление/нициализацию переменной типа DepositCalculator и вызов метода на разные строки
        new DepositCalculator().calculateDepositParameters();
    }
}
//лишняя строка
