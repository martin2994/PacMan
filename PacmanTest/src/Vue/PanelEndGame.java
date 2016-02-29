package Vue;

import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class PanelEndGame extends JPanel {
	
	public PanelEndGame(){
	}
	
	public void paintComponent(Graphics g, MouseClic controle_c){
		g.setColor(Color.black);
		g.fillRect(0, 0, this.getWidth(), this.getHeight());
		JOptionPane.showMessageDialog(null, controle_c.getName());
		
	}

}
