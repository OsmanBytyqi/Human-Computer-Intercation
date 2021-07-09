package application;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class LoginForm {
	
	private String username;
	private String password;
	
	public LoginForm (String username, String password) {
		this.username= username;
		this.password = password;
		
	}
	
	public String username() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	
	public String getPassword() {
		return password;
	}
	
	public void setPassword(String pasword)
	{
		this.password = password;
	}
	
	public static boolean addAdmin(String username, String password) {
		String query =  "INSERT into login (username, password) VALUES(?, ?)";
		try {
			PreparedStatement pst= DBConnection.getConnection().prepareStatement(query);
			pst.setString(1, username);
			pst.setString(2, password);
			return (pst.executeUpdate() > 0);
		}
		catch(SQLException ex) {
			ex.printStackTrace();
			return false;
		}
	}
	public static List<LoginForm> getAdmin() {
		List<LoginForm> adminList = new ArrayList();
		
		String query = "Select * from login";
		try {
			PreparedStatement pst = DBConnection.getConnection().prepareStatement(query);
			ResultSet rst = pst.executeQuery();
			
			while(rst.next()) {
				LoginForm admin = new LoginForm(rst.getString(1), rst.getString(2));
				adminList.add(admin);
			}
		}
			catch(SQLException ex) {
				ex.printStackTrace();
			}
			return adminList;
		}
	
}
