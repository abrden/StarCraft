package fiuba.algo3.starcraft.view;

import fiuba.algo3.starcraft.game.PlayerSetup;

public class StartupView {

	public int playersQuantity() {
		// TODO preguntar cuantos jugadores hay y devolver la cantidad
		return 0;
	}

	public PlayerSetup playerSetup(int playerNumber) {
		// TODO mostrarle al jugador las opciones nombre, color, raza
		return null;
	}

	public PlayerSetup newPlayerSetupDueToError(String message, int playerNumber) {
		this.showMessage(message);
		return this.playerSetup(playerNumber);
	}

	private void showMessage(String message) {
		// mostrarle al jugador un mensaje de error en una popup window
	}

}
