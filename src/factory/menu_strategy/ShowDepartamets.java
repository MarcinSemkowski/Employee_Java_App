package factory.menu_strategy;

import factory.DB_Connection.DB_Strategy;
import factory.Department;
import factory.Factory;

import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class ShowDepartamets implements CaseStrategy {

   private DB_Strategy db_strategy;


    public ShowDepartamets(DB_Strategy db_strategy) {
        this.db_strategy = db_strategy;
    }

    @Override
    public void runCaseTask(Factory factory, Scanner scan) {
        System.out.println("Pobrać z bazy danych ? " +
                "1. Nie " +
                "2. Tak");
        int db_id = scan.nextInt();
        if(db_id == 2){
            db_strategy.doCRUDTask(factory,null);
            factory.setDepartmentMap(db_strategy.getDepartments());
            List<String> list = factory.getDepartmentMap()
                    .keySet()
                    .stream()
                    .collect(Collectors.toList());
            MapKeys.getInstance().setMapKeys(list);
        }


        System.out.println(factory.showDepartmentsFromMapDepartment());
        System.out.println(" ");
        System.out.println("-1. By wyjść");
        int depId = scan.nextInt();

        Department selectedDep = factory.selectedDepartment(MapKeys.getInstance().getMapKeys(),depId);
        System.out.println("Witaj w " + selectedDep.getName());
        selectedDep.showEmployeeMethods()
                .stream()
                .forEach(System.out::println);
        int employeeMethodId = scan.nextInt();
        System.out.println(" ");


        selectedDep.employeeMenu(employeeMethodId,scan);


    }


}
