package fiuba.algo3.starcraft.logic.templates;

import fiuba.algo3.starcraft.logic.templates.qualities.Value;

public abstract class Template {
	
	public abstract String getName();
	
	public abstract Value getValue();
	
	public abstract int getConstructionTime();

}
