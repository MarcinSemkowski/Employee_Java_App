import factory.Department;
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
                   System.out.println("Imię:");
                   String nameDep = scan.nextLine();

                   System.out.println("Nocna Zmiana: ");
                   System.out.println("1.Tak");
                   System.out.println("2.Nie");
                   int isNightShift = scan.nextInt();
                   Department newDep = Factory.createDepartment(nameDep);
                   switch (isNightShift){
                       case 1:

                           newDep.setNightShift(true);
                         factory.getDepratments().put(newDep.getName(),newDep);
                         break;
                       case 2:
                           newDep.setNightShift(false);
                           factory.getDepratments().put(newDep.getName(),newDep);
                           break;
                   }
                   break;
               case 2:

                   break;
           }
       }

    }

    private static void departmentMenu(){
        int menuNum = -1;
        System.out.println("Witaj w " + nameFactory);
        while (menuNum != 0){

         switch (menuNum){
             case 1:
         }
        }
    }

    private static void employeeMenu(int num){
        System.out.println("Witaj w " + nameFactory);
    }

}
