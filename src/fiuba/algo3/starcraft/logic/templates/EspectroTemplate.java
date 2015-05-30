package fiuba.algo3.starcraft.logic.templates;

public class EspectroTemplate extends MuggleTemplate {

	EspectroTemplate() {
		value = new Value(150,100);
		constructionTime = 8;
		vision = 7;
		populationQuota = 2;
		life = new Life(120);
		transportationQuota = 0;
		damage = new Damage(8,20);
		damageRange = 5;
	}
}
