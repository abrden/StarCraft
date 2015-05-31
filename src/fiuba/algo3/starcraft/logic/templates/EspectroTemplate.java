package fiuba.algo3.starcraft.logic.templates;

public class EspectroTemplate extends MuggleTemplate {

	public static EspectroTemplate instance = null;

	private EspectroTemplate() {
		value = new Value(150,100);
		constructionTime = 8;
		vision = 7;
		populationQuota = 2;
		health = 120;
		transportationQuota = 0;
		damage = new Damage(8,20);
		damageRange = 5;
	}

	public static EspectroTemplate getInstance(){
		if (instance == null){
			instance = new EspectroTemplate();
		}
		return instance;
	}
}
