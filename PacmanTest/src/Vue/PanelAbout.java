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
	private int pixelProducer;
	private int pixelDirector;
	private int pixelScreenwriter;
	private int pixelMusician;

	public PanelAbout() {
		this.pixelProducer=20;
		this.pixelMaxime = 50;
		this.pixelDirector=80;
		this.pixelManu = 110;
		this.pixelScreenwriter=140;
		this.pixelMartin = 170;
		this.pixelStarring = 200;
		this.pixelPacman = 230;
		this.pixelGhost = 250;
		this.pixelMusician=280;
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
		if (pixelDirector == this.getHeight()) {
			pixelDirector = 0;
		}
		if (pixelProducer == this.getHeight()) {
			pixelProducer = 0;
		}
		if (pixelScreenwriter == this.getHeight()) {
			pixelScreenwriter = 0;
		}
		if (pixelMusician == this.getHeight()) {
			pixelMusician = 0;
		}

		this.pixelStarring++;
		this.pixelMaxime++;
		this.pixelMartin++;
		this.pixelManu++;
		this.pixelPacman++;
		this.pixelGhost++;
		this.pixelProducer++;
		this.pixelDirector++;
		this.pixelScreenwriter++;
		this.pixelMusician++;

		g.setColor(Color.black);
		g.fillRect(0, 0, this.getWidth(), this.getHeight());

		Font font = new Font("Courier", Font.BOLD, 25);
		g.setFont(font);
		g.setColor(Color.YELLOW);
		g.drawString("Executive Producer", this.getWidth()/3, pixelProducer);
		g.drawString("Director",this.getWidth()/3, pixelDirector);
		g.drawString("Screenwriter",this.getWidth()/3, pixelScreenwriter);
		g.drawString("Starring",this.getWidth()/3, pixelStarring);
		g.drawString("Music by",this.getWidth()/3, pixelMusician);

		Font font2 = new Font("Courier", Font.BOLD, 20);
		g.setFont(font2);
		g.setColor(Color.YELLOW);
		g.drawString("Duchene Maxime", this.getWidth()/3+30, pixelMaxime);
		g.drawString("Herrmann Emmanuel", this.getWidth()/3+30, pixelManu);
		g.drawString("Rety Martin", this.getWidth()/3+30, pixelMartin);
		g.drawString("Pacman", this.getWidth()/3+30, pixelPacman);
		g.drawString("and the Ghosts", this.getWidth()/3+30, pixelGhost);
	}
}
