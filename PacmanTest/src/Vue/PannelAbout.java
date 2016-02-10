package Vue;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;

import javax.swing.JPanel;

public class PannelAbout extends JPanel {

	private int pixelStarring;
	private int pixelMaxime;
	private int pixelMartin;
	private int pixelManu;
	private int pixelGuest;
	private int pixelPacman;
	private int pixelGhost;
	
	public PannelAbout(){
		this.pixelStarring=20;
		this.pixelMaxime=60;
		this.pixelMartin=90;
		this.pixelManu=120;
		this.pixelGuest=150;
		this.pixelPacman=180;
		this.pixelGhost=210;
	}
	
	public void paintComponent(Graphics g) {
		g.setColor(Color.black);
		g.fillRect(0, 0, this.getWidth(), this.getHeight());

		Font font = new Font("Courier", Font.BOLD, 25);
		g.setFont(font);
		g.setColor(Color.YELLOW);
		g.drawString("Starring", 3*(this.getWidth() /7)-10 , pixelStarring);
		Font font2 = new Font("Courier", Font.BOLD, 20);
		g.setFont(font2);
		g.setColor(Color.YELLOW);
		g.drawString("Duchene Maxime", 3*(this.getWidth()/8),pixelMaxime);
		g.drawString("Rety Martin", 6*(this.getWidth()/15)+6, pixelMartin);
		g.drawString("Herrmann Emmanuel", this.getWidth() / 2, pixelManu);
		g.drawString("Special Guest", this.getWidth() / 2, pixelGuest);
		g.drawString("Pacman", this.getWidth() / 2, pixelPacman);
		g.drawString("and the Ghosts", this.getWidth() / 2, pixelGhost);
	}
}
