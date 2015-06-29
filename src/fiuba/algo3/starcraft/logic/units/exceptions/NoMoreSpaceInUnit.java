package fiuba.algo3.starcraft.logic.units.exceptions;


public class NoMoreSpaceInUnit extends Exception {

	private static final long serialVersionUID = 2826306346326043857L;

	public String getMessage() {
		return "There is no space in the transportation unit.";
	}
}
