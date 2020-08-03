import java.math.BigDecimal;

public class Operator implements Employee {

    private final double fixedSalary = 30000;

    private Company company;

    @Override
    public void setCompany(Company company) {
        this.company = company;
    }

    @Override
    public BigDecimal getMonthSalary() {
        return BigDecimal.valueOf(fixedSalary);
    }
}
