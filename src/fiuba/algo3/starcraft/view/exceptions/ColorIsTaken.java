package fiuba.algo3.starcraft.view.exceptions;

public class ColorIsTaken extends Exception {

	private static final long serialVersionUID = -1994068251119495778L;

	public String getMessage() {
		return "The chosen color is already taken.";
	}
}
