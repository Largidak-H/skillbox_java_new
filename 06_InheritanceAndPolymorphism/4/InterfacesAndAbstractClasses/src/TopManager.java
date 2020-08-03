import java.math.BigDecimal;

public class TopManager implements Employee {

    private final double fixedSalary = 70000;
    private final double bonusPercent = 150;
    private final double companyIncomeLevel = 10000000;

    private Company company;

    public void setCompany(Company company) {
        this.company = company;
    }

    @Override
    public BigDecimal getMonthSalary() {
        if (company.getIncome().compareTo(BigDecimal.valueOf(companyIncomeLevel)) > 0) {
            return BigDecimal.valueOf(fixedSalary * (1 + bonusPercent / 100));
        } else {
            return BigDecimal.valueOf(fixedSalary);
        }
    }
}
