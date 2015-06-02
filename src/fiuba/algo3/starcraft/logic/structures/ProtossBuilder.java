package fiuba.algo3.starcraft.logic.structures;

import java.util.HashMap;
import java.util.LinkedList;

import fiuba.algo3.starcraft.logic.templates.AccesoTemplate;
import fiuba.algo3.starcraft.logic.templates.ArchivosTemplariosTemplate;
import fiuba.algo3.starcraft.logic.templates.NexoMineralTemplate;
import fiuba.algo3.starcraft.logic.templates.PilonTemplate;
import fiuba.algo3.starcraft.logic.templates.PuertoEstelarProtossTemplate;
import fiuba.algo3.starcraft.logic.templates.StructureTemplate;

public class ProtossBuilder extends Builder {

	ProtossBuilder() {
		templates = new LinkedList<StructureTemplate>();
		templates.add(NexoMineralTemplate.getInstance());
		templates.add(PilonTemplate.getInstance());
		templates.add(AccesoTemplate.getInstance());
		templates.add(PuertoEstelarProtossTemplate.getInstance());
		templates.add(ArchivosTemplariosTemplate.getInstance());
		
		dependsOn = new HashMap<String,String>();
		dependsOn.put("Puerto Estelar", "Acceso");
		dependsOn.put("Archivos Templarios", "Puerto Estelar");
	}
}
