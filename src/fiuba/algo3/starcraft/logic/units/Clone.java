	package fiuba.algo3.starcraft.logic.units;

import java.util.ArrayList;
import java.util.List;

import fiuba.algo3.starcraft.logic.game.ActionID;
import fiuba.algo3.starcraft.logic.templates.qualities.Damage;
import fiuba.algo3.starcraft.logic.templates.qualities.Life;

public class Clone extends Unit {
	
	private Unit cloned;
	private final static int ATTACK_RANGE = 0;
	private final static Damage DAMAGE = new Damage(0,0);
	
	public Clone(Unit unit) {
		super(unit.getName(), new Life(0, unit.getShield()), unit.getPosition(),
				unit.getVision(), unit.getStepsPerTurn(), 
				unit.getPopulationQuota());
		this.cloned = unit;
	}
	
	public boolean itsAlive() {
		return (life.getShield() > 0);
	}
	
	public void update() {
        movedThisTurn = false;
		life.regenerateShield();
	}

	public void executeEMP() {
		life.destroyShield();
	}
	
	
	public int getTransportQuota() {
		if (cloned instanceof Transportable) return ((Transportable) cloned).getTransportQuota();
		return 0;
	}
	
	public boolean canFly() {
		if (cloned instanceof Transportable) return ((Transportable) cloned).canFly();
		return true;
	}
	
	public int getAttackRange() {
		return ATTACK_RANGE;
	}
	
	public int getAttackLandDamage() {
		return DAMAGE.getLandDamage();
	}
	
	public int getAttackSpaceDamage() {
		return DAMAGE.getSpaceDamage();
	}
	
	public Iterable<ActionID> getActions() {
		List<ActionID> actions = new ArrayList<ActionID>();
		actions.add(ActionID.move);
		return actions;
	}

}
