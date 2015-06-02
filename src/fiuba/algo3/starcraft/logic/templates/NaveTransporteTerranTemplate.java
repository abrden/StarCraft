package fiuba.algo3.starcraft.logic.templates;

import fiuba.algo3.starcraft.logic.units.TransportUnit;

public class NaveTransporteTerranTemplate extends TransportUnitTemplate {

    private static NaveTransporteTerranTemplate instance = new NaveTransporteTerranTemplate();

    private NaveTransporteTerranTemplate() {
        name = "NaveTransporteTerran";
        value = new Value(100,100);
        constructionTime = 7;
        vision = 8;
        populationQuota = 2;
        health = 150;
        capacity = 8;
    }

    public static NaveTransporteTerranTemplate getInstance() {
        return instance;
    }
    
    public TransportUnit create() {
        // TODO Resolver tiempo de construccion
    	return new TransportUnit(new Life(health, shield), vision, populationQuota, capacity);
    }

	public TemplateID getId() {
		return TemplateID.NaveTransporteTerranTemplate;
	}
       
}