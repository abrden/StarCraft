package fiuba.algo3.starcraft.logic.units;

import fiuba.algo3.starcraft.logic.map.Point;

public interface Transportable {

	public int getTransportQuota();
	
	public boolean canFly();
	public Point getPosition();
}
