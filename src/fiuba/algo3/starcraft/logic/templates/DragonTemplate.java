package fiuba.algo3.starcraft.logic.templates;


public class DragonTemplate extends MuggleTemplate {

	public static DragonTemplate instance = new DragonTemplate();

	private DragonTemplate() {
		value = new Value(125,50);
		constructionTime = 6;
		vision = 8;
		populationQuota = 2;
		health = 80;
		shield = 100;
		transportationQuota = 4;
		damage = new Damage(20,20);
		damageRange = 4;
	}

	public static DragonTemplate getInstance(){
		return instance;
	}
}
