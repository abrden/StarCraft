package fiuba.algo3.starcraft.view;

import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JFrame;
import javax.swing.JScrollPane;

import fiuba.algo3.starcraft.logic.game.StarCraft;

public class StarCraftView extends JFrame {

	private static final long serialVersionUID = 1L;
	
	private MapView mapView;
	private PlayerStatusView playerStatusView;
	private ActionsView actionsView;
	private MessageBox messageBox;
	private JScrollPane scrollPane;
	
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
        
        ActionsView actionsView = new ActionsView(game, messageBox, playerStatusView);
        setActionsView(actionsView);
        
        MapView mapView = new MapView(game.map, actionsView, messageBox);
        setMapView(mapView);
        
        setVisible(true);
	}
	
	private void setPlayerStatusView(PlayerStatusView playerStatusView) {
		this.playerStatusView = playerStatusView;
		
		playerStatusView.setBounds(0, screenSize.height * 2 / 3, screenSize.width * 1 / 3, screenSize.height * 1 / 6);
		playerStatusView.setBackground(Color.black);
		
		add(playerStatusView);
	}
	
	private void setMessageBox(MessageBox messageBox) {
		this.messageBox = messageBox;
		
		messageBox.setBounds(0, screenSize.height * 5 / 6 , screenSize.width * 1 / 3, screenSize.height * 1 / 6);
		messageBox.setBackground(Color.black);
		messageBox.displayMessage("Welcome to AlgoCraft");
		add(messageBox);
	}
	
	private void setMapView(MapView mapView) {
		this.mapView = mapView;
		mapView.setPreferredSize(mapView.getSize());
		
		JScrollPane scrollPane = new JScrollPane(mapView,JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
        scrollPane.setBounds(0, 0, screenSize.width, screenSize.height * 2 / 3);
        
        this.scrollPane = scrollPane;
                
        add(scrollPane);
	}
	
	private void setActionsView(ActionsView actionsView) {
		this.actionsView = actionsView;
		actionsView.setBounds(screenSize.width * 1 / 3, screenSize.height * 2 / 3, screenSize.width * 2 / 3, screenSize.height * 1 / 3);
		actionsView.setBackground(Color.black);
		add(actionsView);
	}
}
