package factory;

import factory.employee.Employee;
import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

import static org.hamcrest.core.Is.is;
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