package fiuba.algo3.starcraft.logic.templates;

import fiuba.algo3.starcraft.logic.units.MuggleUnit;


public class GolliatTemplate extends MuggleTemplate {

	private static GolliatTemplate instance = new GolliatTemplate();

	private GolliatTemplate() {
		name = "Golliat";
		value = new Value(100,50);
		constructionTime = 6;
		vision = 8;
		populationQuota = 2;
		health = 125;
		transportationQuota = 2;
		damage = new Damage(12,10);
		damageRange = 6; //TODO: ARREGLAR ESTO, TIENE DANO POR AIRES TAMBIEN!
	}

	public static GolliatTemplate getInstance(){
		return instance;
	}

	public MuggleUnit create() {
		return new MuggleUnit(new Life(health), vision, attack, transportationQuota, populationQuota);
	}
	
	public TemplateID getId() {
		return TemplateID.GolliatTemplate;
	}

}
