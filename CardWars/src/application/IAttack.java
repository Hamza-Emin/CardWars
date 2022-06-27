package application;

public interface IAttack {
	public int cardToComputerAttack(Cards card);
	public int cardToCardAttack1(Cards card1,Cards card2);
	public int determineWinnerCard(Cards card1,Cards card2);
	
	
}
