package factory.menu_strategy;

import factory.DB_Connection.DB_Strategy;
import factory.Factory;

import java.util.Scanner;

public interface CaseStrategy {
     void runCaseTask(Factory factory, Scanner scan);
}
