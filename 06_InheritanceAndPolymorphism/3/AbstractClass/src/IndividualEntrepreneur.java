public class IndividualEntrepreneur extends Client {

    private double value = 1000;
    private double percentLessValue = 1;
    private double percentMoreEqualValue = 0.5;

    public IndividualEntrepreneur(long account) {
        this.account = account;
        this.replenishCondition = "с комиссией в " + percentLessValue + "% для сумм меньше " + value +
                " руб., и с комиисией в " + percentMoreEqualValue + "% для сумм равной или больше " + value + " руб.";
    }

    @Override
    public void replenish(double amount) {
        double amountPercent;
        if (amount < value) {
            amountPercent = amount * (percentLessValue / 100);
        } else {
            amountPercent = amount * (percentMoreEqualValue / 100);
        }
        System.out.printf("Счет № %1$d пополнен на средства в количестве - %2$.2f руб. за вычетом комиссии " +
                "в количестве - %3$.2f руб.\n", account, amount, amountPercent);
        setAccountBalance(getAccountBalance() + amount - amountPercent);
    }
}
