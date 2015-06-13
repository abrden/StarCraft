package fiuba.algo3.starcraft.logic.map;

import fiuba.algo3.starcraft.logic.map.exceptions.NoResourcesToExtract;
import fiuba.algo3.starcraft.logic.map.resources.ExtractableType;

public interface Extractable {
	public ExtractableType extractResource() throws NoResourcesToExtract;
}
