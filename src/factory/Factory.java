package factory;

import factory.employee.Employee;

import java.util.HashMap;
import java.util.Map;

public class Factory {

    private String name;

    private Map<String, Department> departmentMap;


    public Factory(String name) {
        this.name = name;
        departmentMap = new HashMap<>();
    }

    public static Employee createEmployee(String name, int age, String department) {
        return new Employee(name, age, department);
    }

    public static Department createDepartment(String nameDepartment) {
        return new Department(nameDepartment);
    }


    public void addToMapDepartment(String nameDep,boolean nightShift){
        Department newDep = Factory.createDepartment(nameDep);
        newDep.setNightShift(nightShift);
        departmentMap.put(newDep.getName(), newDep);
    }

    


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Map<String, Department> getDepartmentMap() {
        return departmentMap;
    }


}
