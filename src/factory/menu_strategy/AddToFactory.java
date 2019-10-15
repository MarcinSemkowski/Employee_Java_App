package factory.menu_strategy;


import factory.Factory;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class AddToFactory implements MenuStrategy {

    Scanner scan = new Scanner(System.in);

    private static List<String> mapKey = new ArrayList<>();

    @Override
    public void runCaseTask(Factory factory) {
        System.out.println("Imię:");
        String nameDep = scan.next();


        System.out.println("Nocna Zmiana: ");
        System.out.println("True. Tak");
        System.out.println("False. Nie");
        boolean isNightShift = scan.nextBoolean();


        factory.addToFactory(nameDep, isNightShift);
        mapKey = factory.getDepartmentMap()
                .keySet()
                .stream()
                .collect(Collectors.toList());
    }

    public static List<String> getMapKey() {
        return mapKey;
    }


}
