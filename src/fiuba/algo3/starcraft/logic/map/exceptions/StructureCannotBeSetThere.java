package fiuba.algo3.starcraft.logic.map.exceptions;

public class StructureCannotBeSetThere extends Exception {

	private static final long serialVersionUID = -70307555590663341L;

	public String getMessage() {
		return "The parcel you chose to build this structure is not valid.";
	}
}
