package fiuba.algo3.starcraft.logic.map;

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
	
	public Resource extractResource() throws NoResourcesToExtractException {
		if (extractableSurface != null) {
			return extractableSurface.extractResource();
		} else {
			throw new NoResourcesToExtractException();
		}
	}
}
