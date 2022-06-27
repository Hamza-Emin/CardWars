package application;

public class Game  implements IAttack{
	public int CompHealth;
	public int PlayerHealth;
	GameController controller;
	
	
	public int cardToComputerAttack(Cards card) {
		return card.attackdamage;
		
		
	}
	

	public int cardToCardAttack1(Cards card1,Cards card2) {
		if(determineWinnerCard(card1,card2)==1) {
			return 1;
		}
		else if(determineWinnerCard(card1,card2)==2) {
			return 2;
		}
		else if(determineWinnerCard(card1,card2)==3) {
			return 3;	
}
		else {
			return 0;
		}
	}
	public boolean actionValidator(int action) {
        if (action == 0)
            return false;
        else;
            return true;
    }

	
	public int determineWinnerCard(Cards card1,Cards card2) {
		if((card1.attackdamage>=card2.defence) && (card2.attackdamage>=card1.defence)) {
	
			return 1;
		}
		else if((card1.attackdamage>=card2.defence) && (card1.defence >= card2.attackdamage)) {

			return 2;
		}
		else if((card2.defence >= card1.attackdamage) && (card2.attackdamage>=card1.defence)) {
			
			return 3;
		}else 
		return 0; 
		}
	
	

	
	
	
	
	

}
