package fiuba.algo3.starcraft.logic.templates;

import java.util.LinkedList;

import fiuba.algo3.starcraft.logic.structures.ConstructionStructure;

public class PuertoEstelarTerranTemplate extends ConstructionTemplate {

        private static PuertoEstelarTerranTemplate instance = new PuertoEstelarTerranTemplate();

        private PuertoEstelarTerranTemplate() {
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
        public ConstructionStructure create() {
            // TODO Resolver tiempo de construccion
            return new ConstructionStructure(new Life(health), enabledTemplates);
        }
}