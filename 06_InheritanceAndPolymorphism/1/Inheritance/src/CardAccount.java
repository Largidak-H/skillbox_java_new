public class CardAccount extends BankAccount {

    double percent = 1;

    public CardAccount() {
    }

    public CardAccount(double startBalance) {
        super(startBalance);
    }

    @Override
    public boolean withdraw(double amount) {
        return super.withdraw(amount * (1 + percent / 100));
    }
}
