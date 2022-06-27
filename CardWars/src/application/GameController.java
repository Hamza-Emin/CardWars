package application;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Random;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.DialogPane;
import javafx.scene.control.Label;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonBar.ButtonData;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

public class GameController  {
	
	@FXML
	Label nameLabel, nameLabel2;
	
	
	@FXML
	ImageView card1View, drawedCard, card2View, card3View, card4View, card11View, card12View, card13View, card14View;

	@FXML
	ImageView board1View, board2View, board3View, board4View, board11View, board12View, board13View, board14View;
	
	@FXML
	ImageView hiddenView1, hiddenView2, hiddenView3, hiddenView4;
	
	
	
	
	
	
	Random random = new Random();
	Game gameCheck = new Game();
	Cards card = new Cards();
	//Cards cardCheck = new Cards();

	List<Cards> cards = new ArrayList<Cards>();
	
	
	@FXML
	Image card1, card2, card3, card4, card11, card12, card13, card14;
	@FXML
	Image hidden = new Image(getClass().getResourceAsStream("cardBack.jpg"));
	
	@FXML
	Image newCard;
	
	@FXML
	Label deckLabel;
	 
	Cards temp = new Cards();
	
	
	@FXML
	Label roundLabel;
	@FXML
	Label player2HealthLabel;
	@FXML
	Label player1HealthLabel;
	
	@FXML
	Button StartButton;
	
	
	int Player2Health;
	 int Player1Health;
	 Stage stage;
	 Parent root;
	
	int round = 1;
	int deckCount = 25;
	
	
	SceneController controller = new SceneController();
	
	int player1CardAction = 1;
	int player1AttackAction = 1;
	int player2CardAction = 1;
	int player2AttackAction = 1;
	
	
	
	
	public void displayPlayer1Name(String username1) {
		nameLabel.setText("Player1: " + username1);
		
		
	}
	
	public void displayPlayer2Name(String username2) {
		nameLabel2.setText("Player2: " + username2);
	}
	
	public void displayHealthPlayer2(int health) {
		this.Player2Health = health;
		player2HealthLabel.setText("Health: " + this.Player2Health);
		
	}
	public void displayHealthPlayer1(int health) {
		this.Player1Health = health;
		player1HealthLabel.setText("Health: " + this.Player1Health);
		
	}
	
	public void displayRound() {
		roundLabel.setText("Round: " + this.round);
		
	}
	public void displayDeck() {
		deckLabel.setText("Card Amount: " + deckCount);
	}
	
	
	
	
	public void startTheGame() throws IOException{
		Random random = new Random();
		Cards card = new Cards();
		
		
		
		hiddenView1.setImage(new Image(getClass().getResourceAsStream("cardBack.jpg")));
		hiddenView2.setImage(new Image(getClass().getResourceAsStream("cardBack.jpg")));
		hiddenView3.setImage(new Image(getClass().getResourceAsStream("cardBack.jpg")));
		hiddenView4.setImage(new Image(getClass().getResourceAsStream("cardBack.jpg")));
		
		hiddenView1.setLayoutX(card11View.getLayoutX());
		hiddenView2.setLayoutX(card12View.getLayoutX());
		hiddenView3.setLayoutX(card13View.getLayoutX());
		hiddenView4.setLayoutX(card14View.getLayoutX());
		
		hiddenView1.setLayoutY(card11View.getLayoutY());
		hiddenView2.setLayoutY(card12View.getLayoutY());
		hiddenView3.setLayoutY(card13View.getLayoutY());
		hiddenView4.setLayoutY(card14View.getLayoutY());
		
		
		
		
		
		
		ArrayList<String> cards = (ArrayList<String>)card.giveCard("Cards.txt").clone();
		
		
		
		ArrayList<ImageView> cardLoc = new ArrayList<ImageView>();
		
		ArrayList<ImageView> cardLoc2 = new ArrayList<ImageView>();
		
		
		
		String path, path2;
		
		path = cards.get(random.nextInt(cards.size()));
		path2 = cards.get(random.nextInt(cards.size()));
		
		cardLoc.add(card1View);
		cardLoc.add(card2View);
		cardLoc.add(card3View);
		cardLoc.add(card4View);
		
		cardLoc2.add(card11View);
		cardLoc2.add(card12View);
		cardLoc2.add(card13View);
		cardLoc2.add(card14View);
		
		
		for(int i = 0; i < cardLoc.size(); i++) {
			path = cards.get(random.nextInt(cards.size()));
			
			(cardLoc.get(i)).setImage(newCard = new Image(getClass().getResourceAsStream("Card DB/" + path)));
			
			//cardLoc.get(i).setOpacity(1);
			
			cards.remove(path);
		
		}
		
		
		for(int i = 0; i < cardLoc2.size();i++) {
			path2 = cards.get(random.nextInt(cards.size()));
			
			(cardLoc2.get(i)).setImage(newCard = new Image(getClass().getResourceAsStream("Card DB/" + path2)));
			
			//cardLoc.get(i).setOpacity(1);
			
			cards.remove(path);
		}
		
		
		
		
		StartButton.setOpacity(-1);
		StartButton.setDisable(true);
			
		}
		
		
		
		
	
	
	
	public void endTurn() throws IOException {
		round++;
		int roundCheck = round % 2;
		
		roundLabel.setText("Round: " + round);
		Cards card = new Cards();
		
		ArrayList<String> cardPath = (ArrayList<String>)card.giveCard("Cards.txt").clone();
		
		
		
		String path = cardPath.get(random.nextInt(cardPath.size()));
		 String path2 = cardPath.get(random.nextInt(cardPath.size()));
		ArrayList<ImageView> cardLoc = new ArrayList<ImageView>();
		
		cardLoc.add(card1View);
		cardLoc.add(card2View);
		cardLoc.add(card3View);
		cardLoc.add(card4View);
		
		ArrayList<ImageView> cardLoc2 = new ArrayList<ImageView>();
		cardLoc2.add(card11View);
		cardLoc2.add(card12View);
		cardLoc2.add(card13View);
		cardLoc2.add(card14View);
		
	
		
		
		if(round >= 2) {
			switch(roundCheck) {
			case 1:
				for(int i = 0; i < cardLoc.size();i++) {
					path = cardPath.get(random.nextInt(cardPath.size()));
					
					ImageView newView = cardLoc.get(i);
					if(card.isEmpty(newView)) {
						newView.setImage(new Image(getClass().getResourceAsStream("Card DB/" + path)));
						cardLoc.set(i, newView);
						
						
						
						break;
					}
			}
				hiddenView1.setLayoutX(card11View.getLayoutX());
				hiddenView2.setLayoutX(card12View.getLayoutX());
				hiddenView3.setLayoutX(card13View.getLayoutX());
				hiddenView4.setLayoutX(card14View.getLayoutX());
				
				hiddenView1.setLayoutY(card11View.getLayoutY());
				hiddenView2.setLayoutY(card12View.getLayoutY());
				hiddenView3.setLayoutY(card13View.getLayoutY());
				hiddenView4.setLayoutY(card14View.getLayoutY());
				break;
			case 0:
				for(int i = 0; i < cardLoc2.size(); i++) {
					path2 = cardPath.get(random.nextInt(cardPath.size()));
					
					ImageView newView = cardLoc2.get(i);
					
					if(card.isEmpty(newView)) {
						newView.setImage(new Image(getClass().getResourceAsStream("Card DB/" + path2)));
						cardLoc2.set(i, newView);
						
						break;
					}
				}
				hiddenView1.setLayoutX(card1View.getLayoutX());
				hiddenView2.setLayoutX(card2View.getLayoutX());
				hiddenView3.setLayoutX(card3View.getLayoutX());
				hiddenView4.setLayoutX(card4View.getLayoutX());
				
				hiddenView1.setLayoutY(card1View.getLayoutY());
				hiddenView2.setLayoutY(card2View.getLayoutY());
				hiddenView3.setLayoutY(card3View.getLayoutY());
				hiddenView4.setLayoutY(card4View.getLayoutY());
				break;
				
		
		}
			
		}
		player1CardAction= 1 ;
        player1AttackAction= 1;
        player2CardAction= 1;
        player2AttackAction = 1;
		

	}
	
	
	public void hiddenClick() {
		Alert errorAlert = new Alert(AlertType.ERROR);
		
		errorAlert.setHeaderText("NOT YOUR TURN!!!");
		
		errorAlert.showAndWait();
	}
	
	public void mouseClicked() throws IOException {
		if(gameCheck.actionValidator(player1CardAction)) {
            board1View.setImage(card1View.getImage());
            card1View.setImage(null);
            player1CardAction--;
        }else {
            Alert error = new Alert(AlertType.ERROR);
            error.setHeaderText("You can't play more than one card");
            error.showAndWait();}
		
	}
	public void mouseClicked2() {
		if(gameCheck.actionValidator(player1CardAction)) {
            board2View.setImage(card2View.getImage());
            card2View.setImage(null);
            player1CardAction--;
        }else {
            Alert error = new Alert(AlertType.ERROR);
            error.setHeaderText("You can't play more than one card");
            error.showAndWait();}
		
	}
	public void mouseClicked3() {
		if(gameCheck.actionValidator(player1CardAction)) {
            board3View.setImage(card3View.getImage());
            card3View.setImage(null);
            player1CardAction--;
        }else {
            Alert error = new Alert(AlertType.ERROR);
            error.setHeaderText("You can't play more than one card");
            error.showAndWait();}
	}
	public void mouseClicked4() {
		if(gameCheck.actionValidator(player1CardAction)) {
            board4View.setImage(card4View.getImage());
            card4View.setImage(null);
            player1CardAction--;
        }else {
            Alert error = new Alert(AlertType.ERROR);
            error.setHeaderText("You can't play more than one card");
            error.showAndWait();}
	}
	public void mouseClicked11() {
		if(gameCheck.actionValidator(player2CardAction)) {
            board11View.setImage(card11View.getImage());
            card11View.setImage(null);
            player2CardAction--;
        }else {
            Alert error = new Alert(AlertType.ERROR);
            error.setHeaderText("You can't play more than one card");
            error.showAndWait();}
	}
	
