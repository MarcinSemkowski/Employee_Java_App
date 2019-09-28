package factory;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.Assert.*;

public class FactoryTest {

    private String nameDepTest;

    Factory factory;
    Department departmentTest;

    @Before
    public void init() {
        factory = new Factory("dev");
        nameDepTest = "developers";
        departmentTest = new Department(nameDepTest);
        departmentTest.setNightShift(true);
    }


    @Test
    public void addToMapDepartment() {
        //given
        departmentTest.setNightShift(false);
        //when
        boolean isDepAdded = factory.addToMapDepartment(departmentTest.getName(), departmentTest.isNightShift());
        //then
        assertTrue(isDepAdded);
    }

    @Test
    public void deleteFromMapDepartment() {
        //given
        departmentTest.setNightShift(true);
        factory.addToMapDepartment(departmentTest.getName(), departmentTest.isNightShift());
        String[] arrayKeyTest = new String[factory.getDepartmentMap().size()];
        int i = 0;
        //when
        for (String keyTest : factory.getDepartmentMap().keySet()) {
            arrayKeyTest[i++] = keyTest;
        }
        //then
        assertFalse(factory.deleteFromMapDepartment(0, arrayKeyTest));
    }

    @Test
    public void showDepartmentsFromMapDepartment() {
        //give
        departmentTest.setNightShift(false);
        StringBuilder keysTest = new StringBuilder();
        keysTest.append("-----------------------");
        keysTest.append("\n");
        keysTest.append("-------------");
        keysTest.append("\n");
        keysTest.append(nameDepTest);
        keysTest.append("\n");
        keysTest.append("------------");
        keysTest.append("\n");
        keysTest.append("-----------------------");
        //when
        factory.getDepartmentMap().put(departmentTest.getName(), departmentTest);
        //then
        assertEquals(keysTest.toString(), factory.showDepartmentsFromMapDepartment());

    }

    @Test
    public void updateToMapDepartment() {
        //given
        int indexTest = 0;
        factory.addToMapDepartment("developers", false);
        String[] keysTest = new String[factory.getDepartmentMap().size()];
        String updateDepTest = " dep";
        int i = 0;
        //when
        for (String keyTest : factory.getDepartmentMap().keySet()) {
            keysTest[i++] = keyTest;
        }
        boolean isUpdated = factory.updateToMapDepartment(indexTest, keysTest, updateDepTest, true);
        //then
        assertTrue(isUpdated);

    }
}