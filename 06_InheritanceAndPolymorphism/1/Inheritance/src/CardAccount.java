public class CardAccount extends BankAccount{

    public CardAccount() {
    }

    public CardAccount(double startBalance) {
        super(startBalance);
    }

    public void withdraw(double amount) {
        super.withdraw(amount * (1 + 0.01));
    }
}
