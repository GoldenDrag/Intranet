package project;

import java.io.*;

public class Employee extends User{
	private static final long serialVersionUID = 1L;
	private String name;
	private int salary;
	private String id;

	public Employee(String login, String password, String name, int salary, String id) {
		super(login, password);
		// TODO Auto-generated constructor stub
		this.setName(name);
		this.setId(id);
		this.setSalary(salary);
	}

	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getSalary() {
		return salary;
	}
	public void setSalary(int salary) {
		this.salary = salary;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + salary;
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		Employee other = (Employee) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (salary != other.salary)
			return false;
		return true;
	}
	@Override
	public String toString() {
		return  id + " " + name + " " + salary;
	}
	public void serialize(){
		try {
		FileOutputStream fos = new FileOutputStream("employee");
		ObjectOutputStream oos = new ObjectOutputStream(fos);
		oos.writeObject(this);
		oos.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public void deserialize() {
		try {
			FileInputStream fis = new FileInputStream("employee");
			ObjectInputStream oin = new ObjectInputStream(fis);
			Employee user = (Employee)oin.readObject();
			System.out.println(user);
			oin.close();
		} catch (IOException | ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
