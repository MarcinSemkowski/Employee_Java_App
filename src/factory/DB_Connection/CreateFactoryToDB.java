package factory.DB_Connection;

import factory.Department;
import factory.Factory;
import factory.menu_strategy.MapKeys;

import java.sql.*;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

public class CreateFactoryToDB extends DB_Strategy {



    @Override
    public void getDepartmentsMap(Map<String,Department> departmentMap) {
      this.departmentMap = departmentMap;
    }

    @Override
    public boolean doCRUDTask(Factory factory, Department department) {


        String sqlFindFactory = "SELECT * FROM factories WHERE factory_name = " + "'"  + factory.getName() + "'";
        String sqlInsertFactory = "INSERT INTO Factories (factory_name)" +

                " VALUES (?);";

        ResultSet rs_FindDepartments = null;

        try (Connection con = DriverManager.getConnection(getUrl(), getUser(), getPassword())) {

            con.setAutoCommit(false);

            try(
                    Statement ps_findDepartments = con.createStatement();
                    Statement ps_FindFactory = con.createStatement();
                    ResultSet resultSetFindFactory = ps_FindFactory.executeQuery(sqlFindFactory);
                    PreparedStatement createFactory = con.prepareStatement(sqlInsertFactory)
                    ) {


                if (resultSetFindFactory.next()) {
                    String factoryName;

                    factoryName = resultSetFindFactory.getString("factory_name");
                    int factory_id = resultSetFindFactory.getInt("factory_id");

                    Optional<String> isFindFactory = Optional.ofNullable(factoryName);
                    if (isFindFactory.isPresent()) {

                        rs_FindDepartments = ps_findDepartments.executeQuery("SELECT * FROM Departments WHERE dep_factory_id = " + "'" + factory_id + "'");

                        Map<String,Department> newDeps = new HashMap<>();
                            while (rs_FindDepartments.next()) {
                                String dep_name = rs_FindDepartments.getString("dep_name");
                                boolean isNightShift = rs_FindDepartments.getBoolean("is_night_shift");
                               Department newDep = new Department(dep_name);
                               newDep.setNightShift(isNightShift);
                               newDeps.put(newDep.getName(),newDep);
                            }
                            getDepartmentsMap(newDeps);
                        List<String> list = factory.getDepartmentMap()
                                .keySet()
                                .stream()
                                .collect(Collectors.toList());
                        MapKeys.getInstance().setMapKeys(list);




                    }else{
                        createFactory.setString(1, factory.getName());
                        createFactory.executeUpdate();
                    }
                }
                con.commit();


                return true;


            } catch(SQLException e) {
                System.out.println(e.getMessage());
                if (con != null) {
                    try {
                        con.rollback();
                    } catch (Exception ex) {
                        ex.printStackTrace();
                    }
                }
                return false;
            } finally {
              if(rs_FindDepartments != null){
                  rs_FindDepartments.close();
              }
            }




        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }

    }




}
