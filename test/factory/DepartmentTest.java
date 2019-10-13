package factory;

import factory.employee.Employee;
import org.junit.Before;
import org.junit.Test;

import java.util.*;

import static org.hamcrest.core.Is.is;
import static org.hamcrest.core.IsNot.not;
import static org.junit.Assert.*;

public class DepartmentTest {

    Department department;

    @Before
    public void init() {
        department = new Department("Drivers");
        department.setNightShift(true);

    }

    @Test
    public void showEmployeeMethodsTest() {
        //given
        List<String> employeeMethodsTest = Arrays.asList(
                "1. By dodać pracownika do \n"
                , "2 By usunąć pracownika z \n"
                , "3. By zaktualizować pracownika \n "
        );
        //then
        assertThat(department.showEmployeeMethods(), is(employeeMethodsTest));
    }
    @Test
    public void showSortMethodsTest(){
       //given
        List<String> sortMethodsTest = Arrays.asList(
                "1.By sortować alfabetycznie  \n"
                , " By sortować po wieku:\n"
                ,"2. Od najstarszego do najmłodszego \n"
                ,"3. Od najmłodszego do najstarszego \n "
        );
        //then
        assertThat(department.showSortMethods(),is(sortMethodsTest));
    }
    @Test
    public void sortAlphabeticallyTest(){
        //given
        Employee employee = new Employee("Christopher",25,department,4);
        Employee employee1 = new Employee("David",30,department,8);
        Employee employee2 = new Employee("Alexander",30,department,8);
        Employee employee3 = new Employee("Brandon",30,department,8);
        Set<Employee> employeesTest = new HashSet<>();
        //when
        employeesTest.add(employee);
        employeesTest.add(employee1);
        employeesTest.add(employee2);
        employeesTest.add(employee3);


        department.addEmployeeToDepartment(employee);
        department.addEmployeeToDepartment(employee1);
        department.addEmployeeToDepartment(employee2);
        department.addEmployeeToDepartment(employee3);
        department.setEmployees(department.sortAlphabetically());
        //then
        assertThat(employeesTest,is(not(department.getEmployees())));
    }


    @Test
    public void AddEmployeeTest() {
        //given
        String name = "Mike";
        int age = 25;
        int experience = 3;
        //when
        boolean isAdd = department.addEmployeeToDepartment(new Employee(name, age, department, experience));
        //then
        assertTrue(isAdd);
    }

    @Test
    public void deleteEmployeeTest() {
        //given
        String name = "Mike";
        int age = 25;
        int experience = 3;
        //when
        boolean isAdd = department.addEmployeeToDepartment(new Employee(name, age, department, experience));
        boolean isDeleted = department.deleteEmployee(new Employee(name, age, department, experience));
         //then
        assertTrue(isAdd);
        assertTrue(isDeleted);
    }

    @Test
    public void updateEmployeeTest(){
        //given
        String name = "Mike";
        int age = 25;
        int experience = 3;
        Employee oldEmployee = new Employee(name,age,department,experience);
        String updateName = "John";
        int updateAge = 32;
        int updateExperience = 7;

        //when
        boolean isAdd = department.addEmployeeToDepartment(oldEmployee);
        boolean isUpdate = department.updateEmployee(oldEmployee,new Employee(updateName,updateAge,department,updateExperience));
        //then
        assertTrue(isAdd);
        assertTrue(isUpdate);

    }
}