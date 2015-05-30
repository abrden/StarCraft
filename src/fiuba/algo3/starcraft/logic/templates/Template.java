package fiuba.algo3.starcraft.logic.templates;


public abstract class Template {

	private Value value;
	private int constructionTime;
	private int vision;
	private int populationQuota; //suministro
	private Life life;
	private int transportationQuota; //transporte
	private Damage damage;
	private int damageRange; //TODO: VER COMO HACEMOS CON EL GOLLIAT QUE ES EL UNICO QUE TIENE RANGOS DIFERENTES EN SPACE Y LAND
	
}
