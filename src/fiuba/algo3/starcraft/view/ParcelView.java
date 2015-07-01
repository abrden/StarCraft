package fiuba.algo3.starcraft.view;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import fiuba.algo3.starcraft.logic.map.Map;
import fiuba.algo3.starcraft.logic.map.Parcel;
import fiuba.algo3.starcraft.logic.map.Point;
import fiuba.algo3.starcraft.logic.map.exceptions.UnitCantGetToDestination;
import fiuba.algo3.starcraft.logic.units.exceptions.InsufficientEnergy;
import fiuba.algo3.starcraft.logic.units.exceptions.NonexistentPower;
import fiuba.algo3.starcraft.logic.units.exceptions.UnitAlreadyMovedThisTurn;

public class ParcelView extends DrawableView implements MouseListener{
	
	private static final long serialVersionUID = 1L;
	private Parcel parcel;
	
	private ActionsView actionsView;
    private MessageBox messageBox;
	
	public ParcelView(Parcel parcel, ActionsView actionsView, MessageBox messageBox) {
		this.parcel = parcel;
		this.actionsView = actionsView;
        this.messageBox = messageBox;
		parcel.setDrawableView(this);
		this.setBounds((int)parcel.getOrigin().getX(), (int)parcel.getOrigin().getY(), (int)Map.PARCEL_SIDE, (int)Map.PARCEL_SIDE);
		addMouseListener(this);
	}
	
	@Override
	public void mouseClicked(MouseEvent arg0) {
	 	double mapClickX = (arg0.getPoint().getX() + parcel.getOrigin().getX());
	 	double mapClickY = (arg0.getPoint().getY() + parcel.getOrigin().getY());

		
		try {
			actionsView.setActionPoint(new Point(mapClickX, mapClickY));
		} catch (UnitCantGetToDestination | InsufficientEnergy
				| NonexistentPower | UnitAlreadyMovedThisTurn e) {
			e.printStackTrace();
            messageBox.displayMessage(e.getMessage());
		}

		if (this.parcel.getStructure() != null) {
			actionsView.showActions(this.parcel.getStructure());
			return;
		}
		actionsView.showActions(this.parcel);
	}

	@Override
	public void mouseEntered(MouseEvent arg0) {}

	@Override
	public void mouseExited(MouseEvent arg0) {}

	@Override
	public void mousePressed(MouseEvent arg0) {}

	@Override
	public void mouseReleased(MouseEvent arg0) {}
}
