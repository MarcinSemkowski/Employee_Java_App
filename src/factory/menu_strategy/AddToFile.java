package factory.menu_strategy;

import factory.Department;
import factory.Factory;
import factory.employee.Employee;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.EmptyStackException;
import java.util.Optional;
import java.util.Scanner;

public class AddToFile implements CaseStrategy {


    @Override
    public void runCaseTask(Factory factory, Scanner scan) {

        System.out.println("Podaj nazwę działu, by zapisać.");
        String depName = scan.next();

        Optional<Department> department = Optional.ofNullable(factory.getDepartmentMap().get(depName));

        if (department.isPresent()) {

        }

    }


}

