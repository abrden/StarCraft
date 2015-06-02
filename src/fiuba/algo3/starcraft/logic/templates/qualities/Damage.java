package fiuba.algo3.starcraft.logic.templates.qualities;

public class Damage {
	
	private int landDamage;
	private int spaceDamage;
	
	public Damage(int landDamage, int spaceDamage) {
		this.landDamage = landDamage;
		this.spaceDamage = spaceDamage;
	}

	public int getLandDamage() {
		return landDamage;
	}
	
	public int getSpaceDamage() {
		return spaceDamage;
	}
}
