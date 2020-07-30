import java.time.LocalDate;

public class DepositAccount extends BankAccount {

    LocalDate dateForNextWithdraw;

    public DepositAccount() {
    }

    public DepositAccount(double startBalance) {
        super(startBalance);
    }

    @Override
    public void replenish(double amount) {
        super.replenish(amount);
        dateForNextWithdraw = LocalDate.now().plusMonths(1);
    }

    @Override
    public boolean withdraw(double amount) {
        if (dateForNextWithdraw == null || LocalDate.now().isAfter(dateForNextWithdraw)) {
            return super.withdraw(amount);
        } else {
            System.out.println("С последнего пополнения счета прошло недостаточно времени для снятия средств.");
            return false;
        }
    }
}
