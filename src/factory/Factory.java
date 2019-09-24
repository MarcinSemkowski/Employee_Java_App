package factory;

import factory.employee.Employee;

import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
public class Factory {

private String name;

private Map<String, Set<Employee>> depratment;

    public Factory(String name) {
        this.name = name;
        depratment = new TreeMap();
    }

    public Employee createEmployee(String name,int age,String department){
        return new Employee(name,age,department);
    }






}
