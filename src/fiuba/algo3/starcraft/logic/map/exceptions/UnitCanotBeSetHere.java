package fiuba.algo3.starcraft.logic.map.exceptions;


public class UnitCanotBeSetHere extends Throwable {

	private static final long serialVersionUID = -6909362486390725492L;

	public String getMessage() {
		return "The unit can't stand on the chosen surface.";
	}
}
