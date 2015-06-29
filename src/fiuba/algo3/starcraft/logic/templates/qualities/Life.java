package fiuba.algo3.starcraft.logic.templates.qualities;

public class Life {
	
	private Shield shield;
	private int health;
	private final int maximumHealth;
	
	public Life(int health) {
		this.maximumHealth = health;
		this.health = health;
	}

	public Life(int health, int shield) {
		this.maximumHealth = health;
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
	}

	public void reduce(int damage) {
		for(int i = 0; i < damage; i++) {
			if ((shield != null) && (!shield.isGone())) shield.reduce(1);
			else health -= 1;
		}
	}
	
	public void destroyShield() {
		if (shield != null) shield.destroy();
	}

	public void drain() {
		this.destroyShield();
		health = 0;
	}

	public int getMaximumHealth() {
		return maximumHealth;
	}

	public int getMaximumShield() {
		if (shield != null) return shield.getMaximum();
		return 0;
	}
	
}
