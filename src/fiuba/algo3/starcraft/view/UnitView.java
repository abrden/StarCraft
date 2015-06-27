package fiuba.algo3.starcraft.view;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import fiuba.algo3.starcraft.logic.units.Unit;

public class UnitView extends DrawableView implements MouseListener {
	
	private final int kBoundHeight = 70;
	private final int kBoundWight = 60;
	
	
	private static final long serialVersionUID = 1L;
	Unit unit;
	
	public UnitView(Unit unit) {
		this.unit = unit;
		unit.setDrawableView(this);
		setBounds((int)unit.getPosition().getX(), (int)unit.getPosition().getY(), kBoundWight, kBoundHeight);
		addMouseListener(this);
	}
	
	public void paint (Graphics g) {
		super.paint(g);
		
		drawHealth(g);
		drawShield(g);
	}
	
	private void drawHealth(Graphics g) {
		g.setColor(Color.green);
		g.fillRect(0, 60, calculateHealthBar() , 4);
	}
	
	private void drawShield(Graphics g) {
		g.setColor(Color.blue);
		g.fillRect(0, 66, calculateHealthBar() , 4);
		
	}
	
	//FIXME : need a property of max ammount of health for calculation
	private int calculateHealthBar() {
		return 60;
	}
	
	
	@Override
	public void mouseClicked(MouseEvent arg0) {
		System.out.println("clicked in unit " + unit.getName());
	}

	@Override
	public void mouseEntered(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mousePressed(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}	
}
