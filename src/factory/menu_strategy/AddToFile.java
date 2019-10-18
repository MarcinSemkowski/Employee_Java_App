package factory.menu_strategy;

import factory.DB_Connection.DB_Strategy;
import factory.Department;
import factory.Factory;
import factory.employee.Employee;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Optional;
import java.util.Scanner;
import java.util.stream.Collectors;

public class AddToFile implements CaseStrategy {


    @Override
    public void runCaseTask(Factory factory, Scanner scan) {

        System.out.println("Podaj nazwę działu, by zapisać.");
        String depName = scan.next();

        Optional<Department> department = Optional.ofNullable(factory.getDepartmentMap().get(depName));

        if (department.isPresent()) {
            System.out.println("Podaj ścieżkę do pliku, by zapisać.");
            String fileName = scan.next();

            Path path = Paths.get(fileName);

            if (Files.exists(path)){
                File file = new File(fileName);
                addDepartmentToFile(file,department.get());

            }else{
                System.out.println("Nie znaleziono pliku stworzono nowy plik.");
                File file = new File(fileName);
                addDepartmentToFile(file,department.get());
            }
        }
    }

    private boolean addDepartmentToFile(File file,Department department){
        try(BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(file))) {
            bufferedWriter.write(department.getName());
            bufferedWriter.newLine();
            bufferedWriter.write(department.getEmployees()
                    .stream()
                    .map(Employee::toString)
                    .collect(Collectors.joining(","))
            );
            return true;
        }catch (IOException e){
            return false;
        }
    }


}



