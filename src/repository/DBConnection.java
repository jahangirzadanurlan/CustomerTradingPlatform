package repository;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {
    //Singleton pattern
    private static DBConnection instance=null;
    private static Connection connection=null;

    private DBConnection() throws ClassNotFoundException, SQLException {
        Class.forName("org.postgresql.Driver");
        String url="jdbc:postgresql://localhost:5432/customer_trading_platform";
        String username="postgres";
        String password="root";

        connection=DriverManager.getConnection(url,username,password);
    }
    public static synchronized DBConnection getInstance() throws SQLException, ClassNotFoundException {
        if (instance==null){
            instance=new DBConnection();
        }else if (instance.getConnection().isClosed()) {
            instance = new DBConnection();
        }
        return instance;
    }
    public Connection getConnection(){
        return connection;
    }
}
