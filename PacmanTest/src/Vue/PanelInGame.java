package Vue;

import Controller.Controller;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;

import javax.swing.JPanel;

import Modele.Ghost;
import Modele.Pacman;

public class PanelInGame extends JPanel {
	private boolean pause;
	private int counter;

	private Ghost blinky;
	private Ghost pinky;
	private Ghost inky;
	private Ghost clyde;
	private Pacman hero;
	private boolean[] bonus;
	private MyImage myimage;


	// boolean et timer pour gerer la forme du pacman
	private boolean form_pacman = false;
	private int timer_anim_pacman = 0;

	public PanelInGame() {
		pause = false;
		System.out.println("Counter initialisé PanelInGame");
		counter = 4;
		myimage=new MyImage();
	}

	public void paintComponent(Graphics g) {
		drawLabyrinth(g);
		drawPacman(g);
		drawOptions(g);
		drawGhost(g);
		if (pause) {
			drawPause(g);
		}
		if(counter>0){
			Font font = new Font("Courier", Font.BOLD, 150);
			g.setFont(font);
			g.setColor(Color.YELLOW);
			g.drawString(Integer.toString(counter), this.getWidth() / 2 - 100, this.getHeight() / 2 + 32);
			counter--;
		}
	}

	public void drawLabyrinth(Graphics g) {
		int mat[][] = Controller.getLabyrinth();

		// affichage du fond noir
		g.setColor(Color.black);
		g.fillRect(0, 0, this.getWidth(), this.getHeight());

		// affichage du labyrinth
		for (int i = 0; i < 19; i++) {
			for (int j = 0; j < 22; j++) {
				switch (mat[i][j]) {
				case -5:
					g.drawImage(myimage.getCase(26), i * 28, j * 28, this);
					break;
				case -4:
					g.drawImage(myimage.getBonus("Fraise"), i * 28, j * 28, this);
					break;
				case -3:
					g.drawImage(myimage.getBonus("Cerise"), i * 28, j * 28, this);
					break;
				case -2:
					g.drawImage(myimage.getBonus("Orange"), i * 28, j * 28, this);
					break;
				case -1:
					g.drawImage(myimage.getBonus("Pomme"), i * 28, j * 28, this);
					break;
				case 0:
					g.drawImage(myimage.getCase(0), i * 28, j * 28, this);
					break;
				case 1:
					g.drawImage(myimage.getCase(1), i * 28, j * 28, this);
					break;
				case 2:
					g.drawImage(myimage.getCase(2), i * 28, j * 28, this);
					break;
				case 3:
					g.drawImage(myimage.getCase(3), i * 28, j * 28, this);
					break;
				case 4:
					g.drawImage(myimage.getCase(4), i * 28, j * 28, this);
					break;
				case 5:
					g.drawImage(myimage.getCase(5), i * 28, j * 28, this);
					break;
				case 6:
					g.drawImage(myimage.getCase(6), i * 28, j * 28, this);
					break;
				case 7:
					g.drawImage(myimage.getCase(7), i * 28, j * 28, this);
					break;
				case 8:
					g.drawImage(myimage.getCase(8), i * 28, j * 28, this);
					break;
				case 9:
					g.drawImage(myimage.getCase(9), i * 28, j * 28, this);
					break;
				case 10:
					g.drawImage(myimage.getCase(10), i * 28, j * 28, this);
					break;
				case 11:
					g.drawImage(myimage.getCase(11), i * 28, j * 28, this);
					break;
				case 12:
					g.drawImage(myimage.getCase(12), i * 28, j * 28, this);
					break;
				case 13:
					g.drawImage(myimage.getCase(13), i * 28, j * 28, this);
					break;
				case 14:
					g.drawImage(myimage.getCase(14), i * 28, j * 28, this);
					break;
				case 15:
					g.drawImage(myimage.getCase(15), i * 28, j * 28, this);
					break;
				case 16:
					g.drawImage(myimage.getCase(16), i * 28, j * 28, this);
					break;
				case 17:
					g.drawImage(myimage.getCase(17), i * 28, j * 28, this);
					break;
				case 18:
					g.drawImage(myimage.getCase(18), i * 28, j * 28, this);
					break;
				case 19:
					g.drawImage(myimage.getCase(19), i * 28, j * 28, this);
					break;
				case 20:
					g.drawImage(myimage.getCase(20), i * 28, j * 28, this);
					break;
				case 21:
					g.drawImage(myimage.getCase(21), i * 28, j * 28, this);
					break;
				case 22:
					g.drawImage(myimage.getCase(22), i * 28, j * 28, this);
					break;
				case 23:
					g.drawImage(myimage.getCase(23), i * 28, j * 28, this);
					break;
				case 24:
					g.drawImage(myimage.getCase(24), i * 28, j * 28, this);
					break;
				case 25:
					g.drawImage(myimage.getCase(25), i * 28, j * 28, this);
					break;
				}
			}
		}
		// affichage des lignes de séparation labyrinth/option
		g.setColor(Color.white);
		g.fillRect(this.getWidth() - 120, 0, 2, this.getHeight());
		g.fillRect(this.getWidth() - 124, 0, 2, this.getHeight());
	}

