package fiuba.algo3.starcraft.logic.templates;

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
	
}
