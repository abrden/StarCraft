package fiuba.algo3.starcraft.view.exceptions;

public class NameIsTaken extends Exception {

	private static final long serialVersionUID = 3462721261418444410L;

	public String getMessage() {
		return "The chosen name is already taken.";
	}
}
