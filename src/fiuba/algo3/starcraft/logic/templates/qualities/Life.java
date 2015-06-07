package fiuba.algo3.starcraft.logic.templates.qualities;

public class Life {
	
	private Shield shield;
	private int health;
	
	public Life(int health) {
		this.health = health;
	}

	public Life(int health, int shield) {
		this.health = health;
		this.shield = new Shield(shield);
	}
	
	public int getHealth() {
		return health;
	}
	
	public int getShield() {
		if (shield != null) return shield.getShield();
		else return 0;
	}
	
	public void regenerateShield() {
		if (shield != null) shield.regenerate();
		else return;
	}

	public void reduce(int damage) {
		for(int i = 0; i < damage; i++) {
			if ((shield != null) && (!shield.isGone())) shield.reduce(1);
			else health -= 1;
		}
	}
	//TODO: Faltan excepciones por si no tiene escudo (Es Terran).
}
