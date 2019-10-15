package factory.menu_strategy;

import factory.Factory;

import java.util.Scanner;

public class CaseMenu {

private CaseStrategy caseStrategy;
 private Factory factory;
 private Scanner scan;

    public CaseMenu(Factory factory, Scanner scan) {
        this.factory = factory;
        this.scan = scan;
    }

    public void runTask(){
         caseStrategy.runCaseTask(factory,scan);
     }

    public CaseStrategy getCaseStrategy() {
        return caseStrategy;
    }

    public void setCaseStrategy(CaseStrategy caseStrategy) {
        this.caseStrategy = caseStrategy;
    }
}
