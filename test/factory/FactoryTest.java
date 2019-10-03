package factory;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.*;
import java.util.stream.Collectors;

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

       List<String> arrayKeyTest = factory.getDepartmentMap()
              .keySet()
              .stream()
              .collect(Collectors.toList());
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

    @Test
    public void sortDepartmentsAlphabetically(){
        //given
        int caseNumTest = 0;
        Department department = new Department("Grafik");
        department.setNightShift(false);
        Department department1 = new Department("Spedytor");
        Department department2 = new Department("Automatyk");
        Department department3 = new Department("Budowlaniec");
        Department department4 = new Department("Holowniczy");
        Department department5 = new Department("Ceglarz");

        //when
        Map<String,Department> departmentMapTest = new LinkedHashMap<>();
        factory.getDepartmentMap().put(department.getName(),department);
        factory.getDepartmentMap().put(department1.getName(),department1);
        factory.getDepartmentMap().put(department2.getName(),department2);
        factory.getDepartmentMap().put(department3.getName(),department3);
        factory.getDepartmentMap().put(department4.getName(),department4);
        factory.getDepartmentMap().put(department5.getName(),department5);
        departmentMapTest.put(department.getName(),department);
        departmentMapTest.put(department1.getName(),department1);
        departmentMapTest.put(department2.getName(),department2);
        departmentMapTest.put(department3.getName(),department3);
        departmentMapTest.put(department4.getName(),department4);
        departmentMapTest.put(department5.getName(),department5);

        //then
         assertNotSame(departmentMapTest,factory.sortDepartments(0));
    }
    @Test
    public void sortDepartmentsBaseOnNightShift(){
        //given
        Department department = new Department("Grafik");
        Department department1 = new Department("Spedytor");
        Department department2 = new Department("Automatyk");
        Department department3 = new Department("Budowlaniec");
        Department department4 = new Department("Holowniczy");
        Department department5 = new Department("Ceglarz");
        //when
         factory.addToMapDepartment(department.getName(),true);
        factory.addToMapDepartment(department1.getName(),true);
        factory.addToMapDepartment(department2.getName(),true);
        factory.addToMapDepartment(department3.getName(),true);
        factory.addToMapDepartment(department4.getName(),false);
        factory.addToMapDepartment(department5.getName(),false);



        Map<String,Department> sortTest = factory.sortDepartments(2);
        //then
        assertNotSame(sortTest,factory.getDepartmentMap());

    }


    @Test
    public void findByNameTest(){
       //given
        Department department = new Department("Holowniczy");
        String expectedName = "Holowniczy";
         //when
        boolean isAdded = factory.addToMapDepartment(department.getName(),true);
        String actualName = factory.findBy(expectedName);
        //then
        assertTrue(isAdded);
        assertEquals(expectedName,actualName);
    }
    @Test
    public void findByNightShift(){
       //given
        Department department = new Department("Grafik");
        department.setNightShift(false);
        Department department1 = new Department("Spedytor");
        Department department2 = new Department("Automatyk");
        Department department3 = new Department("Budowlaniec");
        Department department4 = new Department("Holowniczy");
        Department department5 = new Department("Ceglarz");
        boolean nightShift = true;
        //when
        factory.addToMapDepartment(department.getName(),true);
        factory.addToMapDepartment(department1.getName(),false);
        factory.addToMapDepartment(department2.getName(),false);
        factory.addToMapDepartment(department3.getName(),false);
        factory.addToMapDepartment(department4.getName(),true);
        factory.addToMapDepartment(department5.getName(),true);
        Set<String> setTest = new HashSet<>();
        setTest.add("Grafik");
        setTest.add("Holowniczy");
        setTest.add("Ceglarz");
        //then
        assertEquals(setTest,factory.findBy(nightShift));
    }
}