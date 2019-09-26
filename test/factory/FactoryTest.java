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
        boolean nightShift = true;
        Department departmentTest = new Department(nameDepTest);
        //when
        departmentTest.setNightShift(nightShift);
        boolean isDepAdded = factory.addToMapDepartment(departmentTest.getName(),departmentTest.isNightShift());
        //then
          assertTrue(isDepAdded);
    }

    @Test
    public void deleteFromMapDepartment() {
    }
}