package pkg.model;

import java.util.StringJoiner;

public class Employees {

	private Long id;
	private String name;

	public Employees() {
	}
	
	public Employees(Long id, String name) {
		this.id = id;
		this.name = name;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	@Override
	public String toString() {
		return "Employees" + new StringJoiner(", ", "[", "]")
				.add(id.toString())
				.add(name);
	}

}
