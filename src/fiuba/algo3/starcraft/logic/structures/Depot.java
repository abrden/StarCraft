package fiuba.algo3.starcraft.logic.structures;

import fiuba.algo3.starcraft.logic.templates.qualities.Life;

public class Depot extends Structure {
	
	public Depot(String name, Life life) {
		super(name, life);
	}

	public StructureID getId() {
		return StructureID.Depot;
	}
}
