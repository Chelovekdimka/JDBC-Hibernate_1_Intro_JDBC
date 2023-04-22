package Ex_5;

import java.util.List;

//Используя Workbench в данной базе данных создайте 3 таблицы, В 1-й таблице содержатся имена и номера телефонов сотрудников компании.
//        Во 2-й таблице содержатся ведомости о зарплате и должностях сотрудников:
//        главный директор, менеджер, рабочий. В 3-й таблице содержится информация о семейном положении, дате рождения, и месте проживания.

//Используя IntelijIdea и JDBC cделайте выборку при помощи JOIN’s для таких заданий:
//        1) Получите контактные данные сотрудников (номера телефонов, место жительства).
//        2) Получите информацию о дате рождения всех холостых сотрудников и их номера.
//        3) Получите информацию обо всех менеджерах компании: дату рождения и номер телефона.
public class Main {
    public static void main(String[] args) {

        DBWorker worker = new DBWorker();
        List<Employee> employeesPhoneAddress = worker.getAllPhonesAndAddresses();
        List<Employee> allSingleEmployeesBirthdays = worker.getAllSingleEmployeesBirthdays();
        List<Employee> allManagersDetails = worker.getAllManagersDetails();

        System.out.println("Контактні дані співробітників (номера телефонів, місце проживання) : ");
        for (Employee employee : employeesPhoneAddress) {
            System.out.println(employee.getEmployeeID() + " " + employee.getFirstName() + " " + employee.getLastName() + " " + employee.getPhone() + " " +
                    employee.getAddress());
        }

        System.out.println("\nІнформація про дату народження всіх холостих співробітників та їх номера :");
        for (Employee employee : allSingleEmployeesBirthdays) {
            System.out.println(employee.getEmployeeID() + " " + employee.getFirstName() + " " + employee.getLastName() + " " + employee.getMaritalStatus()
                     + " " + employee.getBirthDate() + " " + employee.getPhone());
        }
        System.out.println("\nІнформація про всіх менеджерів компанії (дату народження та номер телефону) : ");
        for (Employee employee : allManagersDetails) {
            System.out.println(employee.getEmployeeID() + " " + employee.getFirstName() + " " + employee.getLastName() + " " + employee.getPosition() + " "
             + employee.getBirthDate() + " " + employee.getPhone());

        }
    }
}
