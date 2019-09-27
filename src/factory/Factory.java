package factory;

import factory.employee.Employee;

import java.util.HashMap;
import java.util.Map;

public class Factory {

    private String name;

    private Map<String, Department> departmentMap;


    public Factory(String name) {
        this.name = name;
        departmentMap = new HashMap<>();
    }




    public boolean addToMapDepartment(String nameDep,boolean nightShift){
        Department newDep = new Department(nameDep);
        newDep.setNightShift(nightShift);
        departmentMap.put(newDep.getName(), newDep);
       return departmentMap.containsKey(newDep.getName());
    }

    public boolean deleteFromMapDepartment(int index,String[] arrayKey){
       String key = arrayKey[index];
       departmentMap.remove(key);
        System.out.println("Poprawnie Usunięto: " + key);
        System.out.println("-------------------------------");
       return  departmentMap.containsKey(key);
    }

    public String showDepartmentsFromMapDepartment(){
        StringBuffer keys = new StringBuffer();
        for (String key: departmentMap.keySet()) {
            keys.append("-----------------------");
            keys.append("\n");
            keys.append("-------------");
            keys.append("\n");
            keys.append(key);
            keys.append("\n");
            keys.append("------------");
            keys.append("\n");

        }
        keys.append("-----------------------");
        return keys.toString();
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Map<String, Department> getDepartmentMap() {
        return departmentMap;
    }


}
