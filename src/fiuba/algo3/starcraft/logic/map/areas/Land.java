package fiuba.algo3.starcraft.logic.map.areas;

import java.util.ArrayList;
import java.util.List;

import fiuba.algo3.starcraft.logic.game.ActionID;
import fiuba.algo3.starcraft.logic.map.Extractable;
import fiuba.algo3.starcraft.logic.map.exceptions.NoResourcesToExtract;
import fiuba.algo3.starcraft.logic.map.resources.ExtractableType;
import fiuba.algo3.starcraft.logic.map.resources.Mine;
import fiuba.algo3.starcraft.logic.map.resources.ReservoirType;
import fiuba.algo3.starcraft.logic.map.resources.Volcano;
import fiuba.algo3.starcraft.logic.units.Unit;
import fiuba.algo3.starcraft.view.DrawableView;

public class Land extends Surface {
	
	private Extractable extractableSurface;

	public Land(ReservoirType reservoir) {
		this.setExtractableSurface(reservoir);
	}
	
	public Land() {
	}
	
	private void setExtractableSurface(ReservoirType reservoir) {
		switch (reservoir) {	
		case volcano : 
			extractableSurface = new Volcano();		
			break;
		case mine :
			extractableSurface = new Mine();
			break;
		}
	}
	
	public boolean letPass(Unit unit) {
		return true;
	}

	public ExtractableType extractResource() throws NoResourcesToExtract {
		if (extractableSurface != null) return extractableSurface.extractResource();
		else return null;
	}

	@Override
	public void setDrawableView(DrawableView drawableView) {
		String imageToPresent = "land.jpg";
		if (extractableSurface != null) {
			try {
				switch (extractableSurface.extractResource()) {
				case gas:
					imageToPresent = "volcanoInLand.png";
					break;
				case mineral:
					imageToPresent = "mineInLand.png";
					break;
				}
			} catch (NoResourcesToExtract e) {}
		}
		drawableView.setImageName("MapView/".concat(imageToPresent));
	}

	public Iterable<ActionID> getActions() {
		List<ActionID> actions = new ArrayList<ActionID>();
		actions.add(ActionID.build);
		return actions;
	}
}