	public void drawPacman(Graphics g) {
		/*
		 * affichage de pacman en fonction de sa direction et du timer pour
		 * faire l'animation
		 */
		if ((form_pacman || timer_anim_pacman < 10) && !this.pause) {
			switch (hero.getGo()) {
			case UP:
				g.drawImage(myimage.getPacman("up"), hero.getCoordX(), hero.getCoordY(), this);
				break;
			case DOWN:
				g.drawImage(myimage.getPacman("down"), hero.getCoordX(), hero.getCoordY(), this);
				break;
			case LEFT:
				g.drawImage(myimage.getPacman("left"), hero.getCoordX(), hero.getCoordY(), this);
				break;
			case RIGHT:
				g.drawImage(myimage.getPacman("right"), hero.getCoordX(), hero.getCoordY(), this);
				break;
			default:
			}
			if (timer_anim_pacman == 9)
				form_pacman = false;
		} else {
			g.drawImage(myimage.getPacman("close"), hero.getCoordX(), hero.getCoordY(), this);
		}
		timer_anim_pacman++;
		// réinitialisation du timer
		if (timer_anim_pacman == 20) {
			timer_anim_pacman = 0;
			form_pacman = true;
		}
	}

	public void drawPause(Graphics g) {
		Font font = new Font("Courier", Font.BOLD, 100);
		g.setFont(font);
		g.setColor(Color.YELLOW);
		g.drawString("PAUSE", this.getWidth() / 5 - 14, this.getHeight() / 2);
	}

	public void drawOptions(Graphics g) {
		/*
		 * affichage des options: - le nombre de vie - les differents bonus
		 */
		Font font = new Font("Courier", Font.BOLD, 20);
		g.setFont(font);
		g.setColor(Color.white);
		g.drawString("Life:", this.getWidth() - 105, (this.getHeight() / 3) - 28);
		for (int i = 0; i < hero.getLife(); i++) {
			g.drawImage(myimage.getPacman("right"), (this.getWidth() - 105) + i * 28, (this.getHeight() / 3) - 14, this);
		}
		g.drawString("Bonus:", this.getWidth() - 105, 2 * (this.getHeight() / 3) - 28);
		if (bonus[0])
			g.drawImage(myimage.getBonus("pomme"), this.getWidth() - 50, 2 * (this.getHeight() / 3) + 32, this);
		if (bonus[1])
			g.drawImage(myimage.getBonus("Orange"), this.getWidth() - 105, 2 * (this.getHeight() / 3) + 32, this);
		if (bonus[2])
			g.drawImage(myimage.getBonus("Cerise"), this.getWidth() - 50, 2 * (this.getHeight() / 3) - 10, this);
		if (bonus[3])
			g.drawImage(myimage.getBonus("Fraise"), this.getWidth() - 105, 2 * (this.getHeight() / 3) - 10, this);

		// affichage du score
		g.drawString("Score:", this.getWidth() - 105, 50);
		g.drawString("" + Controller.getScore(), this.getWidth() - 105, 75);
	}

	/*
	 * méthode d'affichage des fantomes
	 */

	public void drawDirectionGhost(Graphics g, Ghost actual, Image up, Image down, Image left, Image right) {
		switch (actual.getGo()) {
		case UP:
			g.drawImage(up, actual.getCoordX(), actual.getCoordY(), this);
			break;
		case DOWN:
			g.drawImage(down, actual.getCoordX(), actual.getCoordY(), this);
			break;
		case LEFT:
			g.drawImage(left, actual.getCoordX(), actual.getCoordY(), this);
			break;
		case RIGHT:
			g.drawImage(right, actual.getCoordX(), actual.getCoordY(), this);
			break;
		default:
		}
	}

