package fiuba.algo3.starcraft.logic.templates.structures.protoss;

import java.util.LinkedList;

import fiuba.algo3.starcraft.logic.structures.ConstructionStructure;
import fiuba.algo3.starcraft.logic.templates.qualities.Life;
import fiuba.algo3.starcraft.logic.templates.qualities.Value;
import fiuba.algo3.starcraft.logic.templates.structures.ConstructionTemplate;
import fiuba.algo3.starcraft.logic.templates.units.UnitTemplate;
import fiuba.algo3.starcraft.logic.templates.units.protoss.AltoTemplarioTemplate;

public class ArchivosTemplariosTemplate extends ConstructionTemplate {

    private static ArchivosTemplariosTemplate instance = new ArchivosTemplariosTemplate();

    private ArchivosTemplariosTemplate() {
        name = "Archivos Templarios";
        value = new Value(150,200);
        constructionTime = 9;
        health = 500;
        shield = 500;
        enabledTemplates = new LinkedList<UnitTemplate>();
		enabledTemplates.add(AltoTemplarioTemplate.getInstance());
    }

    public static ArchivosTemplariosTemplate getInstance() {
        return instance;
    }
    public ConstructionStructure create() {
        return new ConstructionStructure(name, new Life(health, shield), enabledTemplates);
    }
}