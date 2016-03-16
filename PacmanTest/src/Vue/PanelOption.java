package Vue;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JPanel;

/**
 * Affiche la page des options
 * 
 * @author Duchene Herrmann Rety
 *
 */
public class PanelOption extends JPanel {

	/**
	 * Affiche la page
	 */
	

	private Image pacman_up;
	
	public PanelOption(){

		try {
			pacman_up=ImageIO.read(Vue.class.getResource("image/Pacman_up.png"));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	
	public void paintComponent(Graphics g) {
		g.setColor(Color.BLACK);
		g.fillRect(0, 0, this.getWidth(), this.getHeight());
		Font font = new Font("Courier", Font.BOLD, 20);
		g.setFont(font);
		g.setColor(Color.YELLOW);
		g.drawString("Ghost difficulty", 40, 30);
		g.drawString("Level to play ", 40, 80);
		g.drawString("Delete high score", 40, 130);
		g.drawString("Disable sound", 40, 180);
		g.setColor(Color.WHITE);
		g.drawLine(0,50,this.getWidth(),50);
		g.drawLine(0,100,this.getWidth(),100);
		g.drawLine(0,150,this.getWidth(),150);
		g.drawLine(0,200,this.getWidth(),200);
		g.drawLine(this.getWidth()/2,0,this.getWidth()/2,225);
		g.drawLine(this.getWidth()/2-1,0,this.getWidth()/2-1,225);
		g.fillOval(this.getWidth()/2-1,235,2,2);
		g.fillOval(this.getWidth()/2-2,250,4,4);
		g.fillOval(this.getWidth()/2-3,270,6,6);
		g.drawImage(pacman_up, this.getWidth()/2-13,280, this);
	}
}
