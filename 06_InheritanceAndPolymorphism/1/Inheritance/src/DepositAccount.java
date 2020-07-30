import java.time.LocalDate;

public class DepositAccount extends BankAccount{

    LocalDate dateForNextWithdraw;

    public DepositAccount() {
    }

    public DepositAccount(double startBalance) {
        super(startBalance);
    }

    public void topUp(double amount) {
        super.topUp(amount);
        dateForNextWithdraw = LocalDate.now().plusMonths(1);
    }

    public void withdraw(double amount) {
        if (dateForNextWithdraw != null) {

        }
        if (dateForNextWithdraw == null || LocalDate.now().isAfter(dateForNextWithdraw)) {
            super.withdraw(amount);
        } else {
            System.out.println("С последнего пополнения счета прошло недостаточно времени для снятия средств.");
        }
    }
}
