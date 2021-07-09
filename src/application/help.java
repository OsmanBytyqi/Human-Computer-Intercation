package application;

import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class help {

	public static void createMainStage() {
		
		Stage stage = new Stage();
		BorderPane layout = new BorderPane();
		Image image3 = new Image("file:///C:/Users/HP/git/knkProjekt/Knk_Project/info-help-data-blue-round-2-512.png");
		ImageView img3 = new ImageView(image3);
		img3.setFitHeight(70);
		img3.setFitWidth(70);
		Text txt0 = new Text("Informacione\n");
		Text txt1 = new Text("Sistemi per menagjimin e bursave ofron mundesine \r\n" + 
				"e aplikimit per bursat MASHT dhe Komunale.\r\n" + 
				"Kerkesat qe duhet ti bashkengjiten formes per \r\n" + 
				"aplikim jepen ne pershkrimin perkates per keto\r\n" + 
				"lloje te bursave.Te drejten e qasjes ne sistem \r\n" + 
				"e ka administratori i sistemit i cili poashtu\r\n" + 
				"ka te drejten e shtimit te administratoreve te \r\n" + 
				"tjere.Sistemi eshte i qasshem edhe permes tasteve\r\n" + 
				"te cilat pershkruhen ne opsionet perkatese te menyve.");
	    txt0.setStroke(Color.DARKBLUE);
		txt0.setFont(Font.font("verdana", FontWeight.BOLD, FontPosture.REGULAR, 20)); 
		txt1.setFont(Font.font("verdana", FontWeight.MEDIUM, FontPosture.REGULAR, 13)); 
		
		Menu LngMenu = new Menu("Gjuha");		        
        MenuItem EItem = new MenuItem("Anglisht");
        MenuItem AItem = new MenuItem("Shqip");
        LngMenu.getItems().addAll(EItem,AItem);
        EItem.setOnAction(e->{
        	
        	txt0.setText("Informations\n");
        	txt1.setText("Scholarship Managment System offers the\r\n" + 
        			"chance toapply for MASHT Scholarship and \r\n" + 
        			"Communal Scholarship.The informations that should \r\n" + 
        			"be included in the application form are given\r\n" + 
        			"in the description for these scholarships.\r\n" + 
        			"This system can access the administrator of the\r\n" + 
        			"system which also can add new administrator.\r\n" + 
        			"The system is also accessible through keyboard\r\n" + 
        			"which are described in the options in the relevant menu.");
        	LngMenu.setText("Language");
        	EItem.setText("English");
        	AItem.setText("Albanian");
        });
        AItem.setOnAction(e->{
        	
        	txt0.setText("Informacione\n");
        	txt1.setText("Sistemi per menagjimin e bursave ofron mundesine \r\n" + 
        			"e aplikimit per bursat MASHT dhe Komunale.\r\n" + 
        			"Kerkesat qe duhet ti bashkengjiten formes per \r\n" + 
        			"aplikim jepen ne pershkrimin perkates per keto\r\n" + 
        			"lloje te bursave.Te drejten e qasjes ne sistem \r\n" + 
        			"e ka administratori i sistemit i cili poashtu\r\n" + 
        			"ka te drejten e shtimit te administratoreve te \r\n" + 
        			"tjere.Sistemi eshte i qasshem edhe permes tasteve\r\n" + 
        			"te cilat pershkruhen ne opsionet perkatese te menyve.");
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
		newWindow.getIcons().add(new Image("file:///C:/Users/HP/git/knkProjekt/Knk_Project/graphic-scholarship_800x600.png"));
		newWindow.setTitle("Info");
		newWindow.setScene(secondScene);
       // Set position of second window, related to primary window
		//newWindow.setX(stage.getX() + 200);
		//newWindow.setY(stage.getY() + 100);
		newWindow.show();
		
	}
};
