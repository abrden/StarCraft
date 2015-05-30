package fiuba.algo3.starcraft.logic.templates;

public class PilonTemplate extends StructureTemplate {

	public static PilonTemplate instance = new PilonTemplate();

	private PilonTemplate() {
		value = new Value(100,0);
		constructionTime = 5;
		life = new Life(300,300);
	}

	public static PilonTemplate getInstance() {
		return instance;
	}
}
