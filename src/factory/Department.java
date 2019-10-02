package factory;

import factory.employee.Employee;

import java.util.Set;
import java.util.TreeSet;

public class Department {

    private String name;

    private boolean nightShift;

    private Set<Employee> employees;

    public Department(String name) {
        this.name = name;
        this.employees = new TreeSet<>();
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
        if(this == obj){
            return true;
        }
        if(obj == null || this.getClass()!= obj.getClass()){
            return false;
        }
        if(obj instanceof Department){
            Department o = (Department) obj;
            if (this.name.equals(o.getName()) && this.isNightShift() == o.isNightShift()){
                return true;
            }
            else{
                return false;
            }
        }else{
            return false;
        }
        
    }
}
