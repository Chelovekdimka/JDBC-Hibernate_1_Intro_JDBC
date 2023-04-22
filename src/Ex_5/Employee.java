package Ex_5;

import java.util.Date;
public class Employee {
    private int employeeID;
    private String firstName;
    private String lastName;
    private String phone;
    private String address;
    private String maritalStatus;
    private Date birthDate;
    private String position;

    public Employee(int employeeID, String firstName, String lastName, String phone, String address) {
        this.employeeID = employeeID;
        this.firstName = firstName;
        this.lastName = lastName;
        this.phone = phone;
        this.address = address;
    }

    public Employee(int employeeID, String firstName, String lastName, String maritalStatus, java.sql.Date birthDate, String phone) {
        this.employeeID = employeeID;
        this.firstName = firstName;
        this.lastName = lastName;
        this.phone = phone;
        this.maritalStatus = maritalStatus;
        this.birthDate = birthDate;
    }

    public Employee(int employeeID, String firstName, String lastName, String position, Date birthDate, String phone) {
        this.employeeID = employeeID;
        this.firstName = firstName;
        this.lastName = lastName;
        this.birthDate = birthDate;
        this.phone = phone;
        this.position = position;
    }

    public int getEmployeeID() {
        return employeeID;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getPhone() {
        return phone;
    }

    public String getAddress() {
        return address;
    }

    public String getMaritalStatus() {
        return maritalStatus;
    }

    public Date getBirthDate() {
        return birthDate;
    }

    public String getPosition() {
        return position;
    }
}
