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


public class login extends Application {
	public static int gjuha=0;
	private Connection dbConnection;
	
	private TextField emailTxt = new TextField();
	private PasswordField passwordTxt = new PasswordField();
	private Stage mainStage;
	private RadioButton btnShqip;
	private RadioButton btnAnglisht;

	public void start(Stage primaryStage) {
		mainStage = primaryStage;
		setConnection();
		
		GridPane gridPane = new GridPane();
		Image image = new Image("file:///C:/Users/HP/git/knkProjekt/Knk_Project/send-user.png");
		ImageView img = new ImageView(image);
		img.setFitHeight(100);
		img.setFitWidth(100);
		gridPane.setAlignment(Pos.CENTER);
		gridPane.setBackground(new Background(new BackgroundFill(Color.ALICEBLUE, CornerRadii.EMPTY, Insets.EMPTY)));	
		gridPane.setHgap(10);
		gridPane.setVgap(10);
		
		gridPane.setPadding(new Insets(10, 10, 10, 10));
		
		Label lblHyrja = new Label("\n\n\t\t\tMiresevini ne SMB!");
	    lblHyrja.setFont(Font.font("verdana", FontWeight.BOLD, FontPosture.ITALIC, 20)); 
		gridPane.add(lblHyrja, 0, 0);
		
		BorderPane pane = new BorderPane();
		pane.setTop(lblHyrja);

		Label lblUsername = new Label("Emri: ");
		Label lblPassword = new Label("Fjalekalimi: ");
		lblUsername.setFont(Font.font("Times new Roman",FontWeight.BOLD,15));
		lblPassword.setFont(Font.font("Times new Roman",FontWeight.BOLD,15));
		
		
		
		gridPane.add(img, 1, 1);
		gridPane.add(lblUsername, 0, 3);
		gridPane.add(emailTxt, 1, 3);
		
		gridPane.add(lblPassword, 0, 4);
		gridPane.add(passwordTxt, 1, 4);
		Button btnLogin = new Button("Login");
		
	
		Label lblGjuha = new Label("Gjuha:");
		TilePane r = new TilePane(); 
        ToggleGroup tg = new ToggleGroup(); 
		btnShqip = new RadioButton("Shqip");
		btnAnglisht = new RadioButton("Anglisht");
		
	    lblGjuha.setFont(Font.font("verdana", FontWeight.BOLD, FontPosture.REGULAR, 13)); 
	    btnShqip.setFont(Font.font("verdana", FontWeight.BOLD, FontPosture.REGULAR, 10)); 
	    btnAnglisht.setFont(Font.font("verdana", FontWeight.BOLD, FontPosture.REGULAR, 10)); 


		btnShqip.setToggleGroup(tg);
		btnAnglisht.setToggleGroup(tg);
		r.getChildren().add(lblGjuha);
		r.getChildren().add(btnAnglisht);
		r.getChildren().add(btnShqip);

		
		btnAnglisht.setOnAction(e->{
			lblUsername.setText("Username:");
			lblPassword.setText("Password:");
			btnLogin.setText("Login");
			lblHyrja.setText("\n\n\t\t\tWelcome to SMS!");

		});
		btnShqip.setOnAction(e->{
			lblUsername.setText("Emri:");
			lblPassword.setText("Fjalekalimi:");
			btnLogin.setText("Hyrja");
			lblHyrja.setText("\n\n\t\t\tMiresevini ne SMB!");


		});
		gridPane.add(btnLogin, 1, 5);
		gridPane.setHalignment(btnLogin, HPos.CENTER);
		btnLogin.setMinSize(70, 30);
		btnLogin.setTextFill(Color.WHITE);
		btnLogin.setFont(Font.font("Verdana",FontWeight.BOLD,FontPosture.REGULAR,13));
		btnLogin.setStyle("-fx-background-color: #9be8d6,linear-gradient(#9be8d6, #2f4b8f),linear-gradient(#9be8d6, #263e75),linear-gradient(#9be8d6, #223768);");
		
		btnLogin.setBackground(new Background(new BackgroundFill(Color.CYAN, CornerRadii.EMPTY, Insets.EMPTY)));
		
		btnLogin.setOnAction(e -> {
			loginUser();
		});

		
		VBox vbox = new VBox();
		vbox.setAlignment(Pos.CENTER);
		vbox.getChildren().addAll(gridPane,r);
		//hjh
		pane.setCenter(vbox);
		
		pane.setBackground(new Background(new BackgroundFill(Color.ALICEBLUE, CornerRadii.EMPTY, Insets.EMPTY)));	

	
		Scene scene = new Scene(pane,500,400);
		primaryStage.getIcons().add(new Image("file:///C:/Users/HP/git/knkProjekt/Knk_Project/safety-clip-round.png"));
		primaryStage.setTitle("Login");
		primaryStage.setScene(scene);

		primaryStage.show();
		
		
	}

	private void setConnection() {
		try {
			String dbName = "menaxhimi_bursave";
			String userName="root";
			String password="";
			Class.forName("com.mysql.jdbc.Driver");
			dbConnection = DriverManager.getConnection("jdbc:mysql://localhost/"+dbName,userName,password);
		} catch (Exception ex) {
			Alert alert = new Alert(AlertType.ERROR);
			alert.setTitle("Database problem");
			alert.setHeaderText(null);
			alert.setContentText("Can not connect to database");
			alert.showAndWait();
			System.exit(0);
			
		}
	}

	public static void main(String[] args) {
		Application.launch(args);
	}
	
	private void loginUser() {
		String query = "Select * from login where username = ? AND password = ?";
		
		try {
			
			PreparedStatement preparedStatement = dbConnection.prepareStatement(query);
			
			preparedStatement.setString(1, emailTxt.getText());
			preparedStatement.setString(2, passwordTxt.getText());

			ResultSet result = preparedStatement.executeQuery();
			
			if(result.next()) {
				Alert alert = new Alert(AlertType.INFORMATION);
				if(btnAnglisht.isSelected()) {
					alert.setTitle("Login result");
					alert.setHeaderText(null);
					alert.setContentText("You are logged in!");
					alert.showAndWait();
					mainStage.hide();
					MainProgram.createMainStage();
				}
				else {
				alert.setTitle("Rezultati i hyrjes");
				alert.setHeaderText(null);
				alert.setContentText("Hyrja u realizua!");
				alert.showAndWait();
				mainStage.hide();
				MainProgram.createMainStage();
				}
				
			} else {
				Alert alert = new Alert(AlertType.INFORMATION);
				
				if(btnAnglisht.isSelected()) {
				alert.setTitle("Login Result");
				alert.setHeaderText(null);
				alert.setContentText("User does not exist!");
				alert.showAndWait();
				}
				else {
					alert.setTitle("Rezultati i hyrjes");
					alert.setHeaderText(null);
					alert.setContentText("Perdoruesi nuk ekziston!");
					alert.showAndWait();
				}
				
			}
			
		} catch(SQLException ex) {
			Alert alert = new Alert(AlertType.ERROR);
			alert.setTitle("Database problem");
			alert.setHeaderText(null);
			alert.setContentText(ex.getMessage());
			alert.showAndWait();
			System.exit(0);
		}
	}

	
}
