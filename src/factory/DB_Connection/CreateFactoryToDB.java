package factory.DB_Connection;

import factory.Department;
import factory.Factory;

import java.sql.*;
import java.util.Optional;

public class CreateFactoryToDB extends DB_Strategy {


    private String sqlFindDepartments = "SELECT * FROM  Departments WHERE dep_factory_id = ? ";
   private String sqlFindFactory = "SELECT * FROM factories WHERE factory_name = ?";
   private   String sqlInsertFactory = "INSERT INTO Factories (factory_name)" +

            " VALUES (?);";


    @Override
    public boolean doCRUDTask(Factory factory, Department department) {
        try (Connection con = DriverManager.getConnection(getUrl(), getUser(), getPassword())) {

            con.setAutoCommit(false);

            try ( PreparedStatement ps_findDepartments = con.prepareStatement(sqlFindDepartments);
                  ResultSet rs_FindDepartments =  ps_findDepartments.executeQuery();
                    PreparedStatement ps_FindFactory = con.prepareStatement(sqlFindFactory);
                  ResultSet resultSetFindFactory = ps_FindFactory.executeQuery();
                  PreparedStatement ps_InsertFactory = con.prepareStatement(sqlInsertFactory)) {



                ps_FindFactory.setString(1,factory.getName());



               if(resultSetFindFactory.next()){
                   String factoryName;

                   factoryName = resultSetFindFactory.getString("factory_name");

                   Optional<String> isFindFactory = Optional.ofNullable(factoryName);
                 if(isFindFactory.isPresent()) {
                     Factory findFactory = new Factory(factoryName);
                     factory = findFactory;

                     if(rs_FindDepartments.next()){
                         while(rs_FindDepartments.next()){
                            String dep_name = rs_FindDepartments.getString("dep_name");
                           boolean isNightShift =  rs_FindDepartments.getBoolean("is_night_shift");
                           if(resultSetFindFactory.getInt("factory_id") ==
                                   rs_FindDepartments.getInt("dep_factory_id")){
                               factory.addToFactory(dep_name,isNightShift);
                           }
                          }
                     }

                 }
               }


                ps_InsertFactory.setString(1,factory.getName());


                ps_InsertFactory.executeUpdate();


                con.commit();
                return true;
            } catch (SQLException e){
                System.out.println(e.getMessage());
                if(con != null){
                    try {
                        con.rollback();
                    }catch (Exception ex){
                        ex.printStackTrace();
                    }
                }
                return false;
            }



        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }

    }





}
