package fiuba.algo3.starcraft.logic.structures;

import java.util.Collection;

import fiuba.algo3.starcraft.logic.player.Resources;
import fiuba.algo3.starcraft.logic.templates.StructureTemplate;
import fiuba.algo3.starcraft.logic.templates.TemplateID;

public abstract class Builder {

	protected Collection<StructureTemplate> templates;
	
	//Puede recibir la coleccion o quizas recordar las cosas que ya construyo? No? pueden morir todas y ya no ser correcto?
	public abstract Structure create(TemplateID id, Resources resources, Collection<Structure> built);
	
	//private abstract boolean structureNeededExists(Collection<Structure> built);
	
}
