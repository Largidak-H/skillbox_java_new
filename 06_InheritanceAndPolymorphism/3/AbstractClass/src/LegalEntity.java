import java.math.BigDecimal;

public class LegalEntity extends Client {

    private final double percent = 1;

    public LegalEntity(long account) {
        setAccount(account);
        withdrawCondition = "с комиссией в " + percent + "%";
    }

    @Override
    protected BigDecimal getWithdrawCommission(double amount) {
        return getBigAmount(amount * (percent / 100));
    }

    @Override
    protected BigDecimal getReplenishCommission(double amount) {
        return getBigAmount(0);
    }
}
