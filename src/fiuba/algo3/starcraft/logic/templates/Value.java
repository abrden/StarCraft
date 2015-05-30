package fiuba.algo3.starcraft.logic.templates;

public class Value {
	
	private int mineralValue;
	private int gasValue;
	
	Value(int mineralValue, int gasValue) {
		this.mineralValue = mineralValue;
		this.gasValue = gasValue;
	}
	
	public int getMineralValue() {
		return mineralValue;
	}
	
	public int getGasValue() {
		return gasValue;
	}

}
