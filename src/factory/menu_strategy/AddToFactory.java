package factory.menu_strategy;


import factory.Factory;

import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class AddToFactory implements CaseStrategy {



    @Override
    public void runCaseTask(Factory factory,Scanner scan) {
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
