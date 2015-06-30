package fiuba.algo3.starcraft.view;

import fiuba.algo3.starcraft.logic.game.PlayerSetup;
import fiuba.algo3.starcraft.logic.game.StarCraft;
import fiuba.algo3.starcraft.view.exceptions.ColorIsTaken;
import fiuba.algo3.starcraft.view.exceptions.NameIsTaken;
import fiuba.algo3.starcraft.view.exceptions.NameIsTooShort;
import fiuba.algo3.starcraft.view.exceptions.PlayerSetupIncomplete;

import javax.swing.*;

import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.List;


public class StartUpView extends JFrame implements ActionListener {

	private static final long serialVersionUID = -8434982376834691380L;
	
	private StarCraft game;
    private List<PlayerSetup> list = new ArrayList<PlayerSetup>();
    private int numberOfPlayers;
    private int createdPlayers = 1;
    private PlayerSetup setup;

    private JLayeredPane jLayeredPane;
    private JPanel logoPanel;
    private JPanel startPanel;
    private JPanel aboutPanel;
    private JPanel numberOfPlayersPanel;
    private JPanel playerSetupPanel;
    private JButton startButton;
    private JButton aboutButton;
    private JLabel aboutLabel;
    private JButton backButton;
    private JLabel logo;
    //private JLabel howMany;
    //private JComboBox numberOfPlayersOptions;
    //private JButton numberOfPlayersNextButton;
    private JLabel playerSetupTitle;
    private JLabel nameLabel;
    private JTextField nameField;
    private JLabel colorLabel;
    private ButtonGroup colorOption;
    private JRadioButton blueColorButton;
    private JRadioButton greenColorButton;
    private JRadioButton redColorButton;
    private JRadioButton yellowColorButton;
    private JLabel raceLabel;
    private ButtonGroup raceOption;
    private JRadioButton terranButton;
    private JRadioButton protossButton;
    private JButton playerSetupNextButton;

    public StartUpView() {
      this.initComponents();
      this.startPanel();
    }

    private void initComponents() {

        raceOption = new ButtonGroup();
        colorOption = new ButtonGroup();
        jLayeredPane = new JLayeredPane();
        logoPanel = new JPanel();
        startPanel = new JPanel();
        aboutPanel = new JPanel();
        aboutLabel = new JLabel();
        backButton = new JButton();
        logo = new JLabel();
        startButton = new JButton();
        aboutButton = new JButton();
        numberOfPlayersPanel = new JPanel();
        //howMany = new JLabel();
        //numberOfPlayersOptions = new JComboBox();
        //numberOfPlayersNextButton = new JButton();
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
    }

