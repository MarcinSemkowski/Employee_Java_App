package factory.DB_Connection;

import factory.Factory;
import org.junit.Test;

import static org.junit.Assert.*;

public class CreateFactoryToDBTest {

 @Test
    public void doCRUDTaskTest(){
     //given
     Factory factory = new Factory("dev");
     //then
     boolean isCreated =  new CreateFactoryToDB().doCRUDTask(factory,null);
     //when
     assertFalse(isCreated);
 }

}