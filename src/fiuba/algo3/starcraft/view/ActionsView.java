package fiuba.algo3.starcraft.view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import fiuba.algo3.starcraft.game.ActionID;
import fiuba.algo3.starcraft.game.Actionable;
import fiuba.algo3.starcraft.game.StarCraft;
import fiuba.algo3.starcraft.logic.map.Parcel;
import fiuba.algo3.starcraft.logic.map.exceptions.NoReachableTransport;
import fiuba.algo3.starcraft.logic.map.exceptions.NoResourcesToExtract;
import fiuba.algo3.starcraft.logic.map.exceptions.UnitCanotBeSetHere;
import fiuba.algo3.starcraft.logic.structures.ConstructionStructure;
import fiuba.algo3.starcraft.logic.structures.exceptions.InsufficientResources;
import fiuba.algo3.starcraft.logic.structures.exceptions.MissingStructureRequired;
import fiuba.algo3.starcraft.logic.structures.exceptions.QuotaExceeded;
import fiuba.algo3.starcraft.logic.structures.exceptions.TemplateNotFound;
import fiuba.algo3.starcraft.logic.units.MagicalUnit;
import fiuba.algo3.starcraft.logic.units.TransportUnit;
import fiuba.algo3.starcraft.logic.units.Transportable;
import fiuba.algo3.starcraft.logic.units.exceptions.NoMoreSpaceInUnit;
import fiuba.algo3.starcraft.logic.units.exceptions.NoUnitToRemove;
import fiuba.algo3.starcraft.logic.units.exceptions.StepsLimitExceeded;

public class ActionsView extends JPanel implements ActionListener {

	private static final long serialVersionUID = 1L;
	
	private StarCraft game;
	private MessageBox messageBox;
	
	private Actionable actionable;
	
	private JButton move = new JButton("Move");
	private JButton usePower = new JButton("Use power");
	private JButton buildStructure = new JButton("Build structure");
	private JButton createUnit = new JButton("Create unit");
	private JButton embark = new JButton("Embark");
	private JButton disembark = new JButton("Disembark");
	private JButton pass = new JButton("PASS TURN");
	
	private boolean performingAction = false;
	
	/*
	ImageIcon move = createImageIcon("");
    ImageIcon usePower = createImageIcon("");
    ImageIcon buildStructure = createImageIcon("");
    ImageIcon createUnit = createImageIcon("");
   	ImageIcon embark = createImageIcon("");
    ImageIcon disembark = createImageIcon("");
    ImageIcon pass = createImageIcon("");
    
    protected static ImageIcon createImageIcon(String path) {
    java.net.URL imgURL = ButtonDemo.class.getResource(path);
    ...//error handling omitted for clarity...
    return new ImageIcon(imgURL);
	}
	*/
	
	ActionsView(StarCraft game, MessageBox messageBox) {
		this.game = game;
		this.messageBox = messageBox;
		
		move.addActionListener(this);
		usePower.addActionListener(this);
		buildStructure.addActionListener(this);
		createUnit.addActionListener(this);
		embark.addActionListener(this);
		disembark.addActionListener(this);
		pass.addActionListener(this);
		
		this.add(move);
		this.add(usePower);
		this.add(buildStructure);
		this.add(createUnit);
		this.add(embark);
		this.add(disembark);
		this.add(pass);
		
		pass.setEnabled(true);
		this.disableActionButtons();
	}
	
    public void actionPerformed(ActionEvent event) {
    	performingAction = true;
    	try {
	        if (event.getSource() == move) {
	        	System.out.println("entre a move");
	        	this.executeMove();
	        } else if (event.getSource() == usePower) {
	        	System.out.println("entre a use power");
	        	this.executeUsePower();
	        } else if (event.getSource() == buildStructure) {
	        	System.out.println("entre a build structure");
	        	this.executeBuildStructure();
	        } else if (event.getSource() == createUnit) {
	        	System.out.println("entre a create unit");
	        	this.executeCreateUnit();
	        } else if (event.getSource() == embark) {
	        	System.out.println("entre a embark");
	        	this.executeEmbark();
	        } else if (event.getSource() == disembark) {
	        	System.out.println("entre a disembark");
	        	this.executeDisembark();
	        } else if (event.getSource() == pass) {
	        	System.out.println("entre a pass turn");
	        	this.executePass();
	        } 
    	} catch (MissingStructureRequired | InsufficientResources
				| TemplateNotFound | NoResourcesToExtract | QuotaExceeded
				| NoMoreSpaceInUnit | StepsLimitExceeded | NoUnitToRemove
				| UnitCanotBeSetHere | NoReachableTransport e) {
    		
    		System.out.println("Hubo una excepcion!" + e.getClass().toString());
			messageBox.displayMessage(e.getMessage());
    	}
    	performingAction = false;
    	disableActionButtons();
    }
    
