import java.math.BigDecimal;

public class PhysicalEntity extends Client {

    public PhysicalEntity(long account) {
        setAccount(account);
    }

    @Override
    protected BigDecimal getWithdrawCommission(double amount) {
        return getBigAmount(0);
    }

    @Override
    protected BigDecimal getReplenishCommission(double amount) {
        return getBigAmount(0);
    }
}
