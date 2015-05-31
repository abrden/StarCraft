package fiuba.algo3.starcraft.logic.templates;

public class MarineTemplate extends MuggleTemplate {

	private static MarineTemplate instance = null;

	private MarineTemplate() {
		value = new Value(50,0);
		constructionTime = 3;
		vision = 7;
		populationQuota = 1;
		health = 40;
		transportationQuota = 1;
		damage = new Damage(6,6);
		damageRange = 4;
	}

	public static MarineTemplate getInstance(){
		if (instance == null){
			instance = new MarineTemplate();
		}
		return instance;
	}


}
