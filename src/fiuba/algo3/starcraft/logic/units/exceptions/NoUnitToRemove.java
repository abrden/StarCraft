package fiuba.algo3.starcraft.logic.units.exceptions;

public class NoUnitToRemove extends Exception{

	private static final long serialVersionUID = 1L;

	public String getMessage() {
		return "Theres no units no remove from the selected transportation unit.";
	}
}
