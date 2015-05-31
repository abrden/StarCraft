package fiuba.algo3.starcraft.logic.templates;

public class Life {
	
	private Shield shield;
	private int health;
	
	Life(int health) {
		this.health = health;
	}

	Life(int health, int shield) {
		this.health = health;
		this.shield = new Shield(shield);
	}
	
	public int getHealth() {
		return health;
	}
	
	public int getShield() {
		return shield.getShield();
	}
	
	public void regenerateShield() {
		shield.regenerate();
	}

	public void reduce(int damage) {
		for(int i = 0; i < damage; i++) {
			if (!shield.isGone()) shield.reduce(1);
			else health -= 1;
		}
	}
	//TODO: Faltan excepciones por si no tiene escudo (Es Terran).
}
