package factory.menu_strategy;


import factory.Factory;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class AddToFactory implements MenuStrategy {

    private Factory factory;
    private Scanner scan;


    public AddToFactory(Factory factory, Scanner scan) {
        this.factory = factory;
        this.scan = scan;
    }

    @Override
    public void runCaseTask() {
        System.out.println("Imię:");
        String nameDep = scan.next();


        System.out.println("Nocna Zmiana: ");
        System.out.println("True. Tak");
        System.out.println("False. Nie");
        boolean isNightShift = scan.nextBoolean();


        factory.addToFactory(nameDep, isNightShift);
        List<String> listKeys = factory.getDepartmentMap()
                .keySet()
                .stream()
                .collect(Collectors.toList());
        MapKeys.getInstance().setMapKeys(listKeys);
    }

}
