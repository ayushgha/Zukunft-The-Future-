package database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class JobSearch {

	double CGPI[] = new double[100];
	int Experience[] = new int[100];
	String Name[] = new String[100];
	String Morgan_Stanley[] = new String[100];
	String Accenture[] = new String[100];
	String Credit_Suisse[] = new String[100];
	int i=0,j=0,l=0;
	
	public void Retrieve() {
		MAIN mainObject = new MAIN();
		try {
			Connection connection = mainObject.getConnection();
			String query1 = "SELECT CGPI FROM applicant";
			PreparedStatement s1 = connection.prepareStatement(query1);
			ResultSet rs = s1.executeQuery(); 
			while(rs.next()) {
				CGPI[i] = rs.getDouble("CGPI");
				i++;
			}
			String query2 = "SELECT Experience FROM applicant";
			PreparedStatement s2 = connection.prepareStatement(query2);
			ResultSet rs2 = s2.executeQuery();
			while(rs2.next()) {
				Experience[j]=rs2.getInt("Experience");
				j++;
			}
			String query3 = "SELECT Name FROM applicant";
			PreparedStatement s3 = connection.prepareStatement(query3);
			ResultSet rs3 = s3.executeQuery(); 
			while(rs3.next()) {
				Name[l] = rs3.getString("Name");
				l++;
			}
		} 
		catch(Exception e) {
			System.out.println(e);
		}
	}
	
	public void findJob() throws Exception{
		Retrieve();
		MAIN obj = new MAIN();
		for(int k=0;Experience[k]!=0;k++) {
			System.out.println(CGPI[k]+"\t"+Experience[k]+"\t"+Name[k]);
			if(CGPI[k] > 9.0 && Experience[k] > 2) {
				try {
					Connection connection = obj.getConnection();
					String query1 = "INSERT INTO morgan_stanley(NAME) VALUES(?)";
					String query2 = "INSERT INTO credit_suisse(NAME) VALUES(?)";
					String query3 = "INSERT INTO accenture(NAME) VALUES(?)";
					PreparedStatement prepared = connection.prepareStatement(query1);
					PreparedStatement prepared2 = connection.prepareStatement(query2);
					PreparedStatement prepared3 = connection.prepareStatement(query3);
					prepared.setString(1,Name[k]);
					prepared2.setString(1,Name[k]);
					prepared3.setString(1,Name[k]);
					prepared.executeUpdate();
					prepared2.executeUpdate();
					prepared3.executeUpdate();
				} 
				catch(Exception e) {
					System.out.println(e);
				}
			}
			else if(CGPI[k]<9.0 && CGPI[k]>8.0 && Experience[k]>2) {
				try {
					Connection connection = obj.getConnection();
					String query = "INSERT INTO morgan_stanley(NAME) VALUES(?)";
					String query2 = "INSERT INTO accenture(NAME) VALUES(?)";
					PreparedStatement prepared = connection.prepareStatement(query);
					PreparedStatement prepared2 = connection.prepareStatement(query2);
					prepared.setString(1,Name[k]);
					prepared.executeUpdate();
					prepared2.setString(1,Name[k]);
					prepared2.executeUpdate();
				} 
				catch(Exception e) {
					System.out.println(e);
				}
			}
			else if(CGPI[k]<9.0 && CGPI[k]>8.0 && Experience[k]<2 && Experience[k]>1) {
				try {
					Connection connection = obj.getConnection();
					String query = "INSERT INTO credit_suisse(NAME) VALUES(?)";
					String query2 = "INSERT INTO accenture(NAME) VALUES(?)";
					PreparedStatement prepared = connection.prepareStatement(query);
					PreparedStatement prepared2 = connection.prepareStatement(query2);
					prepared.setString(1,Name[k]);
					prepared.executeUpdate();
					prepared2.setString(1,Name[k]);
					prepared2.executeUpdate();
				} 
				catch(Exception e) {
					System.out.println(e);
				}
			}
			else {
				try {
					Connection connection = obj.getConnection();
					String query = "INSERT INTO accenture(NAME) VALUES(?)";
					PreparedStatement prepared = connection.prepareStatement(query);
					prepared.setString(1,Name[k]);
					prepared.executeUpdate();
				} 
				catch(Exception e) {
					System.out.println(e);
				}
			}
				
		}
	}
}	

