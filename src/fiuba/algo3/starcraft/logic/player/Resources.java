package fiuba.algo3.starcraft.logic.player;

import fiuba.algo3.starcraft.logic.structures.exceptions.InsufficientResources;

public class Resources {

	private int mineral;
	private int gas;
	
	public Resources(int mineral, int gas) {
		this.mineral = mineral;
		this.gas = gas;
	}
	
	public int getMineral() {
		return mineral;
	}
	
	public int getGas() {
		return gas;
	}

	public void add(int mineral, int gas) {
		this.mineral += mineral;
		this.gas += gas;
	}
	
	public void remove(int mineral, int gas) throws InsufficientResources {
		if((this.mineral >= mineral) && (this.gas >= gas)) {
			this.mineral -= mineral;
			this.gas -= gas;
		}
		else throw new InsufficientResources();
	}

}
