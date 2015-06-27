package fiuba.algo3.starcraft.view.game.main.test;

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
	
	public static void initGame() {		
		StarcraftView starcraftView = new StarcraftView(game);
		starcraftView.setVisible(true);
	}
	
	public static void main(String[] args) {
		initVariables();
		initGame();
	}

}
