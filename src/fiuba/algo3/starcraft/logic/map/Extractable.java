package fiuba.algo3.starcraft.logic.map;

public interface Extractable {
	public ExtractableType extractResource() throws NoResourcesToExtract;
}
