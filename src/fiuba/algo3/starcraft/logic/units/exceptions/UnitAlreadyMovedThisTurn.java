package fiuba.algo3.starcraft.logic.units.exceptions;


public class UnitAlreadyMovedThisTurn extends Throwable {

	private static final long serialVersionUID = 1L;

	public String getMessage() {
        return "This unit already moved this turn.";
    }
}
