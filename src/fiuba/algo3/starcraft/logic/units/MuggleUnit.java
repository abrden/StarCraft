package fiuba.algo3.starcraft.logic.units;

import fiuba.algo3.starcraft.logic.map.Point;
import fiuba.algo3.starcraft.logic.templates.qualities.Attack;
import fiuba.algo3.starcraft.logic.templates.qualities.Life;
import fiuba.algo3.starcraft.view.DrawableView;

public class MuggleUnit extends Unit implements Transportable {
	
	private final Attack attack;
	private final int transportationQuota;
	private final boolean canFly;
	
	public MuggleUnit(String name, Life life, Point position, int vision, int stepsPerTurn,Attack attack, 
			int transportationQuota, boolean canFly, int populationQuota) {
		super(name, life, position, vision, stepsPerTurn, populationQuota);
			this.attack = attack;
			this.transportationQuota = transportationQuota; 
			this.canFly = canFly;
	}
	
	public int getTransportQuota() {
		return transportationQuota;
	}
	
	public boolean canFly() {
		return canFly;
	}
	
	public int getAttackRange() {
		return attack.getRange();
	}
	
	public int getAttackLandDamage() {
		return attack.getLandDamage();
	}
	
	public int getAttackSpaceDamage() {
		return attack.getSpaceDamage();
	}
	
	public void update() {
		life.regenerateShield();
	}

	public void executeEMP() {
		life.destroyShield();
	}

	@Override
	public void setDrawableView(DrawableView drawableView) {
		drawableView.setImageName("volcano.jpg");
	}
}
