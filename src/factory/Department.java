package factory;

import factory.employee.Employee;

import java.util.*;
import java.util.stream.Collectors;

public class Department {

    private String name;

    private boolean nightShift;

    private Set<Employee> employees;

    public Department(String name) {
        this.name = name;
        this.employees = new TreeSet<>();
    }


    public List<String> showEmployeeMethods() {
        List<String> employeeMethods = Arrays.asList(
                "1. By dodać pracownika do \n"
                , "2 By usunąć pracownika z \n"
                , "3. By zaktualizować pracownika \n "
        );
        return employeeMethods;
    }

    public void employeeMenu(int index, Scanner scan) {
        switch (index) {
            case 1:
                System.out.println("Podaj imię:");
                String name = scan.next();
                System.out.println("Podaj wiek:");
                int age = scan.nextInt();
                System.out.println("Podaj doświadczenie:");
                int experience = scan.nextInt();
                addEmployeeToDepartment(name, age, experience);
                break;


        }

    }

    public boolean addEmployeeToDepartment(String name, int age, int experience) {
        employees.add(new Employee(name, age, this, experience));
        return true;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isNightShift() {
        return nightShift;
    }

    public void setNightShift(boolean nightShift) {
        this.nightShift = nightShift;
    }

    public Set<Employee> getEmployees() {
        return employees;
    }

    public void setEmployees(Set<Employee> employees) {
        this.employees = employees;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || this.getClass() != obj.getClass()) {
            return false;
        }
        if (obj instanceof Department) {
            Department o = (Department) obj;
            if (this.name.equals(o.getName()) && this.isNightShift() == o.isNightShift()) {
                return true;
            } else {
                return false;
            }
        } else {
            return false;
        }


    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 31 * hash + (this.name == null ? 0 : name.hashCode());
        hash = 31 * hash + (Boolean.hashCode(this.nightShift));
        hash = 31 * hash + (this.employees.isEmpty() ? 0 : employees.hashCode());
        return hash;
    }


    @Override
    public String toString() {
        return "Department{" +
                "name='" + name + '\'' +
                ", nightShift=" + nightShift +
                ", employees=" + employees +
                '}';
    }
}
