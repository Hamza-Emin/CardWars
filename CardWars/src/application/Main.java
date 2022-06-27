package application;
	
import java.io.IOException;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.image.Image;
import javafx.scene.layout.BorderPane;


public class Main extends Application {
	@Override
	public void start(Stage stage) {
		try {
			Parent root = FXMLLoader.load(getClass().getResource("StartScreen.fxml"));
			
			Image icon = new Image("gameicon.png");
		
			
			Scene scene = new Scene(root);
			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			stage.getIcons().add(icon);
			stage.setTitle("CardWars");
			
			Cards card = new Cards();
			
			
			stage.setOnCloseRequest(event -> {
				event.consume();
				
				exit(stage);
				
				
			});
			
			
			stage.setScene(scene);
			stage.show();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public void exit(Stage stage) {
		Alert alert = new Alert(AlertType.CONFIRMATION);
		
		alert.setTitle("Exit");
		alert.setHeaderText("You are about to exit!");
		alert.setContentText("Are you sure you want to exit?");
		
		if(alert.showAndWait().get() == ButtonType.OK) {
			
			System.out.println("You successfully exited");
			stage.close();
		}
	}
	
	public static void main(String[] args)  {
		
		launch(args);
	}
}
