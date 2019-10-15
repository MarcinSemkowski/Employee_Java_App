package factory.menu_strategy;

import factory.Department;
import factory.Factory;

import java.util.Scanner;

public class ShowDepartamets implements CaseStrategy {
    @Override
    public void runCaseTask(Factory factory, Scanner scan) {
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
