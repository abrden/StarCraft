package fiuba.algo3.starcraft.view;

import java.awt.event.ActionEvent;

import javax.swing.JButton;
import javax.swing.JPanel;

public class ActionsView extends JPanel {

	private static final long serialVersionUID = 1L;
	
	private JButton move; //Pide un punto del mapa
	private JButton usePower; //Lleva a otro panel con botones para cada poder
	private JButton buildStructure; //Lleva a otro panel con botones para cada estructura
	private JButton createUnit; //Lleva a otro panel con botones para cada unidad
	private JButton embark; //Lleva a otro panel con botones para cada unidad fuera pero dentro del radio de vision
	private JButton disembark; //Lleva a otro panel con botones para cada unidad dentro
	
	private void moveButtonActionPerformed(ActionEvent evt) {
		
	}
	
	private void usePowerButtonActionPerformed(ActionEvent evt) {
		
	}
	
	private void buildStructureButtonActionPerformed(ActionEvent evt) {
		
	}
	
	private void createUnitButtonActionPerformed(ActionEvent evt) {
		
	}
	
	private void embarkButtonActionPerformed(ActionEvent evt) {
		
	}
	
	private void disembarkButtonActionPerformed(ActionEvent evt) {
		
	}
	
	public void enableMuggleUnitOptions() {
		move.setEnabled(true);
		usePower.setEnabled(false);
		buildStructure.setEnabled(false);
		createUnit.setEnabled(false);
		embark.setEnabled(false);
		disembark.setEnabled(false);
	}
	
	public void enableMagicalUnitOptions() {
		move.setEnabled(true);
		usePower.setEnabled(true);
		buildStructure.setEnabled(false);
		createUnit.setEnabled(false);
		embark.setEnabled(false);
		disembark.setEnabled(false);
	}

	public void enableTransportUnitOptions() {
		move.setEnabled(true);
		usePower.setEnabled(false);
		buildStructure.setEnabled(false);
		createUnit.setEnabled(false);
		embark.setEnabled(true);
		disembark.setEnabled(true);
	}
	
	public void enableMapOptions() {
		move.setEnabled(false);
		usePower.setEnabled(false);
		buildStructure.setEnabled(true);
		createUnit.setEnabled(false);
		embark.setEnabled(false);
		disembark.setEnabled(false);
	}
	
	public void enableStructureOptions() {
		move.setEnabled(false);
		usePower.setEnabled(false);
		buildStructure.setEnabled(false);
		createUnit.setEnabled(true);
		embark.setEnabled(false);
		disembark.setEnabled(false);
	}
}
