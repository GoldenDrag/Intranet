package project;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class Mark {
	private double firstAttistation;
	private double secondAttistation;
	private double finalMark;
	
	public Mark() {
		this.firstAttistation = 0;
		this.secondAttistation = 0;
		this.finalMark = 0;
	}
	public Mark(double firstAttistation, double secondAttistation, double finalMark) {
		this.firstAttistation = firstAttistation;
		this.secondAttistation = secondAttistation;
		this.finalMark = finalMark;
	}
	
	public double getFirstAttistation() {
		return firstAttistation;
	}
	public void setFirstAttistation(double firstAttistation) {
		this.firstAttistation = firstAttistation;
	}
	public double getSecondAttistation() {
		return secondAttistation;
	}
	public void setSecondAttistation(double secondAttistation) {
		this.secondAttistation = secondAttistation;
	}
	public double getFinalMark() {
		return finalMark;
	}
	public void setFinalMark(double finalMark) {
		this.finalMark = finalMark;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		long temp;
		temp = Double.doubleToLongBits(finalMark);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		temp = Double.doubleToLongBits(firstAttistation);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		temp = Double.doubleToLongBits(secondAttistation);
		result = prime * result + (int) (temp ^ (temp >>> 32));
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
		Mark other = (Mark) obj;
		if (Double.doubleToLongBits(finalMark) != Double.doubleToLongBits(other.finalMark))
			return false;
		if (Double.doubleToLongBits(firstAttistation) != Double.doubleToLongBits(other.firstAttistation))
			return false;
		if (Double.doubleToLongBits(secondAttistation) != Double.doubleToLongBits(other.secondAttistation))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "First Attistation=" + firstAttistation + ", Second Attistation=" + secondAttistation
				+ ", Final Mark=" + finalMark;
	}
	public double getTotal() {
		return firstAttistation + secondAttistation + finalMark;
	}
	public void serialize(){
		try {
		FileOutputStream fos = new FileOutputStream("mark");
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
			FileInputStream fis = new FileInputStream("mark");
			ObjectInputStream oin = new ObjectInputStream(fis);
			Mark user = (Mark)oin.readObject();
			System.out.println(user);
			oin.close();
		} catch (IOException | ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}