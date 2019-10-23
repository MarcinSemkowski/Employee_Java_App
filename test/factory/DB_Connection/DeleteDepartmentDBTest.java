package factory.DB_Connection;

import factory.Department;
import factory.Factory;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class DeleteDepartmentDBTest {

    private DB_Strategy db_strategy;

    @Before
    public void init(){
        db_strategy = new DeleteDepartmentDB();
    }


    @Test
    public void doCRUDTaskTest(){
        //given
        Factory factoryTest = new Factory("dev");
        Department departmentTest = new Department("Drivers");
        departmentTest.setNightShift(true);
        //then
        boolean isDeleted = db_strategy.doCRUDTask(factoryTest,departmentTest);
        //when
        assertTrue(isDeleted);




    }

}