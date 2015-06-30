package fiuba.algo3.starcraft.logic.map.exceptions;

public class UnitCantGetToDestination extends Exception {

	private static final long serialVersionUID = -7275914178228714955L;

	public String getMessage() {
		return "The unit you moved can't get to it's destination.";
	}
}
