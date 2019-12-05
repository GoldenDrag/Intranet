package project;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.HashSet;
/**
 * Manages users
*/
public class Admin extends Employee {
	private static final long serialVersionUID = 1L;
	private HashSet<User> users;
	static FileInputStream fis;
	static FileOutputStream fos;
	static ObjectOutputStream oos;
	static ObjectInputStream oin;
	
	public Admin(String login, String password, String name, int salary, String id) throws IOException {
		super(login, password, name, salary, id);
		// TODO Auto-generated constructor stub
		users = new HashSet<User>();
	}
	
	public boolean addUser(User user) throws IOException {
		oos.flush();
		oos.writeChars(user.toString() + " added\r\n");
		oos.close();
		return users.add(user);
	}
	public boolean removeUser(User user) throws IOException {
		oos.flush();
		oos.writeChars(user.toString() + " removed\r\n");
		oos.close();
		return users.remove(user);
	}
	public void updateLogin(User user, String login) throws IOException {
		oos.flush();
		String temp = user.getLogin();
		oos.writeChars(user.toString() + " login updated from " + temp +" to " + login + "\r\n");
		oos.close();
		user.setLogin(login);
	}
	public void updatePassword(User user, String password) throws IOException {
		oos.flush();
		String temp = user.getPassword();
		oos.writeChars(user.toString() + " password updated from " + temp +" to " + password + "\r\n");
		user.setPassword(password);
		oos.close();
	}
	public void seeLogFiles() throws IOException, ClassNotFoundException {
		fis = new FileInputStream("usersLogFiles.txt");
		oin = new ObjectInputStream(fis);
		String str = oin.readLine();
		while(str != null) {
			System.out.println(str);
			str = oin.readLine();
		}
		oin.close();
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((users == null) ? 0 : users.hashCode());
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
		Admin other = (Admin) obj;
		if (users == null) {
			if (other.users != null)
				return false;
		} else if (!users.equals(other.users))
			return false;
		return true;
	}
	public void serialize() {
		try {
			fos = new FileOutputStream("admin");
			oos = new ObjectOutputStream(fos);
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
			fis = new FileInputStream("admin");
			oin = new ObjectInputStream(fis);
			Admin admin = (Admin)oin.readObject();
			System.out.println(admin);
			oin.close();
		} catch (IOException | ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}

