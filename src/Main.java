import factory.Department;
import factory.Factory;
import factory.menu_strategy.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Main {

    private static Scanner scan = new Scanner(System.in);
    private static String nameFactory;
    private static Factory factory;
    private static List<String> mapKey = new ArrayList<>();
    private static CaseMenu caseMenu;

    public static void main(String[] args) {


        System.out.println("Witaj wpisz nazwę swojej fabryki.");
        nameFactory = scan.nextLine();
        System.out.println("------------------------");
        factory = new Factory(nameFactory);
        caseMenu = new CaseMenu(factory, scan);


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
                    ,"7 By dodać do pliku wybrany dział"
                    , "0. by zakończyć "
            );
            menuList.stream().forEach(System.out::println);

            System.out.println("----------------------");
            System.out.println();

            menuNum = scan.nextInt();
            switch (menuNum) {
                case 1:
                    caseMenu.setCaseStrategy(new AddToFactory());
                    caseMenu.runTask();
                    break;
                case 2:
                    caseMenu.setCaseStrategy(new DeleteFromFactory());
                    caseMenu.runTask();
                    break;
                case 3:
                    caseMenu.setCaseStrategy(new ShowDepartamets());
                    caseMenu.runTask();
                    break;
                case 4:
                    caseMenu.setCaseStrategy(new UpdateDepartmentFromFactory());
                    caseMenu.runTask();
                    break;
                case 5:
                    factory.showSortDepartments();
                    int sortId = scan.nextInt();
                    factory.setDepartmentMap(factory.sortDepartments(sortId));
                    break;
                case 6:
                    factory.showFindByMethods();
                    int findById = scan.nextInt();
                    switch (findById) {
                        case 1:
                            caseMenu.setCaseStrategy(new FindByName());
                            caseMenu.runTask();
                            break;
                        case 2:
                            caseMenu.setCaseStrategy(new FindByNightShift());
                            caseMenu.runTask();
                            break;
                    }
                    break;
                case 7:
                  caseMenu.setCaseStrategy(new AddToFile());
                  caseMenu.runTask();
                 break;


            }
        }

    }


}
