package fiuba.algo3.starcraft.logic.structures.exceptions;

public class ConstructionNotFinished extends Exception {

	private static final long serialVersionUID = -5078480555698441478L;

	public String getMessage() {
		return "The construction you are trying to release is not finished.";
	}
}
