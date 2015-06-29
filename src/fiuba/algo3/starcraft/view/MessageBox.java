package fiuba.algo3.starcraft.view;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public class MessageBox extends JPanel {

	private static final long serialVersionUID = -5029650685763890667L;
	
	private JTextArea textArea;
	
    MessageBox() {
    	this.textArea = new JTextArea(3, 30);
    	textArea.setEditable(false);
    	JScrollPane scrollPane = new JScrollPane(textArea);
    	this.add(scrollPane);
    }
    
    public void displayMessage(String message) {
    	 textArea.setText(message);
    }
    
    public void clear() {
    	textArea.setText(null);
    }
}
