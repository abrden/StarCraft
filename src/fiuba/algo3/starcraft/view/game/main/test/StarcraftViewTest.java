package fiuba.algo3.starcraft.view.game.main.test;

import java.util.ArrayList;

import fiuba.algo3.starcraft.game.PlayerSetup;
import fiuba.algo3.starcraft.game.StarCraft;
import fiuba.algo3.starcraft.view.StarCraftView;
import fiuba.algo3.starcraft.view.exceptions.NameIsTooShort;


public class StarcraftViewTest {

	static StarCraft game;
	public static void initVariables() {
		ArrayList<PlayerSetup> playerSetups = new ArrayList<PlayerSetup>();
			
		try {
			playerSetups.add(new PlayerSetup("Ricky Fort", "Red", "Terran"));
			playerSetups.add(new PlayerSetup("Ricky Maravilla", "Blue", "Protoss"));
		} catch (NameIsTooShort e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
			
		game = new StarCraft(playerSetups);
		game.start(); // Donde deberiamos encajar esto?
	}
	
	public static void initGame() {		
		StarCraftView starcraftView = new StarCraftView(game);
		starcraftView.setVisible(true);
	}
	
	public static void main(String[] args) {
		initVariables();
		initGame();
	}

}
