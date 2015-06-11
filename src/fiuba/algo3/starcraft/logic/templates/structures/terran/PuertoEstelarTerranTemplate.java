package fiuba.algo3.starcraft.logic.templates.structures.terran;

import java.util.LinkedList;

import fiuba.algo3.starcraft.logic.map.Point;
import fiuba.algo3.starcraft.logic.structures.ConstructionStructure;
import fiuba.algo3.starcraft.logic.templates.qualities.Life;
import fiuba.algo3.starcraft.logic.templates.qualities.Value;
import fiuba.algo3.starcraft.logic.templates.structures.ConstructionTemplate;
import fiuba.algo3.starcraft.logic.templates.units.UnitTemplate;
import fiuba.algo3.starcraft.logic.templates.units.terran.EspectroTemplate;
import fiuba.algo3.starcraft.logic.templates.units.terran.NaveCienciaTemplate;
import fiuba.algo3.starcraft.logic.templates.units.terran.NaveTransporteTerranTemplate;

public class PuertoEstelarTerranTemplate extends ConstructionTemplate {

    public PuertoEstelarTerranTemplate() {
        name = "Puerto Estelar";
        value = new Value(150,100);
        constructionTime = 10;
        health = 1300;
        enabledTemplates = new LinkedList<UnitTemplate>();
        enabledTemplates.add(new EspectroTemplate());
        enabledTemplates.add(new NaveTransporteTerranTemplate());
        enabledTemplates.add(new NaveCienciaTemplate());
        }

    public ConstructionStructure create(Point position) {
        return new ConstructionStructure(name, new Life(health), position, enabledTemplates);
        }
}