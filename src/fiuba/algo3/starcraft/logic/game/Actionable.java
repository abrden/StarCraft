package fiuba.algo3.starcraft.logic.game;

public interface Actionable {

	public Iterable<ActionID> getActions();
	
	public boolean hasOwner();
}
