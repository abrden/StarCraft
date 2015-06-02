package fiuba.algo3.starcraft.logic.templates.units.terran;

import fiuba.algo3.starcraft.logic.templates.qualities.Life;
import fiuba.algo3.starcraft.logic.templates.qualities.Value;
import fiuba.algo3.starcraft.logic.templates.units.TransportTemplate;
import fiuba.algo3.starcraft.logic.units.TransportUnit;

public class NaveTransporteTerranTemplate extends TransportTemplate {

    private static NaveTransporteTerranTemplate instance = new NaveTransporteTerranTemplate();

    private NaveTransporteTerranTemplate() {
        name = "Nave Transporte";
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
    	return new TransportUnit(name, new Life(health, shield), vision, populationQuota, capacity);
    }
       
}