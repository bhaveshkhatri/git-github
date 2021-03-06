package com.cb.cogent;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class Serilizer {

	public static void main(String[] args) {

		Serilizer serializer = new Serilizer();
		//serializer.serializeEmployee("gemini", "usa", "tx", "1126");
		serializer.deserializeEmployee();
		

	}

	private void deserializeEmployee() {
		try {
			FileInputStream fin = new FileInputStream("G://chinna.txt");
			ObjectInputStream oi = new ObjectInputStream(fin);
			Example e = (Example)oi.readObject();
			System.out.println(e.getStreet()+" "+e.getState()+" "+e.getCountry()+" "+e.getEmpAddress());
		} catch (Exception e) {
			
		}
		
		
		
	}

	private void serializeEmployee(String street, String country, String state, String empAddress) {
		Example e = new Example();
		e.setStreet(street);e.setCountry(country);e.setState(state);e.setCountry(country);
		
		try {
			FileOutputStream fout = new  FileOutputStream("G://chinna.txt");
			ObjectOutputStream os = new ObjectOutputStream(fout);
			os.writeObject(e);
			fout.close();
			os.close();
			System.out.println("done");
			
		} catch (Exception e2) {
			// TODO: handle exception
		}
	}

}
