package fiuba.algo3.starcraft.logic.units.exceptions;


public class UnitAlreadyMovedThisTurn extends Throwable {

    public String getMessage() {
        return "This unit already moved this turn";
    }
}
