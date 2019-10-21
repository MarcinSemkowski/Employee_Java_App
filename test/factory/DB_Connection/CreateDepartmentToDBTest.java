package factory.DB_Connection;

import factory.Department;
import factory.Factory;
import org.junit.Test;

import static org.junit.Assert.*;

public class CreateDepartmentToDBTest {




    @Test
  public void doCRUDTaskTest(){
  //given
        Factory factory = new Factory("dev");
        Department department = new Department("drivers");
        department.setNightShift(true);
        DB_Strategy db_strategy =  new CreateDepartmentToDB();
        //then
        boolean isAdded =  db_strategy.doCRUDTask(factory,department);
        //when
        assertTrue(isAdded);
 }
}