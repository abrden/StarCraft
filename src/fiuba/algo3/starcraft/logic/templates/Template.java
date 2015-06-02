package fiuba.algo3.starcraft.logic.templates;

import fiuba.algo3.starcraft.logic.templates.qualities.Value;

public abstract class Template {
	
	protected String name;
	protected Value value;
	protected int constructionTime;
	protected int health;
	protected int shield;
	
	public String getName() {
		return name;
	}
	
	public Value getValue() {
		return value;
	}
	
	public int getConstructionTime() {
		return constructionTime;
	}
}
