package fiuba.algo3.starcraft.game;

import java.awt.Color;

public class PlayerSetup {

	private String name;
	private Color color;
	private RaceType race;

	public PlayerSetup(String name, String color, String race) throws NameIsTooShort {
		if (name.length() < 4) throw new NameIsTooShort();
		this.name = name;
		this.parseColor(color);
		this.parseRace(race);
	}

	private void parseColor(String color) {
		switch (color) {
        case "Blue":
        	this.color = Color.BLUE;
            break;
        case "Red":
        	this.color = Color.RED;
            break;
        case "Yellow": 
        	this.color = Color.YELLOW;
        	break;
        case "Green": 
        	this.color = Color.GREEN;
        	break;
        }
	}
	
	private void parseRace(String race) {
		switch (race) {
        case "Terran": this.race = RaceType.terran;
                 break;
        case "Protoss": this.race = RaceType.terran;
                 break;
        }
	}
	
	public RaceType getRace() {
		return race;
	}

	public Color getColor() {
		return color;
	}

	public String getName() {
		return name;
	}

}
