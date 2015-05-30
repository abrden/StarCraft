package fiuba.algo3.starcraft.logic.structures;

import fiuba.algo3.starcraft.logic.templates.Life;

public class Depot extends Structure {

	private int content;
	
	public Depot(Life life) {
		this.life = life;
		this.content = 0;
	}
	
	public boolean isEmpty() {
		return (content == 0);
	}

}
