public abstract class Client {

    public long account;
    private double accountBalance = 0;
    public String withdrawCondition = "без комиссии";
    public String replenishCondition = "без комиссии";

    public void withdraw(double amount) {
        if (getAccountBalance() < amount) {
            System.out.printf("На счете № %d недостаточно средств.\n", account);
        } else {
            System.out.printf("Со счета № %1$d списаны средства в количестве - %2$.2f руб.\n", account, amount);
            setAccountBalance(getAccountBalance() - amount);
        }
    }

    public void replenish(double amount) {
        System.out.printf("Счет № %1$d пополнен на средства в количестве - %2$.2f руб.\n", account, amount);
        setAccountBalance(getAccountBalance() + amount);
    }

    public double getAccountBalance() {
        return accountBalance;
    }

    public void setAccountBalance(double accountBalance) {
        this.accountBalance = accountBalance;
    }

    public void getAccountInfo() {
        System.out.printf("\nСчёт № %1$d:\nпополнение - %2$s,\nснятие - %3$s,\nбаланс - %4$.2f руб.\n", account,
                replenishCondition, withdrawCondition, getAccountBalance());
    }
}
