package application;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


import com.sun.org.apache.xerces.internal.impl.xpath.regex.Match;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableColumnBase;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.stage.Stage;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.text.Font;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;


public class teZgjedhurit{


		static TableView<getDheSet> table = new TableView();
		static Connection conn = getConnection();
	
	public static void createMainStage() throws SQLException {
	{
		
				
		Stage primaryStage = new Stage();

		primaryStage.setTitle("Studentet qe kane fituar bursen");
		
		GridPane pane = new GridPane();
		
		pane.setPadding(new Insets(20,20,20,20));
		pane.setHgap(5);
		pane.setVgap(5);
		
		
		Label titulliLbl = new Label(); 
		titulliLbl.setText("Studentet e Zgjedhur Per Marrjen e Bursave");
		titulliLbl.setFont(Font.font("Cambria", 32));
		titulliLbl.setAlignment(Pos.CENTER_LEFT);
		pane.add(titulliLbl, 0, 0);
		
		Label rasteLbl = new Label(); 
		rasteLbl.setText("Ne raste se ka ndodhur ndonje gabim, mund te SHTONI/FSHINI student");
		rasteLbl.setFont(Font.font("Cambria", 15));
		pane.add(rasteLbl, 1, 3);
		
		table.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);
		ObservableList<getDheSet> optTable = FXCollections.observableArrayList();

		TableColumn idStudentit = new TableColumn("Id");
		idStudentit.setCellValueFactory(new PropertyValueFactory<getDheSet,String>("idStudentit"));
		
		TableColumn emri = new TableColumn("Emri");
		emri.setCellValueFactory(new PropertyValueFactory<getDheSet,String>("emri"));

		TableColumn mbiemri = new TableColumn("Mbimri");
		mbiemri.setCellValueFactory(new PropertyValueFactory<getDheSet,String>("mbiemri"));

		TableColumn mesatarja = new TableColumn("Mesatarja");
		mesatarja.setCellValueFactory(new PropertyValueFactory<getDheSet,Float>("mesatarja"));
		
		TableColumn email = new TableColumn("Email");
		email.setCellValueFactory(new PropertyValueFactory<getDheSet,String>("email"));
		
		TableColumn numri = new TableColumn("Numri");
		numri.setCellValueFactory(new PropertyValueFactory<getDheSet,String>("numri"));
		
		TableColumn fakulteti = new TableColumn("Fakulteti");
		fakulteti.setCellValueFactory(new PropertyValueFactory<getDheSet,String>("fakulteti"));

		TableColumn drejtimi = new TableColumn("Drejtimi");
		drejtimi.setCellValueFactory(new PropertyValueFactory<getDheSet,String>("drejtimi"));
		
		TableColumn bursa = new TableColumn("Bursa");
		bursa.setCellValueFactory(new PropertyValueFactory<getDheSet,String>("bursa"));
        
        table.getColumns().addAll(idStudentit,emri, mbiemri,drejtimi,mesatarja,email,numri,fakulteti,bursa);
        
        Statement st = conn.createStatement();
        
        String query = "SELECT * FROM Selected where mesatarja>=8 ORDER BY mesatarja DESC ";
        ResultSet fetchedBursistat = st.executeQuery(query);
	     try	
		    {
			while(fetchedBursistat.next())
			{
				
				int a = fetchedBursistat.getInt(2); //id
				String b = fetchedBursistat.getString(3); //emri
				String c = fetchedBursistat.getString(4); //mbiemri
				Float d = fetchedBursistat.getFloat(6); //mesatarja
				String e = fetchedBursistat.getString(7);//email
				int f = fetchedBursistat.getInt(8); //numri
				String g = fetchedBursistat.getString(13);//fakulteti
				String h = fetchedBursistat.getString(14);//drejtimi
				String i = fetchedBursistat.getString(15); //bursa
				
				optTable.add(new getDheSet(a,b,c,d,e,f,g,h,i));
			}
		}
		
		catch(Exception ex)
		{
			ex.printStackTrace();
		}
		table.setItems(optTable);
        
        
		Button insert = new Button();
		insert.setText("Shto Bursiste");
		
		Button delete = new Button();
		delete.setText("Fshij Bursiste");
//		 kodi per handler [DELETE]
		delete.setOnAction(new EventHandler<ActionEvent>() {
		    @Override public void handle(ActionEvent e) {
		    	
		    	getDheSet test = table.getSelectionModel().getSelectedItem();
		    	int _id = test.getIdStudentit();
		    	try {
		    		Statement st = conn.createStatement();
		    		 st.execute("delete from Selected where idStudentit = "+_id+";");

				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
		    	try {
					refreshTable();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
		    }
 		}); //[/DELETE]

//		mbraimi i kodit per handler
		
		
//		 kodi per butonin insert (click hanlder)  [INSERT]
		insert.setOnAction(new EventHandler<ActionEvent>() {
		    @Override public void handle(ActionEvent e) {
		    	 Label secondLabel = new Label("Hello");
	                
		    	 Stage secondStage = new Stage();
	             secondStage.setTitle("Shto Bursiste");
		    	 GridPane secondPane = new GridPane();

		    	 secondPane.setPadding(new Insets(15,15,15,15));
		    	 secondPane.setHgap(5);
		    	 secondPane.setVgap(5);
	                
		    	 Label idLbl = new Label("ID e Studentit : ");
		    	 Label emriLbl= new Label("Emri : ");
		    	 Label mbiemriLbl= new Label("Mbiemri : ");
		    	 Label mesatarjaLbl = new Label("Mesatarja : ");
		    	 Label drejtimiLbl =new Label("Drejtimi : ");
		    	 Label emailLbl = new Label("Email : ");
		    	 Label numriLbl = new Label("Numri : ");
		    	 Label fakultetiLbl = new Label("Fakulteti : ");
		    	 Label bursaLbl = new Label("Bursa : ");
	                
		    	 TextField idField=new TextField();
		    	 TextField emriField=new TextField();
		    	 TextField mbiemriField=new TextField();
		    	 TextField mesatarjaField=new TextField();
		    	 TextField drejtimiField=new TextField();
		    	 TextField emailField=new TextField();
		    	 TextField numriField=new TextField();
		    	 TextField fakultetiField=new TextField();
		    	 TextField bursaField=new TextField();
		    	 
		    	 Button shto = new Button();
		    	 shto.setText("Shto");// [SHTO]
		    	 
		    	 secondPane.add(idLbl, 0, 1);
		    	 secondPane.add(emriLbl, 0, 2);
		    	 secondPane.add(mbiemriLbl, 0, 3 );
		    	 secondPane.add(mesatarjaLbl, 0, 4);
		    	 secondPane.add(drejtimiLbl, 0, 5);
		    	 secondPane.add(emailLbl, 0, 6);
		    	 secondPane.add(numriLbl, 0, 7);
		    	 secondPane.add(fakultetiLbl, 0, 8);
		    	 secondPane.add(bursaLbl, 0, 9);
		    	 
		    	 secondPane.add(idField, 1, 1);
		    	 secondPane.add(emriField, 1, 2);
		    	 secondPane.add(mbiemriField, 1, 3 );
		    	 secondPane.add(mesatarjaField, 1, 4);
		    	 secondPane.add(drejtimiField, 1, 5);
		    	 secondPane.add(emailField, 1, 6);
		    	 secondPane.add(numriField, 1, 7);
		    	 secondPane.add(fakultetiField, 1, 8);
		    	 secondPane.add(bursaField, 1, 9);
		    	 
		    	 secondPane.add(shto, 1, 10);
		    	 shto.setOnAction(new EventHandler<ActionEvent>() {
		 		    @Override public void handle(ActionEvent e) {
		 		    	Float id = Float.parseFloat(idField.getText());
		 		    	String emri = emriField.getText();
		 		    	String mbiemri = emriField.getText();
		 		    	Float mesatarja = Float.parseFloat(mesatarjaField.getText());
		 		    	String drejtimi = drejtimiField.getText();
		 		    	String email = emailField.getText();
		 		    	float numri = Float.parseFloat(numriField.getText());
		 		    	String fakulteti = fakultetiField.getText();
		 		    	String bursa = bursaField.getText();

		 		    	try {
							st.executeUpdate("insert into Selected (idStudentit,emri,mbiemri,mesatarja,drejtimi,email,numri,fakulteti,bursa)"
									+ " values("+id+",'"+emri+"','"+mbiemri+"',"+mesatarja+",'"+drejtimi+"','"+email+"',"+numri+",'"+fakulteti+"','"+bursa+"');");
						} catch (SQLException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
							System.out.println("Nuk mundesh me insertu te dhena");
						}
		 		    	try {
							refreshTable();
						} catch (SQLException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
		 		    	
		 		    	idField.setText("");
		 		    	emriField.setText("");
		 		    	mbiemriField.setText("");
		 		    	mesatarjaField.setText("");
		 		    	drejtimiField.setText("");
		 		    	emailField.setText("");	
		 		    	numriField.setText("");
		 		    	fakultetiField.setText("");
		 		    	bursaField.setText("");
		 		    	idField.setFocusTraversable(true);
		 		    	
		 		   }
		 		});// [/SHTO]
		    	 
	        		//secondPane.setColumnSpan(table, 5);
	        		
//	        		secondPane.add(secondLabel, 0, 1);
	        		
	        		Scene secondScene = new Scene(secondPane);
	        		secondStage.setScene(secondScene);
	        		secondStage.show();
		    }
		});
		
//		mbraimi i kodit per handler [/INSERT]
		
		pane.add(table, 0, 2);
		pane.setColumnSpan(table, 5);
		
		pane.add(insert, 2, 3);
		pane.add(delete, 3, 3);
		
		Scene scene = new Scene(pane);
		primaryStage.setScene(scene);
		primaryStage.getIcons().add(new Image("file:///C:/Users/HP/git/knkProjekt/Knk_Project/graphic-scholarship_800x600.png"));

		primaryStage.show();
			
	}
	}
	
	
	public static void refreshTable() throws SQLException { 

		table.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);
		ObservableList<getDheSet> optTable = FXCollections.observableArrayList();
		
		optTable.clear(); 
		Connection conn = getConnection();
		Statement st = conn.createStatement();
        
        String query = "SELECT * FROM Selected where mesatarja>=8 ORDER BY mesatarja DESC ";
        ResultSet fetchedBursistat = st.executeQuery(query);
		try	
		{
			while(fetchedBursistat.next())
			{
				
				
				
				int a = fetchedBursistat.getInt(2); //id
				String b = fetchedBursistat.getString(3); //emri
				String c = fetchedBursistat.getString(4); //mbiemri
				Float d = fetchedBursistat.getFloat(6); //mesatarja
				String e = fetchedBursistat.getString(7);//email
				int f = fetchedBursistat.getInt(8); //numri
				String g = fetchedBursistat.getString(13);//fakulteti
				String h = fetchedBursistat.getString(14);//drejtimi
				String i = fetchedBursistat.getString(15); //bursa
				
				optTable.add(new getDheSet(a,b,c,d,e,f,g,h,i));
			}
		}
		
		catch(Exception ex)
		{
			ex.printStackTrace();
		}
		table.setItems(optTable);
		}



    public static java.sql.Connection getConnection()
    {
        try
        {
        	String correct = "?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
            java.sql.Connection conn = DriverManager.getConnection
            		("jdbc:mysql://localhost:3306/menaxhimi_bursave"+correct, "root", "");
           
            System.out.println("Jeni lidhur me sukses");
            
            
            return conn;
        }
        catch (Exception ex)
        {
            ex.printStackTrace();
           
            return null;
        }
    }
    }

