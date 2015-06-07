package fiuba.algo3.starcraft.logic.structures.builders;

import fiuba.algo3.starcraft.logic.templates.structures.terran.BarracaTemplate;
import fiuba.algo3.starcraft.logic.templates.structures.terran.CentroMineralTemplate;
import fiuba.algo3.starcraft.logic.templates.structures.terran.DepositoSuministroTemplate;
import fiuba.algo3.starcraft.logic.templates.structures.terran.FabricaTemplate;
import fiuba.algo3.starcraft.logic.templates.structures.terran.PuertoEstelarTerranTemplate;
import fiuba.algo3.starcraft.logic.templates.structures.terran.RefineriaTemplate;

public class TerranBuilder extends Builder {
	
	private static TerranBuilder instance = new TerranBuilder();
	
	TerranBuilder() {
		templates.add(CentroMineralTemplate.getInstance());
		templates.add(FabricaTemplate.getInstance());
		templates.add(BarracaTemplate.getInstance());
		templates.add(DepositoSuministroTemplate.getInstance());
		templates.add(RefineriaTemplate.getInstance());
		templates.add(PuertoEstelarTerranTemplate.getInstance());
		
		dependsOn.put("Fabrica", "Barraca");
		dependsOn.put("Puerto Estelar", "Fabrica");
	}
	
	public static TerranBuilder getInstance() {
		return instance;
	}

}
