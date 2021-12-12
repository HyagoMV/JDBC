package pkg.model.test;

import java.util.Optional;

import pkg.model.Employees;
import pkg.model.EmployeesDao;

public class EmployeesTestDriver {

	public static void main(String[] args) {
		EmployeesDao dao = new EmployeesDao();

		testCreate(dao);
		testRead(dao);
		testUpdateEmployeesName(dao);
		testDelete(dao);

	}

	private static void testRead(EmployeesDao dao) {
		Optional<Employees> emOptional = dao.read(1L);
		emOptional.ifPresent(System.out::println);
	}

	private static void testCreate(EmployeesDao dao) {
		Employees employees = new Employees(1L, "Brain");
		boolean wasSavedEmployees = dao.create(employees);
		System.out.println(wasSavedEmployees ? "Success" : "Not Success");
	}
	
	private static void testUpdateEmployeesName(EmployeesDao dao) {
		boolean wasUpdateedEmployeesName = dao.updateEmployeesName(1L, "Lula");
		System.out.println(wasUpdateedEmployeesName ? "Success" : "Not Success");
	}
	
	private static void testDelete(EmployeesDao dao) {
		boolean wasDeletedEmployees = dao.delete(1L);
		System.out.println(wasDeletedEmployees ? "Success" : "Not Success");
	}
}
