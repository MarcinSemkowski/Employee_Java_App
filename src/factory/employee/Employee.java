package factory.employee;

import java.util.Map;
import java.util.Set;

public class Employee {

    private String name;

    private int age;

    private String department;

    private int experience;


    public Employee(String name, int age, String work) {
        this.name = name;
        this.age = age;
        this.department = work;

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

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
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
        result = 31 * result + (department == null ? 0 : department.hashCode());
        result = 31 * result + experience;
        return result;
    }
}
