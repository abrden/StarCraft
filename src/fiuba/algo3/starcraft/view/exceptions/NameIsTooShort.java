package fiuba.algo3.starcraft.view.exceptions;

public class NameIsTooShort extends Exception {

	private static final long serialVersionUID = 1557617266655986705L;

	public String getMessage() {
		return "The player name must be at least four characters long.";
	}
}
