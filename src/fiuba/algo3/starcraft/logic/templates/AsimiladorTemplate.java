package fiuba.algo3.starcraft.logic.templates;

public class AsimiladorTemplate extends StructureTemplate {

	private static AsimiladorTemplate instance = null;

	private AsimiladorTemplate() {
		value = new Value(100,0);
		constructionTime = 6;
		life = new Life(450,450);
	}

	public static AsimiladorTemplate getInstance(){
		if (instance == null){
			instance = new AsimiladorTemplate();
		}
		return instance;
	}
}
