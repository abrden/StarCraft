package fiuba.algo3.starcraft.logic.templates;

public class Life {
	
	private Shield shield;
	private int health;
	
	Life(int health) {
		this.health = health;
	}

	Life(int health, Shield shield) {
		this.health = health;
		this.shield = shield;
	}
}
