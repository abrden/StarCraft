package fiuba.algo3.starcraft.logic.structures.builders;

import fiuba.algo3.starcraft.logic.templates.structures.protoss.AccesoTemplate;
import fiuba.algo3.starcraft.logic.templates.structures.protoss.ArchivosTemplariosTemplate;
import fiuba.algo3.starcraft.logic.templates.structures.protoss.AsimiladorTemplate;
import fiuba.algo3.starcraft.logic.templates.structures.protoss.NexoMineralTemplate;
import fiuba.algo3.starcraft.logic.templates.structures.protoss.PilonTemplate;
import fiuba.algo3.starcraft.logic.templates.structures.protoss.PuertoEstelarProtossTemplate;

public class ProtossBuilder extends Builder {

	public ProtossBuilder() {
		templates.add(new NexoMineralTemplate());
		templates.add(new PilonTemplate());
		templates.add(new AsimiladorTemplate());
		templates.add(new AccesoTemplate());
		templates.add(new PuertoEstelarProtossTemplate());
		templates.add(new ArchivosTemplariosTemplate());
		
		dependsOn.put("Puerto Estelar", "Acceso");
		dependsOn.put("Archivos Templarios", "Puerto Estelar");
	}
}
