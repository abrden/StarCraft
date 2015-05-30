package fiuba.algo3.starcraft.logic.templates;

public class MarineTemplate extends MuggleTemplate {
	
	MarineTemplate() {
		value = new Value(50,0);
		constructionTime = 3;
		vision = 7;
		populationQuota = 1;
		life = new Life(40);
		transportationQuota = 1;
		damage = new Damage(6,6);
		damageRange = 4;
	}
}