	public void drawEatableGhost(Graphics g, Ghost actual) {
		if (hero.getTimer_superPacman() >= 625) {
			if (hero.getTimer_superPacman() % 25 < 13) {
				g.drawImage(myimage.getGhost("White",""), actual.getCoordX(), actual.getCoordY(), this);
			} else {
				g.drawImage(myimage.getGhost("Blue",""), actual.getCoordX(), actual.getCoordY(), this);
			}
		} else {
			g.drawImage(myimage.getGhost("Blue",""), actual.getCoordX(), actual.getCoordY(), this);
		}
	}

	public void drawGhost(Graphics g) {
		/*
		 * affichage des 4 fantomes en fonction de: - leur etat
		 * (0->normal,1->bleu,2->yeux) - leur direction
		 */
		switch (blinky.getState()) {
		case 0:
			drawDirectionGhost(g, blinky, myimage.getGhost("Blinky","up"), myimage.getGhost("Blinky","down"), myimage.getGhost("Blinky","left"),myimage.getGhost("Blinky","right"));
			break;
		case 1:
			drawEatableGhost(g, blinky);
			break;
		case 2:
			drawDirectionGhost(g, blinky, myimage.getGhost("Eye","up"), myimage.getGhost("Eye","down"), myimage.getGhost("Eye","left"),myimage.getGhost("Eye","right"));
			break;
		}
		switch (inky.getState()) {
		case 0:
			drawDirectionGhost(g, inky, myimage.getGhost("Inky","up"), myimage.getGhost("Inky","down"), myimage.getGhost("Inky","left"),myimage.getGhost("Inky","right"));
			break;
		case 1:
			drawEatableGhost(g, inky);
			break;
		case 2:
			drawDirectionGhost(g, inky, myimage.getGhost("Eye","up"), myimage.getGhost("Eye","down"), myimage.getGhost("Eye","left"),myimage.getGhost("Eye","right"));
			break;
		}
		switch (pinky.getState()) {
		case 0:
			drawDirectionGhost(g, pinky,myimage.getGhost("Pinky","up"), myimage.getGhost("Pinky","down"), myimage.getGhost("Pinky","left"),myimage.getGhost("Pinky","right"));
			break;
		case 1:
			drawEatableGhost(g, pinky);
			break;
		case 2:
			drawDirectionGhost(g, pinky, myimage.getGhost("Eye","up"), myimage.getGhost("Eye","down"), myimage.getGhost("Eye","left"),myimage.getGhost("Eye","right"));
			break;
		}
		switch (clyde.getState()) {
		case 0:
			drawDirectionGhost(g, clyde,myimage.getGhost("Clyde","up"), myimage.getGhost("Clyde","down"), myimage.getGhost("Clyde","left"),myimage.getGhost("Clyde","right"));
			break;
		case 1:
			drawEatableGhost(g, clyde);
			break;
		case 2:
			drawDirectionGhost(g, clyde, myimage.getGhost("Eye","up"), myimage.getGhost("Eye","down"), myimage.getGhost("Eye","left"),myimage.getGhost("Eye","right"));
			break;
		}

	}

	public Ghost getBlinky() {
		return blinky;
	}

	public void setBlinky(Ghost blinky) {
		this.blinky = blinky;
	}

	public Ghost getPinky() {
		return pinky;
	}

	public void setPinky(Ghost pinky) {
		this.pinky = pinky;
	}

	public Ghost getInky() {
		return inky;
	}

	public void setInky(Ghost inky) {
		this.inky = inky;
	}

	public Ghost getClyde() {
		return clyde;
	}

	public void setClyde(Ghost clyde) {
		this.clyde = clyde;
	}

	public boolean getForm_pacman() {
		return this.form_pacman;
	}

	public void setForm_pacman(boolean new_form) {
		this.form_pacman = new_form;
	}

	public int getTimer_anim_pacman() {
		return timer_anim_pacman;
	}

	public void setTimer_anim_pacman(int timer_anim_pacman) {
		this.timer_anim_pacman = timer_anim_pacman;
	}

	public void setHero(Pacman hero) {
		this.hero = hero;
	}

	public void setPause(boolean _pause) {
		this.pause = _pause;
	}

	public void setBonus(boolean[] bonus) {
		this.bonus = bonus;
	}
	
	public void resetCounter(){
		this.counter=4;
		timer_anim_pacman=0;
	}
	
	public void setCounter(int i){
		this.counter=i;
	}

}