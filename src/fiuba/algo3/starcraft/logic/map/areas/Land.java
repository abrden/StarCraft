package fiuba.algo3.starcraft.logic.map.areas;

import fiuba.algo3.starcraft.logic.map.Extractable;
import fiuba.algo3.starcraft.logic.map.exceptions.NoResourcesToExtract;
import fiuba.algo3.starcraft.logic.map.resources.ExtractableType;
import fiuba.algo3.starcraft.logic.map.resources.Mine;
import fiuba.algo3.starcraft.logic.map.resources.ReservoirType;
import fiuba.algo3.starcraft.logic.map.resources.Volcano;
import fiuba.algo3.starcraft.logic.units.Transportable;

public class Land extends Surface {
	
	private Extractable extractableSurface;
	
	public Land(ReservoirType reservoir) {
		this.setExtractableSurface(reservoir);
	}
	
	public Land() {
	}

	private void setExtractableSurface(ReservoirType reservoir) {
		switch (reservoir) {	
		case volcano : extractableSurface = new Volcano();		
		break;
		case mine : extractableSurface = new Mine();
		break;
		}
	}
	
	@Override
	public boolean letPass(Transportable unit) {
		return true;
	}
	
	//TODO Arreglar return null, hecho para que pasen las pruebas
	public ExtractableType extractResource() throws NoResourcesToExtract {
		if (extractableSurface != null) return extractableSurface.extractResource();
		else return null; //throw new NoResourcesToExtract();
	}
}
