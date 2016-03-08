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
	private int pixelPacman;
	private int pixelGhost;
	private int pixelProducer;
	private int pixelDirector;
	private int pixelScreenwriter;
	private int pixelMusician;

	private int baseProducer;
	private int baseMaxime;
	private int baseDirector;
	private int baseManu;
	private int baseScreenwriter;
	private int baseMartin;
	private int baseStarring;
	private int basePacman;
	private int baseGhost;
	private int baseMusician;

	public PanelAbout(int height) {
		this.baseProducer=height+20;
		this.baseMaxime=height+60;
		this.baseDirector=height+100;
		this.baseManu=height+140;
		this.baseScreenwriter=height+180;
		this.baseMartin=height+220;
		this.baseStarring=height+260;
		this.basePacman=height+300;
		this.baseGhost=height+330;
		this.baseMusician=height+370;
		this.pixelProducer=baseProducer;
		this.pixelMaxime = baseMaxime;
		this.pixelDirector=baseDirector;
		this.pixelManu = baseManu;
		this.pixelScreenwriter=baseScreenwriter;
		this.pixelMartin = baseMartin;
		this.pixelStarring = baseStarring;
		this.pixelPacman = basePacman;
		this.pixelGhost = baseGhost;
		this.pixelMusician=baseMusician;
	}

	public void paintComponent(Graphics g) {
		if (pixelMusician == -10) {
			this.pixelProducer=baseProducer;
			this.pixelMaxime = baseMaxime;
			this.pixelDirector=baseDirector;
			this.pixelManu = baseManu;
			this.pixelScreenwriter=baseScreenwriter;
			this.pixelMartin = baseMartin;
			this.pixelStarring = baseStarring;
			this.pixelPacman = basePacman;
			this.pixelGhost = baseGhost;
			this.pixelMusician=baseMusician;
		}

		this.pixelStarring--;
		this.pixelMaxime--;
		this.pixelMartin--;
		this.pixelManu--;
		this.pixelPacman--;
		this.pixelGhost--;
		this.pixelProducer--;
		this.pixelDirector--;
		this.pixelScreenwriter--;
		this.pixelMusician--;

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
