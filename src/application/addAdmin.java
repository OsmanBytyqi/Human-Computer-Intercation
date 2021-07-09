package application;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.image.Image;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;
import javafx.stage.Window;

public class addAdmin {
	 	private Connection dbConnection;
	 	private static TextField usernameTxt = new TextField();
	 	private static PasswordField passwordTxt = new PasswordField();
		private static Button submitButton = new Button("Regjistro");
		
	public static void createMainStage() {
    	Stage primaryStage = new Stage();
        primaryStage.setTitle("Regjistroni nje administrues te ri");
       

        GridPane gridPane = createRegistrationFormPane();
        addUIControls(gridPane);
        Scene scene = new Scene(gridPane, 800, 500);
        primaryStage.setScene(scene);
        primaryStage.getIcons().add(new Image("file:///C:/Users/HP/git/knkProjekt/Knk_Project/graphic-scholarship_800x600.png"));
        primaryStage.show();
    }


    private static GridPane createRegistrationFormPane() {
       
        GridPane gridPane = new GridPane();
        
        //gridPane.setBackground(new Background(new BackgroundFill(Color.color(0.2, 0.3, 0.2, 0.04), CornerRadii.EMPTY, Insets.EMPTY)));	
        gridPane.setAlignment(Pos.CENTER);
        gridPane.setPadding(new Insets(40, 40, 40, 40));
        gridPane.setHgap(10);
        gridPane.setVgap(10);
        gridPane.setBackground(new Background(new BackgroundFill(Color.ALICEBLUE, CornerRadii.EMPTY, Insets.EMPTY)));

        

        
        ColumnConstraints columnOneConstraints = new ColumnConstraints(100, 100, Double.MAX_VALUE);
        columnOneConstraints.setHalignment(HPos.RIGHT);

        
        ColumnConstraints columnTwoConstrains = new ColumnConstraints(200,200, Double.MAX_VALUE);
        columnTwoConstrains.setHgrow(Priority.ALWAYS);

        gridPane.getColumnConstraints().addAll(columnOneConstraints, columnTwoConstrains);

        return gridPane;
    }

    private static void addUIControls(GridPane gridPane) {
     
        Label headerLabel = new Label("Regjistrohuni");
        headerLabel.setFont(Font.font("Trebuchet MS", FontWeight.BOLD, 24));
        headerLabel.setTextFill(Color.DARKMAGENTA);
        gridPane.add(headerLabel, 0,0,2,1);
        GridPane.setHalignment(headerLabel, HPos.CENTER);
        GridPane.setMargin(headerLabel, new Insets(20, 0,20,0));

      
        Label nameLabel = new Label("Emri i perdoruesit: ");
        gridPane.add(nameLabel, 0,1);
        nameLabel.setTextFill(Color.DARKMAGENTA);
        nameLabel.setFont(Font.font("Trebuchet MS", FontWeight.NORMAL, 10));

       
        usernameTxt.setPrefHeight(40);
        gridPane.add(usernameTxt, 1,1);
        


        // Add Password Label
        Label passwordLabel = new Label("Fjalekalimi : ");
        gridPane.add(passwordLabel, 0, 3);
        passwordLabel.setTextFill(Color.DARKMAGENTA);
        passwordLabel.setFont(Font.font("Trebuchet MS", FontWeight.NORMAL, 10));

        passwordTxt.setPrefHeight(40);
        gridPane.add(passwordTxt, 1, 3);



        submitButton.setPrefHeight(40);
        submitButton.setDefaultButton(true);
        submitButton.setPrefWidth(100);
        submitButton.setTextFill(Color.DARKMAGENTA);
        submitButton.setFont(Font.font("Trebuchet MS", FontWeight.BOLD, 18));
        gridPane.add(submitButton, 0, 4, 2, 1);
        GridPane.setHalignment(submitButton, HPos.CENTER);
        GridPane.setMargin(submitButton, new Insets(20, 0,20,0));


        submitButton.setOnAction(e ->{
        	insertAdmin();
        	Stage secondStage = new Stage();
            secondStage.setTitle("Regjistrimi i nje administruesi te ri");
            
	    	 GridPane secondPane = new GridPane();
	    	 secondPane.setPadding(new Insets(20,20,20,20));
	    	 
	    	 Label secondLabel = new Label("Administruesi i ri eshte shtuar me sukses!");
	    	 secondLabel.setTextFill(Color.DARKMAGENTA);
	    	 secondPane.setBackground(new Background(new BackgroundFill(Color.ALICEBLUE, CornerRadii.EMPTY, Insets.EMPTY)));
	    	 
	    	 secondLabel.setFont(new Font("Arial",32));
	    	 
	    	 secondPane.add(secondLabel, 1, 0);
	    	 
	    	 Scene secondScene = new Scene(secondPane);
     		secondStage.setScene(secondScene);
     		secondStage.show();
        });
    }

    private void showAlert(Alert.AlertType alertType, Window owner, String title, String message) {
        Alert alert = new Alert(alertType);
        alert.setTitle("Regjistrimi i nje administruesi te ri");
        alert.setHeaderText(null);
        alert.setContentText("Administruesi u shtua me sukses");
        
        alert.show();
    }
    
   
    
    private void setConnection() {
		String dbName = "menaxhimi_bursave";
		String userName="root";
		String password="";
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
    
    public static void showAdmin() {
		List<LoginForm> admin = LoginForm.getAdmin();
		
		ObservableList<LoginForm> adminList = FXCollections.observableArrayList();
		
		for(int i = 0; i < admin.size(); i++) {
			adminList.add(admin.get(i));
		}
		
		//adminTable.setItems(adminList);
	}
	
public static void insertAdmin() {
	
		
		if(LoginForm.addAdmin(usernameTxt.getText(), passwordTxt.getText())) {
			showAdmin();

		}
		
		
	}

 
}