package application;

import java.io.Serializable;

public class medicine implements Serializable{
	private String medname;
	private String medamount;
	private int time;

	public int getTime() {
		return time;
	}



	public void setTime(int time) {
		this.time = time;
	}



	public String getMedamount() {
		return medamount;
	}



	public void setMedamount(String medamount) {
		this.medamount = medamount;
	}



	public String getMedname() {
		return medname;
	}



	public void setMedname(String medname) {
		this.medname = medname;
	}
	
	public medicine(String medname, String medamount, int time) {
		this.setMedname(medname);
		this.setMedamount(medamount);
		this.setTime(time);
	}
	
	public String toString() {
		return medname +"                    "+ medamount +"                 "+ String.format("%02d", time) + ":00";
	}
}

