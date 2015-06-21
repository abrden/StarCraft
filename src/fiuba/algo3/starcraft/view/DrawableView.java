package fiuba.algo3.starcraft.view;

import java.awt.Canvas;

public abstract class DrawableView extends Canvas {
	
	private static final long serialVersionUID = 1L;
	private String imageName;
	
	public String getImageName() {
		return imageName;
	}
	
	public void setImageName(String imageName) {
		this.imageName = imageName;
		
		//Image image = new Image();
		//getGraphics().drawImage(image, 0, 0, null);
		System.out.println("" + imageName);
	}
	
}
