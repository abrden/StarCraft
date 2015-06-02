package fiuba.algo3.starcraft.logic.structures.builders;

import java.util.HashMap;
import java.util.LinkedList;

import fiuba.algo3.starcraft.logic.templates.structures.StructureTemplate;
import fiuba.algo3.starcraft.logic.templates.structures.protoss.AccesoTemplate;
import fiuba.algo3.starcraft.logic.templates.structures.protoss.ArchivosTemplariosTemplate;
import fiuba.algo3.starcraft.logic.templates.structures.protoss.AsimiladorTemplate;
import fiuba.algo3.starcraft.logic.templates.structures.protoss.NexoMineralTemplate;
import fiuba.algo3.starcraft.logic.templates.structures.protoss.PilonTemplate;
import fiuba.algo3.starcraft.logic.templates.structures.protoss.PuertoEstelarProtossTemplate;

public class ProtossBuilder extends Builder {
	
	private static ProtossBuilder instance = new ProtossBuilder();

	ProtossBuilder() {
		templates = new LinkedList<StructureTemplate>();
		templates.add(NexoMineralTemplate.getInstance());
		templates.add(PilonTemplate.getInstance());
		templates.add(AsimiladorTemplate.getInstance());
		templates.add(AccesoTemplate.getInstance());
		templates.add(PuertoEstelarProtossTemplate.getInstance());
		templates.add(ArchivosTemplariosTemplate.getInstance());
		
		dependsOn = new HashMap<String,String>();
		dependsOn.put("Puerto Estelar", "Acceso");
		dependsOn.put("Archivos Templarios", "Puerto Estelar");
	}
	
	public static ProtossBuilder getInstance() {
		return instance;
	}
}
