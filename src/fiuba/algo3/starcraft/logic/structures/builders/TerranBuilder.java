package fiuba.algo3.starcraft.logic.structures.builders;

import fiuba.algo3.starcraft.logic.templates.structures.terran.BarracaTemplate;
import fiuba.algo3.starcraft.logic.templates.structures.terran.CentroMineralTemplate;
import fiuba.algo3.starcraft.logic.templates.structures.terran.DepositoSuministroTemplate;
import fiuba.algo3.starcraft.logic.templates.structures.terran.FabricaTemplate;
import fiuba.algo3.starcraft.logic.templates.structures.terran.PuertoEstelarTerranTemplate;
import fiuba.algo3.starcraft.logic.templates.structures.terran.RefineriaTemplate;

public class TerranBuilder extends Builder {
	
	public TerranBuilder() {
		templates.add(new CentroMineralTemplate());
		templates.add(new FabricaTemplate());
		templates.add(new BarracaTemplate());
		templates.add(new DepositoSuministroTemplate());
		templates.add(new RefineriaTemplate());
		templates.add(new PuertoEstelarTerranTemplate());
		
		dependsOn.put("Fabrica", "Barraca");
		dependsOn.put("Puerto Estelar", "Fabrica");
	}
}
