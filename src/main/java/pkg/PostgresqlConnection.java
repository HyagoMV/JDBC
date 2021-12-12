package pkg;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public final class PostgresqlConnection {

	public static Connection getConnection(String user, String password) throws SQLException  {
		var protocol = "jdbc:postgresql:";
		var port = "5432";
		var host = "127.0.0.1";
		var database = "db_test";
		var properties = "user=" + "postgres" + "&password=" + password;
		var jdbcUrl = protocol + "//" + host + ":" + port + "/" + database + "?" + properties;

		return DriverManager.getConnection(jdbcUrl);
	}
}
