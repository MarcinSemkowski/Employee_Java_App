import factory.Factory;

import java.util.Scanner;

public class Main {

    private static Scanner scan = new Scanner(System.in);
    private static String nameFactory;
    private static Factory factory ;

    public static void main(String[] args) {


        System.out.println("Witaj wpisz nazwę swojej fabryki.");
        nameFactory = scan.nextLine();
        System.out.println("------------------------");

    }

    private static void  menu(){
       int menuNum = -1;
        System.out.println("Witaj w " + nameFactory);

        while (menuNum == 0) {
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

            menuNum = scan.nextInt();
            factory = new Factory(nameFactory);
           switch (menuNum) {
               case 1:
                 
                   break;
               case 2:

                   break;
           }
       }

    }

    private static void employee_menu(int num){
        System.out.println("Witaj w " + nameFactory);
    }

}
