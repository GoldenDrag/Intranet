package project;

import java.io.*;
public abstract class User implements Comparable<User>, Cloneable, Serializable {
	private String login;
	private String password;
	private static final long serialVersionUID = 1L;
	
	public User() {
		this.login = null;
		this.password = null;
	}
	public User(String login, String password) {
		this.login = login;
		this.password = password;
	}
	
	public String getLogin() {
		return login;
	}
	public void setLogin(String login) {
		this.login = login;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((login == null) ? 0 : login.hashCode());
		result = prime * result + ((password == null) ? 0 : password.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		User other = (User) obj;
		if (login == null) {
			if (other.login != null)
				return false;
		} else if (!login.equals(other.login))
			return false;
		if (password == null) {
			if (other.password != null)
				return false;
		} else if (!password.equals(other.password))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "login=" + login + ", password=" + password;
	}
	public int compareTo(User user) {
		if (Integer.parseInt(this.login) > Integer.parseInt(user.getLogin())) return 1;
		else if (Integer.parseInt(this.login) < Integer.parseInt(user.getLogin())) return -1;
		else return 0;
	}
	public void serialize() {
		try {
			FileOutputStream fos = new FileOutputStream("users.txt");
			ObjectOutputStream oos = new ObjectOutputStream(fos);
			oos.writeObject(this);
			oos.flush();
			oos.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public void deserialize() {
		try {
			FileInputStream fis = new FileInputStream("users.txt");
			ObjectInputStream oin = new ObjectInputStream(fis);
			User user = (User)oin.readObject();
			System.out.println(user);
			oin.close();
		} catch (IOException | ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
