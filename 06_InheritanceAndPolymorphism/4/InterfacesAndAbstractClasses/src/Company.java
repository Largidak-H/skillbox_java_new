import java.math.BigDecimal;
import java.util.*;

public class Company {

    private List<Employee> employeeList = new ArrayList<>();

    public List<Employee> getEmployeeList() {
        return employeeList;
    }

    public void hire(Employee employee) {
        employee.setCompany(this);
        employeeList.add(employee);
    }

    public void hireAll(List<Employee> employeeList) {
        for (Employee employee : employeeList) {
            employee.setCompany(this);
        }
        this.employeeList.addAll(employeeList);
    }

    public void fire() {
        employeeList.remove((int) (Math.random() * employeeList.size()));
    }

    public BigDecimal getIncome() {
        BigDecimal income = BigDecimal.valueOf(0);
        for (Employee employee : employeeList) {
            if (employee instanceof Manager) {
                income = income.add(((Manager) employee).getMakedMoney());
            }
        }
        return income;
    }

    public List<Employee> getTopSalaryStaff(int count) {
        Comparator<Employee> ascendingSalaryComparator = (o1, o2) -> Integer.compare(0, o1.getMonthSalary().compareTo(o2.getMonthSalary()));
        return getSalaryStaff(count,ascendingSalaryComparator);
    }

    public List<Employee> getLowestSalaryStaff(int count) {
        Comparator<Employee> descendingSalaryComparator = (o1, o2) -> Integer.compare(o1.getMonthSalary().compareTo(o2.getMonthSalary()), 0);
        return getSalaryStaff(count, descendingSalaryComparator);
    }
     protected List<Employee> getSalaryStaff(int count, Comparator<Employee> comparator) {
         List<Employee> salaryList = new ArrayList<>(employeeList);
         salaryList.sort(comparator);
         if (count > 0) {
             if (count > salaryList.size()) {
                 count = salaryList.size();
             }
             return salaryList.subList(0, count);
         } else {
             System.out.println("Неверно указана длина запрашиваемого списка.");
             salaryList.clear();
             return salaryList;
         }
     }
}
