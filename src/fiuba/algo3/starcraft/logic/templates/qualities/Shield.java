package fiuba.algo3.starcraft.logic.templates.qualities;

public class Shield {
	
	private int shield;
	private final int maximumShield;
	private final static int REGENERATION_RATIO = 20;
	
	public Shield(int shield) {
		this.maximumShield = shield;
		this.shield = shield;
	}
	
	public int getShield() {
		return shield;
	}
	
	public void regenerate() {
		shield += REGENERATION_RATIO;
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
