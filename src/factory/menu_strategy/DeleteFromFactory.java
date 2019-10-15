package factory.menu_strategy;

import factory.Factory;

import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class DeleteFromFactory implements CaseStrategy {

    @Override
    public void runCaseTask(Factory factory, Scanner scan) {
        System.out.println("Wybierz kadrę, by usunąć.");

        int i = 0;


        for (String key : MapKeys.getInstance().getMapKeys()) {
            System.out.println(i++ + " " + key);
        }
        System.out.println("------------------------");
        System.out.println();
        System.out.println(":");
        int deleteId = scan.nextInt();
        factory.deleteFromFactory(deleteId, MapKeys.getInstance().getMapKeys());
        List<String> listKeys = factory.getDepartmentMap()
                .keySet()
                .stream()
                .collect(Collectors.toList());
        MapKeys.getInstance().setMapKeys(listKeys);
    }
}
