package Vue;

import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JButton;
import javax.swing.JPanel;

public class PannelStart extends JPanel {

	
	public void paintComponent(Graphics g) {
		System.out.println("paintComponent");
		g.setColor(Color.black);
		g.fillRect(0, 0, this.getWidth(), this.getHeight());
		
	}
}
