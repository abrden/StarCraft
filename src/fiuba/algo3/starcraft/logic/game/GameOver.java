package fiuba.algo3.starcraft.logic.game;


public class GameOver extends Exception {

	private static final long serialVersionUID = -1237524609661160276L;
	
	private String winner;
	
	public GameOver(String winner) {
		this.winner = winner;
	}

	public String getWinnersName() {
		return winner;
	}
	
}
