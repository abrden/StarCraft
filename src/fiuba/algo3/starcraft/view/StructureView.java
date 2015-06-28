package fiuba.algo3.starcraft.view;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import fiuba.algo3.starcraft.logic.map.Map;
import fiuba.algo3.starcraft.logic.map.Parcel;
import fiuba.algo3.starcraft.logic.structures.Structure;

public class StructureView extends DrawableView implements MouseListener {

	private static final long serialVersionUID = 8495743548337315698L;

	private Structure structure;
	private ActionsView actionsView;
	
	public StructureView(Structure structure, Parcel parcel, ActionsView actionsView) {
		this.structure = structure;
		this.actionsView = actionsView;
		structure.setDrawableView(this);
		
		this.setBounds((int) parcel.getOrigin().getX(), (int) parcel.getOrigin().getY(), (int) Map.PARCEL_SIDE, (int) Map.PARCEL_SIDE);
		addMouseListener(this);
	}
	
	@Override
	public void mouseClicked(MouseEvent arg0) {
		System.out.println("clicked in structure " + structure.getName());
		actionsView.showActions(this.structure);
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
