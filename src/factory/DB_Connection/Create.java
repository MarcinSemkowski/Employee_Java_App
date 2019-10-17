package factory.DB_Connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class Create extends DB_Strategy {

    private  String sqlStmt = " ";

    @Override
    protected boolean doCRUDTask() {
        try {
            Connection conn = DriverManager.getConnection(this.getUrl(),this.getUser(),this.getPassword());
            Statement statement = conn.createStatement();
            statement.execute(this.sqlStmt);
            return true;
        }catch(SQLException e){
            e.getMessage();
            return false;
        }
    }
}
