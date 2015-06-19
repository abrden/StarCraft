package fiuba.algo3.starcraft.logic.templates.qualities;

import java.util.ArrayList;
import java.util.List;

import fiuba.algo3.starcraft.logic.units.Clone;
import fiuba.algo3.starcraft.logic.units.Unit;

public class Alucinacion extends Power implements Cloner {

	private static final int COST = 100;
	private static final int RANGE = 0;
	
	private Clone clone1;
	private Clone clone2;
	private List<Unit> clones = new ArrayList<Unit>();
	
	public int getCost() {
		return COST;
	}
	
	public int getRange() {
		return RANGE;
	}
	
	public void activate() {
		clone1 = new Clone(affectedUnits.get(0));
		clone2 = new Clone(affectedUnits.get(0));
	}
	
	public void execute(Unit unit) {
		clones.add(clone1);
		clones.add(clone2);
	}
	
	public boolean itsFinished() {
		return (!clone1.itsAlive() && !clone2.itsAlive());
	}
	
	public Iterable<Unit> getClones() {
		return clones;
	}
}
