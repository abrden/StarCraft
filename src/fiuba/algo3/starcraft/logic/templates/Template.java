package fiuba.algo3.starcraft.logic.templates;

public abstract class Template {
	
	protected Value value;
	protected int constructionTime;
	protected int health;
	protected int shield;
	
	public Value getValue() {
		return value;
	}
}
