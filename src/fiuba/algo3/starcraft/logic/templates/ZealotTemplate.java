package fiuba.algo3.starcraft.logic.templates;

public class ZealotTemplate extends MuggleTemplate {

	public static ZealotTemplate instance = new ZealotTemplate();

	private ZealotTemplate() {
		value = new Value(100,0);
		constructionTime = 4;
		vision = 7;
		populationQuota = 2;
		life = new Life(60,100);
		transportationQuota = 2;
		damage = new Damage(8,0);
		damageRange = 1;
	}

	public static ZealotTemplate getInstance(){
		return instance;
	}

}
