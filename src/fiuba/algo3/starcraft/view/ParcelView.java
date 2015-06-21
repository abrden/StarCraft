package fiuba.algo3.starcraft.view;

import java.awt.Canvas;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import fiuba.algo3.starcraft.logic.map.Map;
import fiuba.algo3.starcraft.logic.map.Parcel;

public class ParcelView extends Canvas implements MouseListener{
	
	private static final long serialVersionUID = 1L;
	Parcel parcel;
	
	public ParcelView(Parcel parcel) {
		this.parcel = parcel;
		setBounds((int)parcel.getOrigin().getX(), (int)parcel.getOrigin().getY(), (int)Map.PARCEL_SIDE, (int)Map.PARCEL_SIDE);
		addMouseListener(this);
	}

	@Override
	public void mouseClicked(MouseEvent arg0) {
		System.out.println("la parcela que toque fue X: " + parcel.getOrigin().getX() + " Y: " + parcel.getOrigin().getY());
	}

	@Override
	public void mouseEntered(MouseEvent arg0) {
		//System.out.println("la parcela que toque fue X: " + parcel.getOrigin().getX() + " Y: " + parcel.getOrigin().getY());
		
	}

	@Override
	public void mouseExited(MouseEvent arg0) {
		//System.out.println("la parcela que toque fue X: " + parcel.getOrigin().getX() + " Y: " + parcel.getOrigin().getY());
		
	}

	@Override
	public void mousePressed(MouseEvent arg0) {
		//System.out.println("la parcela que toque fue X: " + parcel.getOrigin().getX() + " Y: " + parcel.getOrigin().getY());
		
	}

	@Override
	public void mouseReleased(MouseEvent arg0) {
		//System.out.println("la parcela que toque fue X: " + parcel.getOrigin().getX() + " Y: " + parcel.getOrigin().getY());
		
	}
}
