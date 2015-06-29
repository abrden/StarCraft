package fiuba.algo3.starcraft.view;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import fiuba.algo3.starcraft.logic.units.Unit;

public class UnitView extends DrawableView implements MouseListener {

	private static final long serialVersionUID = 1L;
	
	private final int kBoundHeight = 70;
	private final int kBoundWight = 60;
	private final int lifeBarHeight = 4;
	private final int lifeBarWidth = 60;
	private final int healthBarYPosition = 66;
	private final int shieldBarYPosition = 60;

	private Unit unit;
	private ActionsView actionsView;
	
	public UnitView(Unit unit, ActionsView actionsView) {
		this.unit = unit;
		this.actionsView = actionsView;
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
		g.fillRect(0, healthBarYPosition, calculateHealthBarWidth() , lifeBarHeight);
	}
	
	private void drawShield(Graphics g) {
		g.setColor(Color.gray);
		g.fillRect(0, shieldBarYPosition, calculateShieldBarWidth() , lifeBarHeight);		
	}
	
	private int calculateHealthBarWidth() {
		return ((unit.getHealth() * lifeBarWidth)/unit.getMaximumHealth());
	}
	
	private int calculateShieldBarWidth() {
		if (unit.getMaximumShield() == 0) return 0;
		return ((unit.getShield() * lifeBarWidth)/unit.getMaximumShield());
	}
	
	@Override
	public void mouseClicked(MouseEvent arg0) {
		actionsView.showActions(this.unit);
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
