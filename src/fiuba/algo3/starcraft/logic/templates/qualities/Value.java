package fiuba.algo3.starcraft.logic.templates.qualities;

public class Value {
	
	private int mineralValue;
	private int gasValue;
	
	public Value(int mineralValue, int gasValue) {
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
