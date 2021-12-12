package pkg;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public final class MySQLConnection {

	public static Connection getConnection(String user, String password) throws SQLException {
		var protocol = "jdbc:mysql:";
		var port = "3306";
		var host = "127.0.0.1";
		var database = "db_test";
		var properties = "user=" + user + "&password=" + password;
		var jdbcUrl = protocol + "//" + host + ":" + port + "/" + database + "?" + properties;

		return DriverManager.getConnection(jdbcUrl);

	}
}
