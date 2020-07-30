public class BankAccount {

    public double accountBalance = 0;

    public BankAccount() {
    }

    public BankAccount(double startBalance) {
        accountBalance = startBalance;
    }

    public boolean withdraw(double amount) {
        if (accountBalance < amount) {
            System.out.println("На счете недостаточно средств.");
            return false;
        } else {
            System.out.println("Со счета списаны средства в количестве - " + amount);
            accountBalance -= amount;
            return true;
        }
    }

    public void replenish(double amount) {
        System.out.println("Счет пополнен на средства в количестве - " + amount);
        accountBalance += amount;
    }

    public double getBalance() {
        System.out.println("Баланс счета - " + accountBalance);
        return accountBalance;
    }

    public boolean send(BankAccount receiver, double amount) {
        if (withdraw(amount)) {
            receiver.replenish(amount);
            System.out.println("Перевод стредств в количестве - " + amount + " успешно завершен.");
            return true;
        } else {
            return false;
        }
    }
}
