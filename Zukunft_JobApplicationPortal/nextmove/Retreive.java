package nextmove;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class Retreive {

	String Morgan_Stanley[] = new String[100];
	String Accenture[] = new String[100];
	String Credit_Suisse[] = new String[100];
	String Username[] = new String[100];
        String Password[] = new String[100];
        int i=0,j=0,l=0;
	
	public void Retrieve() {
		MAIN mainObject = new MAIN();
		try {
			Connection connection = mainObject.getConnection();
			String query1 = "SELECT * FROM morgan_stanley";
			PreparedStatement s1 = connection.prepareStatement(query1);
			ResultSet rs = s1.executeQuery(); 
			while(rs.next()) {
				Morgan_Stanley[i] = rs.getString("NAME");
					i++;
			}
			String query2 = "SELECT * FROM credit_suisse";
			PreparedStatement s2 = connection.prepareStatement(query2);
			ResultSet rs2 = s2.executeQuery();
			while(rs2.next()) {
				Credit_Suisse[j]=rs2.getString("NAME");
				j++;
			}
			String query3 = "SELECT * FROM accenture";
			PreparedStatement s3 = connection.prepareStatement(query3);
			ResultSet rs3 = s3.executeQuery(); 
			while(rs3.next()) {
				Accenture[l] = rs3.getString("NAME");
				l++;
			}
		} 
		catch(Exception e) {
			System.out.println(e);
		}
	}
        
        public void retreiveLogin() {
            MAIN mainObject = new MAIN();
		try {
			Connection connection = mainObject.getConnection();
			String query1 = "SELECT Username FROM applicant";
			PreparedStatement s1 = connection.prepareStatement(query1);
			ResultSet rs = s1.executeQuery(); 
                        rs.next();
			while(rs.next()) {
				Username[i] = rs.getString("Username");
					i++;
			}
			String query2 = "SELECT Password FROM applicant";
			PreparedStatement s2 = connection.prepareStatement(query2);
			ResultSet rs2 = s2.executeQuery();
                        rs2.next();
			while(rs2.next()) {
				Password[j]=rs2.getString("Password");
				j++;
			}
		} 
		catch(Exception e) {
			System.out.println(e);
		}
        }
        
        public void getmycompany()
                
        {
            
        }
}
