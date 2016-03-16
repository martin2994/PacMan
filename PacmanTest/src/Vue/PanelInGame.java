package Vue;

import Controller.Controller;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;

import javax.swing.JPanel;

import Modele.Ghost;
import Modele.Pacman;

/**
 * PanelInGame est la classe centralisant toutes les méthodes d'affichage durant
 * le jeu
 * 
 * @author Duchene Herrmann Rety
 *
 */
public class PanelInGame extends JPanel {

	/**
	 * boolean qui gère la pause du jeu
	 */
	private boolean pause;

	/**
	 * entier qui gère le compteur de début de jeu
	 */
	private int counter;

	/**
	 * attribut qui gère le fantôme Blinky
	 */
	private Ghost blinky;

	/**
	 * attribut qui gère le fantôme Pnky
	 */
	private Ghost pinky;

	/**
	 * attribut qui gère le fantôme Iky
	 */
	private Ghost inky;

	/**
	 * attribut qui gère le fantôme Clyde
	 */
	private Ghost clyde;

	/**
	 * attribut qui gère le Pacman
	 */
	private Pacman hero;

	/**
	 * tableau des bonus affichés
	 */
	private boolean[] bonus;

	/**
	 * attribut contenant toutes les images
	 */
	private MyImage myimage;

	/**
	 * boolean pour gerer la forme du pacman
	 */
	private boolean form_pacman = false;

	/**
	 * timer pour gerer la forme du pacman
	 */
	private int timer_anim_pacman = 0;

	private int timer_dead=0;
	/**
	 * Contructeur de PanelInGame, initialisation des images et des attributs du
	 * panneau
	 * 
	 */
	public PanelInGame() {
		pause = false;
		counter = 0;
		myimage = new MyImage();
	}

	/**
	 * Affichage du labyrinth, du pacman, des fantômes et des options affichage
	 * de la pause et du compteur si besoin
	 * 
	 * @param g
	 *            Fenêtre actuelle
	 */
	public void paintComponent(Graphics g) {
		drawLabyrinth(g);
		drawPacman(g);
		drawOptions(g);
		drawGhost(g);
		if (pause) {
			drawPause(g);
		}
		if (counter != 0) {
			Font font = new Font("Courier", Font.BOLD, 150);
			g.setFont(font);
			g.setColor(Color.YELLOW);
			g.drawString(Integer.toString(counter), this.getWidth() / 2 - 100, this.getHeight() / 2 + 32);
		}
	}

	/**
	 * Affichage des cases du labyrinth et des lignes de démarcation des bonus
	 * 
	 * @param g
	 *            Fenêtre actuelle
	 */
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

	/**
	 * Affichage du pacman en fonction de sa direction et du temps
	 * 
	 * @param g
	 *            Fenêtre actuelle
	 */
	public void drawPacman(Graphics g) {
		/*
		 * affichage de pacman en fonction de sa direction et du timer pour
		 * faire l'animation
		 */
		if (hero.isState()){
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
		}else{
			if (timer_dead>=0 && timer_dead<2)
				g.drawImage(myimage.getPacman("close"), hero.getCoordX(), hero.getCoordY(), this);
			if (timer_dead>=2 && timer_dead<4)
				g.drawImage(myimage.getPacman("up"), hero.getCoordX(), hero.getCoordY(), this);
			if (timer_dead>=4 && timer_dead<6)
				g.drawImage(myimage.getPacman("mort1"), hero.getCoordX(), hero.getCoordY(), this);
			if (timer_dead>=6 && timer_dead<8)
				g.drawImage(myimage.getPacman("mort2"), hero.getCoordX(), hero.getCoordY(), this);
			if (timer_dead>=8 && timer_dead<10)
				g.drawImage(myimage.getPacman("mort3"), hero.getCoordX(), hero.getCoordY(), this);
			timer_dead++;
			if (timer_dead>=10){
				timer_dead=0;
			}
		}
	}

