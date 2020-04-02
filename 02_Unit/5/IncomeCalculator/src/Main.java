import java.util.Scanner;

public class Main
{
    private static int minIncome = 200000; //минимальная сумма дохода компании за месяц
    private static int maxIncome = 900000; //максимальная сумма дохода компании за месяц

    private static int officeRentCharge = 140000; //плата за аренду помещения в месяц
    private static int telephonyCharge = 12000; //плата за телефонную связь в месяц
    private static int internetAccessCharge = 7200; //плата доступ к Интернету в месяц

    private static int assistantSalary = 45000; //зарплата помощника в месяц
    private static int financeManagerSalary = 90000; //зарплата финансового менеджера в месяц

    private static double mainTaxPercent = 0.24; //процент налога от чистого дохода
    private static double managerPercent = 0.15; //процент от дохода на зарплату менеджера

    private static double minInvestmentsAmount = 100000; //миниммальная сумма инвестиций

    public static void main(String[] args)
    {
        double minIncomeForYes = (minInvestmentsAmount / (1 - mainTaxPercent) + calculateFixedCharges())
                / (1 - managerPercent); //расчет минимальной суммы дохода для инвестирования
        System.out.println(Math.ceil(minIncomeForYes)); //вывод в консоль МСДдИ с округлением в большую сторону

        while(true)
        {
            System.out.println("Введите сумму доходов компании за месяц " +
                "(от 200 до 900 тысяч рублей): ");
            int income = (new Scanner(System.in)).nextInt(); //чтение из консоли суммы дохода

            if(!checkIncomeRange(income)) { //проверка введенной суммы доходов на соответствие указанным рамкам
                continue;
            }

            double managerSalary = income * managerPercent; //расчет зарплаты менеджера
            double pureIncome = income - managerSalary -
                calculateFixedCharges(); //расчет чистого дохода
            double taxAmount = mainTaxPercent * pureIncome; //расчет суммы налога на чистый доход
            double pureIncomeAfterTax = pureIncome - taxAmount; //расчет чистого дохода после налогообложения

            boolean canMakeInvestments = pureIncomeAfterTax >=
                minInvestmentsAmount; //расчет возможности инвестирования

            System.out.println("Зарплата менеджера: " + managerSalary);
            System.out.println("Общая сумма налогов: " +
                (taxAmount > 0 ? taxAmount : 0));
            System.out.println("Компания может инвестировать: " +
                (canMakeInvestments ? "да" : "нет"));
            if(pureIncome < 0) {
                System.out.println("Бюджет в минусе! Нужно срочно зарабатывать!");
            }
        }
    }

    private static boolean checkIncomeRange(int income) //метод проверки введенной суммы доходов на соответствие
    {                                                   //указанным рамкам
        if(income < minIncome)
        {
            System.out.println("Доход меньше нижней границы");
            return false;
        }
        if(income > maxIncome)
        {
            System.out.println("Доход выше верхней границы");
            return false;
        }
        return true;
    }

    private static int calculateFixedCharges() //метод подсчета издержек на аренду и зарплаты
    {
        return officeRentCharge +
                telephonyCharge +
                internetAccessCharge +
                assistantSalary +
                financeManagerSalary;
    }
}
