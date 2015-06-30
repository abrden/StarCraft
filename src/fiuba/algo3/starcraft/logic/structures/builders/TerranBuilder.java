package fiuba.algo3.starcraft.logic.structures.builders;


import fiuba.algo3.starcraft.logic.templates.structures.terran.BarracaTemplate;
import fiuba.algo3.starcraft.logic.templates.structures.terran.CentroMineralTemplate;
import fiuba.algo3.starcraft.logic.templates.structures.terran.DepositoSuministroTemplate;
import fiuba.algo3.starcraft.logic.templates.structures.terran.FabricaTemplate;
import fiuba.algo3.starcraft.logic.templates.structures.terran.PuertoEstelarTerranTemplate;
import fiuba.algo3.starcraft.logic.templates.structures.terran.RefineriaTemplate;

public class TerranBuilder extends Builder {
	
	public TerranBuilder() {
		addTemplate(new CentroMineralTemplate());
		addTemplate(new FabricaTemplate());
		addTemplate(new BarracaTemplate());
		addTemplate(new DepositoSuministroTemplate());
		addTemplate(new RefineriaTemplate());
		addTemplate(new PuertoEstelarTerranTemplate());
		
		addDependency("Fabrica", "Barraca");
		addDependency("Puerto Estelar Terran", "Fabrica");
	}

    @Override
    public String getRace() {
        return "Terran";
    }
}
