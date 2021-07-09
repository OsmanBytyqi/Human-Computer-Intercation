package application;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
//import javafx.scene.control.PasswordField;
//import javafx.scene.text.Text;
//import static javafx.geometry.HPos.RIGHT;
import javafx.scene.control.*;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.image.Image;
import javafx.geometry.HPos;
//import javafx.scene.control.Alert.AlertType;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
import javafx.stage.FileChooser;
import java.io.File;
import java.io.IOException;
import java.util.List;
//import javafx.scene.layout.HBox;
//import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.stage.Window;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.awt.Desktop;
import java.sql.*;
import java.text.DateFormat;
import java.text.SimpleDateFormat;


public class Aplikimi{

	
	private static Connection dbConnection;
	private static Label resultLabel;
	static TextField txtemri = new TextField();
	static TextField txtmbiemri = new TextField();
	static TextField txtemail = new TextField();
	static TextField txtid = new TextField();
	static TextField txtadresa = new TextField();
	static TextField txtqyteti = new TextField();	
	static TextField txtshteti = new TextField();
	static TextField txtzipkodi = new TextField();
	static TextField txtnrtel = new TextField();
	static TextField txtfakulteti = new TextField();
	static TextField txtdrejtimi = new TextField();
	static TextField txtVitiiStudimeve = new TextField();
	static TextField txtNiveliiStudimeve = new TextField();
	static TextField txtnm = new TextField();
	static TextField txtdtl = new TextField();

//	private ChoiceBox<String> choicebox;
	private static CheckBox box;
	private static ChoiceBox<String> choiceboxBursa;
	private static ChoiceBox<String> choicebox1;
	private static ChoiceBox<String> choiceboxnm;
	private static ChoiceBox<String> chKomuna;
	private static DatePicker dtl;
	 private static java.sql.Date date; //= new java.sql.Date(0000-00-00);
	public static void createMainStage() {
		setConnection();
		Stage stage = new Stage();
		
		GridPane pane = new GridPane();
		pane.setPadding(new Insets(11,12,13,14));
		pane.setAlignment(Pos.CENTER);
		pane.setHgap(13);
		pane.setVgap(13);
		
		
		pane.setBackground(new Background(new BackgroundFill(Color.color(0.2, 0.3, 0.2, 0.04), CornerRadii.EMPTY, Insets.EMPTY)));
		
		
		Label lblemri = new Label("Emri");
		Label lblmbiemri = new Label("Mbiemri");
		Label lblid = new Label("Id e studentit");
		Label lblditelindja = new Label("Data e lindjes");
		Label lbladresa = new Label("Adresa");
		Label lblqyteti = new Label("Qyteti:");
		Label lblshteti = new Label("Shteti");
		Label lbldate= new Label("Datelindja");
		Label lblnrtel = new Label("Nr i Telefonit");
		Label lblemail = new Label("Email-i");
		Label lbluniversiteti = new Label("	Universiteti");
		Label lblfakulteti = new Label("Fakulteti");
		Label lbldrejtimi = new Label("Drejtimi");
		Label lblVitiiStudimeve = new Label(" Viti i Studimeve");
		Label lblNotaMesatare = new Label("Nota mesatare");
		Label lblTranskriptaNotave = new Label("Transkripta e Notave");
		Label lblPerserit = new Label("Perserites i Vitit");
		Label lblBursa = new Label("Zgjedh Bursen:");
		
		txtemri.setPrefColumnCount(5);
		txtmbiemri.setPrefColumnCount(5);


	
//		choicebox = new ChoiceBox<>();
//		choicebox.setValue("Universiteti i Prishtines");
//		choicebox.getItems().addAll("Universiteti i Prishtines","Universiteti i Prizrenit","Universiteti i Mitrovices");
		
		choiceboxBursa = new ChoiceBox<>();
		choiceboxBursa.setValue("MASHT");
		choiceboxBursa.getItems().addAll("MASHT","Komunale");
		
		choiceboxnm = new ChoiceBox<>();
		choiceboxnm.setValue("Nen 8");
		choiceboxnm.getItems().addAll("Nen 8","Mbi 8","Mbi 9");
		
		
		choicebox1 = new ChoiceBox<>();
		choicebox1.setValue("Fakulteti i Arteve");
		choicebox1.getItems().addAll("Fakulteti i Arteve","Fakulteti i Shkencave Sportive","Fakulteti Juridik","FSHMN","Fakulteti Ekonomik","Fakulteti Filologjik"
				,"Fakulteti i Edukimit","Fakulteti i Ndertimtarise dhe Arkitektures","Fakulteti Filozofik","Fakulteti i Inxhinierise Mekanike"
				,"Fakulteti i Mjekesise","Fakulteti i shkencave matematiko-natyrore","Fakulteti i Inxhinierise Elektrike dhe Kompjuterike");
		pane.add(choicebox1, 1, 13); 
		
		chKomuna = new ChoiceBox<>();
		chKomuna.setValue("Prishtine");
		chKomuna.getItems().addAll("Prishtine","Peje","Gjakove","Prizren","Malisheve","Ferizaj","Gjilan","Vushtrri");
		
		box= new CheckBox("Jo");
		lblemri.setFont(Font.font("Times new Roman",FontWeight.BOLD,15));
		lblmbiemri.setFont(Font.font("Times new Roman",FontWeight.BOLD,15));
		lblnrtel.setFont(Font.font("Times new Roman",FontWeight.BOLD,15));
		lblid.setFont(Font.font("Times new Roman",FontWeight.BOLD,15));
		lblqyteti.setFont(Font.font("Times new Roman",FontWeight.BOLD,15));
		lblshteti.setFont(Font.font("Times new Roman",FontWeight.BOLD,15));
		lbldate.setFont(Font.font("Times new Roman",FontWeight.BOLD,15));
		lbladresa.setFont(Font.font("Times new Roman",FontWeight.BOLD,15));
		lblemail.setFont(Font.font("Times new Roman",FontWeight.BOLD,15));
		lbluniversiteti.setFont(Font.font("Times new Roman",FontWeight.BOLD,15));
		lblfakulteti.setFont(Font.font("Times new Roman",FontWeight.BOLD,15));
		lbldrejtimi.setFont(Font.font("Times new Roman",FontWeight.BOLD,15));
		lblVitiiStudimeve.setFont(Font.font("Times new Roman",FontWeight.BOLD,15));
		lblNotaMesatare.setFont(Font.font("Times new Roman",FontWeight.BOLD,15));
		lblditelindja.setFont(Font.font("Times new Roman",FontWeight.BOLD,15));
		lblPerserit.setFont(Font.font("Times new Roman",FontWeight.BOLD,15));
		lblBursa.setFont(Font.font("Times new Roman",FontWeight.BOLD,15));

        Label lblW = new Label("                            Forma e Aplikimit");
		lblW.setFont(Font.font("Times new Roman",FontWeight.BOLD,FontPosture.ITALIC,23));
		pane.setHalignment(lblW,HPos.CENTER);
		pane.add(lblW, 1, 0);
		
		pane.add(lblemri,0,3);
		pane.add(txtemri,1,3);	
		Label lbl0 = new Label();
		pane.add(lbl0, 1, 1);
		lbl0.setFont(Font.font("Times new Roman",FontPosture.ITALIC,12));
		lbl0.setTextFill(Color.RED);;
		
		pane.add(lblmbiemri, 2, 3);
		pane.add(txtmbiemri, 3, 3);		
		Label lbl = new Label();
		pane.add(lbl, 3, 1);
		lbl.setFont(Font.font("Times new Roman",FontPosture.ITALIC,12));
		lbl.setTextFill(Color.RED);;
		
		
	//	pane.add(lblditelindja, 0, 1);
	//	pane.add(dtl,1,1);
		
		pane.add(lblid, 0, 5);
		pane.add(txtid, 1,5);
		Label lbli = new Label();
		pane.add(lbli, 1, 6);
		lbli.setFont(Font.font("Times new Roman",FontPosture.ITALIC,12));
		lbli.setTextFill(Color.RED);;
		
		pane.add(lbladresa, 2, 5);
		pane.add(txtadresa, 3, 5);	
		Label lbla = new Label();
		pane.add(lbla, 3, 6);
		lbla.setFont(Font.font("Times new Roman",FontPosture.ITALIC,12));
		lbla.setTextFill(Color.RED);;
		
		pane.add(lblqyteti, 0, 7);
		pane.add(chKomuna, 1, 7);
		Label lblq = new Label();
		pane.add(lblq, 1, 8);
		lblq.setFont(Font.font("Times new Roman",FontPosture.ITALIC,12));
		lblq.setTextFill(Color.RED);;
		
		pane.add(lblshteti, 2, 7);
		pane.add(txtshteti,3,7);
		Label lbls = new Label();
		pane.add(lbls, 3, 8);
		lbls.setFont(Font.font("Times new Roman",FontPosture.ITALIC,12));
		lbls.setTextFill(Color.RED);;
		
		dtl = new DatePicker();
		date = new java.sql.Date(0000-00-00);
		pane.add(lbldate, 0, 9);
		pane.add(txtdtl,1,9);
		
		
		pane.add(lblnrtel, 2, 9);
		pane.add(txtnrtel,3,9);
		Label lbln = new Label();
		pane.add(lbln, 3, 10);
		lbln.setFont(Font.font("Times new Roman",FontPosture.ITALIC,12));
		lbln.setTextFill(Color.RED);;
		
		pane.add(lblemail, 0,11);
		pane.add(txtemail,1,11);	
		Label lble = new Label();
		pane.add(lble, 1, 12);
		lble.setFont(Font.font("Times new Roman",FontPosture.ITALIC,12));
		lble.setTextFill(Color.RED);;
		
//		pane.add(lbluniversiteti, 2, 8);
//		pane.add(choicebox,3,8);
		
		pane.add(lblPerserit, 2, 11);
		pane.add(box,3,11);
	
		
		Label lblnm = new Label();
		pane.add(lblnm, 3, 15);
		lblnm.setFont(Font.font("Times new Roman",FontPosture.ITALIC,12));
		lblnm.setTextFill(Color.RED);;
		
		
		pane.add(lblfakulteti, 0, 13);
		//pane.add(txtfakulteti,1,10);
		Label lblf = new Label();
		pane.add(lblf, 1, 14);
		lblf.setFont(Font.font("Times new Roman",FontPosture.ITALIC,12));
		lblf.setTextFill(Color.RED);;
		
		pane.add(lbldrejtimi, 2, 13);
		pane.add(txtdrejtimi,3,13);
		Label lbld = new Label();
		pane.add(lbld, 3, 14);
		lbld.setFont(Font.font("Times new Roman",FontPosture.ITALIC,12));
		lbld.setTextFill(Color.RED);;
		
		pane.add(lblVitiiStudimeve, 0, 15);
		pane.add(txtVitiiStudimeve,1,15);
		Label lblv = new Label();
		pane.add(lblv, 1, 16);
		lblv.setFont(Font.font("Times new Roman",FontPosture.ITALIC,12));
		lblv.setTextFill(Color.RED);;
	
		pane.add(lblNotaMesatare, 2, 15);
		pane.add(choiceboxnm, 3, 15);
		
		
		pane.add(lblBursa, 0, 17);
		pane.add(choiceboxBursa, 1, 17);
		

	
		Button btnApliko = new Button("  Apliko  ");
		btnApliko.setFont(Font.font("Verdana",FontWeight.BOLD,16));
		//btnApliko.setMinHeight(10);
		//btnApliko.setMinWidth(10);
		btnApliko.setTextFill(Color.GHOSTWHITE);
		btnApliko.setStyle("-fx-background-color: #000000,linear-gradient(#7ebcea, #2f4b8f),linear-gradient(#426ab7, #263e75),linear-gradient(#395cab, #223768);");
		
		btnApliko.setBackground(new Background(new BackgroundFill(Color.BLACK, CornerRadii.EMPTY, Insets.EMPTY)));  
		pane.add(btnApliko,1,20);
		pane.setHalignment(btnApliko,HPos.RIGHT);
		
		resultLabel = new Label(); 
		resultLabel.setFont(Font.font("Verdana",FontWeight.LIGHT,FontPosture.ITALIC,13));
		resultLabel.setTextFill(Color.DARKRED);
		pane.add(resultLabel, 3, 20);
		
		Scene scene = new Scene(pane,950,700);
		stage.setTitle("Forma e Aplikimit");
		//primaryStage.setResizable(false);
		stage.setScene(scene);
		stage.getIcons().add(new Image("file:///C:/Users/HP/git/knkProjekt/Knk_Project/graphic-scholarship_800x600.png"));

		stage.show();
		
		Button btnfile = new Button("Open file");
		pane.add(btnfile, 2, 17);
		FileChooser fileChooser = new FileChooser();

		ListView<String> list = new ListView<String>();
        list.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);
        list.setEditable(true);
		pane.add(list, 3, 17);
		
		
		btnfile.setOnAction(new EventHandler<ActionEvent>() {
			  @Override
			    public void handle(ActionEvent event) {
		    FileChooser fc = new FileChooser();
		    fc.setInitialDirectory(new File("C:\\Users"));
		    List<File> selectedFiles = fc.showOpenMultipleDialog(null);
		    if (selectedFiles != null) {
		        for (int i = 0; i < selectedFiles.size(); i++) {
		            list.getItems().add(selectedFiles.get(i).getAbsolutePath());
		        }
		    } else {
		        System.out.println("File is not Valid");
		    }
			  }
				});
		
