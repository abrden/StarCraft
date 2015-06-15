package fiuba.algo3.starcraft.logic.units;

import fiuba.algo3.starcraft.logic.map.Point;
import fiuba.algo3.starcraft.logic.units.exceptions.StepsLimitExceeded;

public interface Transportable {

	public int getTransportQuota();
	
	public boolean canFly();
	
	public Point getPosition();
	
	public void setPosition(Point destination) throws StepsLimitExceeded;
	
}
