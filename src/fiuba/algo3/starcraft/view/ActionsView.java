package fiuba.algo3.starcraft.view;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.*;

import fiuba.algo3.starcraft.logic.game.ActionID;
import fiuba.algo3.starcraft.logic.game.Actionable;
import fiuba.algo3.starcraft.logic.game.GameOver;
import fiuba.algo3.starcraft.logic.game.StarCraft;
import fiuba.algo3.starcraft.logic.map.Parcel;
import fiuba.algo3.starcraft.logic.map.Point;
import fiuba.algo3.starcraft.logic.map.exceptions.NoReachableTransport;
import fiuba.algo3.starcraft.logic.map.exceptions.NoResourcesToExtract;
import fiuba.algo3.starcraft.logic.map.exceptions.StructureCannotBeSetHere;
import fiuba.algo3.starcraft.logic.map.exceptions.UnitCannotBeSetHere;
import fiuba.algo3.starcraft.logic.map.exceptions.UnitCantGetToDestination;
import fiuba.algo3.starcraft.logic.player.Player;
import fiuba.algo3.starcraft.logic.structures.ConstructionStructure;
import fiuba.algo3.starcraft.logic.structures.exceptions.InsufficientResources;
import fiuba.algo3.starcraft.logic.structures.exceptions.MissingStructureRequired;
import fiuba.algo3.starcraft.logic.structures.exceptions.QuotaExceeded;
import fiuba.algo3.starcraft.logic.structures.exceptions.TemplateNotFound;
import fiuba.algo3.starcraft.logic.units.MagicalUnit;
import fiuba.algo3.starcraft.logic.units.TransportUnit;
import fiuba.algo3.starcraft.logic.units.Transportable;
import fiuba.algo3.starcraft.logic.units.Unit;
import fiuba.algo3.starcraft.logic.units.exceptions.*;

public class ActionsView extends JPanel implements ActionListener {

	private static final long serialVersionUID = 1L;
	
	private StarCraft game;
	private MessageBox messageBox;
    private PlayerStatusView playerStatusView;
	
	private Actionable actionable;
	
	private JButton move = new JButton("Move", new ImageIcon(getClass().getClassLoader().getResource("fiuba/algo3/starcraft/presets/ActionsView/move.png")));
	private JButton usePower = new JButton("Use power", new ImageIcon(getClass().getClassLoader().getResource("fiuba/algo3/starcraft/presets/ActionsView/power.png")));
	private JButton buildStructure = new JButton("Build structure", new ImageIcon(getClass().getClassLoader().getResource("fiuba/algo3/starcraft/presets/ActionsView/newStructure.png")));
	private JButton createUnit = new JButton("Create unit", new ImageIcon(getClass().getClassLoader().getResource("fiuba/algo3/starcraft/presets/ActionsView/newUnit.png")));
	private JButton embark = new JButton("Embark", new ImageIcon(getClass().getClassLoader().getResource("fiuba/algo3/starcraft/presets/ActionsView/embark.png")));
	private JButton disembark = new JButton("Disembark", new ImageIcon(getClass().getClassLoader().getResource("fiuba/algo3/starcraft/presets/ActionsView/disembark.png")));
	private JButton pass = new JButton("PASS TURN", new ImageIcon(getClass().getClassLoader().getResource("fiuba/algo3/starcraft/presets/ActionsView/next.png")));
	
