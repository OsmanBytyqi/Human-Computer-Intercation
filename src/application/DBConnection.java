package application;

import java.sql.Connection;
import java.sql.DriverManager;

import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;


public class DBConnection {
	private static Connection dbConnection;
	private final static String host = "localhost";
	private final static String dbName = "menaxhimi_bursave";
	private final static String userName = "root";
	private final static String password = "";
	

	
	public static Connection getConnection() {
		if(dbConnection == null) {
		
			try {
				Class.forName("com.mysql.jdbc.Driver");
				dbConnection = DriverManager.getConnection("jdbc:mysql://localhost/"+dbName,userName,password);
			}  catch (Exception ex) {
				Alert alert = new Alert(AlertType.ERROR);
				alert.setTitle("Database problem");
				alert.setHeaderText(null);
				alert.setContentText("Can not connect to database");
				alert.showAndWait();
				System.exit(0);
			}
	}
		return dbConnection;
		}
	
	

}