package database;

import java.sql.Connection;
import java.sql.DriverManager;

public class MAIN {

	public static void main(String[] args) throws Exception{
		
		JobApplication job = new JobApplication();
		job.getJob("new.docx");
		
	}
	
	public Connection getConnection() throws Exception{
		try {
			String driver = "com.mysql.jdbc.Driver";
			String url = "jdbc:mysql://localhost/Jobs";
			String username = "root";
			String password = "";
			Class.forName(driver);
			
			Connection connection = DriverManager.getConnection(url,username,password);
			return connection;
		} catch(Exception e) {
			System.out.println(e);
		}
		return null;
	}
}

