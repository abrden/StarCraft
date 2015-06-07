package fiuba.algo3.starcraft.logic.templates.structures;

import fiuba.algo3.starcraft.logic.map.Point;
import fiuba.algo3.starcraft.logic.structures.Structure;
import fiuba.algo3.starcraft.logic.templates.Template;

public abstract class StructureTemplate extends Template {

	public abstract Structure create(Point position);
	
}
