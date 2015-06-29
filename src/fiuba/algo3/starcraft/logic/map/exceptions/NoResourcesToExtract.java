package fiuba.algo3.starcraft.logic.map.exceptions;

public class NoResourcesToExtract extends Exception{
	
	private static final long serialVersionUID = 1L;

	public String getMessage() {
		return "The chosen surface has no resources to extract.";
	}
}
