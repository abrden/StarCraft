package fiuba.algo3.starcraft.logic.templates;

public class CentroMineralTemplate extends StructureTemplate {

	public static CentroMineralTemplate instance = new CentroMineralTemplate();

	private CentroMineralTemplate() {
		value = new Value(50,0);
		constructionTime = 4;
		life = new Life(500);
	}

	public static CentroMineralTemplate getInstance(){
		return instance;
	}

}