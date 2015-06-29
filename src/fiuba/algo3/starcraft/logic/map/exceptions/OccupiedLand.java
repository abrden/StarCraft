package fiuba.algo3.starcraft.logic.map.exceptions;

public class OccupiedLand extends Exception {

	private static final long serialVersionUID = -1964793891036582864L;

	public String getMessage() {
		return "The chosen land is occupied.";
	}
}
