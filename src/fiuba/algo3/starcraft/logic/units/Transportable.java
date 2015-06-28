package fiuba.algo3.starcraft.logic.units;

import fiuba.algo3.starcraft.logic.map.Point;

public interface Transportable {

	public int getTransportQuota();
	
	public boolean canFly();
	
	public Point getPosition();
	
	public void setPosition(Point destination);
	
	public int getStepsPerTurn();

	public void killInFlight();

	public String getName();

	public int getHealth();

	public int getShield();
}
