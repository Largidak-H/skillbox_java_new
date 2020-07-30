public class BankAccount {
    public double accountBalance = 0;
    boolean operation = false;

    public BankAccount() {
    }

    public BankAccount(double startBalance) {
        accountBalance = startBalance;
    }

    public void withdraw(double amount) {
        if (accountBalance < amount) {
            System.out.println("На счете недостаточно средств.");
            operation = false;
        } else {
            System.out.println("Со счета списаны средства в количестве - " + amount);
            accountBalance-=amount;
            operation = true;
        }
    }

    public void topUp(double amount) {
        System.out.println("Счет пополнен на средства в количестве - " + amount);
        accountBalance+=amount;
    }

    public double getBalance() {
        System.out.println("Баланс счета - " + accountBalance);
        return accountBalance;
    }

    public boolean send(BankAccount receiver, double amount) {
        withdraw(amount);
        if (operation) {
            receiver.topUp(amount);
            System.out.println("Перевод стредств в количестве - " + amount + " успешно завершен.");
        }
        return operation;
    }

}
