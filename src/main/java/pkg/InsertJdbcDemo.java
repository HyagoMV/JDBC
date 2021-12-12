package pkg;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/*
 *  docker run --name test-mysql -e MYSQL_ROOT_PASSWORD=toor -dp 3306:3306 mysql
 * 
 *	CREATE USER 'juser'@'%' identified by 'jpass';
 *	GRANT INSERT ON db.tb to 'juser'@'%';
 *
 *	DROP USER 'juser'@'%';
 */
public class InsertJdbcDemo {

	public static void main(String[] args) throws SQLException {
		Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/db?user=juser&password=jpass");
		
		for (var i = 100; i < 200; i++) {
			PreparedStatement prepareStatement = connection.prepareStatement("insert into tb (cl_name) values (?);");
			
			prepareStatement.setString(1, "testando " + i);
			
			prepareStatement.executeUpdate();
			
			prepareStatement.close();
		}

		
	
		connection.close();
	}

}
