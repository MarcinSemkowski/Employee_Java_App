package factory.menu_strategy;

import factory.Factory;

import java.util.Scanner;

public class FindByName implements CaseStrategy {
    @Override
    public void runCaseTask(Factory factory, Scanner scan) {
        System.out.println("Imię:");
        String name = scan.next();
        System.out.println(factory.findBy(name));
    }
}
