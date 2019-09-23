package factory;

import java.util.Set;
import java.util.TreeSet;

public class Factory {

private String name;

private Set employees;

    public Factory(String name) {
        this.name = name;
        employees = new TreeSet();
    }


}
