package factory;

import factory.DB_Connection.DatabaseData;
import factory.employee.Employee;

import java.sql.*;
import java.util.*;
import java.util.stream.Collectors;

public class Department {

    private static int idDB = 1;

    private int id;
    private String name;

    private boolean nightShift;

    private Set<Employee> employees;

    public Department(String name) {
        id = idDB++;
        this.name = name;
        this.employees = new TreeSet<>();
    }


    public List<String> showEmployeeMethods() {
        List<String> employeeMethods = Arrays.asList(
                "1. By dodać pracownika do \n"
                , "2 By usunąć pracownika z \n"
                , "3. By zaktualizować pracownika \n "
                , "4. By sortować  pracowników \n"
                , "5. By zobaczyć pracowników "
        );
        return employeeMethods;
    }

    public List<String> showSortMethods() {
        List<String> sortMethods = Arrays.asList(
                "1.By sortować alfabetycznie  \n"
                , " By sortować po wieku:\n"
                , "2. Od najstarszego do najmłodszego \n"
                , "3. Od najmłodszego do najstarszego \n "
        );
        return sortMethods;
    }

    public void sortEmployees(int index) {
        switch (index) {
            case 1:
                employees = sortAlphabetically();
                employees
                        .stream()
                        .forEach(System.out::println);
                break;
            case 2:
                employees = sortByAge();
                employees
                        .stream()
                        .forEach(System.out::println);
                break;
            case 3:
                employees = sortByAgeReversed();
                employees
                        .stream()
                        .forEach(System.out::println);
                break;

        }
    }


    public Set<Employee> sortAlphabetically() {
        return employees
                .stream()
                .sorted(Comparator.comparing(Employee::getName))
                .collect(Collectors.toCollection(LinkedHashSet::new));
    }

    public Set<Employee> sortByAge() {

        return employees
                .stream()
                .sorted(Comparator.comparingInt(Employee::getAge))
                .collect(Collectors.toCollection(LinkedHashSet::new));

    }

    public Set<Employee> sortByAgeReversed() {

        return employees
                .stream()
                .sorted(Comparator.comparingInt(Employee::getAge).reversed())
                .collect(Collectors.toCollection(LinkedHashSet::new));

    }


    public Employee employeeInfo(Scanner scan) {
        System.out.println("Podaj imię:");
        String name = scan.next();
        System.out.println("Podaj wiek:");
        int age = scan.nextInt();
        System.out.println("Podaj doświadczenie:");
        int experience = scan.nextInt();
        return new Employee(name, age, this, experience);
    }

    public void employeeMenu(int index, Scanner scan) {
        switch (index) {
            case 1:
                Employee newEmployee = employeeInfo(scan);
                addEmployeeToDepartment(newEmployee);

                break;
            case 2:
                deleteEmployee(employeeInfo(scan));
                break;
            case 3:

                Employee employee = employeeInfo(scan);
                if (employees.contains(employee)) {
                    System.out.println("Podaj imię: " + "imię: " + employee.getName());
                    String name = scan.next();
                    System.out.println("Podaj wiek: " + "wiek: " + employee.getAge());
                    int age = scan.nextInt();
                    System.out.println("Podaj doświadczenie: " + "doświadczenie: " + employee.getExperience());
                    int experience = scan.nextInt();
                    updateEmployee(employee, new Employee(name, age, this, experience));

                } else {
                    System.out.println("Nie ma takiego pracownika !");
                }
                break;
            case 4:
                showSortMethods()
                        .stream()
                        .forEach(System.out::println);
                int sortId = scan.nextInt();
                sortEmployees(sortId);

                break;
            case 5:
                employees
                        .stream()
                        .forEach(System.out::println);
                break;


        }
    }

    public boolean addEmployeeToDatabase(Employee employee) {
        String sqlAddEmployee = "INSERT INTO employees(employee_name, employee_age, employee_dep_id, employee_experiance) " +
                "VALUES(?,?,?,?)";
        ResultSet resultSet = null;
        try (Connection conn = DriverManager.getConnection(DatabaseData.URL.getName()
                , DatabaseData.USER.getName()
                , DatabaseData.PASSWORD.getName())) {
            conn.setAutoCommit(false);
            try (Statement statement = conn.createStatement();
                 PreparedStatement ps_addEmployeeToDB = conn.prepareStatement(sqlAddEmployee)) {

                resultSet = statement.executeQuery("SELECT * FROM Departments WHERE dep_name = " + "'" + this.getName() + "'");

                if (resultSet.next()) {
                    int depId = resultSet.getInt("dep_id");
                    ps_addEmployeeToDB.setString(1, employee.getName());
                    ps_addEmployeeToDB.setInt(2, employee.getAge());
                    ps_addEmployeeToDB.setInt(3, depId);
                    ps_addEmployeeToDB.setInt(4, employee.getExperience());
                    ps_addEmployeeToDB.executeUpdate();
                    conn.commit();
                    return true;
                } else {
                    return false;
                }


            } catch (SQLException e) {
                System.out.println(e.getMessage());
                if (conn != null) {
                    try {
                        conn.rollback();
                    } catch (Exception ex) {
                        ex.printStackTrace();
                        return false;
                    }
                }
                return false;
            } finally {
                if (resultSet != null) {
                     resultSet.close();
                }
            }


        } catch (SQLException e) {
            e.getMessage();

            return false;
        }
    }


