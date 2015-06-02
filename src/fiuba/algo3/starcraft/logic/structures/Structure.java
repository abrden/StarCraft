package fiuba.algo3.starcraft.logic.structures;

import fiuba.algo3.starcraft.logic.map.Point;
import fiuba.algo3.starcraft.logic.templates.qualities.Life;

public abstract class Structure {
	
	//protected int size; Radio de la circunferencia de tierra que ocupa? No es necesario por ahora pero, si se queda, no tendriamos que ponerle size tambien a las units?
	protected Point position;
	protected Life life;
	protected String name;
	
	Structure(String name, Life life) {
		this.name = name;
		this.life = life;
	}
	
	public abstract StructureID getId();
	
	public boolean itsAlive() {
		return (life.getHealth() > 0);
	}
	
	public void reduceLife(int damage) {
		life.reduce(damage);
	}

	public String getName(){
		return this.name;
	}

}
