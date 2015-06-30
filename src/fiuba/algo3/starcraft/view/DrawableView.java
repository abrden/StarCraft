package fiuba.algo3.starcraft.view;

import java.awt.Container;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;

import fiuba.algo3.starcraft.logic.map.Point;

public abstract class DrawableView extends Container {
	
	private static final long serialVersionUID = 1L;
	private String imageName;
	
	private ActionsView actionsView;
	
	public String getImageName() {
		return imageName;
	}
	
	public void setImageName(String imageName) {
		this.imageName = imageName;
		this.repaint();
	}
	
	public void paint (Graphics g) {
		try {
			Image image = Toolkit.getDefaultToolkit().getImage("src/fiuba/algo3/starcraft/presets/".concat(imageName));
			g.drawImage(image, 0, 0, null);
		} catch (Exception e) {}
	}
}
