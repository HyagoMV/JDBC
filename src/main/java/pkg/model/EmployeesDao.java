package pkg.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Optional;

public class EmployeesDao {

	public boolean create(Employees employees) {
		try {
			Connection connection = null;
			PreparedStatement prepareStatement = null;
			try {
				try {
					connection = DriverManager
							.getConnection("jdbc:mysql://localhost:3306/db_account?user=root&password=toor");
					prepareStatement = connection
							.prepareStatement("insert into tb_employees (pk_employees, cl_name) values (?, ?);");

					connection.setAutoCommit(false);

					prepareStatement.setLong(1, employees.getId());
					prepareStatement.setString(2, employees.getName());

					var wasSavedEmployees = prepareStatement.executeUpdate() != 0;

					connection.commit();

					return wasSavedEmployees;
				} finally {
					if (prepareStatement != null)
						prepareStatement.close();
					if (connection != null)
						connection.rollback();
				}
			} finally {
				if (connection != null)
					connection.close();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}

	public Optional<Employees> read(Long id) {
		try {
			Connection connection = null;
			PreparedStatement prepareStatement = null;
			try {
				try {
					connection = DriverManager
							.getConnection("jdbc:mysql://localhost:3306/db_account?user=root&password=toor");
					prepareStatement = connection
							.prepareStatement("select * from tb_employees where pk_employees = ?;");

					connection.setAutoCommit(false);

					prepareStatement.setLong(1, id);

					var resultSet = prepareStatement.executeQuery();
					if (resultSet.next()) {
						Employees employees = new Employees();
						employees.setId(resultSet.getLong(1));
						employees.setName(resultSet.getString(2));

						connection.commit();

						return Optional.of(employees);
					}
				} finally {
					if (prepareStatement != null)
						prepareStatement.close();
					if (connection != null)
						connection.rollback();
				}
			} finally {
				if (connection != null)
					connection.close();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return Optional.empty();
	}

	public boolean updateEmployeesName(Long id, String name) {
		try {
			Connection connection = null;
			PreparedStatement prepareStatement = null;
			try {
				try {
					connection = DriverManager
							.getConnection("jdbc:mysql://localhost:3306/db_account?user=root&password=toor");
					prepareStatement = connection
							.prepareStatement("update tb_employees set cl_name = ? where pk_employees = ?;");

					connection.setAutoCommit(false);

					prepareStatement.setString(1, name);
					prepareStatement.setLong(2, id);

					var wasUpdatedEmployeesName = prepareStatement.executeUpdate() != 0;

					connection.commit();

					return wasUpdatedEmployeesName;
				} finally {
					if (prepareStatement != null)
						prepareStatement.close();
					if (connection != null)
						connection.rollback();
				}
			} finally {
				if (connection != null)
					connection.close();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}

	public boolean delete(Long id) {
		try {
			Connection connection = null;
			PreparedStatement prepareStatement = null;
			try {
				try {
					connection = DriverManager
							.getConnection("jdbc:mysql://localhost:3306/db_account?user=root&password=toor");
					prepareStatement = connection.prepareStatement("delete from tb_employees where pk_employees = ?;");

					connection.setAutoCommit(false);

					prepareStatement.setLong(1, id);

					var wasDeletedEmployees = prepareStatement.executeUpdate() != 0;

					connection.commit();

					return wasDeletedEmployees;
				} finally {
					if (prepareStatement != null)
						prepareStatement.close();
					if (connection != null)
						connection.rollback();
				}
			} finally {
				if (connection != null)
					connection.close();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}
}
