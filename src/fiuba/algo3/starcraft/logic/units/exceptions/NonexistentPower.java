package fiuba.algo3.starcraft.logic.units.exceptions;

public class NonexistentPower extends Exception {

	private static final long serialVersionUID = 4498643284108917547L;

	public String getMessage() {
		return "The power you are trying to execute does not exist.";
	}
}
