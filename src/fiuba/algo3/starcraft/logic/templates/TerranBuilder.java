package fiuba.algo3.starcraft.logic.templates;

import fiuba.algo3.starcraft.logic.structures.StructureID;

public class TerranBuilder extends Builder {
	
	public static TerranBuilder instance = new TerranBuilder();
	
	private TerranBuilder() {
		templates.add(DepositoSuministroTemplate.getInstance());
		templates.add(BarracaTemplate.getInstance());
		templates.add(FabricaTemplate.getInstance());
		templates.add(PuertoEstelarTemplate.getInstance());
		templates.add(CentroMineralTemplate.getInstance());
		templates.add(RefineriaTemplate.getInstance());
	}
	
	public static TerranBuilder getInstance(){
		return instance;
	}

}
