package factory.menu_strategy;

import factory.Factory;

import java.util.Scanner;

public class FindByNightShift implements CaseStrategy {


    @Override
    public void runCaseTask(Factory factory, Scanner scan) {
        System.out.println("Nocna zmiana: ");
        System.out.println("True - Tak");
        System.out.println("False - Nie");
        boolean nightShiftGet = scan.nextBoolean();
        factory.findBy(nightShiftGet).stream().forEach(System.out::println);
    }
}
