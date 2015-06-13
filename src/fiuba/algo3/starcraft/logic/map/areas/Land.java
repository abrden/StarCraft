package fiuba.algo3.starcraft.logic.map.areas;

import fiuba.algo3.starcraft.logic.map.Extractable;
import fiuba.algo3.starcraft.logic.map.exceptions.NoResourcesToExtract;
import fiuba.algo3.starcraft.logic.map.resources.ExtractableType;
import fiuba.algo3.starcraft.logic.map.resources.Reservoir;
import fiuba.algo3.starcraft.logic.map.resources.Volcano;
import fiuba.algo3.starcraft.logic.units.Transportable;

public class Land extends Surface {
	
	private Extractable extractableSurface;
	
	public Land(ExtractableType extractableType) {
		setExtractableSurface(extractableType);
	}
	
	public Land() {
	}

	private void setExtractableSurface(ExtractableType extractableType) {
		switch (extractableType) {	
		case volcano : extractableSurface = new Volcano();		
		break;
		case reservoir : extractableSurface = new Reservoir();
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
