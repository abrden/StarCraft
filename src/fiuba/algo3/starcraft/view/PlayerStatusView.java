package fiuba.algo3.starcraft.view;

import java.awt.Color;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

import fiuba.algo3.starcraft.game.StarCraft;
import fiuba.algo3.starcraft.logic.player.Player;

public class PlayerStatusView extends JPanel {

	private static final long serialVersionUID = 7906877651611716146L;

	private StarCraft game;
	
	private JLabel playerName = new JLabel();
	private JLabel mineral = new JLabel();
	private JLabel gas = new JLabel();
	
	PlayerStatusView(StarCraft game) {
		this.game = game;
		
		add(playerName);
		
		ImageIcon mineralIcon = new ImageIcon(getClass().getClassLoader().getResource("fiuba/algo3/starcraft/presets/PlayerStatusView/mineralIcon.png"));
		mineral.setIcon(mineralIcon);
		mineral.setForeground(Color.WHITE);
		ImageIcon gasIcon = new ImageIcon(getClass().getClassLoader().getResource("fiuba/algo3/starcraft/presets/PlayerStatusView/gasIcon.png"));
		gas.setIcon(gasIcon);
		gas.setForeground(Color.WHITE);
		
		add(mineral);
		add(gas);
        this.showActivePlayerStatus();
	}
	
	public void showActivePlayerStatus() {
		Player player = game.getActivePlayer();
		
		playerName.setText(player.getName());
		playerName.setForeground(player.getColor());
		playerName.setIcon(new ImageIcon(getClass().getClassLoader().getResource("fiuba/algo3/starcraft/presets/PlayerStatusView/"+player.getRace()+".png")));
		
		mineral.setText(Integer.toString(player.getMineral()));
		gas.setText(Integer.toString(player.getGas()));
		
	}
}
