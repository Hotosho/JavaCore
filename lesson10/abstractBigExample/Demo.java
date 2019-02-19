package lesson10.abstractBigExample;

public class Demo {

    private Employee[] employees = new Employee[100];

    void paySalaryToEmployess(){
        for (Employee employee : employees){
            employee.paySalary();
            System.out.println("salary was paid successfully to " + employee.getName() + "employee");
        }
    }
}
