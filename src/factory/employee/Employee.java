package factory.employee;

import factory.Department;

import java.util.Map;
import java.util.Set;

public class Employee implements  Comparable<Employee> {

    private String name;

    private int age;

    private Department department;

    private int experience;


    public Employee(String name, int age, Department department, int experience) {
        this.name = name;
        this.age = age;
        this.department = department;
        this.experience = experience;
    }

    public int getExperience() {
        return experience;
    }

    public void setExperience(int experience) {
        this.experience = experience;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }

    @Override
    public boolean equals(Object obj) {

        if (this == obj) {
            return true;
        }

        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }

        if (obj instanceof Employee) {
            Employee employeeObject = (Employee) obj;
            if (this.name.equals(employeeObject.name) &&
                    (this.age == employeeObject.age) &&
                    (this.department.equals(employeeObject.department)) &&
                    (this.experience == this.experience)) {
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
        int result = 7;
        result = 31 * result + (name == null ? 0 : name.hashCode());
        result = 31 * result + age;
        result = 31 * result + experience;
        return result;
    }


    @Override
    public int compareTo(Employee o) {
       return Integer.compare(this.getExperience(), o.getExperience());
    }

    @Override
    public String toString() {
        return "Employee{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", department=" + department +
                ", experience=" + experience +
                '}';
    }
}
