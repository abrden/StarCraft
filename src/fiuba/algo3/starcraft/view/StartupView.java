package fiuba.algo3.starcraft.view;

import java.awt.event.ActionEvent;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;

import javax.swing.AbstractButton;
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

import fiuba.algo3.starcraft.logic.game.PlayerSetup;
import fiuba.algo3.starcraft.logic.game.StarCraft;
import fiuba.algo3.starcraft.view.exceptions.ColorIsTaken;
import fiuba.algo3.starcraft.view.exceptions.NameIsTaken;
import fiuba.algo3.starcraft.view.exceptions.NameIsTooShort;

public class StartupView extends JFrame {

	private static final long serialVersionUID = 4626965807904867072L;

	StarCraft game;
	private List<PlayerSetup> setups = new ArrayList<PlayerSetup>();
	int numberOfPlayers;
	
    public StartupView() {
        this.initComponents();
    }
	
	private void startButtonActionPerformed(ActionEvent evt) {
		startPanel.setVisible(false);
		numberOfPlayersPanel.setVisible(true);
        playerSetupPanel.setVisible(false);
    }
	
    private void numberOfPlayersNextButtonActionPerformed(ActionEvent evt) {
    	numberOfPlayers = Integer.parseInt((String) numberOfPlayersOptions.getSelectedItem());
		startPanel.setVisible(false);
		numberOfPlayersPanel.setVisible(false);
        playerSetupPanel.setVisible(true);
    }
	
	private boolean checkPlayerSetup(PlayerSetup newSetup) throws NameIsTaken, ColorIsTaken {
		for (PlayerSetup setup : setups) {
			if (setup.getName() == newSetup.getName())
				throw new NameIsTaken();
			if (setup.getColor() == newSetup.getColor())
				throw new ColorIsTaken();
		} 
		return true;
	}
	
    private String getSelectedButtonText(ButtonGroup buttonGroup) {
    	for (Enumeration<AbstractButton> buttons = buttonGroup.getElements(); buttons.hasMoreElements();) {
    		AbstractButton button = buttons.nextElement();
    		if (button.isSelected()) return button.getText();
    	}
    	return null;
    }
	
