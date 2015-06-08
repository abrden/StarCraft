package fiuba.algo3.starcraft.logic.templates.qualities;

public class Shield {
	
	private int shield;
	private int maximumShield;
	private final int shieldRegen = 20;
	
	Shield(int shield) {
		this.maximumShield = shield;
		this.shield = shield;
	}
	
	public int getShield() {
		return shield;
	}
	
	public void regenerate() {
		shield += shieldRegen;
		if (shield > maximumShield)
			shield = maximumShield;
	}

	public void reduce(int damage) {
		shield -= damage;
	}
	
	public boolean isGone() {
		return (shield <= 0);
	}
	
	public void destroy() {
		shield = 0;
	}
	
}
