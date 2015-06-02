package fiuba.algo3.starcraft.logic.structures;

import java.util.HashMap;
import java.util.LinkedList;

import fiuba.algo3.starcraft.logic.templates.BarracaTemplate;
import fiuba.algo3.starcraft.logic.templates.CentroMineralTemplate;
import fiuba.algo3.starcraft.logic.templates.DepositoSuministroTemplate;
import fiuba.algo3.starcraft.logic.templates.FabricaTemplate;
import fiuba.algo3.starcraft.logic.templates.PuertoEstelarTerranTemplate;
import fiuba.algo3.starcraft.logic.templates.RefineriaTemplate;
import fiuba.algo3.starcraft.logic.templates.StructureTemplate;

public class TerranBuilder extends Builder {
	
	private static TerranBuilder instance = new TerranBuilder();
	
	TerranBuilder() {
		templates = new LinkedList<StructureTemplate>();
		templates.add(CentroMineralTemplate.getInstance());
		templates.add(FabricaTemplate.getInstance());
		templates.add(BarracaTemplate.getInstance());
		templates.add(DepositoSuministroTemplate.getInstance());
		templates.add(RefineriaTemplate.getInstance());
		templates.add(PuertoEstelarTerranTemplate.getInstance());
		
		dependsOn = new HashMap<String,String>();
		dependsOn.put("Fabrica", "Barraca");
		dependsOn.put("Puerto Estelar", "Fabrica");
	}
	
	public static TerranBuilder getInstance() {
		return instance;
	}

}
