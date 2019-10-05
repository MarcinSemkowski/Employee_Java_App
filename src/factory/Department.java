package factory;

import factory.employee.Employee;

import java.util.*;

public class Department {

    private String name;

    private boolean nightShift;

    private Set<Employee> employees;

    public Department(String name) {
        this.name = name;
        this.employees = new TreeSet<>();
    }


    public void showEmployeeMethods(){
        List<String> employeeMethods =Arrays.asList(
                "1. By dodać pracownika do \n"
                ,"2 By usunąć pracownika z \n"
                ,"3. By zaktualizować pracownika \n "
        );
        employeeMethods
                .stream()
                .forEach(System.out::println);
    }

    public void employeeMenu(int index, Scanner scan){
       switch (index){
           case 1:
               System.out.println("Podaj imię:");
               String name = scan.next();
               System.out.println("Podaj wiek:");
              int age = scan.nextInt();
               System.out.println("Podaj doświadczenie:");
               int  experience = scan.nextInt();
               Employee employee = new Employee(name,age,this,experience);
               employees.add(employee);
           break;
       }
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

    @Override
    public String toString() {
        return "Department{" +
                "name='" + name + '\'' +
                ", nightShift=" + nightShift +
                ", employees=" + employees +
                '}';
    }
}