	private boolean waitingToMove;
	private boolean waitingToExecutePower;

	
	ActionsView(StarCraft game, MessageBox messageBox, PlayerStatusView playerStatusView) {
		move.setVerticalTextPosition(SwingConstants.BOTTOM);
		move.setHorizontalTextPosition(SwingConstants.CENTER);
		move.setBackground(Color.darkGray);
		move.setForeground(Color.WHITE);
		usePower.setVerticalTextPosition(SwingConstants.BOTTOM);
		usePower.setHorizontalTextPosition(SwingConstants.CENTER);
		usePower.setBackground(Color.darkGray);
		usePower.setForeground(Color.WHITE);
		buildStructure.setVerticalTextPosition(SwingConstants.BOTTOM);
		buildStructure.setHorizontalTextPosition(SwingConstants.CENTER);
		buildStructure.setBackground(Color.darkGray);
		buildStructure.setForeground(Color.WHITE);
		createUnit.setVerticalTextPosition(SwingConstants.BOTTOM);
		createUnit.setHorizontalTextPosition(SwingConstants.CENTER);
		createUnit.setBackground(Color.darkGray);
		createUnit.setForeground(Color.WHITE);
		embark.setVerticalTextPosition(SwingConstants.BOTTOM);
		embark.setHorizontalTextPosition(SwingConstants.CENTER);
		embark.setBackground(Color.darkGray);
		embark.setForeground(Color.WHITE);
		disembark.setVerticalTextPosition(SwingConstants.BOTTOM);
		disembark.setHorizontalTextPosition(SwingConstants.CENTER);
		disembark.setBackground(Color.darkGray);
		disembark.setForeground(Color.WHITE);
		pass.setVerticalTextPosition(SwingConstants.BOTTOM);
		pass.setHorizontalTextPosition(SwingConstants.CENTER);
		pass.setBackground(Color.darkGray);
		pass.setForeground(Color.WHITE);
		
		this.game = game;
		this.messageBox = messageBox;
        this.playerStatusView = playerStatusView;
		
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
	        	//System.out.println("entre a pass turn");
	        	this.executePass();
	        } 
    	} catch (MissingStructureRequired | InsufficientResources
				| TemplateNotFound | NoResourcesToExtract | QuotaExceeded
				| NoMoreSpaceInUnit | StepsLimitExceeded | NoUnitToRemove
				| UnitCannotBeSetHere | NoReachableTransport | InsufficientEnergy
				| NonexistentPower | StructureCannotBeSetHere | UnitCantGetToDestination e) {
    		
    		System.out.println("Hubo una excepcion!" + e.getClass().toString());
			messageBox.displayMessage(e.getMessage());
    	
    	} catch (GameOver e) {
    		JOptionPane.showMessageDialog(null, "The winner is " + e.getWinnersName());
    		pass.setEnabled(false);
		}
    	
    	disableActionButtons();
    }
    
    public void setActionPoint(Point destination) throws UnitCantGetToDestination, InsufficientEnergy, NonexistentPower, UnitAlreadyMovedThisTurn {
        if (waitingToMove && actionable.canMove()) {
            try {
                game.getActivePlayer().move((Unit) actionable, destination);
            } catch (UnitCantGetToDestination | UnitAlreadyMovedThisTurn e) {
                e.printStackTrace();
                System.out.println("lalalalal");
                messageBox.displayMessage(e.getMessage());
            }
        }
    	if (waitingToExecutePower) {
    		String powerName = this.getSelectedPowerName();
    		game.getActivePlayer().usePower((MagicalUnit) actionable, powerName, destination);
    	}
    	
    	waitingToMove = false;
    	waitingToExecutePower = false;
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
		
		String passengerRepresentation = ((String) JOptionPane.showInputDialog(
		                    null,
		                    "Which unit would you like to disembark?",
		                    "Unit selection",
		                    JOptionPane.PLAIN_MESSAGE,
		                    null,     //do not use a custom Icon
		                    passengerRepresentations,
		                    "-"));
		
		if (passengerRepresentation == null) return null;
		
		String passengerData[] = passengerRepresentation.split(" - ");

		String name = passengerData[0];
		int health = Integer.parseInt(passengerData[1]);
		int shield = Integer.parseInt(passengerData[2]);

		for (Transportable passenger : passengers) {
			if ((name.equals(passenger.getName())) && (health == passenger.getHealth()) && (shield == passenger.getShield()))
				return passenger;
		}
		
		return null;
	}
	
	private void executePass() throws GameOver {
		this.disableActionButtons();
        waitingToMove = false;
        waitingToExecutePower = false;
		messageBox.clear();
		game.nextTurn();
        playerStatusView.showActivePlayerStatus();
	}
	
	private void executeDisembark() throws NoUnitToRemove, StepsLimitExceeded, UnitCannotBeSetHere {
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
        playerStatusView.showActivePlayerStatus();
    }

	private void executeBuildStructure() throws MissingStructureRequired, InsufficientResources, TemplateNotFound, NoResourcesToExtract, StructureCannotBeSetHere {
		String structureName = this.getSelectedStructureName();
		
		if (structureName == null) {
			this.disableActionButtons();
			return;
		}
		game.getActivePlayer().newStructureWithName(structureName, ((Parcel) actionable).getOrigin());
        playerStatusView.showActivePlayerStatus();

		disableActionButtons();
	}

	private void executeUsePower() throws InsufficientEnergy, NonexistentPower {
		String powerName = this.getSelectedPowerName();
		
		waitingToExecutePower = true;
		
		if (powerName == null) {
			this.disableActionButtons();
			return;
		}
	}

	private void executeMove() throws UnitCantGetToDestination {		
		waitingToMove = true;

	}
	
	private void enableActionButton(ActionID action) {
		if (waitingToMove || waitingToExecutePower) {
			return ;
		}
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
		disableActionButtons();
		messageBox.clear();
		
		Player activePlayer = game.getActivePlayer();		
		if ((actionable.hasOwner() && !activePlayer.actionableIsMine(actionable))) {
			return;
		}
		
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
