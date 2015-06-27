package fiuba.algo3.starcraft.view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;

import fiuba.algo3.starcraft.game.ActionID;
import fiuba.algo3.starcraft.game.Actionable;
import fiuba.algo3.starcraft.game.StarCraft;
import fiuba.algo3.starcraft.logic.map.Parcel;
import fiuba.algo3.starcraft.logic.map.exceptions.UnitCanotBeSetHere;
import fiuba.algo3.starcraft.logic.units.TransportUnit;
import fiuba.algo3.starcraft.logic.units.Transportable;
import fiuba.algo3.starcraft.logic.units.exceptions.NoUnitToRemove;
import fiuba.algo3.starcraft.logic.units.exceptions.StepsLimitExceeded;

public class ActionsView extends JPanel implements ActionListener {

	private static final long serialVersionUID = 1L;
	
	private StarCraft game;
	private Actionable actionable;
	
	private JButton move = new JButton(); //Pide un punto del mapa
	private JButton usePower = new JButton(); //Lleva a otro panel con botones para cada poder
	private JButton buildStructure = new JButton(); //Lleva a otro panel con botones para cada estructura
	private JButton createUnit = new JButton(); //Lleva a otro panel con botones para cada unidad
	private JButton embark = new JButton(); //Lleva a otro panel con botones para cada unidad fuera pero dentro del radio de vision
	private JButton disembark = new JButton(); //Lleva a otro panel con botones para cada unidad dentro
	
	/*
	ImageIcon move = createImageIcon("");
    ImageIcon usePower = createImageIcon("");
    ImageIcon buildStructure = createImageIcon("");
    ImageIcon createUnit = createImageIcon("");
   	ImageIcon embark = createImageIcon("");
    ImageIcon disembark = createImageIcon("");
    
    protected static ImageIcon createImageIcon(String path) {
    java.net.URL imgURL = ButtonDemo.class.getResource(path);
    ...//error handling omitted for clarity...
    return new ImageIcon(imgURL);
	}
	*/
	
	ActionsView(StarCraft game) {
		this.game = game;
		this.add(move);
		this.add(usePower);
		this.add(buildStructure);
		this.add(createUnit);
		this.add(embark);
		this.add(disembark);
	}
	
    public void actionPerformed(ActionEvent event) {
        if (event.getSource() == move) {
        	this.executeMove();
        } else if (event.getSource() == usePower) {
        	this.showPowers();
        } else if (event.getSource() == buildStructure) {
        	this.executeBuildStructure();
        } else if (event.getSource() == createUnit) {
        	this.executeCreateUnit();
        } else if (event.getSource() == embark) {
        	this.executeEmbark();
        } else if (event.getSource() == disembark) {
        	//this.executeDisembark();
        //} else if ((event.getSource())) {
        	
        //	this.executeDisembark(transportable);
        }
    }
    
	private void showPowers() {
		//new PowersOptionView(this.getX(), this.getY(), actionable).setVisible(true);
		
	}

	private void executeDisembark(Transportable transportable) throws NoUnitToRemove, StepsLimitExceeded, UnitCanotBeSetHere {
		game.getActivePlayer().disembark((TransportUnit) actionable, transportable);
		this.disableActionButtons();
	}

	private void executeEmbark() {
		// TODO Auto-generated method stub
		//game.getActivePlayer().embark(transport, actionable);
		this.disableActionButtons();
	}

	private void executeCreateUnit() {
		//TODO actualizar panel con opciones de units a construir
		
		//String name = ;
		//game.getActivePlayer().newUnitWithName(name, actionable);
		this.disableActionButtons();
	}

	private void executeBuildStructure() {
		//TODO actualizar panel con opciones de structuras a construir
		
		//String name = ;
		//game.getActivePlayer().newStructureWithName(name, ((Parcel) actionable).getOrigin());
		this.disableActionButtons();
	}

	private void executeUsePower() {
		// TODO Auto-generated method stub
		this.disableActionButtons();
	}

	private void executeMove() {
		// TODO Como espero a que el jugador clickee un punto de destino?
		
		//Point destination = ;
		//game.getActivePlayer().move((Unit) actionable, destination);
		this.disableActionButtons();
	}
	
	private void enableActionButton(ActionID action) {
		switch (action) {
		case move:
			move.setEnabled(true);
			break;
		case power: 
			usePower.setEnabled(true);
			break;
		case build: 
			buildStructure.setEnabled(true);
			break;
		case create: 
			createUnit.setEnabled(true);
			break;
		case embark: 
			embark.setEnabled(true);
			break;
		case disembark: 
			disembark.setEnabled(true);
			break;
		}
	}
	
	public void showActions(Actionable actionable) {
		this.actionable = actionable;
		
		for(ActionID action : actionable.getActions())
			this.enableActionButton(action);
	}
	
	private void disableActionButtons() {
		move.setEnabled(false);
		usePower.setEnabled(false);
		buildStructure.setEnabled(false);
		createUnit.setEnabled(false);
		embark.setEnabled(false);
		disembark.setEnabled(false);
	}
}
