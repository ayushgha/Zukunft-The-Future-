package database;

import java.sql.Connection;
import java.sql.PreparedStatement;

public class InsertUser {

	public void insertTable(String Lastname,String userName,String Password,String DOB) throws Exception {
		MAIN obj = new MAIN();
		try {
			Connection connection = obj.getConnection();
			String query = "INSERT INTO applicant(Lastname,Username,Password,DOB) VALUES(?,?,?,?)";
			PreparedStatement prepared = connection.prepareStatement(query);
			prepared.setString(1,Lastname);
			prepared.setString(2,userName);
			prepared.setString(3,Password);
			prepared.setString(4,DOB);
			prepared.execute();
			
		} 
		catch(Exception e) {
			System.out.println(e);
		}
		finally { System.out.println("TABLE CREATED"); }
	}
	
	public void insertResume(Double CGPI, int Experience,String Name) {
		MAIN obj = new MAIN();
		try {
			Connection connection = obj.getConnection();
			String query1 = "UPDATE applicant SET CGPI=? WHERE Username = ?";
			String query2 = "UPDATE applicant SET Experience=? WHERE Username = ?";
			PreparedStatement prepared = connection.prepareStatement(query1);
			PreparedStatement prepared2 = connection.prepareStatement(query2);
			prepared.setDouble(1,CGPI);
			prepared.setString(2, Name);
			prepared2.setInt(1,Experience);
			prepared2.setString(2, Name);
			prepared.executeUpdate();
			prepared2.executeUpdate();
		} 
		catch(Exception e) {
			System.out.println(e);
		}
		finally { System.out.println("TABLE CREATED"); }
	}
	
}
