package fiuba.algo3.starcraft.view;

import fiuba.algo3.starcraft.game.PlayerSetup;
import fiuba.algo3.starcraft.game.StarCraft;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;


public class StartUpView extends JFrame implements ActionListener {

    private StarCraft game;
    private List<PlayerSetup> list;

    private JLayeredPane jLayeredPane;
    private JPanel logoPanel;
    private JPanel startPanel;
    private JPanel aboutPanel;
    private JPanel numberOfPlayersPanel;
    private JPanel playerSetupPanel;
    private JButton startButton;
    private JButton aboutButton;
    JLabel agustina;
    JLabel francisco;
    JLabel santiago;
    JLabel padronA;
    JLabel padronF;
    JLabel padronS;
    private JLabel logo;
    private JLabel howMany;
    private JComboBox numberOfPlayersOptions;
    private JButton numberOfPlayersNextButton;
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
        agustina = new JLabel();
        francisco = new JLabel();
        santiago = new JLabel();
        padronA = new JLabel();
        padronF = new JLabel();
        padronS = new JLabel();
        logo = new JLabel();
        startButton = new JButton();
        aboutButton = new JButton();
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

        agustina.setText("Agustina Barbetta");
        francisco.setText("Francisco Ordoñez");
        santiago.setText("Santiago Lazzari");
        padronA.setText("Padrón: 96528");
        padronF.setText("Padrón: 96478");
        padronS.setText("Padrón: 96735");

        agustina.setBounds(200,125,500,40);
        francisco.setBounds(200, 185, 500, 40);
        santiago.setBounds(200, 245, 200, 40);
        padronA.setBounds(200,145,500,40);
        padronF.setBounds(200,205, 500, 40);
        padronS.setBounds(200,265,500,40);

        aboutPanel.add(agustina);
        aboutPanel.add(francisco);
        aboutPanel.add(santiago);
        aboutPanel.add(padronA);
        aboutPanel.add(padronF);
        aboutPanel.add(padronS);

        add(aboutPanel, BorderLayout.CENTER);
        aboutPanel.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent event) {
        //performingAction = true;
            if (event.getSource() == startButton) {
                System.out.println("Start");
                this.startButtonActionPerformed(event);
            } else if (event.getSource() == aboutButton) {
                System.out.println("About");
                this.aboutButtonActionPerformed(event);
            }
            //performingAction = false;
            //disableActionButtons();
    }

    private void startButtonActionPerformed(ActionEvent event) {
        startPanel.setVisible(false);
        numberOfPlayersPanel.setVisible(true);
        playerSetupPanel.setVisible(false);
    }
    private void aboutButtonActionPerformed(ActionEvent event) {
        startPanel.setVisible(false);
        this.aboutPanel();
    }

    public static void main(String[] args) {
        new StartUpView();

    }

}

