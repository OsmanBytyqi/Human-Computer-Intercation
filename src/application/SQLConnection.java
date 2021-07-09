package application;

import java.sql.Connection;
import java.sql.DriverManager;

import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;

public class SQLConnection {
	
	
	public static Connection DbConnector() {
		try {
			Connection conn= null;
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection("jdbc:mysql://localhost/menaxhimi_bursave?autoReconnect=true&useSSL=false","root","");
			return conn;
			
			
		}
		catch (Exception ex) {
			Alert alert = new Alert(AlertType.ERROR);
			alert.setTitle("Database problem");
			alert.setHeaderText(null);
			alert.setContentText("Can not connect to database");
			alert.showAndWait();
			System.exit(0);
	}
		return DbConnector();
		
	
	}
}
