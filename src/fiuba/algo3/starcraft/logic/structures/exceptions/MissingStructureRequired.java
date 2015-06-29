package fiuba.algo3.starcraft.logic.structures.exceptions;

public class MissingStructureRequired extends Exception {

	private static final long serialVersionUID = -9178611779914957174L;

	public String getMessage() {
		return "The structure you are trying to build requires an inexistent previous structure.";
	}
}