	/**
	 * Affichage de la pause
	 * 
	 * @param g
	 *            Fenêtre actuelle
	 */
	public void drawPause(Graphics g) {
		Font font = new Font("Courier", Font.BOLD, 100);
		g.setFont(font);
		g.setColor(Color.YELLOW);
		g.drawString("PAUSE", this.getWidth() / 5 - 14, this.getHeight() / 2);
	}

	/**
	 * Affichage des options (bonus, score, vie)
	 * 
	 * @param g
	 *            Fenêtre actuelle
	 */
	public void drawOptions(Graphics g) {
		/*
		 * affichage des options: - le nombre de vie - les differents bonus
		 */
		Font font = new Font("Courier", Font.BOLD, 20);
		g.setFont(font);
		g.setColor(Color.white);
		g.drawString("Life:", this.getWidth() - 105, (this.getHeight() / 3) - 28);
		for (int i = 0; i < hero.getLife(); i++) {
			g.drawImage(myimage.getPacman("right"), (this.getWidth() - 105) + i * 28, (this.getHeight() / 3) - 14,
					this);
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

	/**
	 * Affichage des fantomes en fonction de leur direction
	 * 
	 * @param g
	 *            Fenêtre actuelle
	 * @param actual
	 *            fantôme à afficher
	 * @param up
	 *            image du fantôme vers le haut
	 * @param down
	 *            image du fantôme vers le bas
	 * @param left
	 *            image du fantôme vers la gauche
	 * @param right
	 *            image du fantôme vers la droite
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

	/**
	 * Affichage des fantomes mangeables
	 * 
	 * @param g
	 *            Fenêtre actuelle
	 * @param actual
	 *            fantôme à afficher
	 */
	public void drawEatableGhost(Graphics g, Ghost actual) {
		if (hero.getTimer_superPacman() >= 625) {
			if (hero.getTimer_superPacman() % 25 < 13) {
				g.drawImage(myimage.getGhost("White", ""), actual.getCoordX(), actual.getCoordY(), this);
			} else {
				g.drawImage(myimage.getGhost("Blue", ""), actual.getCoordX(), actual.getCoordY(), this);
			}
		} else {
			g.drawImage(myimage.getGhost("Blue", ""), actual.getCoordX(), actual.getCoordY(), this);
		}
	}

	/**
	 * Affichage des fantomes en fonction de leur direction et de leur état
	 * 
	 * @param g
	 *            Fenêtre actuelle
	 * 
	 */
	public void drawGhost(Graphics g) {
		/*
		 * affichage des 4 fantomes en fonction de: - leur etat
		 * (0->normal,1->bleu,2->yeux) - leur direction
		 */
		switch (blinky.getState()) {
		case 0:
			drawDirectionGhost(g, blinky, myimage.getGhost("Blinky", "up"), myimage.getGhost("Blinky", "down"),
					myimage.getGhost("Blinky", "left"), myimage.getGhost("Blinky", "right"));
			break;
		case 1:
			drawEatableGhost(g, blinky);
			break;
		case 2:
			drawDirectionGhost(g, blinky, myimage.getGhost("Eye", "up"), myimage.getGhost("Eye", "down"),
					myimage.getGhost("Eye", "left"), myimage.getGhost("Eye", "right"));
			break;
		}
		switch (inky.getState()) {
		case 0:
			drawDirectionGhost(g, inky, myimage.getGhost("Inky", "up"), myimage.getGhost("Inky", "down"),
					myimage.getGhost("Inky", "left"), myimage.getGhost("Inky", "right"));
			break;
		case 1:
			drawEatableGhost(g, inky);
			break;
		case 2:
			drawDirectionGhost(g, inky, myimage.getGhost("Eye", "up"), myimage.getGhost("Eye", "down"),
					myimage.getGhost("Eye", "left"), myimage.getGhost("Eye", "right"));
			break;
		}
		switch (pinky.getState()) {
		case 0:
			drawDirectionGhost(g, pinky, myimage.getGhost("Pinky", "up"), myimage.getGhost("Pinky", "down"),
					myimage.getGhost("Pinky", "left"), myimage.getGhost("Pinky", "right"));
			break;
		case 1:
			drawEatableGhost(g, pinky);
			break;
		case 2:
			drawDirectionGhost(g, pinky, myimage.getGhost("Eye", "up"), myimage.getGhost("Eye", "down"),
					myimage.getGhost("Eye", "left"), myimage.getGhost("Eye", "right"));
			break;
		}
		switch (clyde.getState()) {
		case 0:
			drawDirectionGhost(g, clyde, myimage.getGhost("Clyde", "up"), myimage.getGhost("Clyde", "down"),
					myimage.getGhost("Clyde", "left"), myimage.getGhost("Clyde", "right"));
			break;
		case 1:
			drawEatableGhost(g, clyde);
			break;
		case 2:
			drawDirectionGhost(g, clyde, myimage.getGhost("Eye", "up"), myimage.getGhost("Eye", "down"),
					myimage.getGhost("Eye", "left"), myimage.getGhost("Eye", "right"));
			break;
		}

	}

	/**
	 * Getter du fantôme Blinky
	 * 
	 * @return Blinky
	 */
	public Ghost getBlinky() {
		return blinky;
	}

	/**
	 * Setter du fantôme Blinky
	 * 
	 * @param blinky
	 *            nouvelle état du fantôme
	 */
	public void setBlinky(Ghost blinky) {
		this.blinky = blinky;
	}

	/**
	 * Getter du fantôme Pinky
	 * 
	 * @return Pinky
	 */
	public Ghost getPinky() {
		return pinky;
	}

	/**
	 * Setter du fantôme Pinky
	 * 
	 * @param pinky
	 *            nouvelle état du fantôme
	 */
	public void setPinky(Ghost pinky) {
		this.pinky = pinky;
	}

	/**
	 * Getter du fantôme Inky
	 * 
	 * @return Inky
	 */
	public Ghost getInky() {
		return inky;
	}

	/**
	 * Setter du fantôme Inky
	 * 
	 * @param inky
	 *            nouvelle état du fantôme
	 */
	public void setInky(Ghost inky) {
		this.inky = inky;
	}

	/**
	 * Getter du fantôme Clyde
	 * 
	 * @return Clyde
	 */
	public Ghost getClyde() {
		return clyde;
	}

	/**
	 * Setter du fantôme Clyde
	 * 
	 * @param clyde
	 *            nouvelle état du fantôme
	 */
	public void setClyde(Ghost clyde) {
		this.clyde = clyde;
	}

	/**
	 * Getter de la forme du pacman
	 * 
	 * @return la forme
	 */
	public boolean getForm_pacman() {
		return this.form_pacman;
	}

	/**
	 * Setter de la forme du pacman
	 * 
	 * @param new_form
	 *            nouvelle forme
	 */
	public void setForm_pacman(boolean new_form) {
		this.form_pacman = new_form;
	}

	/**
	 * Getter du timer de la l'animation du pacman
	 * 
	 * @return le timer
	 */
	public int getTimer_anim_pacman() {
		return timer_anim_pacman;
	}

	/**
	 * Setter du timer de la forme du pacman
	 * 
	 * @param timer_anim_pacman
	 *            nouveau timer
	 */
	public void setTimer_anim_pacman(int timer_anim_pacman) {
		this.timer_anim_pacman = timer_anim_pacman;
	}

	/**
	 * Setter du pacman
	 * 
	 * @param hero
	 *            nouveau pacman
	 */
	public void setHero(Pacman hero) {
		this.hero = hero;
	}

	/**
	 * Setter de la pause
	 * 
	 * @param _pause
	 *            nouvelle état
	 */
	public void setPause(boolean _pause) {
		this.pause = _pause;
	}

	/**
	 * Setter des nous
	 * 
	 * @param bonus
	 *            nouveaux états
	 */
	public void setBonus(boolean[] bonus) {
		this.bonus = bonus;
	}

	/**
	 * Setter du compteur
	 * 
	 * @param i
	 *            ième seconde
	 */
	public void setCounter(int i) {
		this.counter = i;
	}

}