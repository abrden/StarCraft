package fiuba.algo3.starcraft.view;

import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JFrame;
import javax.swing.JScrollPane;

import fiuba.algo3.starcraft.game.StarCraft;

public class StarCraftView extends JFrame {

	private static final long serialVersionUID = 1L;
	
	private MapView mapView;
	private PlayerStatusView playerStatusView;
	private ActionsView actionsView;
	private MessageBox messageBox;
	
	private StarCraft game;
	
	private Dimension screenSize;
	
	public StarCraftView(StarCraft game) {
		this.game = game;
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.screenSize = getToolkit().getScreenSize();
		setSize(screenSize);
		setResizable(false);
		getContentPane().setBackground(new Color(0,0,255));
		setLayout(null);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        
        MessageBox messageBox = new MessageBox();
        setMessageBox(messageBox);
        
     	PlayerStatusView playerStatusView = new PlayerStatusView(game);
     	setPlayerStatusView(playerStatusView);
        
        ActionsView actionsView = new ActionsView(game, messageBox);
        setActionsView(actionsView);
        
        MapView mapView = new MapView(game.map, actionsView);
        setMapView(mapView);
        
        setVisible(true);
	}
	
	private void setPlayerStatusView(PlayerStatusView playerStatusView) {
		this.playerStatusView = playerStatusView;
		
		// Agregar opciones de formato
		
		add(playerStatusView);
	}
	
	private void setMessageBox(MessageBox messageBox) {
		this.messageBox = messageBox;
		
		// Agregar opciones de formato
		
		add(messageBox);
	}
	
	private void setMapView(MapView mapView) {
		this.mapView = mapView;
		mapView.setPreferredSize(mapView.getSize());
		
		JScrollPane scrollPane = new JScrollPane(mapView,JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
        scrollPane.setBounds(0, 0, screenSize.width, screenSize.height * 2 / 3);
        
        add(scrollPane);
	}
	
	private void setActionsView(ActionsView actionsView) {
		this.actionsView = actionsView;
		actionsView.setBounds(0, screenSize.height * 2 / 3, screenSize.width, screenSize.height * 1 / 3);
		add(actionsView);
	}
}
