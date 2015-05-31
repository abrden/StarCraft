package fiuba.algo3.starcraft.logic.templates;

public class ZealotTemplate extends MuggleTemplate {

	public static ZealotTemplate instance = new ZealotTemplate();

	private ZealotTemplate() {
		value = new Value(100,0);
		constructionTime = 4;
		vision = 7;
		populationQuota = 2;
		health = 60;
		shield = 100;
		transportationQuota = 2;
		damage = new Damage(8,0);
		damageRange = 1;
	}

	public static ZealotTemplate getInstance(){
		return instance;
	}

}
