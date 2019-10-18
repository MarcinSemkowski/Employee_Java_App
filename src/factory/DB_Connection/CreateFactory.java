package factory.DB_Connection;

import factory.Department;
import factory.Factory;

import java.sql.*;

public class CreateFactory extends DB_Strategy {

    String sqlFactory = "INSERT INTO factories(factory_name,factory_departments) " +
            "VALUES(?,?)";


    @Override
    protected boolean doCRUDTask(Factory factory, Department department) {

        try (Connection conn = DriverManager.getConnection(this.getUrl(), this.getUser(), this.getPassword());
        ) {

            conn.setAutoCommit(false);

            try (PreparedStatement psInsert = conn.prepareStatement(sqlFactory)) {
                psInsert.setString(1, factory.getName());
                psInsert.setInt(2, 0);
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

