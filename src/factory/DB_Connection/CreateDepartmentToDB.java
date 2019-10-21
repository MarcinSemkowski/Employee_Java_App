package factory.DB_Connection;

import factory.Department;
import factory.Factory;

import java.sql.*;

public class CreateDepartmentToDB extends DB_Strategy {



    String sqlGetFactoryId = "Select * from factories WHERE factory_name = ?; ";

    String sqlInsertDepartment = "INSERT INTO Departments (dep_name, is_night_shift, dep_factory_id) VALUES (?,?,?);";



    @Override
    public boolean doCRUDTask(Factory factory, Department department) {

        try (Connection conn = DriverManager.getConnection(this.getUrl(), this.getUser(), this.getPassword())
        ) {

            conn.setAutoCommit(false);

            try ( PreparedStatement statement = conn.prepareStatement(sqlGetFactoryId);
                    ResultSet ps_get_id_Factory = statement.executeQuery();
                 PreparedStatement ps_InsertToDepartment = conn.prepareStatement(sqlInsertDepartment)) {

                statement.setString(1,factory.getName());
                int id =  ps_get_id_Factory.findColumn("factory_id");

                ps_InsertToDepartment.setString(1,department.getName());
                ps_InsertToDepartment.setBoolean(2,department.isNightShift());
                ps_InsertToDepartment.setInt(3,id);
                ps_InsertToDepartment.executeUpdate();
                conn.commit();
                return true;
            }catch (SQLException e){
                e.printStackTrace();
                if(conn != null){
                    try {
                        conn.rollback();
                    }catch(Exception ex){
                        ex.printStackTrace();
                        return false;
                    }
                }
            }




        } catch (SQLException e) {
            e.printStackTrace();
             return false;
        }

     return  false;
    }
}

