package programm;

import java.sql.*;

public class DB {

    private final String HOST = "localhost";
    private final String PORT = "3306";
    private final String DB_NAME = "java_db";
    private final String LOGIN = "mysql";
    private final String PASS = "mysql";

    private Connection dbConn = null;

    private Connection getDbConnection() throws SQLException, ClassNotFoundException {
        String connStr = "jdbc:mysql://" + HOST + ":" + PORT + "/" + DB_NAME + "?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
        Class.forName("com.mysql.cj.jdbc.Driver");

        dbConn = DriverManager.getConnection(connStr, LOGIN, PASS);

        return dbConn;
    }

    public void createTable (String table) throws SQLException, ClassNotFoundException {
        String sql = "CREATE TABLE IF NO EXISTS " + table + " (idex INT AUTO_INCREMENT PRIMARY KEY, titlex, name VARCHAR(50), passwordx VARCHAR(89))"
                + " ENGINE = MYISAM";
        Statement statement =getDbConnection().createStatement();
        statement.executeUpdate(sql);
    }
}