		btnApliko.setOnAction(new EventHandler<ActionEvent>() {
		    @Override
		    public void handle(ActionEvent event) {
		    	
		    	  if(txtemri.getText().isEmpty() || txtmbiemri.getText().isEmpty() || txtid.getText().isEmpty() || txtdtl.getText().isEmpty()
		    			  || txtadresa.getText().isEmpty() || txtshteti.getText().isEmpty()
		    			|| txtnrtel.getText().isEmpty()|| txtemail.getText().isEmpty() || txtVitiiStudimeve.getText().isEmpty()|| txtdrejtimi.getText().isEmpty()) {
		           showAlert(Alert.AlertType.ERROR, pane.getScene().getWindow(), 
		            "Form Error!", "Ju lutem mbushni te gjitha fushat!");
		            return;
		        }
	
		      
		        if (!txtnrtel.getText().matches("[0-9]+")) {
		        	 showAlert(Alert.AlertType.ERROR, pane.getScene().getWindow(), 
			 		            "Numri i telefonit duhet te permbaj numra!", "!");
			 		            return; 
		        }
		        if (!txtid.getText().matches("[0-9]+")) {
		        	 showAlert(Alert.AlertType.ERROR, pane.getScene().getWindow(), 
			 		            "Id e studentit duhet te permbaj numra!", "!");
			 		            return; 
		        }
		    
		      
		        if ( !txtemri.getText().matches("[a-z A-Z]+") && (txtemri.getText().isEmpty()) == false){
		        	 showAlert(Alert.AlertType.ERROR, pane.getScene().getWindow(), 
		 		            "Form Error!", "Emri duhet te permbaj shkronja!");
		 		            return;  
		        } 
		        
		    
		    
		        if ( !txtmbiemri.getText().matches("[a-z A-Z]+") && (txtmbiemri.getText().isEmpty()) == false){
		        	 showAlert(Alert.AlertType.ERROR, pane.getScene().getWindow(), 
		 		            "Form Error!", "Mbiemri duhet te permbaj shkronja!");
		 		            return;  
		        } 
		        

		        if (!txtemail.getText().matches("[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.com") && (txtemail.getText().isEmpty()) == false) {
		        	  	 showAlert(Alert.AlertType.ERROR, pane.getScene().getWindow(), 
			 		            "Form Error!", "Email-i duhet te jete ne formatin: Someone@example.com ");
			 		            return; 
		        }
		      

		 if(choiceboxBursa.getValue().toString() == "MASHT") {
			 try {
		    if(((choicebox1.getValue().toString() == "Fakulteti i Inxhinierise Elektrike dhe Kompjuterike")
		    		||(choicebox1.getValue().toString() == "Fakulteti i Nd€rtimtarise dhe Arkitektures")
		    		||(choicebox1.getValue().toString() == "Fakulteti i Inxhinierise Mekanike"))&&
		    		(box.isSelected())&&((choiceboxnm.getValue().toString() == "Mbi 8")||(choiceboxnm.getValue().toString() == "Mbi 9"))) {
		        	zgjedhAplikues();

		        }
		    else if(((choicebox1.getValue().toString() == "Fakulteti Filozofik")||(choicebox1.getValue().toString() == "Fakulteti Filologjik")
		    		||(choicebox1.getValue().toString() == "Fakulteti i Shkencave Sportive")||(choicebox1.getValue().toString() == "Fakulteti Juridik"
		    		||(choicebox1.getValue().toString() == "Fakulteti Ekonomik")||(choicebox1.getValue().toString() == "Fakulteti i Mjekesise")
		    		||(choicebox1.getValue().toString() == "Fakulteti i shkencave matematiko-natyrore")))&&(box.isSelected())
		    		&& (choiceboxnm.getValue().toString() == "Mbi 9")) {
		    	zgjedhAplikues();

		        }
			 }
			 catch(Exception e) {
				 
			 }
		 }
		 
		 
		 if(choiceboxBursa.getValue().toString() == "Komunale" && chKomuna.getValue().toString()=="Prishtine") {
			 try {
		    if(((choicebox1.getValue().toString() == "Fakulteti i Inxhinierise Elektrike dhe Kompjuterike")
		    		||(choicebox1.getValue().toString() == "Fakulteti i Ndertimtarise dhe Arkitektures")
		    		||(choicebox1.getValue().toString() == "Fakulteti i Inxhinierise Mekanike"))&&(box.isSelected())&&
		    		((choiceboxnm.getValue().toString() == "Mbi 8")||(choiceboxnm.getValue().toString() == "Mbi 9"))) {
	        		shtoAplikues();
		        	//zgjedhAplikues();

		        }
		    else if(((choicebox1.getValue().toString() == "Fakulteti Filozofik")||(choicebox1.getValue().toString() == "Fakulteti Filologjik")
		    		||(choicebox1.getValue().toString() == "Fakulteti i Arteve")||(choicebox1.getValue().toString() == "Fakulteti i Edukimit")
		    		||(choicebox1.getValue().toString() == "Fakulteti i Shkencave Sportive")||(choicebox1.getValue().toString() == "Fakulteti Juridik"
		    		||(choicebox1.getValue().toString() == "Fakulteti Ekonomik")||(choicebox1.getValue().toString() == "Fakulteti i Mjekesise")
		    		||(choicebox1.getValue().toString() == "Fakulteti i shkencave matematiko-natyrore")))&&(box.isSelected())
		    		&& (choiceboxnm.getValue().toString() == "Mbi 9")) {
	        	shtoAplikues();	
		    	//zgjedhAplikues();

		        }
		    else {
		    	shtoAplikues();
		    }
			 }
			 catch(Exception e) {
				 
			 }
		 }
		 
		    else {
	        	shtoAplikues();
	       // 	zgjedhAplikues();

	        }
		        	
		        // !txtmbiemri.getText().matches("[a-z A-Z]+")
		       // showAlert(Alert.AlertType.CONFIRMATION, pane.getScene().getWindow(), 
		        //"Registration Successful!", "Welcome " + nameField.getText());
		    }

		    private void showAlert(Alert.AlertType alertType, Window owner, String title, String message) {
		        Alert alert = new Alert(alertType);
		        alert.setTitle(title);
		        alert.setHeaderText(null);
		        alert.setContentText(message);
		        alert.initOwner(owner);
		        alert.show();
		    }
		});
		
		

		
	}

	Desktop desktop = Desktop.getDesktop();
	

	private static void setConnection() {
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
	
	
public static void main(String[] args) {
	Application.launch(args);
}

private static void shtoAplikues() { 
	try {
		
		String query = "INSERT INTO aplikuesit(idStudentit, emri, mbiemri, ditelindja,mesatarja,email,numri,qyteti,adresa,VitiiStudimeve,NiveliiStudimeve,fakulteti,drejtimi,bursa) VALUES ( ? ,?,?, ?, ? ,?,?, ?, ? ,?,?, ?, ?,? )";
		
		PreparedStatement preparedStatement = dbConnection.prepareStatement(query);
		
		preparedStatement.setString(1, txtid.getText());
		preparedStatement.setString(2, txtemri.getText());
		preparedStatement.setString(3, txtmbiemri.getText());
		preparedStatement.setString(4, txtdtl.getText());
		preparedStatement.setString(5, txtnm.getText());
		preparedStatement.setString(6, txtemail.getText());
		preparedStatement.setString(7, txtnrtel.getText());
		preparedStatement.setString(8, txtqyteti.getText());
		preparedStatement.setString(9, txtadresa.getText());
		preparedStatement.setString(10, txtVitiiStudimeve.getText());
		preparedStatement.setString(11, txtNiveliiStudimeve.getText());
		preparedStatement.setString(12, choicebox1.getValue());
		preparedStatement.setString(13, txtdrejtimi.getText());
		preparedStatement.setString(14, choiceboxBursa.getValue());

		
		if(preparedStatement.executeUpdate() > 0) {
			Alert alert = new Alert(AlertType.INFORMATION);
			alert.setTitle("Rezultati");
			alert.setHeaderText(null);
			alert.setContentText("Aplikimi u krye me sukses!");
			alert.showAndWait();
		} else {
			Alert alert = new Alert(AlertType.INFORMATION);
			alert.setTitle("Login result");
			alert.setHeaderText(null);
			alert.setContentText("Aplikimi nuk eshte kryer!");
			alert.showAndWait();
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

private static void zgjedhAplikues() { 
	try {
		
		String query = "INSERT INTO Selected(idStudentit, emri, mbiemri, ditelindja,mesatarja,email,numri,qyteti,adresa,VitiiStudimeve,NiveliiStudimeve,fakulteti,drejtimi,bursa) VALUES (? ,?,?, ?, ? ,?,?, ?, ? ,?,?, ?, ?,? )";
		
		PreparedStatement prStatement = dbConnection.prepareStatement(query);
		
		prStatement.setString(1, txtid.getText());
		prStatement.setString(2, txtemri.getText());
		prStatement.setString(3, txtmbiemri.getText());
		prStatement.setString(4, txtdtl.getText());
		prStatement.setString(5, txtnm.getText());
		prStatement.setString(6, txtemail.getText());
		prStatement.setString(7, txtnrtel.getText());
		prStatement.setString(8, chKomuna.getValue());
		prStatement.setString(9, txtadresa.getText());
		prStatement.setString(10, txtVitiiStudimeve.getText());
		prStatement.setString(11, txtNiveliiStudimeve.getText());
		prStatement.setString(12, choicebox1.getValue());
		prStatement.setString(13, txtdrejtimi.getText());
		prStatement.setString(14, choiceboxBursa.getValue());
		
		if(prStatement.executeUpdate() > 0) {
			resultLabel.setText("U shtua ne listen e te zgjedhurve");
		} else {
			resultLabel.setText("nuk u shtua");
		}
	}
	catch(SQLException ex) {
		Alert alert = new Alert(AlertType.ERROR);
		alert.setTitle("Database problem");
		alert.setHeaderText(null);
		alert.setContentText(ex.getMessage());
		alert.showAndWait();
		System.exit(0);
	}

}
}
	