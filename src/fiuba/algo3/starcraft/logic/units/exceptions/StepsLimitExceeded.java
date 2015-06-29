package fiuba.algo3.starcraft.logic.units.exceptions;


public class StepsLimitExceeded extends Exception {

	private static final long serialVersionUID = 640003851089904999L;
	
	public String getMessage() {
		return "The steps per turn limit has been exceeded.";
	}
}
