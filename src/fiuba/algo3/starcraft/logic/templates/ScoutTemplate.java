package fiuba.algo3.starcraft.logic.templates;

public class ScoutTemplate extends MuggleTemplate {

	public static ScoutTemplate instance = new ScoutTemplate();

	private ScoutTemplate() {
		value = new Value(300,150);
		constructionTime = 9;
		vision = 7;
		populationQuota = 3;
		life = new Life(100,150);
		transportationQuota = 0;
		damage = new Damage(8,14);
		damageRange = 4;
	}

	public static ScoutTemplate getInstance(){
		return instance;
	}
}
