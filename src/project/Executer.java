package project;
import java.util.*;
/**
*/
public class Executer extends Employee {
	private static final long serialVersionUID = 1L;
	private Vector<String> doneOrders;
	private Vector<String> acceptedOrders;
	
	public Executer(String login, String password, String name, int salary, String id) {
			super(login, password, name, salary, id);
			// TODO Auto-generated constructor stub
		}
	
	public boolean sendOrder(String order) {
	    return acceptedOrders.add(order);
	}
	public void viewOrders() {
		for(int i = 0; i < acceptedOrders.size(); ++i) {
			System.out.println(acceptedOrders.get(i));
		}
	}
	public void raiseSalary(Employee employee) {
	    employee.setSalary(getSalary() + 40000);
	}
	public void viewDoneOrders() {
		for(int i = 0; i < doneOrders.size(); ++i) {
			System.out.println(doneOrders.get(i));
		}
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((acceptedOrders == null) ? 0 : acceptedOrders.hashCode());
		result = prime * result + ((doneOrders == null) ? 0 : doneOrders.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (!(obj instanceof Executer))
			return false;
		Executer other = (Executer) obj;
		if (acceptedOrders == null) {
			if (other.acceptedOrders != null)
				return false;
		} else if (!acceptedOrders.equals(other.acceptedOrders))
			return false;
		if (doneOrders == null) {
			if (other.doneOrders != null)
				return false;
		} else if (!doneOrders.equals(other.doneOrders))
			return false;
		return true;
	}
}

