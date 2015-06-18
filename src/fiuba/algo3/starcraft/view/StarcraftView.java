package fiuba.algo3.starcraft.view;

import java.awt.Color;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class StarcraftView extends JFrame{

	private static final long serialVersionUID = 1L;
	
	private MapView mapView;
	private PlayerStatusView playerStatusView;
	private ActionsView actionsView;
	
	public StarcraftView() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(getToolkit().getScreenSize());
		setResizable(false);
		setVisible(true);
		getContentPane().setBackground(new Color(0,0,255));
		setLayout(null);
	}
	
	public void setMapView(MapView mapView) {
		this.mapView = mapView;
		getContentPane().add(mapView);
		mapView.setBackground(new Color(0,255,0));
		mapView.setBounds(0, 0, 100, 100);
	}
}
