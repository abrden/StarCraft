package fiuba.algo3.starcraft.logic.units.exceptions;

public class InsufficientEnergy extends Exception {

	private static final long serialVersionUID = 3072635324580993434L;

	public String getMessage() {
		return "The unit's energy is insufficient.";
	}
}
