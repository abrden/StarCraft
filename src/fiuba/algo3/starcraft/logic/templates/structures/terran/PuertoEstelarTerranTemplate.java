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

        private static PuertoEstelarTerranTemplate instance = new PuertoEstelarTerranTemplate();

        private PuertoEstelarTerranTemplate() {
            name = "Puerto Estelar";
            value = new Value(150,100);
            constructionTime = 10;
            health = 1300;
            enabledTemplates = new LinkedList<UnitTemplate>();
            enabledTemplates.add(EspectroTemplate.getInstance());
            enabledTemplates.add(NaveTransporteTerranTemplate.getInstance());
            enabledTemplates.add(NaveCienciaTemplate.getInstance());
        }

        public static PuertoEstelarTerranTemplate getInstance() {
            return instance;
        }
        public ConstructionStructure create(Point position) {
            return new ConstructionStructure(name, new Life(health), position, enabledTemplates);
        }
}