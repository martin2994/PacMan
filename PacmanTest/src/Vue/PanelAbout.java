package Vue;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;

import javax.swing.JPanel;

public class PanelAbout extends JPanel {

	private int pixelStarring;
	private int pixelMaxime;
	private int pixelMartin;
	private int pixelManu;
	private int pixelGuest;
	private int pixelPacman;
	private int pixelGhost;

	public PanelAbout() {
		this.pixelStarring = 20;
		this.pixelMaxime = 60;
		this.pixelManu = 90;
		this.pixelMartin = 120;
		this.pixelGuest = 160;
		this.pixelPacman = 200;
		this.pixelGhost = 230;
	}

	public void paintComponent(Graphics g) {

		if (pixelStarring == this.getHeight()) {
			pixelStarring = 0;
		}
		if (pixelMaxime == this.getHeight()) {
			pixelMaxime = 0;
		}
		if (pixelMartin == this.getHeight()) {
			pixelMartin = 0;
		}
		if (pixelManu == this.getHeight()) {
			pixelManu = 0;
		}
		if (pixelGuest == this.getHeight()) {
			pixelGuest = 0;
		}
		if (pixelPacman == this.getHeight()) {
			pixelPacman = 0;
		}
		if (pixelGhost == this.getHeight()) {
			pixelGhost = 0;
		}

		this.pixelStarring++;
		this.pixelMaxime++;
		this.pixelMartin++;
		this.pixelManu++;
		this.pixelGuest++;
		this.pixelPacman++;
		this.pixelGhost++;

		g.setColor(Color.black);
		g.fillRect(0, 0, this.getWidth(), this.getHeight());

		Font font = new Font("Courier", Font.BOLD, 25);
		g.setFont(font);
		g.setColor(Color.YELLOW);
		g.drawString("Starring", 3 * (this.getWidth() / 7) - 10, pixelStarring);
		g.drawString("Special Guest", this.getWidth() / 2 - 95, pixelGuest);

		Font font2 = new Font("Courier", Font.BOLD, 20);
		g.setFont(font2);
		g.setColor(Color.YELLOW);
		g.drawString("Duchene", this.getWidth() / 2 - 103, pixelMaxime);
		g.drawString("Maxime", this.getWidth() / 2 + 20, pixelMaxime);
		g.drawString("Rety", this.getWidth() / 2 - 67, pixelMartin);
		g.drawString("Martin", this.getWidth() / 2 + 20, pixelMartin);
		g.drawString("Herrmann", this.getWidth() / 2 - 113, pixelManu);
		g.drawString("Emmanuel", this.getWidth() / 2 + 20, pixelManu);
		g.drawString("Pacman", this.getWidth() / 2 - 35, pixelPacman);
		g.drawString("and the Ghosts", this.getWidth() / 2 - 80, pixelGhost);
	}
}
