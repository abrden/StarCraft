package fiuba.algo3.starcraft.view.exceptions;

public class PlayerSetupIncomplete extends Exception {

	private static final long serialVersionUID = 6738721041837017499L;

	public String getMessage() {
		return "The player setup is incomplete.";
	}
}
