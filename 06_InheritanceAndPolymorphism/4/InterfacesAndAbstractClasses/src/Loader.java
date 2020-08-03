import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.List;

public class Loader {
    public static void main(String[] args) {

        Company company1 = new Company();
        for (int i = 0; i < 180 ; i++) {
            company1.hire(new Operator());
        }
        for (int j = 0; j < 80 ; j++) {
            company1.hire(new Manager());
        }
        List<Employee> topManagerList = new ArrayList<>();
        for (int k = 0; k < 10 ; k++) {
            topManagerList.add(new TopManager());
        }
        company1.hireAll(topManagerList);
        printSalary(company1.getTopSalaryStaff(15));
        printSalary(company1.getLowestSalaryStaff(30));
        for (int l = 0; l < company1.getEmployeeList().size(); l=l+2) {
            company1.fire();
        }
        printSalary(company1.getTopSalaryStaff(15));
        printSalary(company1.getLowestSalaryStaff(30));
    }

    public static void printSalary(List<Employee> employees) {
        for (Employee employee : employees) {
            System.out.println(employee.getMonthSalary().setScale(2, RoundingMode.HALF_UP) + " руб.");
        }
        System.out.println();
    }
}
