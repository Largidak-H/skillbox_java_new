import java.math.BigDecimal;

public class IndividualEntrepreneur extends Client {

    private final double value = 1000;
    private final double percentLessValue = 1;
    private final double percentMoreEqualValue = 0.5;

    public IndividualEntrepreneur(long account) {
        setAccount(account);
        replenishCondition = "с комиссией в " + percentLessValue + "% для сумм меньше " + value +
                " руб., и с комиисией в " + percentMoreEqualValue + "% для сумм равной или больше " +
                value + " руб.";
    }

    @Override
    protected BigDecimal getWithdrawCommission(double amount) {
        return getBigAmount(0);
    }

    @Override
    protected BigDecimal getReplenishCommission(double amount) {
        int compare = getBigAmount(amount).compareTo(BigDecimal.valueOf(value));
        if (compare < 0) {
            return getBigAmount(amount).multiply(BigDecimal.valueOf(percentLessValue / 100));
        } else {
            return getBigAmount(amount).multiply(BigDecimal.valueOf(percentMoreEqualValue / 100));
        }
    }
}
