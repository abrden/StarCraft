package fiuba.algo3.starcraft.logic.templates;

public class NexoMineralTemplate extends StructureTemplate {

	public static NexoMineralTemplate instance = new NexoMineralTemplate();

	private NexoMineralTemplate() {
		value = new Value(50,0);
		constructionTime = 4;
		life = new Life(250,250);
	}

	public NexoMineralTemplate getInstance(){
		return instance;
	}

}
