package factory;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class FactoryTest {

    Factory factory;

    @Before
    public void init(){
        factory = new Factory("dev");

    }


    @Test
    public void addToMapDepartment() {
      //given
        String nameDepTest = "developers";
        Department departmentTest = new Department(nameDepTest);
        //when
        departmentTest.setNightShift(false);
        boolean isDepAdded = factory.addToMapDepartment(departmentTest.getName(),departmentTest.isNightShift());
        //then
          assertTrue(isDepAdded);
    }

    @Test
    public void deleteFromMapDepartment() {
        //given
        String nameDepTest = "developers";
        Department departmentTest = new Department(nameDepTest);
        factory.addToMapDepartment(departmentTest.getName(),departmentTest.isNightShift());
        String[] arrayKeyTest = new String[factory.getDepartmentMap().size()];
        int i =0;
        //when
        for (String keyTest: factory.getDepartmentMap().keySet()) {
           arrayKeyTest[i++] = keyTest;
        }
          //then
        assertFalse(factory.deleteFromMapDepartment(0,arrayKeyTest));
    }
}