    private void startPanel() {

        setLayout(new BorderLayout());

        String pathToImage = "fiuba/algo3/starcraft/presets/StarCraft.png";
        ImageIcon icon = new ImageIcon(getClass().getClassLoader().getResource(pathToImage));
        logo.setIcon(icon);
        logoPanel.setBackground(Color.white);
        logoPanel.add(logo);

        startButton.setText("Start");
        startButton.addActionListener(this);
        startButton.setBounds(250, 125, 100, 40);

        aboutButton.setText("About");
        aboutButton.addActionListener(this);
        aboutButton.setBounds(250, 170, 100, 40);

        startPanel.setBackground(Color.white);
        startPanel.setLayout(null);
        startPanel.add(startButton);
        startPanel.add(aboutButton);

        add(logoPanel, BorderLayout.NORTH);
        add(startPanel, BorderLayout.CENTER);

        setSize(600, 450);
        setBackground(Color.white);
        setTitle("AlgoCraft");
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);
        setVisible(true);
    }

    private void aboutPanel() {
        aboutPanel.setBackground(Color.white);
        aboutPanel.setLayout(null);
        aboutLabel.setText("<html>FACULTAD DE INGENIERIA<br>DE LA UNIVERSIDAD DE BUENOS AIRES<br>" +
                "ALGORITMOS Y PROGRAMACION III [75.07]<br><br><br>" +
                "Agustina Barbetta<br>Padrón: 96528<br><br>" +
                "Francisco Ordoñez<br>Padrón: 96478<br><br>" +
                "Santiago Lazzari<br>Padrón: 96735</html>");
        aboutLabel.setBounds(200, 50, 500, 200);
        backButton.setText("Back");
        backButton.addActionListener(this);
        backButton.setBounds(200, 275, 100, 40);

        aboutPanel.add(backButton);
        aboutPanel.add(aboutLabel);
        add(aboutPanel, BorderLayout.CENTER);
        aboutPanel.setVisible(true);

    }

    private void numberOfPlayersPanel() {
        backButton.setText("Back");
        backButton.addActionListener(this);
        backButton.setBounds(200, 275, 100, 40);
        numberOfPlayersPanel.add(backButton);
        numberOfPlayersPanel.setBackground(Color.white);
        add(numberOfPlayersPanel, BorderLayout.SOUTH);
        numberOfPlayersPanel.setVisible(true);

        String[] s = new String[] { "2", "3", "4" };
        int n = JOptionPane.showOptionDialog(this,
                "How many players?",
                "Player selection",
                JOptionPane.YES_NO_OPTION,
                JOptionPane.QUESTION_MESSAGE,
                null,
                s,
                s[0]);

        if (n < 3 && n >= 0) {
            this.numberOfPlayers = Integer.parseInt(s[n]);
            numberOfPlayersPanel.setVisible(false);
            this.playerSetupPanelInit();
        }
    }

    private void playerSetupPanelInit() {
        playerSetupPanel.setBackground(Color.white);
        playerSetupPanel.setLayout(new FlowLayout());
        playerSetupPanel.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);
        add(playerSetupPanel);
        
        playerSetupPanel.add(Box.createHorizontalStrut(600));
        playerSetupPanel.add(Box.createVerticalStrut(50));
        
        playerSetupPanel.add(playerSetupTitle);

        playerSetupPanel.add(Box.createHorizontalStrut(600));
        playerSetupPanel.add(Box.createVerticalStrut(50));
        
        nameLabel.setText("Name:");
        playerSetupPanel.add(nameLabel);
        nameField.setColumns(14);
        nameField.setToolTipText("");
        nameField.selectAll();
        nameField.addActionListener(this);
        playerSetupPanel.add(nameField);

        playerSetupPanel.add(Box.createHorizontalStrut(600));
        playerSetupPanel.add(Box.createVerticalStrut(50));
        
        colorLabel.setText("Color:");
        playerSetupPanel.add(colorLabel);
        colorOption.add(redColorButton);
        redColorButton.setText("Red");
        colorOption.add(blueColorButton);
        blueColorButton.setText("Blue");
        colorOption.add(yellowColorButton);
        yellowColorButton.setText("Yellow");
        colorOption.add(greenColorButton);
        greenColorButton.setText("Green");
        playerSetupPanel.add(redColorButton);
        playerSetupPanel.add(blueColorButton);
        playerSetupPanel.add(yellowColorButton);
        playerSetupPanel.add(greenColorButton);

        playerSetupPanel.add(Box.createHorizontalStrut(600));
        playerSetupPanel.add(Box.createVerticalStrut(50));
        
        raceLabel.setText("Race:");
        playerSetupPanel.add(raceLabel);
        raceOption.add(protossButton);
        protossButton.setText("Protoss");
        raceOption.add(terranButton);
        terranButton.setText("Terran");
        playerSetupPanel.add(protossButton);
        playerSetupPanel.add(terranButton);
        
        playerSetupPanel.add(Box.createHorizontalStrut(600));
        playerSetupPanel.add(Box.createVerticalStrut(150));
        
        playerSetupNextButton.setText("Next");
        playerSetupNextButton.addActionListener(this);
        playerSetupPanel.add(playerSetupNextButton);

        this.playerSetupPanel();
    }

    public void playerSetupPanel() {
        playerSetupPanel.setVisible(true);
        nameField.selectAll();
        playerSetupTitle.setText("Player " + createdPlayers);
        nameField.setText("");
        colorOption.clearSelection();
        raceOption.clearSelection();
    }

    @Override
    public void actionPerformed(ActionEvent event) {
            if (event.getSource() == startButton) {
                System.out.println("Start");
                this.startButtonActionPerformed(event);
            } else if (event.getSource() == aboutButton) {
                System.out.println("About");
                this.aboutButtonActionPerformed(event);
            } else if (event.getSource() == backButton) {
                System.out.println("Back");
                this.backButtonActionPerformed(event);
            } else if (event.getSource() == playerSetupNextButton) {
                this.playerSetupNextButton();
            }
    }
    
    private void playerSetupNextButton() {
        try {
			this.createPlayerSetup();
			if (createdPlayers == numberOfPlayers){
            game = new StarCraft(list);
            game.start();
            StarCraftView starcraftView = new StarCraftView(game);
            starcraftView.setVisible(true);
            dispose();
			}
			createdPlayers++;
		} catch (NameIsTaken | ColorIsTaken | NameIsTooShort | PlayerSetupIncomplete e) {
            JOptionPane.showMessageDialog(null, e.getMessage() + "\n Please try again.", "Error", JOptionPane.ERROR_MESSAGE);
		}
        this.playerSetupPanel();
    }

    private void createPlayerSetup() throws NameIsTaken, ColorIsTaken, NameIsTooShort, PlayerSetupIncomplete {
        setup = new PlayerSetup(this.getPlayerName(),this.getPlayerColor(),this.getPlayerRace());
        this.checkPlayerSetup(setup);
        list.add(setup);
    }

    private boolean checkPlayerSetup(PlayerSetup newSetup) throws NameIsTaken, ColorIsTaken {
        for (PlayerSetup setup : list) {
            if (setup.getName().equals(newSetup.getName()))
                throw new NameIsTaken();
            if (setup.getColor().equals(newSetup.getColor()))
                throw new ColorIsTaken();
        }
        return true;
    }

    private void backButtonActionPerformed(ActionEvent event) {
        startPanel.setVisible(true);
        aboutPanel.setVisible(false);
        numberOfPlayersPanel.setVisible(false);
    }

    private void startButtonActionPerformed(ActionEvent event) {
        startPanel.setVisible(false);
        aboutPanel.setVisible(false);
        playerSetupPanel.setVisible(false);
        this.numberOfPlayersPanel();
    }

    private void aboutButtonActionPerformed(ActionEvent event) {
        startPanel.setVisible(false);
        numberOfPlayersPanel.setVisible(false);
        this.aboutPanel();
    }

    public String getPlayerName() {
        return nameField.getText();
    }
    public String getPlayerRace() throws PlayerSetupIncomplete {
        if(terranButton.isSelected())
            return terranButton.getText();
        if(protossButton.isSelected())
            return protossButton.getText();
        else
            throw new PlayerSetupIncomplete();
    }

    public String getPlayerColor() throws PlayerSetupIncomplete {
        List<JRadioButton> list = new ArrayList<>();
        list.add(yellowColorButton);
        list.add(blueColorButton);
        list.add(redColorButton);
        list.add(greenColorButton);

        for (JRadioButton button : list) {
            if (button.isSelected())
                return button.getText();
        }
        throw new PlayerSetupIncomplete();
    }

    public static void main(String[] args) {
        new StartUpView();
    }

}