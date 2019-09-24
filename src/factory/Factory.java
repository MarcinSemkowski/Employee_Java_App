package factory;

import factory.employee.Employee;

import java.util.Map;

import java.util.TreeMap;
public class Factory {

private String name;

private Map<String,Department> depratments;



    public Factory(String name) {
        this.name = name;
        depratments = new TreeMap();
    }

    public Employee createEmployee(String name,int age,String department){
        return new Employee(name,age,department);
    }






}
