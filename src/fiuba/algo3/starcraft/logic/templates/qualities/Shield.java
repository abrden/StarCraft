package fiuba.algo3.starcraft.logic.templates.qualities;

public class Shield {
	
	private int shield;
	private int maximumShield;
	
	Shield(int shield) {
		this.maximumShield = shield;
		this.shield = shield;
	}
	
	public int getShield() {
		return shield;
	}
	
	public void regenerate() {
		shield = maximumShield;
	}

	public void reduce(int damage) {
		shield -= damage;
	}
	
	public boolean isGone() {
		return (shield <= 0);
	}
	
}
