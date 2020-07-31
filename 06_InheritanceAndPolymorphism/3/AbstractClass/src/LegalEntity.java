public class LegalEntity extends Client {

    private double percent = 1;

    public LegalEntity(long account) {
        this.account = account;
        this.withdrawCondition = "с комиссией в " + percent + "%";
    }

    @Override
    public void withdraw(double amount) {
        double amountPercent = amount * (percent / 100);
        if (getAccountBalance() < (amount + amountPercent)) {
            System.out.printf("На счете № %d недостаточно средств.\n", account);
        } else {
            System.out.printf("Со счета № %1$d списаны средства в количестве - %2$.2f руб. и комиссия " +
                    "в количестве - %3$.2f руб.\n", account, amount, amountPercent);
            setAccountBalance(getAccountBalance() - amount - amountPercent);
        }
    }
}
