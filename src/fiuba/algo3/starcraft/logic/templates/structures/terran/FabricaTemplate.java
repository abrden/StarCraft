package fiuba.algo3.starcraft.logic.templates.structures.terran;

import java.util.LinkedList;

import fiuba.algo3.starcraft.logic.map.Point;
import fiuba.algo3.starcraft.logic.structures.ConstructionStructure;
import fiuba.algo3.starcraft.logic.templates.qualities.Life;
import fiuba.algo3.starcraft.logic.templates.qualities.Value;
import fiuba.algo3.starcraft.logic.templates.structures.ConstructionTemplate;
import fiuba.algo3.starcraft.logic.templates.units.UnitTemplate;
import fiuba.algo3.starcraft.logic.templates.units.terran.GolliatTemplate;

public class FabricaTemplate extends ConstructionTemplate {

    private static FabricaTemplate instance = new FabricaTemplate();

    private FabricaTemplate() {
        name = "Fabrica";
        value = new Value(200,100);
        constructionTime = 12;
        health = 1250;

		enabledTemplates = new LinkedList<UnitTemplate>();
		enabledTemplates.add(GolliatTemplate.getInstance());
    }

    public static FabricaTemplate getInstance() {
        return instance;
    }
    public ConstructionStructure create(Point position) {
        return new ConstructionStructure(name, new Life(health), position, enabledTemplates);
    }
}
