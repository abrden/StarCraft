package fiuba.algo3.starcraft.logic.templates;

public class GolliatTemplate extends MuggleTemplate {
	
	GolliatTemplate() {
		value = new Value(100,50);
		constructionTime = 6;
		vision = 8;
		populationQuota = 2;
		life = new Life(125);
		transportationQuota = 2;
		damage = new Damage(12,10);
		damageRange = 6; //TODO: ARREGLAR ESTO, TIENE DANO POR AIRES TAMBIEN!
	}

}
