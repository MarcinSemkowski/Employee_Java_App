package factory.menu_strategy;
import factory.DB_Connection.DB_Strategy;
import factory.Department;
import factory.Factory;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class AddToFactory implements CaseStrategy {

 private DB_Strategy db_strategy;

    public AddToFactory(DB_Strategy db_strategy) {
        this.db_strategy = db_strategy;
    }

    @Override
    public void runCaseTask(Factory factory,Scanner scan) {
        System.out.println("Imię:");
        String nameDep = scan.next();


        System.out.println("Nocna Zmiana: ");
        System.out.println("True. Tak");
        System.out.println("False. Nie");
        boolean isNightShift = scan.nextBoolean();
        Department department = new Department(nameDep);
        department.setNightShift(isNightShift);

         boolean isAdded =  db_strategy.doCRUDTask(factory,department);
         if(isAdded){
             factory.addToFactory(nameDep, isNightShift);
             List<String> listKeys = factory.getDepartmentMap()
                     .keySet()
                     .stream()
                     .collect(Collectors.toList());
             MapKeys.getInstance().setMapKeys(listKeys);
         }else{
             System.out.println("Nie dodano !");
         }

    }

}
