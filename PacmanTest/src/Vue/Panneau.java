package Vue;

import Controller.Controller;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JButton;
import javax.swing.JPanel;

import Modele.Ghost;
import Modele.Modele;
import Modele.Pacman;

public class Panneau extends JPanel {
	private Ghost blinky;
	private Ghost pinky;
	private Ghost inky;
	private Ghost clyde;
	private Pacman hero;

	private Image img0;
	private Image img1;
	private Image img_5;
	private Image img2;
	private Image img3;
	private Image img4;
	private Image img5;
	private Image img6;
	private Image img7;
	private Image img8;
	private Image img9;
	private Image img10;
	private Image img11;
	private Image img12;
	private Image img13;
	private Image img14;
	private Image img15;
	private Image img16;
	private Image img17;
	private Image img18;
	private Image img19;
	private Image img20;
	private Image img21;
	private Image img22;
	private Image img23;
	private Image img24;
	private Image pacman_left;
	private Image pacman_right;
	private Image pacman_up;
	private Image pacman_down;
	private Image pacman_close;
	private Image blinky_left;
	private Image blinky_up;
	private Image blinky_down;
	private Image blinky_right;
	private Image clyde_left;
	private Image clyde_up;
	private Image clyde_down;
	private Image clyde_right;
	private Image inky_left;
	private Image inky_up;
	private Image inky_down;
	private Image inky_right;
	private Image pinky_left;
	private Image pinky_up;
	private Image pinky_down;
	private Image pinky_right;
	private Image ghost;
	private Image eyes_right;
	private Image eyes_up;
	private Image eyes_down;
	private Image eyes_left;
	private Image cerise;
	private Image cle;
	private Image fraise;
	private Image orange;
	private Image pomme;
	
	// boolean et timer pour gerer la forme du pacman
	private boolean form_pacman = false;
	private int timer_anim_pacman = 0;

