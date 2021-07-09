package application;

import java.awt.event.KeyEvent;
import java.io.IOException;
import java.sql.SQLException;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
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
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class MainProgram  {
	Stage window;
    BorderPane layout;
    public static Button btnMasht;
    public static Button btnKomunale;
    public static Text txt;
    //public static Text txt0;
   // static Text txt1;
    //public Text txtK0;
    //public Text txtK1;
    static BorderPane layoutt;
    
	public static void createMainStage() {
		Stage stage = new Stage();
		
		GridPane pane = new GridPane();
		pane.setAlignment(Pos.CENTER);
		pane.setHgap(20);
		pane.setVgap(20);
		
        Menu fileMenu = new Menu("File");
        Menu LngMenu = new Menu("Gjuha");
        Menu PaneletMenu = new Menu("Panelet");
        Menu ProfilMenu = new Menu("Profili");
        Menu helpMenu = new Menu("Ndihma");
        
        MenuItem addItem = new MenuItem("Shto Admin");
        MenuItem changeItem = new MenuItem("Ndrysho Password-in");
        MenuItem infoitem = new MenuItem("Info     CTRL+H");
        helpMenu.getItems().addAll(infoitem);
        MenuItem apItem = new MenuItem(" Aplikimi ");
        MenuItem apItem2 = new MenuItem(" Aplikantet ");
        MenuItem apItem3 = new MenuItem(" Te zgjedhurit ");

        ProfilMenu.getItems().addAll(addItem,changeItem);
        PaneletMenu.getItems().addAll(apItem,apItem2,apItem3);
        changeItem.setOnAction(e->{
        	ChangePsw.createMainStage();  	
        });
        addItem.setOnAction(e->{
        	addAdmin.createMainStage();  	
        });
        apItem3.setOnAction(e->{
        	try {
				teZgjedhurit.createMainStage();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}  	
        });
        apItem.setOnAction(e->{
			Aplikimi.createMainStage();
        });
        
        apItem2.setOnAction(e->{
        	//mainStage.hide();
			MainApp.AplikantetStage();
        });

        MenuItem ExitItem = new MenuItem("Dil     CTRL+V");
        fileMenu.getItems().add(ExitItem);
        
        MenuItem EItem = new MenuItem("Anglisht    CTRL+E");
        MenuItem AItem = new MenuItem("Shqip       CTRL+E");
        LngMenu.getItems().addAll(EItem,AItem);
        EItem.setOnAction(e->{
        	
        	btnMasht.setText("MASHT");
        	btnKomunale.setText("Communal");
        	txt.setText("Scholarships");
        	fileMenu.setText("File");
        	LngMenu.setText("Language");
        	helpMenu.setText("Help");
        	PaneletMenu.setText("Pannels");
        	ExitItem.setText("Exit      CTRL+V");
        	EItem.setText("English      CTRL+E");
        	AItem.setText("Albanian     CTRL+A");
        	infoitem.setText("Info     CTRL+H");
        	apItem.setText("Application");
    		stage.setTitle("Scholarship Management System");
    		apItem2.setText(" Applicants ");
    		apItem3.setText(" Selected ");
    		changeItem.setText(" Change Password ");
    		addItem.setText(" Add Admin ");
    		ProfilMenu.setText(" Profile ");

        	

        });
        AItem.setOnAction(e->{
        	
        	btnMasht.setText("Bursa MASHT");
        	btnKomunale.setText("Bursa Komunale");
        	txt.setText("Bursat");
        	fileMenu.setText("File");
        	LngMenu.setText("Gjuha");
        	PaneletMenu.setText("Panelet");
        	helpMenu.setText("Ndihma");
        	ExitItem.setText("Dil     CTRL+V");
        	EItem.setText("Anglisht    CTRL+E");
        	AItem.setText("Shqip       CTRL+E");
        	infoitem.setText("Info     CTRL+H");
        	apItem.setText(" Aplikimi ");
    		stage.setTitle("Scholarship Management System");
    		apItem2.setText(" Aplikantet ");
    		apItem3.setText(" Te zgjedhurit ");
    		changeItem.setText(" Ndrysho Password-in ");
    		addItem.setText(" Shto Admin ");
    		ProfilMenu.setText(" Profili ");


        });
        ExitItem.setOnAction(e->{
        	System.exit(0);
        	
        });
        infoitem.setOnAction(e->{
        	help.createMainStage();	
        });
    
        MenuBar menuBar = new MenuBar();
        
        menuBar.getMenus().addAll(fileMenu,LngMenu,PaneletMenu,helpMenu,ProfilMenu);

		
		 Image imageB = new Image ("file:///C:/Users/HP/git/knkProjekt/Knk_Project/light-grey-background-02.jpg");
	     pane.setBackground(new Background(new BackgroundImage(imageB,BackgroundRepeat.NO_REPEAT,BackgroundRepeat.NO_REPEAT,BackgroundPosition.DEFAULT,BackgroundSize.DEFAULT)));                              
		
		Image image = new Image("file:///C:/Users/HP/git/knkProjekt/Knk_Project/01-512.png");
		Image image2 = new Image("file:///C:/Users/HP/git/knkProjekt/Knk_Project/icon-ministry-circle.png");
		ImageView img = new ImageView(image);
		ImageView img2 = new ImageView(image2);
		img.setFitHeight(250);
		img.setFitWidth(250);
		img2.setFitHeight(180);
		img2.setFitWidth(180);
		
		HBox hbox = new HBox();
		txt = new Text("Bursat");
		txt.setFill(Color.GRAY);
		txt.setFont(Font.font("Sanserif",FontWeight.EXTRA_LIGHT,FontPosture.ITALIC,40));
		hbox.getChildren().addAll(txt);
		
		btnMasht = new Button("Bursa Masht");
		pane.setHalignment(btnMasht,HPos.CENTER);
		btnKomunale = new Button("Bursa Komunale");

		btnMasht.setMinSize(50, 30);
		btnMasht.setTextFill(Color.WHITE);
		btnMasht.setStyle("-fx-background-color: #000000,linear-gradient(#7ebcea, #2f4b8f),linear-gradient(#426ab7, #263e75),linear-gradient(#395cab, #223768);");
		btnMasht.setBackground(new Background(new BackgroundFill(Color.CYAN, CornerRadii.EMPTY, Insets.EMPTY)));
		
		btnKomunale.setMinSize(50, 30);
		btnKomunale.setTextFill(Color.WHITE);
		btnKomunale.setStyle("-fx-background-color: #000000,linear-gradient(#7ebcea, #2f4b8f),linear-gradient(#426ab7, #263e75),linear-gradient(#395cab, #223768);");
		btnKomunale.setBackground(new Background(new BackgroundFill(Color.CYAN, CornerRadii.EMPTY, Insets.EMPTY)));

		
		btnMasht.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				
			BorderPane layout = new BorderPane();
			Image image3 = new Image("file:///C:/Users/HP/git/knkProjekt/Knk_Project/info-help-data-blue-round-2-512.png");
			ImageView img3 = new ImageView(image3);
			img3.setFitHeight(70);
			img3.setFitWidth(70);
			Text txt0 = new Text("Bursat MASHT\n");
			Text txt1 = new Text("Bursat MASHT ndahen nga Ministria e arsimit\r\n" + 
					"shkences dhe teknologjise.\r\n" + 
					"Bursat vlejne per nivelin Bachelor dhe\r\n" + 
					"vlera e tyre eshte 1000 euro per nje vit\r\n" + 
					"akademik aplikimi per kete burse mund te behet\r\n" + 
					"ne formen perkatese te aplikimit.Kërkesës\r\n" + 
					"për burse kandidati duhet që t’i bashkëngjes\r\n" + 
					"Letër reference nga profesorët,Çertifikatën e \r\n" + 
					"notave, kopje të indeksit/document identifikimi.");
		    txt0.setStroke(Color.DARKBLUE);
			txt0.setFont(Font.font("verdana", FontWeight.BOLD, FontPosture.REGULAR, 20)); 
			txt1.setFont(Font.font("verdana", FontWeight.MEDIUM, FontPosture.REGULAR, 13)); 
			
			Menu LngMenu = new Menu("Gjuha");		        
	        MenuItem EItem = new MenuItem("Anglisht");
	        MenuItem AItem = new MenuItem("Shqip");
	        LngMenu.getItems().addAll(EItem,AItem);
	        EItem.setOnAction(e->{
	        	
	        	txt0.setText("MASHT Scholarship\n");
	        	txt1.setText("MASHT Scholarship are made possible by Ministry \r\n" + 
	        			"of science and technology.These Scholarships \r\n" + 
	        			"include Bachelor level.They're worth 1000E.\r\n" + 
	        			"The application for this scholarship can be done\r\n" + 
	        			"in the application form.The candidate should prepare\r\n" + 
	        			"a reference letter from professors,grades certificate,\r\n" + 
	        			"and a copy of identification document.");
	        	LngMenu.setText("Language");
	        	EItem.setText("English");
	        	AItem.setText("Albanian");
	        });
	        AItem.setOnAction(e->{
	        	
	        	txt0.setText("Bursat MASHT\n");
	        	txt1.setText("Bursat MASHT ndahen nga Ministria e arsimit\r\n" + 
						"shkences dhe teknologjise.\r\n" + 
						"Bursat vlejne per nivelin Bachelor dhe\r\n" + 
						"vlera e tyre eshte 1000 euro per nje vit\r\n" + 
						"akademik aplikimi per kete burse mund te behet\r\n" + 
						"ne formen perkatese te aplikimit.Kërkesës\r\n" + 
						"për burse kandidati duhet që t’i bashkëngjes\r\n" + 
						"Letër reference nga profesorët,Çertifikatën e \r\n" + 
						"notave, kopje të indeksit/document identifikimi.");
	        	LngMenu.setText("Gjuha");
	        	EItem.setText("Anglisht");
	        	AItem.setText("Shqip");
	        });
	        MenuBar menuBar = new MenuBar();
	        
	        menuBar.getMenus().addAll(LngMenu);

			VBox secondaryLayout = new VBox();
			secondaryLayout.setAlignment(Pos.CENTER);
			secondaryLayout.getChildren().addAll(img3,txt0,txt1);
			
			layout.setTop(menuBar);
			layout.setCenter(secondaryLayout);
			Scene secondScene = new Scene(layout, 500,450);
			// New window (Stage)
			Stage newWindow = new Stage();
			newWindow.setTitle("Info");
			newWindow.setScene(secondScene);
			newWindow.getIcons().add(new Image("file:///C:/Users/HP/git/knkProjekt/Knk_Project/graphic-scholarship_800x600.png"));

	       // Set position of second window, related to primary window
		//	newWindow.setX(stage.getX() + 200);
		//	newWindow.setY(stage.getY() + 100);
			newWindow.show();}
	});
		
		
		btnKomunale.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
			BorderPane layout = new BorderPane();
		
			Image image3 = new Image("file:///C:/Users/HP/git/knkProjekt/Knk_Project/info-help-data-blue-round-2-512.png");
			ImageView img3 = new ImageView(image3);
			img3.setFitHeight(70);
			img3.setFitWidth(70);
			Text txtK0 = new Text("Bursat Komunale\n");
			Text txtK1 = new Text("Bursat komunale ndahen nga Komuna e Prishtines\r\n" + 
					"per studentet e Universitetit te Prishtines.\r\n" + 
					"Bursat vlejne per nivelin Bachelor dhe\r\n" + 
					"vlera e tyre eshte 500 euro per nje vit\r\n" + 
					"akademik, aplikimi per kete burse mund te behet\r\n" + 
					"ne formen perkatese te aplikimit.Kërkesës\r\n" + 
					"për burse kandidati duhet që t’i bashkëngjes\r\n" + 
					"Letër reference nga profesorët,Çertifikatën e \r\n" + 
					"notave, kopje të indeksit/document identifikimi.\r\n" + 
					"");
		    txtK0.setStroke(Color.DARKBLUE);
			txtK0.setFont(Font.font("verdana", FontWeight.BOLD, FontPosture.REGULAR, 20)); 
			txtK1.setFont(Font.font("verdana", FontWeight.MEDIUM, FontPosture.REGULAR, 13)); 
			
			
			
			Menu LngMenu = new Menu("Gjuha");		        
	        MenuItem EItem = new MenuItem("Anglisht");
	        MenuItem AItem = new MenuItem("Shqip");
	        LngMenu.getItems().addAll(EItem,AItem);
	        EItem.setOnAction(e->{
	        	
	        	txtK0.setText("Communal Scholarships");
	        	txtK1.setText("\r\n" + 
	        			"Communal Scholarship are made possible the Municipal\r\n" + 
	        			"of Prishtina for Students of the University\r\n" + 
	        			"of Prishtina.These Scholarships \r\n" + 
	        			"include Bachelor level.They're worth 1000E.\r\n" + 
	        			"The application for this scholarship can be done\r\n" + 
	        			"in the application form.The candidate should prepare\r\n" + 
	        			"a reference letter from professors,grades certificate,\r\n" + 
	        			"and a copy of identification document.");
	        	LngMenu.setText("Language");
	        	EItem.setText("English");
	        	AItem.setText("Albanian");
	        });
	        AItem.setOnAction(e->{
	        	
	        	txtK0.setText("Bursat Komunale\n");
	        	txtK1.setText("Bursat komunale ndahen nga Komuna e Prishtines\r\n" + 
						"per studentet e Universitetit te Prishtines.\r\n" + 
						"Bursat vlejne per nivelin Bachelor dhe\r\n" + 
						"vlera e tyre eshte 500 euro per nje vit\r\n" + 
						"akademik, aplikimi per kete burse mund te behet\r\n" + 
						"ne formen perkatese te aplikimit.Kërkesës\r\n" + 
						"për burse kandidati duhet që t’i bashkëngjes\r\n" + 
						"Letër reference nga profesorët,Çertifikatën e \r\n" + 
						"notave, kopje të indeksit/document identifikimi.\r\n" + 
						"");
	        	LngMenu.setText("Gjuha");
	        	EItem.setText("Anglisht");
	        	AItem.setText("Shqip");
	        });
	        MenuBar menuBar = new MenuBar();
	        
	        menuBar.getMenus().addAll(LngMenu);

			VBox secondaryLayout = new VBox();
			secondaryLayout.setAlignment(Pos.CENTER);
			secondaryLayout.getChildren().addAll(img3,txtK0,txtK1);
			layout.setTop(menuBar);
			layout.setCenter(secondaryLayout);
			Scene secondScene = new Scene(layout, 500,450);
			// New window (Stage)
			Stage newWindow = new Stage();
			newWindow.getIcons().add(new Image("file:///C:/Users/HP/git/knkProjekt/Knk_Project/graphic-scholarship_800x600.png"));

			newWindow.setTitle("Info");
			newWindow.setScene(secondScene);
	       // Set position of second window, related to primary window
			//newWindow.setX(stage.getX() + 200);
			//newWindow.setY(stage.getY() + 100);
			newWindow.show();}
	});
		
		//VBox vbox = new VBox();
		layoutt = new BorderPane();
		layoutt.setTop(menuBar);
		//pane.add(layoutt,0,0);
		pane.add(hbox,2,0);
		pane.add(img, 0,1);
		pane.add(img2, 4,1);
		pane.add(btnMasht,0,2);
		pane.add(btnKomunale,4,2);
		layoutt.setCenter(pane);
		//vbox.getChildren().addAll(layoutt,pane);		
		Scene scene = new Scene(layoutt);
		stage.getIcons().add(new Image("file:///C:/Users/HP/git/knkProjekt/Knk_Project/graphic-scholarship_800x600.png"));
		stage.setMaximized(true);
		stage.setTitle("Sistemi per menaxhimin e Bursave");
		stage.setScene(scene);
		stage.show();
		
		
		pane.setOnKeyPressed(e -> {
			if(e.isControlDown() && e.getCode() == KeyCode.V) {
				System.exit(0);			}
			if(e.isControlDown() && e.getCode() == KeyCode.A) {
				btnMasht.setText("Bursa MASHT");
	        	btnKomunale.setText("Bursa Komunale");
	        	txt.setText("Bursat");
	        	fileMenu.setText("File");
	        	LngMenu.setText("Gjuha");
	        	PaneletMenu.setText("Panelet");
	        	ExitItem.setText("Dil");
	        	EItem.setText("Anglisht");
	        	AItem.setText("Shqip");
	    		stage.setTitle("Sistemi per menaxhimin e Bursave");
	    		apItem2.setText(" Applicants ");
	    		apItem3.setText(" Selected ");
	    		changeItem.setText(" Change Password ");
	    		addItem.setText(" Add Admin ");
	    		ProfilMenu.setText(" Profile ");

	        	}
			if(e.isControlDown() && e.getCode() == KeyCode.E) {
				btnMasht.setText("MASHT");
	        	btnKomunale.setText("Communal");
	        	txt.setText("Scholarships");
	        	fileMenu.setText("File");
	        	LngMenu.setText("Language");
	        	PaneletMenu.setText("Pannels");
	        	ExitItem.setText("Exit");
	        	EItem.setText("English");
	        	AItem.setText("Albanian");
	    		stage.setTitle("Scholarship Management System");
	    		apItem2.setText(" Aplikantet ");
	    		apItem3.setText(" Te zgjedhurit ");
	    		changeItem.setText(" Ndrysho Password-in ");
	    		addItem.setText(" Shto Admin ");
	    		ProfilMenu.setText(" Profili ");

	        	}
			if(e.isControlDown() && e.getCode() == KeyCode.H) {
				 help.createMainStage();
	        	}
		});
	
		
    }
    
   
}