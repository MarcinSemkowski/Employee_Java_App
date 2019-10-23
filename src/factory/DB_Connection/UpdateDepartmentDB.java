package factory.DB_Connection;

import factory.Department;
import factory.Factory;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class UpdateDepartmentDB extends DB_Strategy {

    @Override
    public boolean doCRUDTask(Factory factory, Department department) {
        String sqlUpdateDepartment = "UPDATE Departments SET dep_name = ?, is_night_shift= ?  WHERE dep_name = ? AND is_night_shift = ? ";

        try(Connection conn = DriverManager.getConnection(DatabaseData.URL.getName(),DatabaseData.USER.getName(),DatabaseData.PASSWORD.getName())) {
            conn.setAutoCommit(false);
            try(PreparedStatement psDeleteDepartment = conn.prepareStatement(sqlUpdateDepartment)) {
                psDeleteDepartment.setString(1,department.getName());
                psDeleteDepartment.setBoolean(2,department.isNightShift());
                return true;
            }catch (SQLException e){
                e.getMessage();
                if(conn!= null){
                    try {
                        conn.rollback();
                    }catch (Exception ex){
                        ex.printStackTrace();
                        return false;
                    }
                }
            }
        }catch (SQLException e){
            e.getMessage();
            return false;
        }
        return false;
    }
}




