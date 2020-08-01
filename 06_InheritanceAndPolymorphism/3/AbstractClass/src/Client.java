import java.math.BigDecimal;

public abstract class Client {

    private long account;
    private BigDecimal accountBalance = getBigAmount(0);
    public String withdrawCondition = "без комиссии";
    public String replenishCondition = "без комиссии";

    public void withdraw(double amount) {
        int compare = getAccountBalance().compareTo(getBigAmount(amount).add(getWithdrawCommission(amount)));
        if (compare < 0) {
            System.out.printf("На счете № %d недостаточно средств.\n", getAccount());
        } else {
            System.out.printf("Со счета № %1$d списаны средства в количестве - %2$.2f руб.", getAccount(), amount);
            if (getWithdrawCommission(amount).compareTo(getBigAmount(0)) != 0) {
                System.out.printf(" и комиссия в количестве - %.2f руб.\n", getWithdrawCommission(amount).doubleValue());
            } else {
                System.out.print("\n");
            }
            setAccountBalance(getAccountBalance().subtract(getBigAmount(amount).add(getWithdrawCommission(amount))));
        }
    }

    protected abstract BigDecimal getWithdrawCommission(double amount);

    public void replenish(double amount) {
        System.out.printf("Счет № %1$d пополнен на средства в количестве - %2$.2f руб.", getAccount(), amount);
        if (getReplenishCommission(amount).compareTo(getBigAmount(0)) != 0) {
            System.out.printf(" за вычетом комиссии в количестве - %.2f руб.\n", getReplenishCommission(amount).doubleValue());
        } else {
            System.out.print("\n");
        }
        setAccountBalance(getAccountBalance().add(getBigAmount(amount).subtract(getReplenishCommission(amount))));
    }

    protected abstract BigDecimal getReplenishCommission(double amount);

    public BigDecimal getAccountBalance() {
        return accountBalance;
    }

    public void setAccountBalance(BigDecimal accountBalance) {
        this.accountBalance = accountBalance;
    }

    public long getAccount() {
        return account;
    }

    public void setAccount(long account) {
        this.account = account;
    }

    public void getAccountInfo() {
        System.out.printf("\nСчёт № %1$d:\nпополнение - %2$s,\nснятие - %3$s,\nбаланс - %4$.2f руб.\n", getAccount(),
                replenishCondition, withdrawCondition, getAccountBalance().doubleValue());
    }

    public BigDecimal getBigAmount(double amount) {
        return BigDecimal.valueOf(amount);
    }
}