	private void playerSetupNextButtonActionPerformed(ActionEvent evt) {
		startPanel.setVisible(false);
		numberOfPlayersPanel.setVisible(false);
        playerSetupPanel.setVisible(true);
		
		String name = nameField.getText();
		String color = this.getSelectedButtonText(colorOption);
		String race = this.getSelectedButtonText(raceOption);
		
		try {
			PlayerSetup setup = new PlayerSetup(name, color, race);
			checkPlayerSetup(setup);
			setups.add(setup);
		} catch (NameIsTooShort | NameIsTaken | ColorIsTaken e) {
			JOptionPane.showMessageDialog(null, e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
		}
		
		if (setups.size() == numberOfPlayers) this.startGame();
		//TODO else mostrar un panel de playeSetup para el proximo jugador
	}
	
	private void startGame() {
		game = new StarCraft(setups);
		// Algo mas??
	}
	
    // Variables declaration //
	//TODO Borrar esa forma horrible de importar
	private javax.swing.JLayeredPane jLayeredPane;
	
	private javax.swing.JPanel startPanel;
	private javax.swing.JPanel numberOfPlayersPanel;
    private javax.swing.JPanel playerSetupPanel;
	
    
    private javax.swing.JButton startButton;
    private javax.swing.JLabel logo;
    
    
    private javax.swing.JLabel howMany;
    private JComboBox numberOfPlayersOptions;
    private javax.swing.JButton numberOfPlayersNextButton;
    
    private javax.swing.JLabel playerSetupTitle;
    
    private javax.swing.JLabel nameLabel;
    private javax.swing.JTextField nameField;
    
    private javax.swing.JLabel colorLabel;
    private javax.swing.ButtonGroup colorOption;
    private javax.swing.JRadioButton blueColorButton;
    private javax.swing.JRadioButton greenColorButton;
    private javax.swing.JRadioButton redColorButton;
    private javax.swing.JRadioButton yellowColorButton;
    
    private javax.swing.JLabel raceLabel;
    private javax.swing.ButtonGroup raceOption;
    private javax.swing.JRadioButton terranButton;
    private javax.swing.JRadioButton protossButton;
    
    private javax.swing.JButton playerSetupNextButton;
    // End of variables declaration //
	
    private void initComponents() {
    	
        raceOption = new ButtonGroup();
        colorOption = new ButtonGroup();
        jLayeredPane = new JLayeredPane();
        startPanel = new JPanel();
        logo = new JLabel();
        startButton = new JButton();
        numberOfPlayersPanel = new JPanel();
        howMany = new JLabel();
        numberOfPlayersOptions = new JComboBox();
        numberOfPlayersNextButton = new JButton();
        playerSetupPanel = new JPanel();
        nameField = new JTextField();
        playerSetupNextButton = new JButton();
        nameLabel = new JLabel();
        colorLabel = new JLabel();
        raceLabel = new JLabel();
        redColorButton = new JRadioButton();
        blueColorButton = new JRadioButton();
        yellowColorButton = new JRadioButton();
        greenColorButton = new JRadioButton();
        protossButton = new JRadioButton();
        terranButton = new JRadioButton();
        playerSetupTitle = new JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        String pathToImage = "fiuba/algo3/starcraft/presets/StarCraft.png";
        ImageIcon icon = new ImageIcon(getClass().getClassLoader().getResource(pathToImage));
        logo.setIcon(icon);

        startButton.setText("Start");
        startButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                startButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout startPanelLayout = new javax.swing.GroupLayout(startPanel);
        startPanel.setLayout(startPanelLayout);
        startPanelLayout.setHorizontalGroup(
            startPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(startPanelLayout.createSequentialGroup()
                .addGroup(startPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(startPanelLayout.createSequentialGroup()
                        .addGap(38, 38, 38)
                        .addComponent(logo))
                    .addGroup(startPanelLayout.createSequentialGroup()
                        .addGap(212, 212, 212)
                        .addComponent(startButton)))
                .addContainerGap(49, Short.MAX_VALUE))
        );
        startPanelLayout.setVerticalGroup(
            startPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(startPanelLayout.createSequentialGroup()
                .addGap(77, 77, 77)
                .addComponent(logo)
                .addGap(37, 37, 37)
                .addComponent(startButton)
                .addContainerGap(82, Short.MAX_VALUE))
        );

        howMany.setText("How many players?");

        numberOfPlayersOptions.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "2", "3", "4" }));
        /*
        numberOfPlayersOptions.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                numberOfPlayersOptionsActionPerformed(evt);
            }
        });
        */

        numberOfPlayersNextButton.setText("Next");
        numberOfPlayersNextButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                numberOfPlayersNextButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout numberOfPlayersPanelLayout = new javax.swing.GroupLayout(numberOfPlayersPanel);
        numberOfPlayersPanel.setLayout(numberOfPlayersPanelLayout);
        numberOfPlayersPanelLayout.setHorizontalGroup(
            numberOfPlayersPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(numberOfPlayersPanelLayout.createSequentialGroup()
                .addGroup(numberOfPlayersPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(numberOfPlayersPanelLayout.createSequentialGroup()
                        .addGap(171, 171, 171)
                        .addComponent(howMany))
                    .addGroup(numberOfPlayersPanelLayout.createSequentialGroup()
                        .addGap(213, 213, 213)
                        .addGroup(numberOfPlayersPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(numberOfPlayersNextButton)
                            .addComponent(numberOfPlayersOptions, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(176, Short.MAX_VALUE))
        );
        numberOfPlayersPanelLayout.setVerticalGroup(
            numberOfPlayersPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(numberOfPlayersPanelLayout.createSequentialGroup()
                .addGap(71, 71, 71)
                .addComponent(howMany)
                .addGap(34, 34, 34)
                .addComponent(numberOfPlayersOptions, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(28, 28, 28)
                .addComponent(numberOfPlayersNextButton)
                .addContainerGap(82, Short.MAX_VALUE))
        );

        nameField.setText("Type your name");
        nameField.setToolTipText("");

        playerSetupNextButton.setText("Next");
        playerSetupNextButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
            	playerSetupNextButtonActionPerformed(evt);
            }
        });

        nameLabel.setText("Name:");

        colorLabel.setText("Color:");

        raceLabel.setText("Race:");

        colorOption.add(redColorButton);
        redColorButton.setText("Red");

        colorOption.add(blueColorButton);
        blueColorButton.setText("Blue");

        colorOption.add(yellowColorButton);
        yellowColorButton.setText("Yellow");

        colorOption.add(greenColorButton);
        greenColorButton.setText("Green");

        raceOption.add(protossButton);
        protossButton.setText("Protoss");

        raceOption.add(terranButton);
        terranButton.setText("Terran");

        playerSetupTitle.setFont(new java.awt.Font("Ubuntu", 0, 36)); // NOI18N
        playerSetupTitle.setText("Player X options");

        javax.swing.GroupLayout playerSetupPanelLayout = new javax.swing.GroupLayout(playerSetupPanel);
        playerSetupPanel.setLayout(playerSetupPanelLayout);
        playerSetupPanelLayout.setHorizontalGroup(
            playerSetupPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, playerSetupPanelLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(playerSetupNextButton)
                .addContainerGap())
            .addGroup(playerSetupPanelLayout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addGroup(playerSetupPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(playerSetupPanelLayout.createSequentialGroup()
                        .addGroup(playerSetupPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(playerSetupPanelLayout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 69, Short.MAX_VALUE)
                                .addComponent(playerSetupTitle))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, playerSetupPanelLayout.createSequentialGroup()
                                .addComponent(nameLabel)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(colorLabel)
                                .addGap(93, 93, 93)
                                .addComponent(raceLabel)))
                        .addGap(116, 116, 116))
                    .addGroup(playerSetupPanelLayout.createSequentialGroup()
                        .addComponent(nameField, javax.swing.GroupLayout.PREFERRED_SIZE, 136, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(38, 38, 38)
                        .addGroup(playerSetupPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(yellowColorButton)
                            .addComponent(blueColorButton)
                            .addComponent(greenColorButton)
                            .addComponent(redColorButton))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(playerSetupPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(protossButton)
                            .addComponent(terranButton))
                        .addGap(62, 62, 62))))
        );
        playerSetupPanelLayout.setVerticalGroup(
            playerSetupPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, playerSetupPanelLayout.createSequentialGroup()
                .addGroup(playerSetupPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(playerSetupPanelLayout.createSequentialGroup()
                        .addGap(122, 122, 122)
                        .addComponent(nameLabel)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(nameField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(playerSetupPanelLayout.createSequentialGroup()
                        .addGap(40, 40, 40)
                        .addComponent(playerSetupTitle, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(playerSetupPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(playerSetupPanelLayout.createSequentialGroup()
                                .addGap(38, 38, 38)
                                .addComponent(raceLabel)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(protossButton)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(terranButton))
                            .addGroup(playerSetupPanelLayout.createSequentialGroup()
                                .addGap(40, 40, 40)
                                .addComponent(colorLabel)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(redColorButton)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(blueColorButton, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(yellowColorButton)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(greenColorButton)))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(playerSetupNextButton)
                .addContainerGap())
        );

        javax.swing.GroupLayout jLayeredPaneLayout = new javax.swing.GroupLayout(jLayeredPane);
        jLayeredPane.setLayout(jLayeredPaneLayout);
        jLayeredPaneLayout.setHorizontalGroup(
            jLayeredPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(numberOfPlayersPanel, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jLayeredPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(startPanel, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(jLayeredPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(playerSetupPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jLayeredPaneLayout.setVerticalGroup(
            jLayeredPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(numberOfPlayersPanel, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jLayeredPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(startPanel, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(jLayeredPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(playerSetupPanel, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jLayeredPane.setLayer(startPanel, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane.setLayer(numberOfPlayersPanel, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane.setLayer(playerSetupPanel, javax.swing.JLayeredPane.DEFAULT_LAYER);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLayeredPane)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLayeredPane)
        );

        pack();
    }
    
	/*
	JFrame frame = new JFrame("StarCraft");
	
	JPanel startPanel;
	JPanel playersQuantity;
	JPanel playerSetup;
	static final String[] PLAYER_QUANTITY_OPTIONS = {"2", "3", "4"};
	
	public int playersQuantity() {
		frame.setContentPane(playersQuantity);
		frame.validate();
        return Integer.parseInt((String) JOptionPane.showInputDialog(
                playersQuantity,
                "Select number of players",
                "Select number of players",
                JOptionPane.PLAIN_MESSAGE,
                null,
                PLAYER_QUANTITY_OPTIONS,
                PLAYER_QUANTITY_OPTIONS[0]));
	}

	public PlayerSetup playerSetup(int playerNumber) {
		frame.setContentPane(playerSetup);
		frame.validate();
		return null;
	}

	public PlayerSetup newPlayerSetupDueToError(String message, int playerNumber) {
		this.showMessage(message);
		return this.playerSetup(playerNumber);
	}

	private void showMessage(String message) {
		JOptionPane.showMessageDialog(frame, message, "Error", JOptionPane.ERROR_MESSAGE);
		// mostrarle al jugador un mensaje de error en una popup window
	}

	*/
    
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(StartupView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(StartupView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(StartupView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(StartupView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new StartupView().setVisible(true);
            }
        });
    }
}
