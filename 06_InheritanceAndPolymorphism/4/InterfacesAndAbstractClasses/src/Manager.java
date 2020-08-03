import java.math.BigDecimal;

public class Manager implements Employee {

    private final double fixedSalary = 50000;
    private final double bonusPercent = 5;
    private final double makedMoney = 115000 + Math.random() * 25000;

    private Company company;

    @Override
    public void setCompany(Company company) {
        this.company = company;
    }

    public BigDecimal getMakedMoney() {
        return BigDecimal.valueOf(makedMoney);
    }

    @Override
    public BigDecimal getMonthSalary() {
        return BigDecimal.valueOf(fixedSalary + (bonusPercent / 100) * makedMoney);
    }

}
