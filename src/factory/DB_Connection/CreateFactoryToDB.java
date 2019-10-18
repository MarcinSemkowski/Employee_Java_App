package factory.DB_Connection;

import factory.Department;
import factory.Factory;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class CreateFactoryToDB extends DB_Strategy {



    String sqlInsertFactory = "INSERT INTO Factories (factory_name, factory_departments)" +
            " VALUES (?,?);";


    @Override
    public boolean doCRUDTask(Factory factory, Department department) {
        try (Connection con = DriverManager.getConnection(getUrl(), getUser(), getPassword())) {

            con.setAutoCommit(false);

            try (PreparedStatement ps_InsertFactory = con.prepareStatement(sqlInsertFactory)) {


                ps_InsertFactory.setString(1,factory.getName());
                ps_InsertFactory.setInt(2, -1);

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
