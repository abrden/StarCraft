package fiuba.algo3.starcraft.logic.templates;

import fiuba.algo3.starcraft.logic.structures.ConstructionStructure;
import fiuba.algo3.starcraft.logic.structures.StructureID;

public class PuertoEstelarTerranTemplate extends ConstructionTemplate {

        private static PuertoEstelarTerranTemplate instance = new PuertoEstelarTerranTemplate();

        private PuertoEstelarTerranTemplate() {
            value = new Value(150,100);
            constructionTime = 10;
            health = 1300;
        }

        public static PuertoEstelarTerranTemplate getInstance() {
            return instance;
        }
        public ConstructionStructure create() {
            // TODO Resolver tiempo de construccion
            return new ConstructionStructure(new Life(health));
        }

        @Override
        public StructureID getStructureId() {
            return StructureID.ConstructionStructure;
        }
}