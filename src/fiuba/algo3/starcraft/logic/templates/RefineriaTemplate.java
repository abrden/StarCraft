package fiuba.algo3.starcraft.logic.templates;

public class RefineriaTemplate extends StructureTemplate {

	public static RefineriaTemplate instance = new RefineriaTemplate();

	private RefineriaTemplate() {
		value = new Value(100,0);
		constructionTime = 6;
		life = new Life(750);
	}

	public static RefineriaTemplate getInstance() {
		return instance;
	}
}
