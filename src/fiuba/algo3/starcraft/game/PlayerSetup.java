package fiuba.algo3.starcraft.game;

import java.awt.Color;

import fiuba.algo3.starcraft.logic.structures.builders.Builder;
import fiuba.algo3.starcraft.logic.structures.builders.ProtossBuilder;
import fiuba.algo3.starcraft.logic.structures.builders.TerranBuilder;

public class PlayerSetup {

	private String name;
	private Color color;
	private Builder builder;

	public Builder getBuilder() {
		return builder;
	}

	public Color getColor() {
		return color;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) throws NameIsTooShort {
		if (name.length() < 4) throw new NameIsTooShort();
		else this.name = name;
	}
	
	public void setColor(Color color) {
		this.color = color;
	}
	
	public void setBuilder(RaceType race) {
		if (race == RaceType.protoss) this.builder = new ProtossBuilder();
		if (race == RaceType.terran) this.builder = new TerranBuilder();
	}
}
