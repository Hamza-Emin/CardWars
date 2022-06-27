package application;

import java.io.BufferedReader;
import java.io.Console;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Random;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class SceneController {
	
	private Parent root;
	private Stage stage;
	private Scene scene;
	@FXML
	private Button button;
	@FXML
	private AnchorPane scenePane;
	@FXML
	private TextField nameTextField, nameTextField2;
	
	Cards cardCheck = new Cards();
	
	Cards ansatsu = new Cards("Card DB/Ansatsu.jpg",100,20);
	Cards ancientElf = new Cards("Card DB/Ancient Elf.jpg", 250,200);
	Cards battleOx = new Cards("Card DB/Battle Ox.jpg",350,210);
	Cards beaver = new Cards("Card DB/Beaver Warrior.jpg",100,200);
	Cards blue = new Cards("Card DB/Blue Eyes White Dragon.jpg",500,200);
	Cards celtic = new Cards("Card DB/Celtic Guardian.jpg",150,150);
	Cards curse = new Cards("Card DB/Curse of Dragon.jpg",190,120);
	Cards darkAs = new Cards("Card DB/Dark Assailant.jpg",250,145);
	Cards darkMag = new Cards("Card DB/Dark Magician.jpg",300,300);
	Cards darkTitan = new Cards("Card DB/Dark Titan of Terror.jpg",105,60);
	Cards destroyer = new Cards("Card DB/Destroyer Golem.jpg",50,250);
	Cards doma = new Cards("Card DB/Doma the Angel of Silence.jpg",400,200);
	Cards dhuman = new Cards("Card DB/D Human.jpg",100,100);
	Cards dragonzom = new Cards("Card DB/Dragon Zombie.jpg",116,55);
	Cards feral = new Cards("Card DB/Feral Imp.jpg",108,75);
	Cards gaia = new Cards("Card DB/Gaia the Fierce Knight.jpg",90,900);
	Cards giant = new Cards("Card DB/Giant Soldier of Stone.jpg",130,120);
	Cards great = new Cards("Card DB/Great White.jpg",300,150);
	Cards gyakutenno = new Cards("Card DB/Gyakutenno Megami.jpg",180,120);
	Cards hitotsu = new Cards("Card DB/Hitotsu-Me Giant.jpg",190,200);
	Cards judge= new Cards("Card DB/Judge Man.jpg",45,60);
	Cards kojikocy = new Cards("Card DB/Kojikocy.jpg",80,200);
	Cards koumori = new Cards("Card DB/Koumori Dragon.jpg",600,200);
	Cards lajinn = new Cards("Card DB/La Jinn the Mystical Genie of the Lamp.jpg",250,105);
	Cards claw = new Cards("Card DB/Claw Reacher.jpg", 450, 300);
	
	
	
	
	public Cards determineCard(ImageView view) throws IOException {
		List<Cards> cards = new ArrayList();
		Collections.addAll(cards, ansatsu, battleOx, beaver, celtic, curse, darkAs, darkTitan, 
							destroyer, dhuman, dragonzom, feral, gaia, giant, gyakutenno, hitotsu, judge,
							kojikocy, koumori, lajinn,claw);
		GameController controller = new GameController();

		for(int i = 0; i < cards.size(); i++) {
			String newPath = (cards.get(i)).path; 
			Image card = new Image(getClass().getResourceAsStream(newPath));
			if(cardCheck.isImageEqual(card, view.getImage())) {
				return cards.get(i);
				
			}
			
		}
		return cardCheck;
	
		
		
	}
	public void switchToGetName(ActionEvent event) throws IOException {
		root = FXMLLoader.load(getClass().getResource("GetName.fxml"));
		stage = (Stage)((Node)event.getSource()).getScene().getWindow();
		scene = new Scene(root);
		stage.setScene(scene);
		stage.show();
	}
	
	public void exit(ActionEvent event) {
		Alert alert = new Alert(AlertType.CONFIRMATION);
		
		alert.setTitle("Exit");
		alert.setHeaderText("You are about to exit!");
		alert.setContentText("Are you sure you want to exit?");
		
		if(alert.showAndWait().get() == ButtonType.OK) {
			stage = (Stage)scenePane.getScene().getWindow();
			System.out.println("You successfully exit");
			stage.close();
		}
	}
	
public void login(ActionEvent event) throws IOException {
		
		String username1 = nameTextField.getText();
		String username2 = nameTextField2.getText();
		FXMLLoader loader = new FXMLLoader(getClass().getResource("Game.fxml"));	
		root = loader.load();	
		
		GameController scene2Controller = loader.getController();
		
		
		scene2Controller.displayPlayer1Name(username1);
		scene2Controller.displayPlayer2Name(username2);
		scene2Controller.displayHealthPlayer2(1000);
		scene2Controller.displayHealthPlayer1(1000);
		scene2Controller.displayRound();
		scene2Controller.displayDeck();
		
		
		
		
		
			
		stage = (Stage)((Node)event.getSource()).getScene().getWindow();
		scene = new Scene(root);
		stage.setScene(scene);
		stage.show();

		
	}


	
	
	
	
}
