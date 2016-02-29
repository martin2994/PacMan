package Vue;

import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class PanelEndGame extends JPanel {
	
	String name;
	
	public PanelEndGame(){
		this.name="";
	}
	
	public void paintComponent(Graphics g){
		g.setColor(Color.black);
		g.fillRect(0, 0, this.getWidth(), this.getHeight());
		//JOptionPane.showMessageDialog(null, name);
	}
	
	public void setName(String _name){
		this.name=_name;
	}

}
