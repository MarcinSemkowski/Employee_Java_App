package factory;

import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

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
                ,"2 By usunąć pracownika z \n"
                ,"3. By zaktualizować pracownika \n "
        );
        assertThat(department.showEmployeeMethods(),is(employeeMethodsTest));
    }
}