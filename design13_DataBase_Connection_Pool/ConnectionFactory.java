package src.design13_DataBase_Connection_Pool;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionFactory {
    public static Connection createConnection() throws SQLException {
        return DriverManager.getConnection("jdbc:DB url ");
    }
}
