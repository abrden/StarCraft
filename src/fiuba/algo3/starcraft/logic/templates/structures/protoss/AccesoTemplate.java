package fiuba.algo3.starcraft.logic.templates.structures.protoss;

import java.util.LinkedList;

import fiuba.algo3.starcraft.logic.structures.ConstructionStructure;
import fiuba.algo3.starcraft.logic.templates.qualities.Life;
import fiuba.algo3.starcraft.logic.templates.qualities.Value;
import fiuba.algo3.starcraft.logic.templates.structures.ConstructionTemplate;
import fiuba.algo3.starcraft.logic.templates.units.UnitTemplate;
import fiuba.algo3.starcraft.logic.templates.units.protoss.DragonTemplate;
import fiuba.algo3.starcraft.logic.templates.units.protoss.ZealotTemplate;

public class AccesoTemplate extends ConstructionTemplate {

    private static AccesoTemplate instance = new AccesoTemplate();

    private AccesoTemplate() {
        name = "Acceso";
        value = new Value(150,0);
        constructionTime = 8;
        health = 500;
        shield = 500;
        enabledTemplates = new LinkedList<UnitTemplate>();
        enabledTemplates.add(ZealotTemplate.getInstance());
        enabledTemplates.add(DragonTemplate.getInstance());
    }

    public static AccesoTemplate getInstance() {
        return instance;
    }
    
    public ConstructionStructure create() {
        // TODO Resolver tiempo de construccion
        return new ConstructionStructure(name, new Life(health, shield), enabledTemplates);
    }
}