package factory.DB_Connection;

import factory.Department;
import factory.Factory;

import java.sql.*;

public class CreateFactory extends DB_Strategy {




    String sqlInsertFactory = "INSERT INTO factories(factory_name,factory_departments) " +
            "VALUES(?,?)";
    String sqlInsertDepartment = "INSERT INTO Departments(dep_name,dep_employee) VALUES(?,?) ";



    @Override
    public boolean doCRUDTask(Factory factory, Department department) {

        try (Connection conn = DriverManager.getConnection(this.getUrl(), this.getUser(), this.getPassword());
        ) {

            conn.setAutoCommit(false);

            try (PreparedStatement psInsertFac = conn.prepareStatement(sqlInsertFactory);
                 PreparedStatement ps_InsertDep = conn.prepareStatement(sqlInsertDepartment)

            ) {
                ps_InsertDep.setString(1,department.getName());
                ps_InsertDep.setInt(2,-1);
                psInsertFac.setString(1, factory.getName());
                psInsertFac.setInt(2, Department.getId());
                conn.commit();
                return true;
            } catch (SQLException e){
                e.printStackTrace();
                if(conn != null){
                    try {
                        conn.rollback();
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

