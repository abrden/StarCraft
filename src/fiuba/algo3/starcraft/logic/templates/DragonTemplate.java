package fiuba.algo3.starcraft.logic.templates;

public class DragonTemplate extends MuggleTemplate {

	DragonTemplate() {
		value = new Value(125,50);
		constructionTime = 6;
		vision = 8;
		populationQuota = 2;
		life = new Life(80,100);
		transportationQuota = 4;
		damage = new Damage(20,20);
		damageRange = 4;
	}
}