    public boolean deleteEmployeeFromDB(Employee employee){

        String sqlDeleteEmployeeDB = "DELETE FROM employees WHERE dep_name = ?";

        try(Connection conn = DriverManager.getConnection(DatabaseData.URL.getName()
                ,DatabaseData.USER.getName()
                ,DatabaseData.PASSWORD.getName())) {
             try( PreparedStatement statement = conn.prepareStatement(sqlDeleteEmployeeDB)
             ) {
               statement.setString(1,employee.getName());
             }

        }catch (SQLException e){
            e.getMessage();
            return false;
        }
        return false;
    }


      public boolean updateEmployee(Employee employee){
        String sqlUpdateEmployee = "UPDATE employee SET employee_name = ?, employee_age= ?, employee_experiance = ?";

        try(Connection connection = DriverManager.getConnection(DatabaseData.URL.getName(),DatabaseData.USER.getName(),DatabaseData.PASSWORD.getName())) {

            try(PreparedStatement psUpdateEmployee = connection.prepareStatement(sqlUpdateEmployee)) {
                psUpdateEmployee.setString(1, employee.getName());
                psUpdateEmployee.setInt(2, employee.getAge());
                psUpdateEmployee.setInt(3, employee.getExperience());
                psUpdateEmployee.executeUpdate();
                connection.commit();
                return true;
            }catch (SQLException e){
             e.getMessage();

            }

        }catch (SQLException e){
            e.getMessage();
            return false;
        }
        return true;
      }






    public boolean updateEmployee(Employee employee, Employee updateEmployee) {
        if (employees.contains(employee)) {
            employees.remove(employee);
            employees.add(updateEmployee);

            return true;
        } else {
            System.out.println("Nie ma takiego pracownika !");
            return false;
        }
    }


    public boolean deleteEmployee(Employee employee) {
        if (employees.contains(employee)) {
            employees.remove(employee);
            System.out.println("Poprawnie usunięto " + employee.getName() + "z " + this.getName());
             boolean isDelete = deleteEmployeeFromDB(employee);
             if(isDelete){
                 return true;
             }
        } else {
            System.out.println("Nie ma takiego pracownika !");
            return false;
        }
        return false;
    }

    public boolean addEmployeeToDepartment(Employee employee) {
        if (employees.add(new Employee(employee.getName()
                , employee.getAge()
                , employee.getDepartment()
                , employee.getExperience()))) {
            boolean isAdded = addEmployeeToDatabase(employee);
            if(isAdded){
                return true;
            }
        }
        return false;
    }




    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isNightShift() {
        return nightShift;
    }

    public void setNightShift(boolean nightShift) {
        this.nightShift = nightShift;
    }

    public Set<Employee> getEmployees() {
        return employees;
    }

    public void setEmployees(Set<Employee> employees) {
        this.employees = employees;
    }


    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || this.getClass() != obj.getClass()) {
            return false;
        }
        if (obj instanceof Department) {
            Department o = (Department) obj;
            if (this.name.equals(o.getName()) && this.isNightShift() == o.isNightShift()) {
                return true;
            } else {
                return false;
            }
        } else {
            return false;
        }
    }

    public Employee searchEmployeeByName(String employeeName) {
        return employees
                .stream()
                .filter(x -> x.getName().equals(employeeName))
                .findFirst()
                .orElse(null);

    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 31 * hash + (this.name == null ? 0 : name.hashCode());
        hash = 31 * hash + (Boolean.hashCode(this.nightShift));
        Iterator i = employees.iterator();
        while (i.hasNext()) {
            Object emp = i.next();
            hash = 31 * hash + (emp == null ? 0 : emp.hashCode());
        }

        return hash;
    }

    @Override
    public String toString() {
        return "Department{" +
                "name='" + name + '\'' +
                ", nightShift=" + nightShift +
                ", employees=" + employees
                .stream()
                .map(e -> e.getName())
                .collect(Collectors.joining()) +
                '}';
    }
}
