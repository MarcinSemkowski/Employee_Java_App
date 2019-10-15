package factory.menu_strategy;

import factory.Factory;

import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class UpdateDepartmentFromFactory implements CaseStrategy {
    @Override
    public void runCaseTask(Factory factory, Scanner scan) {
        System.out.println("Wybierz kadrę. By zaktualizować.");

        int j = 0;
        String[] mapKeys = new String[factory.getDepartmentMap().size()];
        for (String nameKey : factory.getDepartmentMap().keySet()) {
            System.out.println(j + ": " + nameKey);
            mapKeys[j++] = nameKey;
        }
        System.out.println("------------------------");
        System.out.println();
        System.out.println(":");
        int updateId = scan.nextInt();

        System.out.println("Imię:");
        String nameUpdateDep = scan.next();

        System.out.println("Nocna Zmiana: ");
        System.out.println("True. Tak");
        System.out.println("False. Nie");
        boolean nightShiftUpdate = scan.nextBoolean();
        factory.updateToMapDepartment(updateId, mapKeys, nameUpdateDep, nightShiftUpdate);
        List<String> listKeys = factory.getDepartmentMap()
                .keySet()
                .stream()
                .collect(Collectors.toList());
        MapKeys.getInstance().setMapKeys(listKeys);
    }
}