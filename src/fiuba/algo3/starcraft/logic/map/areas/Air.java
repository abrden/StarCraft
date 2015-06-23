package fiuba.algo3.starcraft.logic.map.areas;

import fiuba.algo3.starcraft.logic.map.exceptions.NoResourcesToExtract;
import fiuba.algo3.starcraft.logic.map.resources.ExtractableType;
import fiuba.algo3.starcraft.logic.units.Unit;
import fiuba.algo3.starcraft.view.DrawableView;

public class Air extends Surface {
	
	@Override
	public boolean letPass(Unit unit) {
		return unit.canFly();
	}

	@Override
	public ExtractableType extractResource() throws NoResourcesToExtract {
		throw new NoResourcesToExtract();
	}

	@Override
	public void setDrawableView(DrawableView drawableView) {
		drawableView.setImageName("space3.jpg");
	}
}
