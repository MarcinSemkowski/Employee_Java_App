package factory.DB_Connection;

import factory.Department;
import factory.Factory;

import java.sql.*;

public class CreateDepartmentToDB extends DB_Strategy {



    String sqlUpdateFactory = "UPDATE Factories SET factory_departments = ? WHERE factory_name = ?; ";

    String sqlInsertDepartment = "INSERT INTO Departments (dep_name, is_night_shift, dep_employee) VALUES (?,?,?);";



    @Override
    public boolean doCRUDTask(Factory factory, Department department) {

        try (Connection conn = DriverManager.getConnection(this.getUrl(), this.getUser(), this.getPassword())
        ) {

            conn.setAutoCommit(false);

            try (PreparedStatement ps_Update_Factory = conn.prepareStatement(sqlUpdateFactory);
                 PreparedStatement ps_InsertToDepartment = conn.prepareStatement(sqlInsertDepartment)) {
                ps_Update_Factory.setInt(1,Department.getId());
                ps_Update_Factory.setString(2,factory.getName());
                ps_Update_Factory.executeUpdate();

                ps_InsertToDepartment.setString(1,department.getName());
                ps_InsertToDepartment.setBoolean(2,department.isNightShift());
                ps_InsertToDepartment.setInt(3,-1);
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