	public void mouseClicked12() {
		if(gameCheck.actionValidator(player2CardAction)) {
            board12View.setImage(card12View.getImage());
            card12View.setImage(null);
            player2CardAction--;
        }else {
            Alert error = new Alert(AlertType.ERROR);
            error.setHeaderText("You can't play more than one card");
            error.showAndWait();}
	}
	public void mouseClicked13() {
		if(gameCheck.actionValidator(player2CardAction)) {
            board13View.setImage(card13View.getImage());
            card13View.setImage(null);
            player2CardAction--;
        }else {
            Alert error = new Alert(AlertType.ERROR);
            error.setHeaderText("You can't play more than one card");
            error.showAndWait();}
	}
	public void mouseClicked14() {
		if(gameCheck.actionValidator(player2CardAction)) {
            board14View.setImage(card14View.getImage());
            card14View.setImage(null);
            player2CardAction--;
        }else {
            Alert error = new Alert(AlertType.ERROR);
            error.setHeaderText("You can't play more than one card");
            error.showAndWait();}
	}
	
	
	public void attackToPlayer2Board1() throws IOException {

		if(gameCheck.actionValidator(player1AttackAction)) {
			
			Alert alert = new Alert(AlertType.CONFIRMATION);
			
			alert.setHeaderText("Do you want to attack to a card?");
			alert.setContentText("If you want to attack to a hero click 'Cancel' ");
			
			SceneController controller = new SceneController();
			
			
			
			if(alert.showAndWait().get() == ButtonType.OK) {
				player1AttackAction--;
				int x1 = gameCheck.cardToCardAttack1(controller.determineCard(this.board1View), controller.determineCard(this.board11View));
				
				switch(x1) {
				case 1:
					board1View.setImage(null);
					board11View.setImage(null);
					break;
				case 2:
					board11View.setImage(null);
					break;
				case 3:
					board1View.setImage(null);
					break;
				}
				
				
				
			}
			
			else {
				
					if(card.isImageEqual(board1View.getImage(), new Image(getClass().getResourceAsStream(controller.ansatsu.path)))) {
						this.Player2Health -= controller.ansatsu.attackdamage;
						player2HealthLabel.setText("Health: " + this.Player2Health);
						
					}
						
					else if(card.isImageEqual(board1View.getImage(), new Image(getClass().getResourceAsStream(controller.ancientElf.path)))) {
						this.Player2Health -= controller.ancientElf.attackdamage;
						player2HealthLabel.setText("Health: " + this.Player2Health);
					}
					
					else if(card.isImageEqual(board1View.getImage(), new Image(getClass().getResourceAsStream(controller.battleOx.path)))) {
						this.Player2Health -= controller.battleOx.attackdamage;
						player2HealthLabel.setText("Health: " + this.Player2Health);
					}
					else if(card.isImageEqual(board1View.getImage(), new Image(getClass().getResourceAsStream(controller.beaver.path)))) {
						this.Player2Health -= controller.beaver.attackdamage;
						player2HealthLabel.setText("Health: " + this.Player2Health);
					}
					else if(card.isImageEqual(board1View.getImage(), new Image(getClass().getResourceAsStream(controller.blue.path)))) {
						this.Player2Health -= controller.blue.attackdamage;
						player2HealthLabel.setText("Health: " + this.Player2Health);
					}
					else if(card.isImageEqual(board1View.getImage(), new Image(getClass().getResourceAsStream(controller.celtic.path)))) {
						this.Player2Health -= controller.celtic.attackdamage;
						player2HealthLabel.setText("Health: " + this.Player2Health);
					}
					else if(card.isImageEqual(board1View.getImage(), new Image(getClass().getResourceAsStream(controller.claw.path)))) {
						this.Player2Health -= controller.claw.attackdamage;
						player2HealthLabel.setText("Health: " + this.Player2Health);
					}
					else if(card.isImageEqual(board1View.getImage(), new Image(getClass().getResourceAsStream(controller.curse.path)))) {
						this.Player2Health -= controller.curse.attackdamage;
						player2HealthLabel.setText("Health: " + this.Player2Health);
					}
					else if(card.isImageEqual(board1View.getImage(), new Image(getClass().getResourceAsStream(controller.dhuman.path)))) {
						this.Player2Health -= controller.dhuman.attackdamage;
						player2HealthLabel.setText("Health: " + this.Player2Health);
					}
					else if(card.isImageEqual(board1View.getImage(), new Image(getClass().getResourceAsStream(controller.darkAs.path)))) {
						this.Player2Health -= controller.darkAs.attackdamage;
						player2HealthLabel.setText("Health: " + this.Player2Health);
					}
					else if(card.isImageEqual(board1View.getImage(), new Image(getClass().getResourceAsStream(controller.darkMag.path)))) {
						this.Player2Health -= controller.darkMag.attackdamage;
						player2HealthLabel.setText("Health: " + this.Player2Health);
					}
					else if(card.isImageEqual(board1View.getImage(), new Image(getClass().getResourceAsStream(controller.darkTitan.path)))) {
						this.Player2Health -= controller.darkTitan.attackdamage;
						player2HealthLabel.setText("Health: " + this.Player2Health);
					}
					else if(card.isImageEqual(board1View.getImage(), new Image(getClass().getResourceAsStream(controller.destroyer.path)))) {
						this.Player2Health -= controller.destroyer.attackdamage;
						player2HealthLabel.setText("Health: " + this.Player2Health);
					}
					else if(card.isImageEqual(board1View.getImage(), new Image(getClass().getResourceAsStream(controller.doma.path)))) {
						this.Player2Health -= controller.doma.attackdamage;
						player2HealthLabel.setText("Health: " + this.Player2Health);
					}
					else if(card.isImageEqual(board1View.getImage(), new Image(getClass().getResourceAsStream(controller.dragonzom.path)))) {
						this.Player2Health -= controller.dragonzom.attackdamage;
						player2HealthLabel.setText("Health: " + this.Player2Health);
					}
					else if(card.isImageEqual(board1View.getImage(), new Image(getClass().getResourceAsStream(controller.feral.path)))) {
						this.Player2Health -= controller.feral.attackdamage;
						player2HealthLabel.setText("Health: " + this.Player2Health);
					}
					else if(card.isImageEqual(board1View.getImage(), new Image(getClass().getResourceAsStream(controller.gaia.path)))) {
						this.Player2Health -= controller.gaia.attackdamage;
						player2HealthLabel.setText("Health: " + this.Player2Health);
					}
					else if(card.isImageEqual(board1View.getImage(), new Image(getClass().getResourceAsStream(controller.giant.path)))) {
						this.Player2Health -= controller.giant.attackdamage;
						player2HealthLabel.setText("Health: " + this.Player2Health);
					}
					else if(card.isImageEqual(board1View.getImage(), new Image(getClass().getResourceAsStream(controller.great.path)))) {
						this.Player2Health -= controller.great.attackdamage;
						player2HealthLabel.setText("Health: " + this.Player2Health);
					}
					else if(card.isImageEqual(board1View.getImage(), new Image(getClass().getResourceAsStream(controller.gyakutenno.path)))) {
						this.Player2Health -= controller.gyakutenno.attackdamage;
						player2HealthLabel.setText("Health: " + this.Player2Health);
					}
					else if(card.isImageEqual(board1View.getImage(), new Image(getClass().getResourceAsStream(controller.hitotsu.path)))) {
						this.Player2Health -= controller.hitotsu.attackdamage;
						player2HealthLabel.setText("Health: " + this.Player2Health);
					}
					else if(card.isImageEqual(board1View.getImage(), new Image(getClass().getResourceAsStream(controller.judge.path)))) {
						this.Player2Health -= controller.judge.attackdamage;
						player2HealthLabel.setText("Health: " + this.Player2Health);
					}
					else if(card.isImageEqual(board1View.getImage(), new Image(getClass().getResourceAsStream(controller.kojikocy.path)))) {
						this.Player2Health -= controller.kojikocy.attackdamage;
						player2HealthLabel.setText("Health: " + this.Player2Health);
					}
					else if(card.isImageEqual(board1View.getImage(), new Image(getClass().getResourceAsStream(controller.koumori.path)))) {
						this.Player2Health -= controller.koumori.attackdamage;
						player2HealthLabel.setText("Health: " + this.Player2Health);
					}
					else if(card.isImageEqual(board1View.getImage(), new Image(getClass().getResourceAsStream(controller.lajinn.path)))) {
						this.Player2Health -= controller.lajinn.attackdamage;
						player2HealthLabel.setText("Health: " + this.Player2Health);
					}
				
					player2HealthLabel.setText("Health: " + this.Player2Health);
					
				player1AttackAction--;
				
				
				}
		}else {
			Alert error = new Alert(AlertType.ERROR);
			error.setHeaderText("You can olny attack only once");
			error.showAndWait();
		}
		
		
		
		
			player2HealthLabel.setText("Health: " + this.Player2Health);
			
			  if(Player2Health <=0) { 
				  Alert alert2 = new Alert(AlertType.CONFIRMATION);
			  
			  alert2.setHeaderText("Player1 won!");
			  
			  if(alert2.showAndWait().get() == ButtonType.OK) {
			  
			  System.exit(0);
			  
			  }
			  
			  }
		}
	public void attackToPlayer2Board2() throws IOException {
		if(gameCheck.actionValidator(player1AttackAction)) {
		Alert alert = new Alert(AlertType.CONFIRMATION);
		
		alert.setHeaderText("Do you want to attack to a card?");
		alert.setContentText("If you want to attack to a hero click 'Cancel' ");
		Button button = new Button();
		
	
		
		
		
		if(alert.showAndWait().get() == ButtonType.OK) {
			int x1 = gameCheck.cardToCardAttack1(controller.determineCard(this.board2View), controller.determineCard(this.board12View));
			
			switch(x1) {
			case 1:
				board2View.setImage(null);
				board12View.setImage(null);
				break;
			case 2:
				board12View.setImage(null);
				break;
			case 3:
				board2View.setImage(null);
				break;
			}
			
		}else {
			
			if(card.isImageEqual(board2View.getImage(), new Image(getClass().getResourceAsStream(controller.ansatsu.path)))) {
				this.Player2Health -= controller.ansatsu.attackdamage;
				player2HealthLabel.setText("Health: " + this.Player2Health);
				
			}
				
			else if(card.isImageEqual(board2View.getImage(), new Image(getClass().getResourceAsStream(controller.ancientElf.path)))) {
				this.Player2Health -= controller.ancientElf.attackdamage;
				player2HealthLabel.setText("Health: " + this.Player2Health);
			}
			
			else if(card.isImageEqual(board2View.getImage(), new Image(getClass().getResourceAsStream(controller.battleOx.path)))) {
				this.Player2Health -= controller.battleOx.attackdamage;
				player2HealthLabel.setText("Health: " + this.Player2Health);
			}
			else if(card.isImageEqual(board2View.getImage(), new Image(getClass().getResourceAsStream(controller.beaver.path)))) {
				this.Player2Health -= controller.beaver.attackdamage;
				player2HealthLabel.setText("Health: " + this.Player2Health);
			}
			else if(card.isImageEqual(board2View.getImage(), new Image(getClass().getResourceAsStream(controller.blue.path)))) {
				this.Player2Health -= controller.blue.attackdamage;
				player2HealthLabel.setText("Health: " + this.Player2Health);
			}
			else if(card.isImageEqual(board2View.getImage(), new Image(getClass().getResourceAsStream(controller.celtic.path)))) {
				this.Player2Health -= controller.celtic.attackdamage;
				player2HealthLabel.setText("Health: " + this.Player2Health);
			}
			else if(card.isImageEqual(board2View.getImage(), new Image(getClass().getResourceAsStream(controller.claw.path)))) {
				this.Player2Health -= controller.claw.attackdamage;
				player2HealthLabel.setText("Health: " + this.Player2Health);
			}
			else if(card.isImageEqual(board2View.getImage(), new Image(getClass().getResourceAsStream(controller.curse.path)))) {
				this.Player2Health -= controller.curse.attackdamage;
				player2HealthLabel.setText("Health: " + this.Player2Health);
			}
			else if(card.isImageEqual(board2View.getImage(), new Image(getClass().getResourceAsStream(controller.dhuman.path)))) {
				this.Player2Health -= controller.dhuman.attackdamage;
				player2HealthLabel.setText("Health: " + this.Player2Health);
			}
			else if(card.isImageEqual(board2View.getImage(), new Image(getClass().getResourceAsStream(controller.darkAs.path)))) {
				this.Player2Health -= controller.darkAs.attackdamage;
				player2HealthLabel.setText("Health: " + this.Player2Health);
			}
			else if(card.isImageEqual(board2View.getImage(), new Image(getClass().getResourceAsStream(controller.darkMag.path)))) {
				this.Player2Health -= controller.darkMag.attackdamage;
				player2HealthLabel.setText("Health: " + this.Player2Health);
			}
			else if(card.isImageEqual(board2View.getImage(), new Image(getClass().getResourceAsStream(controller.darkTitan.path)))) {
				this.Player2Health -= controller.darkTitan.attackdamage;
				player2HealthLabel.setText("Health: " + this.Player2Health);
			}
			else if(card.isImageEqual(board2View.getImage(), new Image(getClass().getResourceAsStream(controller.destroyer.path)))) {
				this.Player2Health -= controller.destroyer.attackdamage;
				player2HealthLabel.setText("Health: " + this.Player2Health);
			}
			else if(card.isImageEqual(board2View.getImage(), new Image(getClass().getResourceAsStream(controller.doma.path)))) {
				this.Player2Health -= controller.doma.attackdamage;
				player2HealthLabel.setText("Health: " + this.Player2Health);
			}
			else if(card.isImageEqual(board2View.getImage(), new Image(getClass().getResourceAsStream(controller.dragonzom.path)))) {
				this.Player2Health -= controller.dragonzom.attackdamage;
				player2HealthLabel.setText("Health: " + this.Player2Health);
			}
			else if(card.isImageEqual(board2View.getImage(), new Image(getClass().getResourceAsStream(controller.feral.path)))) {
				this.Player2Health -= controller.feral.attackdamage;
				player2HealthLabel.setText("Health: " + this.Player2Health);
			}
			else if(card.isImageEqual(board2View.getImage(), new Image(getClass().getResourceAsStream(controller.gaia.path)))) {
				this.Player2Health -= controller.gaia.attackdamage;
				player2HealthLabel.setText("Health: " + this.Player2Health);
			}
			else if(card.isImageEqual(board2View.getImage(), new Image(getClass().getResourceAsStream(controller.giant.path)))) {
				this.Player2Health -= controller.giant.attackdamage;
				player2HealthLabel.setText("Health: " + this.Player2Health);
			}
			else if(card.isImageEqual(board2View.getImage(), new Image(getClass().getResourceAsStream(controller.great.path)))) {
				this.Player2Health -= controller.great.attackdamage;
				player2HealthLabel.setText("Health: " + this.Player2Health);
			}
			else if(card.isImageEqual(board2View.getImage(), new Image(getClass().getResourceAsStream(controller.gyakutenno.path)))) {
				this.Player2Health -= controller.gyakutenno.attackdamage;
				player2HealthLabel.setText("Health: " + this.Player2Health);
			}
			else if(card.isImageEqual(board2View.getImage(), new Image(getClass().getResourceAsStream(controller.hitotsu.path)))) {
				this.Player2Health -= controller.hitotsu.attackdamage;
				player2HealthLabel.setText("Health: " + this.Player2Health);
			}
			else if(card.isImageEqual(board2View.getImage(), new Image(getClass().getResourceAsStream(controller.judge.path)))) {
				this.Player2Health -= controller.judge.attackdamage;
				player2HealthLabel.setText("Health: " + this.Player2Health);
			}
			else if(card.isImageEqual(board2View.getImage(), new Image(getClass().getResourceAsStream(controller.kojikocy.path)))) {
				this.Player2Health -= controller.kojikocy.attackdamage;
				player2HealthLabel.setText("Health: " + this.Player2Health);
			}
			else if(card.isImageEqual(board2View.getImage(), new Image(getClass().getResourceAsStream(controller.koumori.path)))) {
				this.Player2Health -= controller.koumori.attackdamage;
				player2HealthLabel.setText("Health: " + this.Player2Health);
			}
			else if(card.isImageEqual(board2View.getImage(), new Image(getClass().getResourceAsStream(controller.lajinn.path)))) {
				this.Player2Health -= controller.lajinn.attackdamage;
				player2HealthLabel.setText("Health: " + this.Player2Health);
			}
			player2HealthLabel.setText("Health: " + this.Player2Health);
			player1AttackAction--;
			
			}
		}else {
			Alert error = new Alert(AlertType.ERROR);
            error.setHeaderText("You can attack only once");
            error.showAndWait();
		}
			player2HealthLabel.setText("Health: " + this.Player2Health);
			
			  if(Player2Health <=0) { 
				  Alert alert2 = new Alert(AlertType.CONFIRMATION);
			  
			  alert2.setHeaderText("Player1 won!");
			  
			  if(alert2.showAndWait().get() == ButtonType.OK) {
			  
			  System.exit(0);
			  
			  }
			  
			  }
		}
	public void attackToPlayer2Board3() throws IOException {
		if(gameCheck.actionValidator(player1AttackAction)) {
	Alert alert = new Alert(AlertType.CONFIRMATION);
	
	alert.setHeaderText("Do you want to attack to a card?");
	alert.setContentText("If you want to attack to a hero click 'Cancel' ");
	Button button = new Button();
	

	
	
	
	if(alert.showAndWait().get() == ButtonType.OK) {
		int x1 = gameCheck.cardToCardAttack1(controller.determineCard(this.board3View), controller.determineCard(this.board13View));
		
		switch(x1) {
		case 1:
			board3View.setImage(null);
			board13View.setImage(null);
			break;
		case 2:
			board13View.setImage(null);
			break;
		case 3:
			board3View.setImage(null);
			break;
		}
		
	}else{
		
		if(card.isImageEqual(board3View.getImage(), new Image(getClass().getResourceAsStream(controller.ansatsu.path)))) {
			this.Player2Health -= controller.ansatsu.attackdamage;
			player2HealthLabel.setText("Health: " + this.Player2Health);
			
		}
			
		else if(card.isImageEqual(board3View.getImage(), new Image(getClass().getResourceAsStream(controller.ancientElf.path)))) {
			this.Player2Health -= controller.ancientElf.attackdamage;
			player2HealthLabel.setText("Health: " + this.Player2Health);
		}
		
		else if(card.isImageEqual(board3View.getImage(), new Image(getClass().getResourceAsStream(controller.battleOx.path)))) {
			this.Player2Health -= controller.battleOx.attackdamage;
			player2HealthLabel.setText("Health: " + this.Player2Health);
		}
		else if(card.isImageEqual(board3View.getImage(), new Image(getClass().getResourceAsStream(controller.beaver.path)))) {
			this.Player2Health -= controller.beaver.attackdamage;
			player2HealthLabel.setText("Health: " + this.Player2Health);
		}
		else if(card.isImageEqual(board3View.getImage(), new Image(getClass().getResourceAsStream(controller.blue.path)))) {
			this.Player2Health -= controller.blue.attackdamage;
			player2HealthLabel.setText("Health: " + this.Player2Health);
		}
		else if(card.isImageEqual(board3View.getImage(), new Image(getClass().getResourceAsStream(controller.celtic.path)))) {
			this.Player2Health -= controller.celtic.attackdamage;
			player2HealthLabel.setText("Health: " + this.Player2Health);
		}
		else if(card.isImageEqual(board3View.getImage(), new Image(getClass().getResourceAsStream(controller.claw.path)))) {
			this.Player2Health -= controller.claw.attackdamage;
			player2HealthLabel.setText("Health: " + this.Player2Health);
		}
		else if(card.isImageEqual(board3View.getImage(), new Image(getClass().getResourceAsStream(controller.curse.path)))) {
			this.Player2Health -= controller.curse.attackdamage;
			player2HealthLabel.setText("Health: " + this.Player2Health);
		}
		else if(card.isImageEqual(board3View.getImage(), new Image(getClass().getResourceAsStream(controller.dhuman.path)))) {
			this.Player2Health -= controller.dhuman.attackdamage;
			player2HealthLabel.setText("Health: " + this.Player2Health);
		}
		else if(card.isImageEqual(board3View.getImage(), new Image(getClass().getResourceAsStream(controller.darkAs.path)))) {
			this.Player2Health -= controller.darkAs.attackdamage;
			player2HealthLabel.setText("Health: " + this.Player2Health);
		}
		else if(card.isImageEqual(board3View.getImage(), new Image(getClass().getResourceAsStream(controller.darkMag.path)))) {
			this.Player2Health -= controller.darkMag.attackdamage;
			player2HealthLabel.setText("Health: " + this.Player2Health);
		}
		else if(card.isImageEqual(board3View.getImage(), new Image(getClass().getResourceAsStream(controller.darkTitan.path)))) {
			this.Player2Health -= controller.darkTitan.attackdamage;
			player2HealthLabel.setText("Health: " + this.Player2Health);
		}
		else if(card.isImageEqual(board3View.getImage(), new Image(getClass().getResourceAsStream(controller.destroyer.path)))) {
			this.Player2Health -= controller.destroyer.attackdamage;
			player2HealthLabel.setText("Health: " + this.Player2Health);
		}
		else if(card.isImageEqual(board3View.getImage(), new Image(getClass().getResourceAsStream(controller.doma.path)))) {
			this.Player2Health -= controller.doma.attackdamage;
			player2HealthLabel.setText("Health: " + this.Player2Health);
		}
		else if(card.isImageEqual(board3View.getImage(), new Image(getClass().getResourceAsStream(controller.dragonzom.path)))) {
			this.Player2Health -= controller.dragonzom.attackdamage;
			player2HealthLabel.setText("Health: " + this.Player2Health);
		}
		else if(card.isImageEqual(board3View.getImage(), new Image(getClass().getResourceAsStream(controller.feral.path)))) {
			this.Player2Health -= controller.feral.attackdamage;
			player2HealthLabel.setText("Health: " + this.Player2Health);
		}
		else if(card.isImageEqual(board3View.getImage(), new Image(getClass().getResourceAsStream(controller.gaia.path)))) {
			this.Player2Health -= controller.gaia.attackdamage;
			player2HealthLabel.setText("Health: " + this.Player2Health);
		}
		else if(card.isImageEqual(board3View.getImage(), new Image(getClass().getResourceAsStream(controller.giant.path)))) {
			this.Player2Health -= controller.giant.attackdamage;
			player2HealthLabel.setText("Health: " + this.Player2Health);
		}
		else if(card.isImageEqual(board3View.getImage(), new Image(getClass().getResourceAsStream(controller.great.path)))) {
			this.Player2Health -= controller.great.attackdamage;
			player2HealthLabel.setText("Health: " + this.Player2Health);
		}
		else if(card.isImageEqual(board3View.getImage(), new Image(getClass().getResourceAsStream(controller.gyakutenno.path)))) {
			this.Player2Health -= controller.gyakutenno.attackdamage;
			player2HealthLabel.setText("Health: " + this.Player2Health);
		}
		else if(card.isImageEqual(board3View.getImage(), new Image(getClass().getResourceAsStream(controller.hitotsu.path)))) {
			this.Player2Health -= controller.hitotsu.attackdamage;
			player2HealthLabel.setText("Health: " + this.Player2Health);
		}
		else if(card.isImageEqual(board3View.getImage(), new Image(getClass().getResourceAsStream(controller.judge.path)))) {
			this.Player2Health -= controller.judge.attackdamage;
			player2HealthLabel.setText("Health: " + this.Player2Health);
		}
		else if(card.isImageEqual(board3View.getImage(), new Image(getClass().getResourceAsStream(controller.kojikocy.path)))) {
			this.Player2Health -= controller.kojikocy.attackdamage;
			player2HealthLabel.setText("Health: " + this.Player2Health);
		}
		else if(card.isImageEqual(board3View.getImage(), new Image(getClass().getResourceAsStream(controller.koumori.path)))) {
			this.Player2Health -= controller.koumori.attackdamage;
			player2HealthLabel.setText("Health: " + this.Player2Health);
		}
		else if(card.isImageEqual(board3View.getImage(), new Image(getClass().getResourceAsStream(controller.lajinn.path)))) {
			this.Player2Health -= controller.lajinn.attackdamage;
			player2HealthLabel.setText("Health: " + this.Player2Health);
		}
	
		player2HealthLabel.setText("Health: " + this.Player2Health);
		player1AttackAction--;
		}
		}else {
			Alert error = new Alert(AlertType.ERROR);
            error.setHeaderText("You can attack only once");
            error.showAndWait();
		}
		player2HealthLabel.setText("Health: " + this.Player2Health);
		
		  if(Player2Health <=0) { 
			  Alert alert2 = new Alert(AlertType.CONFIRMATION);
		  
		  alert2.setHeaderText("Player1 won!");
		  
		  if(alert2.showAndWait().get() == ButtonType.OK) {
		  
		  System.exit(0);
		  
		  }
		  
		  }
	}
	public void attackToPlayer2Board4() throws IOException {
		if(gameCheck.actionValidator(player1AttackAction)) {
	Alert alert = new Alert(AlertType.CONFIRMATION);
	
	alert.setHeaderText("Do you want to attack to a card?");
	alert.setContentText("If you want to attack to a hero click 'Cancel' ");
	Button button = new Button();
	
	
	
	
	
	if(alert.showAndWait().get() == ButtonType.OK) {
		int x1 = gameCheck.cardToCardAttack1(controller.determineCard(this.board4View), controller.determineCard(this.board14View));
		
		switch(x1) {
		case 1:
			board4View.setImage(null);
			board14View.setImage(null);
			break;
		case 2:
			board14View.setImage(null);
			break;
		case 3:
			board4View.setImage(null);
			break;
		}
		
	}else{
		
		if(card.isImageEqual(board4View.getImage(), new Image(getClass().getResourceAsStream(controller.ansatsu.path)))) {
			this.Player2Health -= controller.ansatsu.attackdamage;
			player2HealthLabel.setText("Health: " + this.Player2Health);
			
		}
			
		else if(card.isImageEqual(board4View.getImage(), new Image(getClass().getResourceAsStream(controller.ancientElf.path)))) {
			this.Player2Health -= controller.ancientElf.attackdamage;
			player2HealthLabel.setText("Health: " + this.Player2Health);
		}
		
		else if(card.isImageEqual(board4View.getImage(), new Image(getClass().getResourceAsStream(controller.battleOx.path)))) {
			this.Player2Health -= controller.battleOx.attackdamage;
			player2HealthLabel.setText("Health: " + this.Player2Health);
		}
		else if(card.isImageEqual(board4View.getImage(), new Image(getClass().getResourceAsStream(controller.beaver.path)))) {
			this.Player2Health -= controller.beaver.attackdamage;
			player2HealthLabel.setText("Health: " + this.Player2Health);
		}
		else if(card.isImageEqual(board4View.getImage(), new Image(getClass().getResourceAsStream(controller.blue.path)))) {
			this.Player2Health -= controller.blue.attackdamage;
			player2HealthLabel.setText("Health: " + this.Player2Health);
		}
		else if(card.isImageEqual(board4View.getImage(), new Image(getClass().getResourceAsStream(controller.celtic.path)))) {
			this.Player2Health -= controller.celtic.attackdamage;
			player2HealthLabel.setText("Health: " + this.Player2Health);
		}
		else if(card.isImageEqual(board4View.getImage(), new Image(getClass().getResourceAsStream(controller.claw.path)))) {
			this.Player2Health -= controller.claw.attackdamage;
			player2HealthLabel.setText("Health: " + this.Player2Health);
		}
		else if(card.isImageEqual(board4View.getImage(), new Image(getClass().getResourceAsStream(controller.curse.path)))) {
			this.Player2Health -= controller.curse.attackdamage;
			player2HealthLabel.setText("Health: " + this.Player2Health);
		}
		else if(card.isImageEqual(board4View.getImage(), new Image(getClass().getResourceAsStream(controller.dhuman.path)))) {
			this.Player2Health -= controller.dhuman.attackdamage;
			player2HealthLabel.setText("Health: " + this.Player2Health);
		}
		else if(card.isImageEqual(board4View.getImage(), new Image(getClass().getResourceAsStream(controller.darkAs.path)))) {
			this.Player2Health -= controller.darkAs.attackdamage;
			player2HealthLabel.setText("Health: " + this.Player2Health);
		}
		else if(card.isImageEqual(board4View.getImage(), new Image(getClass().getResourceAsStream(controller.darkMag.path)))) {
			this.Player2Health -= controller.darkMag.attackdamage;
			player2HealthLabel.setText("Health: " + this.Player2Health);
		}
		else if(card.isImageEqual(board4View.getImage(), new Image(getClass().getResourceAsStream(controller.darkTitan.path)))) {
			this.Player2Health -= controller.darkTitan.attackdamage;
			player2HealthLabel.setText("Health: " + this.Player2Health);
		}
		else if(card.isImageEqual(board4View.getImage(), new Image(getClass().getResourceAsStream(controller.destroyer.path)))) {
			this.Player2Health -= controller.destroyer.attackdamage;
			player2HealthLabel.setText("Health: " + this.Player2Health);
		}
		else if(card.isImageEqual(board4View.getImage(), new Image(getClass().getResourceAsStream(controller.doma.path)))) {
			this.Player2Health -= controller.doma.attackdamage;
			player2HealthLabel.setText("Health: " + this.Player2Health);
		}
		else if(card.isImageEqual(board4View.getImage(), new Image(getClass().getResourceAsStream(controller.dragonzom.path)))) {
			this.Player2Health -= controller.dragonzom.attackdamage;
			player2HealthLabel.setText("Health: " + this.Player2Health);
		}
		else if(card.isImageEqual(board4View.getImage(), new Image(getClass().getResourceAsStream(controller.feral.path)))) {
			this.Player2Health -= controller.feral.attackdamage;
			player2HealthLabel.setText("Health: " + this.Player2Health);
		}
		else if(card.isImageEqual(board4View.getImage(), new Image(getClass().getResourceAsStream(controller.gaia.path)))) {
			this.Player2Health -= controller.gaia.attackdamage;
			player2HealthLabel.setText("Health: " + this.Player2Health);
		}
		else if(card.isImageEqual(board4View.getImage(), new Image(getClass().getResourceAsStream(controller.giant.path)))) {
			this.Player2Health -= controller.giant.attackdamage;
			player2HealthLabel.setText("Health: " + this.Player2Health);
		}
		else if(card.isImageEqual(board4View.getImage(), new Image(getClass().getResourceAsStream(controller.great.path)))) {
			this.Player2Health -= controller.great.attackdamage;
			player2HealthLabel.setText("Health: " + this.Player2Health);
		}
		else if(card.isImageEqual(board4View.getImage(), new Image(getClass().getResourceAsStream(controller.gyakutenno.path)))) {
			this.Player2Health -= controller.gyakutenno.attackdamage;
			player2HealthLabel.setText("Health: " + this.Player2Health);
		}
		else if(card.isImageEqual(board4View.getImage(), new Image(getClass().getResourceAsStream(controller.hitotsu.path)))) {
			this.Player2Health -= controller.hitotsu.attackdamage;
			player2HealthLabel.setText("Health: " + this.Player2Health);
		}
		else if(card.isImageEqual(board4View.getImage(), new Image(getClass().getResourceAsStream(controller.judge.path)))) {
			this.Player2Health -= controller.judge.attackdamage;
			player2HealthLabel.setText("Health: " + this.Player2Health);
		}
		else if(card.isImageEqual(board4View.getImage(), new Image(getClass().getResourceAsStream(controller.kojikocy.path)))) {
			this.Player2Health -= controller.kojikocy.attackdamage;
			player2HealthLabel.setText("Health: " + this.Player2Health);
		}
		else if(card.isImageEqual(board4View.getImage(), new Image(getClass().getResourceAsStream(controller.koumori.path)))) {
			this.Player2Health -= controller.koumori.attackdamage;
			player2HealthLabel.setText("Health: " + this.Player2Health);
		}
		else if(card.isImageEqual(board4View.getImage(), new Image(getClass().getResourceAsStream(controller.lajinn.path)))) {
			this.Player2Health -= controller.lajinn.attackdamage;
			player2HealthLabel.setText("Health: " + this.Player2Health);
		}
	
		player2HealthLabel.setText("Health: " + this.Player2Health);
		player1AttackAction--;
		}
		}else {
			Alert error = new Alert(AlertType.ERROR);
            error.setHeaderText("You can attack only once");
            error.showAndWait();
		}
		player2HealthLabel.setText("Health: " + this.Player2Health);
		
		  if(Player2Health <=0) { 
			  Alert alert2 = new Alert(AlertType.CONFIRMATION);
		  
		  alert2.setHeaderText("Player1 won!");
		  
		  if(alert2.showAndWait().get() == ButtonType.OK) {
		  
		  System.exit(0);
		  
		  }
		  
		  }
	}
public void attackToPlayer1Board11() throws IOException {
	if(gameCheck.actionValidator(player2AttackAction)) {
		Alert alert = new Alert(AlertType.CONFIRMATION);
		
		alert.setHeaderText("Do you want to attack to a card?");
		alert.setContentText("If you want to attack to a hero click 'Cancel' ");
		Button button = new Button();
		SceneController controller = new SceneController();
	
		
		
		if(alert.showAndWait().get() == ButtonType.OK) {
			int x1 = gameCheck.cardToCardAttack1(controller.determineCard(this.board11View), controller.determineCard(this.board1View));
			
			switch(x1) {
			case 1:
				board11View.setImage(null);
				board1View.setImage(null);
				break;
			case 2:
				board1View.setImage(null);
				break;
			case 3:
				board11View.setImage(null);
				break;
			}
			
		}else{
			
				if(card.isImageEqual(board11View.getImage(), new Image(getClass().getResourceAsStream(controller.ansatsu.path)))) {
					this.Player1Health -= controller.ansatsu.attackdamage;
					player1HealthLabel.setText("Health: " + this.Player1Health);
					
				}
					
				else if(card.isImageEqual(board11View.getImage(), new Image(getClass().getResourceAsStream(controller.ancientElf.path)))) {
					this.Player1Health -= controller.ancientElf.attackdamage;
					player1HealthLabel.setText("Health: " + this.Player1Health);
				}
				
				else if(card.isImageEqual(board11View.getImage(), new Image(getClass().getResourceAsStream(controller.battleOx.path)))) {
					this.Player1Health -= controller.battleOx.attackdamage;
					player1HealthLabel.setText("Health: " + this.Player1Health);
				}
				else if(card.isImageEqual(board11View.getImage(), new Image(getClass().getResourceAsStream(controller.beaver.path)))) {
					this.Player1Health -= controller.beaver.attackdamage;
					player1HealthLabel.setText("Health: " + this.Player1Health);
				}
				else if(card.isImageEqual(board11View.getImage(), new Image(getClass().getResourceAsStream(controller.blue.path)))) {
					this.Player1Health -= controller.blue.attackdamage;
					player1HealthLabel.setText("Health: " + this.Player1Health);
				}
				else if(card.isImageEqual(board11View.getImage(), new Image(getClass().getResourceAsStream(controller.celtic.path)))) {
					this.Player1Health -= controller.celtic.attackdamage;
					player1HealthLabel.setText("Health: " + this.Player1Health);
				}
				else if(card.isImageEqual(board11View.getImage(), new Image(getClass().getResourceAsStream(controller.claw.path)))) {
					this.Player1Health -= controller.claw.attackdamage;
					player1HealthLabel.setText("Health: " + this.Player1Health);
				}
				else if(card.isImageEqual(board11View.getImage(), new Image(getClass().getResourceAsStream(controller.curse.path)))) {
					this.Player1Health -= controller.curse.attackdamage;
					player1HealthLabel.setText("Health: " + this.Player1Health);
				}
				else if(card.isImageEqual(board11View.getImage(), new Image(getClass().getResourceAsStream(controller.dhuman.path)))) {
					this.Player1Health -= controller.dhuman.attackdamage;
					player1HealthLabel.setText("Health: " + this.Player1Health);
				}
				else if(card.isImageEqual(board11View.getImage(), new Image(getClass().getResourceAsStream(controller.darkAs.path)))) {
					this.Player1Health -= controller.darkAs.attackdamage;
					player1HealthLabel.setText("Health: " + this.Player1Health);
				}
				else if(card.isImageEqual(board11View.getImage(), new Image(getClass().getResourceAsStream(controller.darkMag.path)))) {
					this.Player1Health -= controller.darkMag.attackdamage;
					player1HealthLabel.setText("Health: " + this.Player1Health);
				}
				else if(card.isImageEqual(board11View.getImage(), new Image(getClass().getResourceAsStream(controller.darkTitan.path)))) {
					this.Player1Health -= controller.darkTitan.attackdamage;
					player1HealthLabel.setText("Health: " + this.Player1Health);
				}
				else if(card.isImageEqual(board11View.getImage(), new Image(getClass().getResourceAsStream(controller.destroyer.path)))) {
					this.Player1Health -= controller.destroyer.attackdamage;
					player1HealthLabel.setText("Health: " + this.Player1Health);
				}
				else if(card.isImageEqual(board11View.getImage(), new Image(getClass().getResourceAsStream(controller.doma.path)))) {
					this.Player1Health -= controller.doma.attackdamage;
					player1HealthLabel.setText("Health: " + this.Player1Health);
				}
				else if(card.isImageEqual(board11View.getImage(), new Image(getClass().getResourceAsStream(controller.dragonzom.path)))) {
					this.Player1Health -= controller.dragonzom.attackdamage;
					player1HealthLabel.setText("Health: " + this.Player1Health);
				}
				else if(card.isImageEqual(board11View.getImage(), new Image(getClass().getResourceAsStream(controller.feral.path)))) {
					this.Player1Health -= controller.feral.attackdamage;
					player1HealthLabel.setText("Health: " + this.Player1Health);
				}
				else if(card.isImageEqual(board11View.getImage(), new Image(getClass().getResourceAsStream(controller.gaia.path)))) {
					this.Player1Health -= controller.gaia.attackdamage;
					player1HealthLabel.setText("Health: " + this.Player1Health);
				}
				else if(card.isImageEqual(board11View.getImage(), new Image(getClass().getResourceAsStream(controller.giant.path)))) {
					this.Player1Health -= controller.giant.attackdamage;
					player1HealthLabel.setText("Health: " + this.Player1Health);
				}
				else if(card.isImageEqual(board11View.getImage(), new Image(getClass().getResourceAsStream(controller.great.path)))) {
					this.Player1Health -= controller.great.attackdamage;
					player1HealthLabel.setText("Health: " + this.Player1Health);
				}
				else if(card.isImageEqual(board11View.getImage(), new Image(getClass().getResourceAsStream(controller.gyakutenno.path)))) {
					this.Player1Health -= controller.gyakutenno.attackdamage;
					player1HealthLabel.setText("Health: " + this.Player1Health);
				}
				else if(card.isImageEqual(board11View.getImage(), new Image(getClass().getResourceAsStream(controller.hitotsu.path)))) {
					this.Player1Health -= controller.hitotsu.attackdamage;
					player1HealthLabel.setText("Health: " + this.Player1Health);
				}
				else if(card.isImageEqual(board11View.getImage(), new Image(getClass().getResourceAsStream(controller.judge.path)))) {
					this.Player1Health -= controller.judge.attackdamage;
					player1HealthLabel.setText("Health: " + this.Player1Health);
				}
				else if(card.isImageEqual(board11View.getImage(), new Image(getClass().getResourceAsStream(controller.kojikocy.path)))) {
					this.Player1Health -= controller.kojikocy.attackdamage;
					player1HealthLabel.setText("Health: " + this.Player1Health);
				}
				else if(card.isImageEqual(board11View.getImage(), new Image(getClass().getResourceAsStream(controller.koumori.path)))) {
					this.Player1Health -= controller.koumori.attackdamage;
					player1HealthLabel.setText("Health: " + this.Player1Health);
				}
				else if(card.isImageEqual(board11View.getImage(), new Image(getClass().getResourceAsStream(controller.lajinn.path)))) {
					this.Player1Health -= controller.lajinn.attackdamage;
					player1HealthLabel.setText("Health: " + this.Player1Health);
				}
			
				player1HealthLabel.setText("Health: " + this.Player1Health);
				
			player2AttackAction--;
			
			
			}
	}else {
		Alert error = new Alert(AlertType.ERROR);
        error.setHeaderText("You can attack only once");
        error.showAndWait();
	}
			player1HealthLabel.setText("Health: " + this.Player1Health);
			
			  if(Player1Health <=0) { 
				  Alert alert2 = new Alert(AlertType.CONFIRMATION);
			  
			  alert2.setHeaderText("Player2 won!");
			  
			  if(alert2.showAndWait().get() == ButtonType.OK) {
			  
			  System.exit(0);
			  
			  }
			  
			  }
		}
public void attackToPlayer1Board12() throws IOException {
	if(gameCheck.actionValidator(player2AttackAction)) {
	Alert alert = new Alert(AlertType.CONFIRMATION);
	
	alert.setHeaderText("Do you want to attack to a card?");
	alert.setContentText("If you want to attack to a hero click 'Cancel' ");
	Button button = new Button();
	SceneController controller = new SceneController();

	
	
	if(alert.showAndWait().get() == ButtonType.OK) {
		int x1 = gameCheck.cardToCardAttack1(controller.determineCard(this.board12View), controller.determineCard(this.board2View));
		
		switch(x1) {
		case 1:
			board2View.setImage(null);
			board12View.setImage(null);
			break;
		case 2:
			board2View.setImage(null);
			break;
		case 3:
			board12View.setImage(null);
			break;
		}
		
	}else{
		
			if(card.isImageEqual(board12View.getImage(), new Image(getClass().getResourceAsStream(controller.ansatsu.path)))) {
				this.Player1Health -= controller.ansatsu.attackdamage;
				player1HealthLabel.setText("Health: " + this.Player1Health);
				
			}
				
			else if(card.isImageEqual(board12View.getImage(), new Image(getClass().getResourceAsStream(controller.ancientElf.path)))) {
				this.Player1Health -= controller.ancientElf.attackdamage;
				player1HealthLabel.setText("Health: " + this.Player1Health);
			}
			
			else if(card.isImageEqual(board12View.getImage(), new Image(getClass().getResourceAsStream(controller.battleOx.path)))) {
				this.Player1Health -= controller.battleOx.attackdamage;
				player1HealthLabel.setText("Health: " + this.Player1Health);
			}
			else if(card.isImageEqual(board12View.getImage(), new Image(getClass().getResourceAsStream(controller.beaver.path)))) {
				this.Player1Health -= controller.beaver.attackdamage;
				player1HealthLabel.setText("Health: " + this.Player1Health);
			}
			else if(card.isImageEqual(board12View.getImage(), new Image(getClass().getResourceAsStream(controller.blue.path)))) {
				this.Player1Health -= controller.blue.attackdamage;
				player1HealthLabel.setText("Health: " + this.Player1Health);
			}
			else if(card.isImageEqual(board12View.getImage(), new Image(getClass().getResourceAsStream(controller.celtic.path)))) {
				this.Player1Health -= controller.celtic.attackdamage;
				player1HealthLabel.setText("Health: " + this.Player1Health);
			}
			else if(card.isImageEqual(board12View.getImage(), new Image(getClass().getResourceAsStream(controller.claw.path)))) {
				this.Player1Health -= controller.claw.attackdamage;
				player1HealthLabel.setText("Health: " + this.Player1Health);
			}
			else if(card.isImageEqual(board12View.getImage(), new Image(getClass().getResourceAsStream(controller.curse.path)))) {
				this.Player1Health -= controller.curse.attackdamage;
				player1HealthLabel.setText("Health: " + this.Player1Health);
			}
			else if(card.isImageEqual(board12View.getImage(), new Image(getClass().getResourceAsStream(controller.dhuman.path)))) {
				this.Player1Health -= controller.dhuman.attackdamage;
				player1HealthLabel.setText("Health: " + this.Player1Health);
			}
			else if(card.isImageEqual(board12View.getImage(), new Image(getClass().getResourceAsStream(controller.darkAs.path)))) {
				this.Player1Health -= controller.darkAs.attackdamage;
				player1HealthLabel.setText("Health: " + this.Player1Health);
			}
			else if(card.isImageEqual(board12View.getImage(), new Image(getClass().getResourceAsStream(controller.darkMag.path)))) {
				this.Player1Health -= controller.darkMag.attackdamage;
				player1HealthLabel.setText("Health: " + this.Player1Health);
			}
			else if(card.isImageEqual(board12View.getImage(), new Image(getClass().getResourceAsStream(controller.darkTitan.path)))) {
				this.Player1Health -= controller.darkTitan.attackdamage;
				player1HealthLabel.setText("Health: " + this.Player1Health);
			}
			else if(card.isImageEqual(board12View.getImage(), new Image(getClass().getResourceAsStream(controller.destroyer.path)))) {
				this.Player1Health -= controller.destroyer.attackdamage;
				player1HealthLabel.setText("Health: " + this.Player1Health);
			}
			else if(card.isImageEqual(board12View.getImage(), new Image(getClass().getResourceAsStream(controller.doma.path)))) {
				this.Player1Health -= controller.doma.attackdamage;
				player1HealthLabel.setText("Health: " + this.Player1Health);
			}
			else if(card.isImageEqual(board12View.getImage(), new Image(getClass().getResourceAsStream(controller.dragonzom.path)))) {
				this.Player1Health -= controller.dragonzom.attackdamage;
				player1HealthLabel.setText("Health: " + this.Player1Health);
			}
			else if(card.isImageEqual(board12View.getImage(), new Image(getClass().getResourceAsStream(controller.feral.path)))) {
				this.Player1Health -= controller.feral.attackdamage;
				player1HealthLabel.setText("Health: " + this.Player1Health);
			}
			else if(card.isImageEqual(board12View.getImage(), new Image(getClass().getResourceAsStream(controller.gaia.path)))) {
				this.Player1Health -= controller.gaia.attackdamage;
				player1HealthLabel.setText("Health: " + this.Player1Health);
			}
			else if(card.isImageEqual(board12View.getImage(), new Image(getClass().getResourceAsStream(controller.giant.path)))) {
				this.Player1Health -= controller.giant.attackdamage;
				player1HealthLabel.setText("Health: " + this.Player1Health);
			}
			else if(card.isImageEqual(board12View.getImage(), new Image(getClass().getResourceAsStream(controller.great.path)))) {
				this.Player1Health -= controller.great.attackdamage;
				player1HealthLabel.setText("Health: " + this.Player1Health);
			}
			else if(card.isImageEqual(board12View.getImage(), new Image(getClass().getResourceAsStream(controller.gyakutenno.path)))) {
				this.Player1Health -= controller.gyakutenno.attackdamage;
				player1HealthLabel.setText("Health: " + this.Player1Health);
			}
			else if(card.isImageEqual(board12View.getImage(), new Image(getClass().getResourceAsStream(controller.hitotsu.path)))) {
				this.Player1Health -= controller.hitotsu.attackdamage;
				player1HealthLabel.setText("Health: " + this.Player1Health);
			}
			else if(card.isImageEqual(board12View.getImage(), new Image(getClass().getResourceAsStream(controller.judge.path)))) {
				this.Player1Health -= controller.judge.attackdamage;
				player1HealthLabel.setText("Health: " + this.Player1Health);
			}
			else if(card.isImageEqual(board12View.getImage(), new Image(getClass().getResourceAsStream(controller.kojikocy.path)))) {
				this.Player1Health -= controller.kojikocy.attackdamage;
				player1HealthLabel.setText("Health: " + this.Player1Health);
			}
			else if(card.isImageEqual(board12View.getImage(), new Image(getClass().getResourceAsStream(controller.koumori.path)))) {
				this.Player1Health -= controller.koumori.attackdamage;
				player1HealthLabel.setText("Health: " + this.Player1Health);
			}
			else if(card.isImageEqual(board12View.getImage(), new Image(getClass().getResourceAsStream(controller.lajinn.path)))) {
				this.Player1Health -= controller.lajinn.attackdamage;
				player1HealthLabel.setText("Health: " + this.Player1Health);
			}
		
			player1HealthLabel.setText("Health: " + this.Player1Health);
			player2AttackAction--;
		
		
		
		}
	}else {
		Alert error = new Alert(AlertType.ERROR);
        error.setHeaderText("You can attack only once");
        error.showAndWait();
	}
		player1HealthLabel.setText("Health: " + this.Player1Health);
		
		  if(Player1Health <=0) { 
			  Alert alert2 = new Alert(AlertType.CONFIRMATION);
		  
		  alert2.setHeaderText("Player2 won!");
		  
		  if(alert2.showAndWait().get() == ButtonType.OK) {
		  
		  System.exit(0);
		  
		  
		  }
		  
		  }
	}
public void attackToPlayer1Board13() throws IOException {
	if(gameCheck.actionValidator(player2AttackAction)) {
	Alert alert = new Alert(AlertType.CONFIRMATION);
	
	alert.setHeaderText("Do you want to attack to a card?");
	alert.setContentText("If you want to attack to a hero click 'Cancel' ");
	Button button = new Button();
	SceneController controller = new SceneController();

	
	
	if(alert.showAndWait().get() == ButtonType.OK) {
		int x1 = gameCheck.cardToCardAttack1(controller.determineCard(this.board13View), controller.determineCard(this.board3View));
		
		switch(x1) {
		case 1:
			board3View.setImage(null);
			board13View.setImage(null);
			break;
		case 2:
			board1View.setImage(null);
			break;
		case 3:
			board13View.setImage(null);
			break;
		}
	}else{
		
			if(card.isImageEqual(board13View.getImage(), new Image(getClass().getResourceAsStream(controller.ansatsu.path)))) {
				this.Player1Health -= controller.ansatsu.attackdamage;
				player1HealthLabel.setText("Health: " + this.Player1Health);
				
			}
				
			else if(card.isImageEqual(board13View.getImage(), new Image(getClass().getResourceAsStream(controller.ancientElf.path)))) {
				this.Player1Health -= controller.ancientElf.attackdamage;
				player1HealthLabel.setText("Health: " + this.Player1Health);
			}
			
			else if(card.isImageEqual(board13View.getImage(), new Image(getClass().getResourceAsStream(controller.battleOx.path)))) {
				this.Player1Health -= controller.battleOx.attackdamage;
				player1HealthLabel.setText("Health: " + this.Player1Health);
			}
			else if(card.isImageEqual(board13View.getImage(), new Image(getClass().getResourceAsStream(controller.beaver.path)))) {
				this.Player1Health -= controller.beaver.attackdamage;
				player1HealthLabel.setText("Health: " + this.Player1Health);
			}
			else if(card.isImageEqual(board13View.getImage(), new Image(getClass().getResourceAsStream(controller.blue.path)))) {
				this.Player1Health -= controller.blue.attackdamage;
				player1HealthLabel.setText("Health: " + this.Player1Health);
			}
			else if(card.isImageEqual(board13View.getImage(), new Image(getClass().getResourceAsStream(controller.celtic.path)))) {
				this.Player1Health -= controller.celtic.attackdamage;
				player1HealthLabel.setText("Health: " + this.Player1Health);
			}
			else if(card.isImageEqual(board13View.getImage(), new Image(getClass().getResourceAsStream(controller.claw.path)))) {
				this.Player1Health -= controller.claw.attackdamage;
				player1HealthLabel.setText("Health: " + this.Player1Health);
			}
			else if(card.isImageEqual(board13View.getImage(), new Image(getClass().getResourceAsStream(controller.curse.path)))) {
				this.Player1Health -= controller.curse.attackdamage;
				player1HealthLabel.setText("Health: " + this.Player1Health);
			}
			else if(card.isImageEqual(board13View.getImage(), new Image(getClass().getResourceAsStream(controller.dhuman.path)))) {
				this.Player1Health -= controller.dhuman.attackdamage;
				player1HealthLabel.setText("Health: " + this.Player1Health);
			}
			else if(card.isImageEqual(board13View.getImage(), new Image(getClass().getResourceAsStream(controller.darkAs.path)))) {
				this.Player1Health -= controller.darkAs.attackdamage;
				player1HealthLabel.setText("Health: " + this.Player1Health);
			}
			else if(card.isImageEqual(board13View.getImage(), new Image(getClass().getResourceAsStream(controller.darkMag.path)))) {
				this.Player1Health -= controller.darkMag.attackdamage;
				player1HealthLabel.setText("Health: " + this.Player1Health);
			}
			else if(card.isImageEqual(board13View.getImage(), new Image(getClass().getResourceAsStream(controller.darkTitan.path)))) {
				this.Player1Health -= controller.darkTitan.attackdamage;
				player1HealthLabel.setText("Health: " + this.Player1Health);
			}
			else if(card.isImageEqual(board13View.getImage(), new Image(getClass().getResourceAsStream(controller.destroyer.path)))) {
				this.Player1Health -= controller.destroyer.attackdamage;
				player1HealthLabel.setText("Health: " + this.Player1Health);
			}
			else if(card.isImageEqual(board13View.getImage(), new Image(getClass().getResourceAsStream(controller.doma.path)))) {
				this.Player1Health -= controller.doma.attackdamage;
				player1HealthLabel.setText("Health: " + this.Player1Health);
			}
			else if(card.isImageEqual(board13View.getImage(), new Image(getClass().getResourceAsStream(controller.dragonzom.path)))) {
				this.Player1Health -= controller.dragonzom.attackdamage;
				player1HealthLabel.setText("Health: " + this.Player1Health);
			}
			else if(card.isImageEqual(board13View.getImage(), new Image(getClass().getResourceAsStream(controller.feral.path)))) {
				this.Player1Health -= controller.feral.attackdamage;
				player1HealthLabel.setText("Health: " + this.Player1Health);
			}
			else if(card.isImageEqual(board13View.getImage(), new Image(getClass().getResourceAsStream(controller.gaia.path)))) {
				this.Player1Health -= controller.gaia.attackdamage;
				player1HealthLabel.setText("Health: " + this.Player1Health);
			}
			else if(card.isImageEqual(board13View.getImage(), new Image(getClass().getResourceAsStream(controller.giant.path)))) {
				this.Player1Health -= controller.giant.attackdamage;
				player1HealthLabel.setText("Health: " + this.Player1Health);
			}
			else if(card.isImageEqual(board13View.getImage(), new Image(getClass().getResourceAsStream(controller.great.path)))) {
				this.Player1Health -= controller.great.attackdamage;
				player1HealthLabel.setText("Health: " + this.Player1Health);
			}
			else if(card.isImageEqual(board13View.getImage(), new Image(getClass().getResourceAsStream(controller.gyakutenno.path)))) {
				this.Player1Health -= controller.gyakutenno.attackdamage;
				player1HealthLabel.setText("Health: " + this.Player1Health);
			}
			else if(card.isImageEqual(board13View.getImage(), new Image(getClass().getResourceAsStream(controller.hitotsu.path)))) {
				this.Player1Health -= controller.hitotsu.attackdamage;
				player1HealthLabel.setText("Health: " + this.Player1Health);
			}
			else if(card.isImageEqual(board13View.getImage(), new Image(getClass().getResourceAsStream(controller.judge.path)))) {
				this.Player1Health -= controller.judge.attackdamage;
				player1HealthLabel.setText("Health: " + this.Player1Health);
			}
			else if(card.isImageEqual(board13View.getImage(), new Image(getClass().getResourceAsStream(controller.kojikocy.path)))) {
				this.Player1Health -= controller.kojikocy.attackdamage;
				player1HealthLabel.setText("Health: " + this.Player1Health);
			}
			else if(card.isImageEqual(board13View.getImage(), new Image(getClass().getResourceAsStream(controller.koumori.path)))) {
				this.Player1Health -= controller.koumori.attackdamage;
				player1HealthLabel.setText("Health: " + this.Player1Health);
			}
			else if(card.isImageEqual(board13View.getImage(), new Image(getClass().getResourceAsStream(controller.lajinn.path)))) {
				this.Player1Health -= controller.lajinn.attackdamage;
				player1HealthLabel.setText("Health: " + this.Player1Health);
			}
		
			player1HealthLabel.setText("Health: " + this.Player1Health);
			
		player2AttackAction--;
		
		
		}
	}else {
		Alert error = new Alert(AlertType.ERROR);
        error.setHeaderText("You can attack only once");
        error.showAndWait();
	}
		player1HealthLabel.setText("Health: " + this.Player1Health);
		
		  if(Player1Health <=0) { 
			  Alert alert2 = new Alert(AlertType.CONFIRMATION);
		  
		  alert2.setHeaderText("Player2 won!");
		  
		  if(alert2.showAndWait().get() == ButtonType.OK) {
		  
		  System.exit(0);
		  
		  }
		  
		  }
	}
public void attackToPlayer1Board14() throws IOException {
	if(gameCheck.actionValidator(player2AttackAction)) {
	Alert alert = new Alert(AlertType.CONFIRMATION);
	
	alert.setHeaderText("Do you want to attack to a card?");
	alert.setContentText("If you want to attack to a hero click 'Cancel' ");
	Button button = new Button();
	SceneController controller = new SceneController();

	
	
	if(alert.showAndWait().get() == ButtonType.OK) {
		int x1 = gameCheck.cardToCardAttack1(controller.determineCard(this.board14View), controller.determineCard(this.board4View));
		
		switch(x1) {
		case 1:
			board4View.setImage(null);
			board14View.setImage(null);
			break;
		case 2:
			board4View.setImage(null);
			break;
		case 3:
			board14View.setImage(null);
			break;
		}
		
	}else{
		
			if(card.isImageEqual(board14View.getImage(), new Image(getClass().getResourceAsStream(controller.ansatsu.path)))) {
				this.Player1Health -= controller.ansatsu.attackdamage;
				player1HealthLabel.setText("Health: " + this.Player1Health);
				
			}
				
			else if(card.isImageEqual(board14View.getImage(), new Image(getClass().getResourceAsStream(controller.ancientElf.path)))) {
				this.Player1Health -= controller.ancientElf.attackdamage;
				player1HealthLabel.setText("Health: " + this.Player1Health);
			}
			
			else if(card.isImageEqual(board14View.getImage(), new Image(getClass().getResourceAsStream(controller.battleOx.path)))) {
				this.Player1Health -= controller.battleOx.attackdamage;
				player1HealthLabel.setText("Health: " + this.Player1Health);
			}
			else if(card.isImageEqual(board14View.getImage(), new Image(getClass().getResourceAsStream(controller.beaver.path)))) {
				this.Player1Health -= controller.beaver.attackdamage;
				player1HealthLabel.setText("Health: " + this.Player1Health);
			}
			else if(card.isImageEqual(board14View.getImage(), new Image(getClass().getResourceAsStream(controller.blue.path)))) {
				this.Player1Health -= controller.blue.attackdamage;
				player1HealthLabel.setText("Health: " + this.Player1Health);
			}
			else if(card.isImageEqual(board14View.getImage(), new Image(getClass().getResourceAsStream(controller.celtic.path)))) {
				this.Player1Health -= controller.celtic.attackdamage;
				player1HealthLabel.setText("Health: " + this.Player1Health);
			}
			else if(card.isImageEqual(board14View.getImage(), new Image(getClass().getResourceAsStream(controller.claw.path)))) {
				this.Player1Health -= controller.claw.attackdamage;
				player1HealthLabel.setText("Health: " + this.Player1Health);
			}
			else if(card.isImageEqual(board14View.getImage(), new Image(getClass().getResourceAsStream(controller.curse.path)))) {
				this.Player1Health -= controller.curse.attackdamage;
				player1HealthLabel.setText("Health: " + this.Player1Health);
			}
			else if(card.isImageEqual(board14View.getImage(), new Image(getClass().getResourceAsStream(controller.dhuman.path)))) {
				this.Player1Health -= controller.dhuman.attackdamage;
				player1HealthLabel.setText("Health: " + this.Player1Health);
			}
			else if(card.isImageEqual(board14View.getImage(), new Image(getClass().getResourceAsStream(controller.darkAs.path)))) {
				this.Player1Health -= controller.darkAs.attackdamage;
				player1HealthLabel.setText("Health: " + this.Player1Health);
			}
			else if(card.isImageEqual(board14View.getImage(), new Image(getClass().getResourceAsStream(controller.darkMag.path)))) {
				this.Player1Health -= controller.darkMag.attackdamage;
				player1HealthLabel.setText("Health: " + this.Player1Health);
			}
			else if(card.isImageEqual(board14View.getImage(), new Image(getClass().getResourceAsStream(controller.darkTitan.path)))) {
				this.Player1Health -= controller.darkTitan.attackdamage;
				player1HealthLabel.setText("Health: " + this.Player1Health);
			}
			else if(card.isImageEqual(board14View.getImage(), new Image(getClass().getResourceAsStream(controller.destroyer.path)))) {
				this.Player1Health -= controller.destroyer.attackdamage;
				player1HealthLabel.setText("Health: " + this.Player1Health);
			}
			else if(card.isImageEqual(board14View.getImage(), new Image(getClass().getResourceAsStream(controller.doma.path)))) {
				this.Player1Health -= controller.doma.attackdamage;
				player1HealthLabel.setText("Health: " + this.Player1Health);
			}
			else if(card.isImageEqual(board14View.getImage(), new Image(getClass().getResourceAsStream(controller.dragonzom.path)))) {
				this.Player1Health -= controller.dragonzom.attackdamage;
				player1HealthLabel.setText("Health: " + this.Player1Health);
			}
			else if(card.isImageEqual(board14View.getImage(), new Image(getClass().getResourceAsStream(controller.feral.path)))) {
				this.Player1Health -= controller.feral.attackdamage;
				player1HealthLabel.setText("Health: " + this.Player1Health);
			}
			else if(card.isImageEqual(board14View.getImage(), new Image(getClass().getResourceAsStream(controller.gaia.path)))) {
				this.Player1Health -= controller.gaia.attackdamage;
				player1HealthLabel.setText("Health: " + this.Player1Health);
			}
			else if(card.isImageEqual(board14View.getImage(), new Image(getClass().getResourceAsStream(controller.giant.path)))) {
				this.Player1Health -= controller.giant.attackdamage;
				player1HealthLabel.setText("Health: " + this.Player1Health);
			}
			else if(card.isImageEqual(board14View.getImage(), new Image(getClass().getResourceAsStream(controller.great.path)))) {
				this.Player1Health -= controller.great.attackdamage;
				player1HealthLabel.setText("Health: " + this.Player1Health);
			}
			else if(card.isImageEqual(board14View.getImage(), new Image(getClass().getResourceAsStream(controller.gyakutenno.path)))) {
				this.Player1Health -= controller.gyakutenno.attackdamage;
				player1HealthLabel.setText("Health: " + this.Player1Health);
			}
			else if(card.isImageEqual(board14View.getImage(), new Image(getClass().getResourceAsStream(controller.hitotsu.path)))) {
				this.Player1Health -= controller.hitotsu.attackdamage;
				player1HealthLabel.setText("Health: " + this.Player1Health);
			}
			else if(card.isImageEqual(board14View.getImage(), new Image(getClass().getResourceAsStream(controller.judge.path)))) {
				this.Player1Health -= controller.judge.attackdamage;
				player1HealthLabel.setText("Health: " + this.Player1Health);
			}
			else if(card.isImageEqual(board14View.getImage(), new Image(getClass().getResourceAsStream(controller.kojikocy.path)))) {
				this.Player1Health -= controller.kojikocy.attackdamage;
				player1HealthLabel.setText("Health: " + this.Player1Health);
			}
			else if(card.isImageEqual(board14View.getImage(), new Image(getClass().getResourceAsStream(controller.koumori.path)))) {
				this.Player1Health -= controller.koumori.attackdamage;
				player1HealthLabel.setText("Health: " + this.Player1Health);
			}
			else if(card.isImageEqual(board14View.getImage(), new Image(getClass().getResourceAsStream(controller.lajinn.path)))) {
				this.Player1Health -= controller.lajinn.attackdamage;
				player1HealthLabel.setText("Health: " + this.Player1Health);
			}
		
			player1HealthLabel.setText("Health: " + this.Player1Health);
			player2AttackAction--;
		
		
		
		}
	}else {
		Alert error = new Alert(AlertType.ERROR);
        error.setHeaderText("You can attack only once");
        error.showAndWait();
	}
		player1HealthLabel.setText("Health: " + this.Player1Health);
		
		  if(Player1Health <=0) { 
			  Alert alert2 = new Alert(AlertType.CONFIRMATION);
		  
		  alert2.setHeaderText("Player2 won!");
		  
		  if(alert2.showAndWait().get() == ButtonType.OK) {
		  
		  System.exit(0);
		  
		  }
		  
		  }
	}


	
	public void decreaseCompHealth(int attackDamage) {
		Player2Health -= attackDamage;
	}
	
	public void decreasePlayerHealth(int attackDamage) {
		Player1Health -= attackDamage;
	}
	
	public void endTheGame() {
		if(Player2Health <= 0) {
			Alert alert = new Alert(AlertType.CONFIRMATION);
			
			alert.setHeaderText("Player1 won!");
			
		}else if(Player1Health<= 0 ) {
			
			Alert alert = new Alert(AlertType.CONFIRMATION);
			
			alert.setHeaderText("Player2 won!");
		}
	}
	
	
}
