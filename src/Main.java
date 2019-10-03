import factory.Factory;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collector;
import java.util.stream.Collectors;

public class Main {

    private static Scanner scan = new Scanner(System.in);
    private static String nameFactory;
    private static Factory factory;
   private static List<String> mapKey = new ArrayList<>();

    public static void main(String[] args) {


        System.out.println("Witaj wpisz nazwę swojej fabryki.");
        nameFactory = scan.nextLine();
        System.out.println("------------------------");
        factory = new Factory(nameFactory);


        menu();
    }

    private static void menu() {
        int menuNum = -1;


        while (menuNum != 0) {
            System.out.println("Witaj w " + nameFactory);
            List<String> menuList = Arrays.asList(
                    "1. dodać kadrę \n"
                    , "2. usunąć kadrę\n"
                    , "3. zobaczyć kadry \n"
                    , "4. zaktualizować kadrę\n"
                    , "5. sortować kadrę\n"
                    , "6. By znaleźć po: \n"
                    , "0. by zakończyć "
            );
            menuList.stream().forEach(System.out::println);

            System.out.println("----------------------");
            System.out.println();

            menuNum = scan.nextInt();
            switch (menuNum) {
                case 1:
                    System.out.println("Imię:");
                    String nameDep = scan.next();


                    System.out.println("Nocna Zmiana: ");
                    System.out.println("True. Tak");
                    System.out.println("False. Nie");
                    boolean isNightShift = scan.nextBoolean();


                    factory.addToMapDepartment(nameDep, isNightShift);
                    mapKey = factory.getDepartmentMap()
                            .keySet()
                            .stream()
                            .collect(Collectors.toList());
                    break;
                case 2:
                    System.out.println("Wybierz kadrę, by usunąć.");

                    int i = 0;


                    for (String key : mapKey) {
                        System.out.println(i++ + " " + key);
                    }
                    System.out.println("------------------------");
                    System.out.println();
                    System.out.println(":");
                    int deleteId = scan.nextInt();
                    factory.deleteFromMapDepartment(deleteId, mapKey);
                    mapKey = factory.getDepartmentMap()
                            .keySet()
                            .stream()
                            .collect(Collectors.toList());
                    break;
                case 3:
                    System.out.println(factory.showDepartmentsFromMapDepartment());
                    System.out.println(" ");
                    System.out.println("0. By wyjść");
                    int depId = scan.nextInt();

                    System.out.println("");
                    break;
                case 4:

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
                    mapKey = factory.getDepartmentMap()
                            .keySet()
                            .stream()
                            .collect(Collectors.toList());
                    break;
                case 5:
                    factory.showSortDepartments();
                    int sortId = scan.nextInt();
                    factory.setDepartmentMap(factory.sortDepartments(sortId));
                    break;
                    case 6:
                     factory.showFindByMethods();
                     int findById = scan.nextInt();
                     switch (findById){
                         case 1:
                             System.out.println("Imię:");
                            String name = scan.next();
                             System.out.println(factory.findBy(name));
                             break;
                         case 2:
                             System.out.println("Nocna zmiana: ");
                             System.out.println("True - Tak");
                             System.out.println("False - Nie");
                             boolean nightShiftGet = scan.nextBoolean();
                              factory.findBy(nightShiftGet).stream().forEach(System.out::println);
                             break;
                     }

                        break;


            }
        }

    }


    private static void departmentMenu() {
        int menuNum = -1;
        System.out.println("Witaj w " + nameFactory);
        while (menuNum != 0) {

            switch (menuNum) {
                case 1:
            }
        }
    }

    private static void employeeMenu(int num) {
        System.out.println("Witaj w " + nameFactory);
    }

}