	private String getSelectedPowerName() {
		String[] powers = ((MagicalUnit) actionable).getPowerNames();
		int n = JOptionPane.showOptionDialog(null,
				"Which power would you like to activate?",
				"Power selection",
				JOptionPane.YES_NO_OPTION,
				JOptionPane.QUESTION_MESSAGE,
				null,     //do not use a custom Icon
				powers,  //the titles of buttons
				powers[0]); //default button title
		return powers[n];
	}
	
	private String getSelectedUnitName() {
		String[] unitsAvaiable = ((ConstructionStructure) actionable).getTemplateNames();
		
		String name = (String) JOptionPane.showInputDialog(
		                    null,
		                    "Which unit would you like to create?",
		                    "Unit selection",
		                    JOptionPane.PLAIN_MESSAGE,
		                    null,     //do not use a custom Icon
		                    unitsAvaiable,
		                    "-");

		return name;
	}
	
	private String getSelectedStructureName() {
		String[] structuresAvaiable = game.getActivePlayer().getBuilder().getTemplateNames();
		
		String name = (String) JOptionPane.showInputDialog(
		                    null,
		                    "Which structure would you like to build?",
		                    "Structure selection",
		                    JOptionPane.PLAIN_MESSAGE,
		                    null,     //do not use a custom Icon
		                    structuresAvaiable,
		                    "-");
		
		return name;
	}
	
	private Transportable getSelectedPassenger(TransportUnit transport) {
		List<Transportable> passengers = transport.getPassengers();
		
		String[] passengerRepresentations = new String[passengers.size()];
		int i = 0;
		for (Transportable passenger : passengers) {
			passengerRepresentations[i] = (passenger.getName() + " - " + Integer.toString(passenger.getHealth())  + " - " + Integer.toString(passenger.getShield()));
			i++;
		}
		
		String[] passengerRepresentation = ((String) JOptionPane.showInputDialog(
		                    null,
		                    "Which unit would you like to disembark?",
		                    "Unit selection",
		                    JOptionPane.PLAIN_MESSAGE,
		                    null,     //do not use a custom Icon
		                    passengerRepresentations,
		                    "-")).split(" - ");

		String name = passengerRepresentation[0];
		int health = Integer.parseInt(passengerRepresentation[1]);
		int shield = Integer.parseInt(passengerRepresentation[2]);
		
		for (Transportable passenger : passengers) {
			if ((name == passenger.getName()) && (health == passenger.getHealth()) && (shield == passenger.getShield()))
				return passenger;
		}
		
		return null;
	}
	
	private void executePass() {
		this.disableActionButtons();
		game.nextTurn();
	}
	
	private void executeDisembark() throws NoUnitToRemove, StepsLimitExceeded, UnitCanotBeSetHere {
		Transportable transportable = this.getSelectedPassenger((TransportUnit) actionable);
		
		if (transportable == null) {
			this.disableActionButtons();
			return;
		}
		
		game.getActivePlayer().disembark((TransportUnit) actionable, transportable);
	}

	private void executeEmbark() throws NoMoreSpaceInUnit, StepsLimitExceeded, NoReachableTransport {
		game.getActivePlayer().embark((Transportable) actionable);
		this.disableActionButtons();
	}

	private void executeCreateUnit() throws InsufficientResources, QuotaExceeded, TemplateNotFound {
		String unitName = this.getSelectedUnitName();
		
		if (unitName == null) {
			this.disableActionButtons();
			return;
		}
		
		game.getActivePlayer().newUnitWithName(unitName, (ConstructionStructure) actionable);
	}

	private void executeBuildStructure() throws MissingStructureRequired, InsufficientResources, TemplateNotFound, NoResourcesToExtract {
		String structureName = this.getSelectedStructureName();
		
		if (structureName == null) {
			this.disableActionButtons();
			return;
		}
		
		game.getActivePlayer().newStructureWithName(structureName, ((Parcel) actionable).getOrigin());
	}

	private void executeUsePower() {
		// TODO Como espero a que el jugador clickee un punto de destino?
		String powerName = this.getSelectedPowerName();
		
		if (powerName == null) {
			this.disableActionButtons();
			return;
		}
		
		//Point position = ;
		//game.getActivePlayer().usePower(actionable, powerName, position);
	}

	private void executeMove() {
		// TODO Como espero a que el jugador clickee un punto de destino?
		//Point destination = ;
		//game.getActivePlayer().move((Unit) actionable, destination);
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
		if (performingAction) 
			return;
		
		disableActionButtons();
		messageBox.clear();
		
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
