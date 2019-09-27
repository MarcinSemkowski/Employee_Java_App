import factory.Factory;

import java.util.Scanner;

public class Main {

    private static Scanner scan = new Scanner(System.in);
    private static String nameFactory;
    private static Factory factory;

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
            System.out.println("1. dodać kadrę \n" +
                    "\n" +
                    "2. usunąć kadrę\n" +
                    "\n" +
                    "\n" +
                    "3. zobaczyć kadry \n" +
                    "\n" +
                    "4. zaktualizować kadrę\n" +
                    "\n" +
                    "5. sortować kadrę\n" +
                    "\n" +
                    "0. by zakończyć ");
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

                      factory.addToMapDepartment(nameDep,isNightShift);
                    break;
                case 2:
                    System.out.println("Wybierz kadrę, by usunąć.");

                    int i = 0;
                    String[] mapKey = new String[factory.getDepartmentMap().size()];
                    for (String nameKey : factory.getDepartmentMap().keySet()) {
                        System.out.println(i + ": " + nameKey);
                        mapKey[i++] = nameKey;
                    }
                    System.out.println("------------------------");
                    System.out.println();
                    System.out.println(":");
                    int deleteId = scan.nextInt();
                    factory.deleteFromMapDepartment(deleteId,mapKey);
                    break;
                case 3:
                     System.out.println(factory.showDepartmentsFromMapDepartment());
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
