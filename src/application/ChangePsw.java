package application;


import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.stage.Stage;
import jdk.nashorn.internal.objects.Global;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.BackgroundPosition;
import javafx.scene.layout.BackgroundRepeat;
import javafx.scene.layout.BackgroundSize;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.TilePane;
import javafx.scene.layout.VBox;
import javafx.scene.Scene;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
import javafx.scene.image.Image ;
import javafx.scene.image.ImageView;

import java.sql.*;


public class ChangePsw {
	
	
	private static PasswordField txtPas;
	private static TextField txtEmri;
	private static Label lblResult;
	private static Connection dbConnection;
	public static void createMainStage() {
		
		setConnection();
		Stage primaryStage = new Stage();
		Label lbl = new Label("Ndrysho Fjalekalimin");
		Label lblNew = new Label("Fjalekalimi i ri:");
		Label lblOld = new Label("Username:");
		


		Button btn = new Button("Ruaj");
		
		txtPas = new PasswordField();
		txtEmri = new TextField();
		lblResult = new Label("");

		GridPane pane = new GridPane();
        pane.setBackground(new Background(new BackgroundFill(Color.ALICEBLUE, CornerRadii.EMPTY, Insets.EMPTY)));

		pane.setAlignment(Pos.CENTER);
		pane.setHgap(10);
		pane.setVgap(5);
		pane.add(lbl,0,0);
		pane.add(lblResult,1,1);
		pane.add(lblNew,0,3);
		pane.add(txtPas,1,3);
		pane.add(lblOld,0,5);
		pane.add(txtEmri,1,5);
		pane.add(btn,1,6);
		pane.setHalignment(btn,HPos.RIGHT);
		pane.setHalignment(lbl,HPos.CENTER);

		lbl.setTextFill(Color.DARKRED);
		lbl.setFont(Font.font("verdana", FontWeight.BOLD, FontPosture.ITALIC, 45)); 
		lblNew.setFont(Font.font("Times New Roman", FontWeight.MEDIUM, FontPosture.REGULAR, 17)); 
		lblOld.setFont(Font.font("Times New Roman", FontWeight.MEDIUM, FontPosture.REGULAR, 17)); 
		lblResult.setTextFill(Color.RED);
		lbl.setFont(Font.font("verdana", FontWeight.BOLD, FontPosture.ITALIC, 13)); 
		btn.setTextFill(Color.WHITE);
		btn.setFont(Font.font("Verdana",FontWeight.BOLD,FontPosture.REGULAR,13));
		btn.setBackground(new Background(new BackgroundFill(Color.DARKRED, CornerRadii.EMPTY, Insets.EMPTY)));
		
		btn.setOnAction(e->{
			
			update();
			
		});
		Scene scene = new Scene(pane,800,500);
		primaryStage.setTitle("Ndryshimi i fjalekalimit!");
		primaryStage.setScene(scene);
        primaryStage.getIcons().add(new Image("file:///C:/Users/HP/git/knkProjekt/Knk_Project/graphic-scholarship_800x600.png"));
		primaryStage.show();
				
	
	}

	private static void setConnection() {
		String dbName="menaxhimi_bursave";
		String username = "root";
		String password="";
		try {
		Class.forName("com.mysql.jdbc.Driver");
		dbConnection = DriverManager.getConnection("jdbc:mysql://localhost/"+dbName,username,password);
		}
		catch(Exception e){
			Alert alert = new Alert(AlertType.ERROR);
			alert.setTitle("Database problem");
			alert.setHeaderText(null);
			alert.setContentText("Can not connect to database");
			alert.showAndWait();
			System.exit(0);
		}
	}


	public static void update() {
		
		try {
			String query = "Update login Set password=? Where username=?";
			
			PreparedStatement preparedStatement = dbConnection.prepareStatement(query);
			
			preparedStatement.setString(1,txtPas.getText());
			preparedStatement.setString(2,txtEmri.getText());
			
			if(preparedStatement.executeUpdate()>0) {
				lblResult.setText("Fjalekalimi u ndryshua!");
			}
			else {
				lblResult.setText("Username-i nuk eshte gjetur!");
			}
			
		}
		catch(Exception e) {
			Alert alert = new Alert(AlertType.ERROR);
			alert.setTitle("Database problem");
			alert.setHeaderText(null);
			alert.setContentText(e.getMessage());
			alert.showAndWait();
			System.exit(0);
		}
	}
	
	
}
