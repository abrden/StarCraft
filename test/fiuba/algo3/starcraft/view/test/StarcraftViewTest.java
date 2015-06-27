package fiuba.algo3.starcraft.view.test;

import java.util.ArrayList;

import fiuba.algo3.starcraft.game.PlayerSetup;
import fiuba.algo3.starcraft.game.StarCraft;
import fiuba.algo3.starcraft.view.StarcraftView;
import fiuba.algo3.starcraft.view.exceptions.NameIsTooShort;


public class StarcraftViewTest {
	static StarCraft game;
	public static void initVariables() {
		ArrayList<PlayerSetup> playerSetups = new ArrayList<PlayerSetup>();
			
		try {
			playerSetups.add(new PlayerSetup("santi", "red", "Terran"));
			playerSetups.add(new PlayerSetup("agus", "blue", "Terran"));
		} catch (NameIsTooShort e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
			
		game = new StarCraft(playerSetups);		
	}
	
	public static void main(String[] args) {
		System.out.println("Hola");
		initVariables();
		
		createMapAndSetUnitsOnIt();
	}
	
	public static void createMapAndSetUnitsOnIt() {
		
		StarcraftView starcraftView = new StarcraftView(game);
/*
		for (int i = 0; i < 10; i++) {
			MuggleUnit unit = new MuggleUnit("Marine", null, new Point(70 * i, 30), 0, 0, null, 0, false, 0);
			mapView.addUnitToMap(unit);
		}
		starcraftView.setVisible(true);*/
	}

}