	public Panneau() {
		try { // chargement des images
			img0 = ImageIO.read(new File("src/image/case0.png"));
			img1 = ImageIO.read(new File("src/image/case1.png"));
			img_5 = ImageIO.read(new File("src/image/case-5.png"));
			img2 = ImageIO.read(new File("src/image/case2.png"));
			img3 = ImageIO.read(new File("src/image/case3.png"));
			img4 = ImageIO.read(new File("src/image/case4.png"));
			img5 = ImageIO.read(new File("src/image/case5.png"));
			img6 = ImageIO.read(new File("src/image/case6.png"));
			img7 = ImageIO.read(new File("src/image/case7.png"));
			img8 = ImageIO.read(new File("src/image/case8.png"));
			img9 = ImageIO.read(new File("src/image/case9.png"));
			img10 = ImageIO.read(new File("src/image/case10.png"));
			img11 = ImageIO.read(new File("src/image/case11.png"));
			img12 = ImageIO.read(new File("src/image/case12.png"));
			img13 = ImageIO.read(new File("src/image/case13.png"));
			img14 = ImageIO.read(new File("src/image/case14.png"));
			img15 = ImageIO.read(new File("src/image/case15.png"));
			img16 = ImageIO.read(new File("src/image/case16.png"));
			img17 = ImageIO.read(new File("src/image/case17.png"));
			img18 = ImageIO.read(new File("src/image/case18.png"));
			img19 = ImageIO.read(new File("src/image/case19.png"));
			img20 = ImageIO.read(new File("src/image/case20.png"));
			img21 = ImageIO.read(new File("src/image/case21.png"));
			img22 = ImageIO.read(new File("src/image/case22.png"));
			img23 = ImageIO.read(new File("src/image/case23.png"));
			img24 = ImageIO.read(new File("src/image/case24.png"));
			pacman_left = ImageIO.read(new File("src/image/Pacman_left.png"));
			pacman_right = ImageIO.read(new File("src/image/Pacman_right.png"));
			pacman_up = ImageIO.read(new File("src/image/Pacman_up.png"));
			pacman_down = ImageIO.read(new File("src/image/Pacman_down.png"));
			pacman_close = ImageIO.read(new File("src/image/Pacman_close.png"));
			blinky_left = ImageIO.read(new File("src/image/Blinky_left.png"));
			blinky_up = ImageIO.read(new File("src/image/Blinky_up.png"));
			blinky_down = ImageIO.read(new File("src/image/Blinky_down.png"));
			blinky_right = ImageIO.read(new File("src/image/Blinky_right.png"));
			clyde_left = ImageIO.read(new File("src/image/Clyde_left.png"));
			clyde_up = ImageIO.read(new File("src/image/Clyde_up.png"));
			clyde_down = ImageIO.read(new File("src/image/Clyde_down.png"));
			clyde_right = ImageIO.read(new File("src/image/Clyde_right.png"));
			inky_left = ImageIO.read(new File("src/image/Inky_left.png"));
			inky_up = ImageIO.read(new File("src/image/Inky_up.png"));
			inky_down = ImageIO.read(new File("src/image/Inky_down.png"));
			inky_right = ImageIO.read(new File("src/image/Inky_right.png"));
			pinky_left = ImageIO.read(new File("src/image/Pinky_left.png"));
			pinky_up = ImageIO.read(new File("src/image/Pinky_up.png"));
			pinky_down = ImageIO.read(new File("src/image/Pinky_down.png"));
			pinky_right = ImageIO.read(new File("src/image/Pinky_right.png"));
			ghost = ImageIO.read(new File("src/image/Fantome.png"));
			eyes_right = ImageIO.read(new File("src/image/eyes_right.png"));
			eyes_up = ImageIO.read(new File("src/image/eyes_up.png"));
			eyes_down = ImageIO.read(new File("src/image/eyes_down.png"));
			eyes_left = ImageIO.read(new File("src/image/eyes_left.png"));
			fraise = ImageIO.read(new File("src/image/fraise.png"));
			orange = ImageIO.read(new File("src/image/orange.png"));
			cerise = ImageIO.read(new File("src/image/cerise.png"));
			pomme = ImageIO.read(new File("src/image/pomme.png"));
			cle = ImageIO.read(new File("src/image/cle.png"));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void paintComponent(Graphics g) {
		int mat[][] = Controller.getLabyrinth();
		
		//affichage du fond noir
		g.setColor(Color.black);
		g.fillRect(0, 0, this.getWidth(), this.getHeight());
	
		//affichage du labyrinth
		for (int i = 0; i < 19; i++) {
			for (int j = 0; j < 22; j++) {
				switch (mat[i][j]) {
				case -5:
					g.drawImage(img_5, i * 28, j * 28, this);
					break;
				case 0:
					g.drawImage(img0, i * 28, j * 28, this);
					break;
				case 1:
					g.drawImage(img1, i * 28, j * 28, this);
					break;
				case 2:
					g.drawImage(img2, i * 28, j * 28, this);
					break;
				case 3:
					g.drawImage(img3, i * 28, j * 28, this);
					break;
				case 4:
					g.drawImage(img4, i * 28, j * 28, this);
					break;
				case 5:
					g.drawImage(img5, i * 28, j * 28, this);
					break;
				case 6:
					g.drawImage(img6, i * 28, j * 28, this);
					break;
				case 7:
					g.drawImage(img7, i * 28, j * 28, this);
					break;
				case 8:
					g.drawImage(img8, i * 28, j * 28, this);
					break;
				case 9:
					g.drawImage(img9, i * 28, j * 28, this);
					break;
				case 10:
					g.drawImage(img10, i * 28, j * 28, this);
					break;
				case 11:
					g.drawImage(img11, i * 28, j * 28, this);
					break;
				case 12:
					g.drawImage(img12, i * 28, j * 28, this);
					break;
				case 13:
					g.drawImage(img13, i * 28, j * 28, this);
					break;
				case 14:
					g.drawImage(img14, i * 28, j * 28, this);
					break;
				case 15:
					g.drawImage(img15, i * 28, j * 28, this);
					break;
				case 16:
					g.drawImage(img16, i * 28, j * 28, this);
					break;
				case 17:
					g.drawImage(img17, i * 28, j * 28, this);
					break;
				case 18:
					g.drawImage(img18, i * 28, j * 28, this);
					break;
				case 19:
					g.drawImage(img19, i * 28, j * 28, this);
					break;
				case 20:
					g.drawImage(img20, i * 28, j * 28, this);
					break;
				case 21:
					g.drawImage(img21, i * 28, j * 28, this);
					break;
				case 22:
					g.drawImage(img22, i * 28, j * 28, this);
					break;
				case 23:
					g.drawImage(img23, i * 28, j * 28, this);
					break;
				case 24:
					g.drawImage(img24, i * 28, j * 28, this);
					break;
				}
			}
		}
		//affichage des lignes de séparation labyrinth/option
		g.setColor(Color.white);
		g.fillRect(this.getWidth() - 120, 0, 2, this.getHeight());
		g.fillRect(this.getWidth() - 124, 0, 2, this.getHeight());
		/*
		 * affichage de pacman en fonction de sa direction et du timer
		 * pour faire l'animation
		 */
		if (form_pacman || timer_anim_pacman < 10) {
			switch (hero.getGo()) {
			case UP:
				g.drawImage(pacman_up, hero.getCoordX(), hero.getCoordY(), this);
				break;
			case DOWN:
				g.drawImage(pacman_down, hero.getCoordX(), hero.getCoordY(), this);
				break;
			case LEFT:
				g.drawImage(pacman_left, hero.getCoordX(), hero.getCoordY(), this);
				break;
			case RIGHT:
				g.drawImage(pacman_right, hero.getCoordX(), hero.getCoordY(), this);
				break;
			}
			if (timer_anim_pacman == 9)
				form_pacman = false;
		} else {
			g.drawImage(pacman_close, hero.getCoordX(), hero.getCoordY(), this);
		}
		timer_anim_pacman++;
		// réinitialisation du timer
		if (timer_anim_pacman == 20) {
			timer_anim_pacman = 0;
			form_pacman = true;
		}
		/*
		 * affichage des options:
		 * - le nombre de vie
		 * - les differents bonus 
		 */
		Font font = new Font("Courier", Font.BOLD, 20);
		g.setFont(font);
		g.setColor(Color.white);
		g.drawString("Life:", this.getWidth() - 105, (this.getHeight() / 3) - 28);
		for (int i = 0; i < hero.getLife(); i++) {
			g.drawImage(pacman_right, (this.getWidth() - 105) + i * 28, (this.getHeight() / 3) - 14, this);
		}
		g.drawString("Bonus:", this.getWidth() - 105, 2*(this.getHeight() /3 ) - 28);
		g.drawImage(cerise, this.getWidth() - 105, 2*(this.getHeight() / 3)-10 , this);
		g.drawImage(pomme, this.getWidth() - 50,  2*(this.getHeight() / 3)-10 , this);
		g.drawImage(fraise, this.getWidth() - 105,  2*(this.getHeight() / 3)+ 32, this);
		g.drawImage(orange, this.getWidth() - 50,  2*(this.getHeight() / 3) + 32, this);
		
		/*
		 * affichage des 4 fantomes en fonction de:
		 * - leur etat (0->normal,1->bleu,2->yeux)
		 * - leur direction
		 */
		switch (blinky.getState()) {
		case 0:
			drawGhost(g, blinky, blinky_up, blinky_down, blinky_left, blinky_right);
			break;
		case 1:
			g.drawImage(ghost, blinky.getCoordX(), blinky.getCoordY(), this);
			break;
		case 2:
			drawGhost(g, blinky, eyes_up, eyes_down, eyes_left, eyes_right);
			break;
		}
		switch (inky.getState()) {
		case 0:
			drawGhost(g, inky, inky_up, inky_down, inky_left, inky_right);
			break;
		case 1:
			g.drawImage(ghost, inky.getCoordX(), inky.getCoordY(), this);
			break;
		case 2:
			drawGhost(g, inky, eyes_up, eyes_down, eyes_left, eyes_right);
			break;
		}
		switch (pinky.getState()) {
		case 0:
			drawGhost(g, pinky, pinky_up, pinky_down, pinky_left, pinky_right);
			break;
		case 1:
			g.drawImage(ghost, pinky.getCoordX(), pinky.getCoordY(), this);
			break;
		case 2:
			drawGhost(g, pinky, eyes_up, eyes_down, eyes_left, eyes_right);
			break;
		}
		switch (clyde.getState()) {
		case 0:
			drawGhost(g, clyde, clyde_up, clyde_down, clyde_left, clyde_right);
			break;
		case 1:
			g.drawImage(ghost, clyde.getCoordX(), clyde.getCoordY(), this);
			break;
		case 2:
			drawGhost(g, clyde, eyes_up, eyes_down, eyes_left, eyes_right);
			break;
		}
		//affichage du score
		g.drawString("Score:", this.getWidth() - 105, 50);
		g.drawString("" + Controller.getScore(), this.getWidth() - 105, 75);

	}
	
	/*
	 * méthode d'affichage des fantomes 
	 */
	
	public void drawGhost(Graphics g, Ghost actual, Image up, Image down, Image left, Image right) {
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

}
