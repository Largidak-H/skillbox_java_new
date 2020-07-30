import java.time.LocalDate;

public class Loader {
    public static void main(String[] args) {
        BankAccount myDepositAccount = new DepositAccount(1500);
        BankAccount friendDepositAccount = new DepositAccount(500);
        BankAccount friendCardAccount = new CardAccount(500);

        myDepositAccount.withdraw(1900);
        myDepositAccount.withdraw(700);
        myDepositAccount.getBalance();

        friendCardAccount.withdraw(100);
        friendCardAccount.getBalance();

        friendDepositAccount.withdraw(100);
        friendDepositAccount.getBalance();

        myDepositAccount.send(friendCardAccount, 200);
        myDepositAccount.send(friendDepositAccount, 200);
        myDepositAccount.getBalance();
        friendCardAccount.getBalance();
        friendDepositAccount.getBalance();

        friendCardAccount.withdraw(100);
        friendCardAccount.getBalance();
        friendDepositAccount.withdraw(100);
        friendDepositAccount.getBalance();
    }
}
