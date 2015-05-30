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

	//Faltan atributos para obtener el escudo, excepciones por si no lo tiene
}
