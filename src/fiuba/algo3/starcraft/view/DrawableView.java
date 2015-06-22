package fiuba.algo3.starcraft.view;

import java.awt.Canvas;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;

public abstract class DrawableView extends Canvas {
	
	private static final long serialVersionUID = 1L;
	private String imageName;
	
	public String getImageName() {
		return imageName;
	}
	
	public void setImageName(String imageName) {
		this.imageName = imageName;
	}
	
	public void paint (Graphics g) {
		super.paint(g);
		try {
			Image image = Toolkit.getDefaultToolkit().getImage("presets/".concat(imageName));
			g.drawImage(image, 0, 0, null);
		} catch (Exception e) {}
	}
	
}
