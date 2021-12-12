package pkg;

import java.sql.DriverManager;
import java.sql.SQLException;

/*
 *  docker run --name test-mysql -e MYSQL_ROOT_PASSWORD=toor -dp 3306:3306 mysql
 * 
 *	CREATE USER 'juser'@'%' identified by 'jpass';
 *	GRANT INSERT, SELECT ON db.tb to 'juser'@'%';
 *
 *	DROP USER 'juser'@'%';
 */
public class SelectdbcDemo {

	public static void main(String[] args) {

		try (var connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/db?user=juser&password=jpass");
				var prepareStatement = connection.prepareStatement("SELECT cl_name FROM tb");
				var resultSet = prepareStatement.executeQuery()){

				while (resultSet.next())
					System.out.println(resultSet.getString(1));
				
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
