package fiuba.algo3.starcraft.logic.templates.units.protoss;

import fiuba.algo3.starcraft.logic.map.Point;
import fiuba.algo3.starcraft.logic.templates.qualities.Life;
import fiuba.algo3.starcraft.logic.templates.qualities.Value;
import fiuba.algo3.starcraft.logic.templates.units.TransportTemplate;
import fiuba.algo3.starcraft.logic.units.TransportUnit;

public class NaveTransporteProtossTemplate extends TransportTemplate {

    private static NaveTransporteProtossTemplate instance = new NaveTransporteProtossTemplate();

    private NaveTransporteProtossTemplate() {
        name = "Nave Transporte";
        value = new Value(200,0);
        constructionTime = 8;
        vision = 8;
        populationQuota = 2;
        health = 80;
        shield = 60;
        capacity = 8;
        stepsPerTurn = 8;
    }

    public static NaveTransporteProtossTemplate getInstance() {
        return instance;
    }
    
    public TransportUnit create(Point position) {
        return new TransportUnit(name, new Life(health, shield), position, vision, stepsPerTurn, populationQuota, capacity);
    }
}