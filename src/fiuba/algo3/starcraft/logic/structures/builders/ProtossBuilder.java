package fiuba.algo3.starcraft.logic.structures.builders;

import fiuba.algo3.starcraft.logic.templates.structures.protoss.AccesoTemplate;
import fiuba.algo3.starcraft.logic.templates.structures.protoss.ArchivosTemplariosTemplate;
import fiuba.algo3.starcraft.logic.templates.structures.protoss.AsimiladorTemplate;
import fiuba.algo3.starcraft.logic.templates.structures.protoss.NexoMineralTemplate;
import fiuba.algo3.starcraft.logic.templates.structures.protoss.PilonTemplate;
import fiuba.algo3.starcraft.logic.templates.structures.protoss.PuertoEstelarProtossTemplate;

public class ProtossBuilder extends Builder {

	public ProtossBuilder() {
		addTemplate(new NexoMineralTemplate());
		addTemplate(new PilonTemplate());
		addTemplate(new AsimiladorTemplate());
		addTemplate(new AccesoTemplate());
		addTemplate(new PuertoEstelarProtossTemplate());
		addTemplate(new ArchivosTemplariosTemplate());
		
		addDependency("Puerto Estelar", "Acceso");
		addDependency("Archivos Templarios", "Puerto Estelar");
	}
}
