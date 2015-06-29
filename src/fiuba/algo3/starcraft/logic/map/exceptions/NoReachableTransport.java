package fiuba.algo3.starcraft.logic.map.exceptions;

public class NoReachableTransport extends Exception {

	private static final long serialVersionUID = 4740519779294216923L;

	public String getMessage() {
		return "There's no transport reachable from the unit's position.";
	}
}
