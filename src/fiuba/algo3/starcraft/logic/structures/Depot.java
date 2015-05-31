package fiuba.algo3.starcraft.logic.structures;

import fiuba.algo3.starcraft.logic.templates.Life;

public class Depot extends Structure {
	
	public Depot(Life life) {
		super(life);
	}

	public StructureID getId() {
		return StructureID.Depot;
	}
}
