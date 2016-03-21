package Vue;

import java.awt.Image;
import java.io.IOException;

import javax.imageio.ImageIO;

/**
 * Précharge toutes les images du jeu pour pouvoir les afficher plus rapidement
 * et proprement
 * 
 * @author Duchene Herrmann Rety
 *
 */
public class MyImage {

	/**
	 * tableau des images du labyrinth
	 */
	private Image[] mylab;

	/**
	 * tableau des images des bonus
	 */
	private Image[] mybonus;

	/**
	 * tableau des images du pacman
	 */
	private Image[] mypacman;

	/**
	 * tableau des images des fantômes
	 */
	private Image[] myghost;

	/**
	 * Contructeur de MyImage, chargement de toutes les images du dossier image
	 * et création des tableaux regroupant ces images
	 * 
	 */
	public MyImage() {
		mylab = new Image[27];
		mybonus = new Image[4];
		mypacman = new Image[8];
		myghost = new Image[22];
		try { // chargement des images

			mylab[0] = ImageIO.read(Vue.class.getResource("image/case0.png"));
			mylab[1] = ImageIO.read(Vue.class.getResource("image/case1.png"));
			mylab[26] = ImageIO.read(Vue.class.getResource("image/case-5.png"));
			mylab[2] = ImageIO.read(Vue.class.getResource("image/case2.png"));
			mylab[3] = ImageIO.read(Vue.class.getResource("image/case3.png"));
			mylab[4] = ImageIO.read(Vue.class.getResource("image/case4.png"));
			mylab[5] = ImageIO.read(Vue.class.getResource("image/case5.png"));
			mylab[6] = ImageIO.read(Vue.class.getResource("image/case6.png"));
			mylab[7] = ImageIO.read(Vue.class.getResource("image/case7.png"));
			mylab[8] = ImageIO.read(Vue.class.getResource("image/case8.png"));
			mylab[9] = ImageIO.read(Vue.class.getResource("image/case9.png"));
			mylab[10] = ImageIO.read(Vue.class.getResource("image/case10.png"));
			mylab[11] = ImageIO.read(Vue.class.getResource("image/case11.png"));
			mylab[12] = ImageIO.read(Vue.class.getResource("image/case12.png"));
			mylab[13] = ImageIO.read(Vue.class.getResource("image/case13.png"));
			mylab[14] = ImageIO.read(Vue.class.getResource("image/case14.png"));
			mylab[15] = ImageIO.read(Vue.class.getResource("image/case15.png"));
			mylab[16] = ImageIO.read(Vue.class.getResource("image/case16.png"));
			mylab[17] = ImageIO.read(Vue.class.getResource("image/case17.png"));
			mylab[18] = ImageIO.read(Vue.class.getResource("image/case18.png"));
			mylab[19] = ImageIO.read(Vue.class.getResource("image/case19.png"));
			mylab[20] = ImageIO.read(Vue.class.getResource("image/case20.png"));
			mylab[21] = ImageIO.read(Vue.class.getResource("image/case21.png"));
			mylab[22] = ImageIO.read(Vue.class.getResource("image/case22.png"));
			mylab[23] = ImageIO.read(Vue.class.getResource("image/case23.png"));
			mylab[24] = ImageIO.read(Vue.class.getResource("image/case24.png"));
			mylab[25] = ImageIO.read(Vue.class.getResource("image/case25.png"));
			mypacman[1] = ImageIO.read(Vue.class.getResource("image/Pacman_left.png"));
			mypacman[2] = ImageIO.read(Vue.class.getResource("image/Pacman_right.png"));
			mypacman[3] = ImageIO.read(Vue.class.getResource("image/Pacman_up.png"));
			mypacman[4] = ImageIO.read(Vue.class.getResource("image/Pacman_down.png"));
			mypacman[0] = ImageIO.read(Vue.class.getResource("image/Pacman_close.png"));
			mypacman[5] = ImageIO.read(Vue.class.getResource("image/Pacman_mort1.png"));
			mypacman[6] = ImageIO.read(Vue.class.getResource("image/Pacman_mort2.png"));
			mypacman[7] = ImageIO.read(Vue.class.getResource("image/Pacman_mort3.png"));
			myghost[0] = ImageIO.read(Vue.class.getResource("image/Blinky_left.png"));
			myghost[1] = ImageIO.read(Vue.class.getResource("image/Blinky_up.png"));
			myghost[2] = ImageIO.read(Vue.class.getResource("image/Blinky_down.png"));
			myghost[3] = ImageIO.read(Vue.class.getResource("image/Blinky_right.png"));
			myghost[4] = ImageIO.read(Vue.class.getResource("image/Clyde_left.png"));
			myghost[5] = ImageIO.read(Vue.class.getResource("image/Clyde_up.png"));
			myghost[6] = ImageIO.read(Vue.class.getResource("image/Clyde_down.png"));
			myghost[7] = ImageIO.read(Vue.class.getResource("image/Clyde_right.png"));
			myghost[8] = ImageIO.read(Vue.class.getResource("image/Inky_left.png"));
			myghost[9] = ImageIO.read(Vue.class.getResource("image/Inky_up.png"));
			myghost[10] = ImageIO.read(Vue.class.getResource("image/Inky_down.png"));
			myghost[11] = ImageIO.read(Vue.class.getResource("image/Inky_right.png"));
			myghost[12] = ImageIO.read(Vue.class.getResource("image/Pinky_left.png"));
			myghost[13] = ImageIO.read(Vue.class.getResource("image/Pinky_up.png"));
			myghost[14] = ImageIO.read(Vue.class.getResource("image/Pinky_down.png"));
			myghost[15] = ImageIO.read(Vue.class.getResource("image/Pinky_right.png"));
			myghost[20] = ImageIO.read(Vue.class.getResource("image/Blue_Ghost.png"));
			myghost[21] = ImageIO.read(Vue.class.getResource("image/White_Ghost.png"));
			myghost[19] = ImageIO.read(Vue.class.getResource("image/Eyes_right.png"));
			myghost[17] = ImageIO.read(Vue.class.getResource("image/Eyes_up.png"));
			myghost[18] = ImageIO.read(Vue.class.getResource("image/Eyes_down.png"));
			myghost[16] = ImageIO.read(Vue.class.getResource("image/Eyes_left.png"));
			mybonus[0] = ImageIO.read(Vue.class.getResource("image/Fraise.png"));
			mybonus[1] = ImageIO.read(Vue.class.getResource("image/Orange.png"));
			mybonus[2] = ImageIO.read(Vue.class.getResource("image/Cerise.png"));
			mybonus[3] = ImageIO.read(Vue.class.getResource("image/Pomme.png"));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/**
	 * Retourne l'image à la case i du tableau lab
	 * 
	 * @param i
	 *            ième case du tableau
	 * @return l'image correspondante
	 */
	public Image getCase(int i) {
		return mylab[i];
	}

	/**
	 * Retourne l'image d'un fantôme dans une direction du tableau myghost
	 * 
	 * @param name
	 *            nom du fantôme
	 * @param direction
	 *            direction du fantôme
	 * @return l'image correspondante
	 */
	public Image getGhost(String name, String direction) {
		int i;
		switch (name) {
		case "Blinky":
			i = 0;
			switch (direction) {
			case "left":
				return myghost[4 * i];
			case "up":
				return myghost[4 * i + 1];
			case "down":
				return myghost[4 * i + 2];
			case "right":
				return myghost[4 * i + 3];
			}
		case "Pinky":
			i = 3;
			switch (direction) {
			case "left":
				return myghost[4 * i];
			case "up":
				return myghost[4 * i + 1];
			case "down":
				return myghost[4 * i + 2];
			case "right":
				return myghost[4 * i + 3];
			}
		case "Clyde":
			i = 1;
			switch (direction) {
			case "left":
				return myghost[4 * i];
			case "up":
				return myghost[4 * i + 1];
			case "down":
				return myghost[4 * i + 2];
			case "right":
				return myghost[4 * i + 3];
			}
		case "Inky":
			i = 2;
			switch (direction) {
			case "left":
				return myghost[4 * i];
			case "up":
				return myghost[4 * i + 1];
			case "down":
				return myghost[4 * i + 2];
			case "right":
				return myghost[4 * i + 3];
			}
		case "Eye":
			i = 4;
			switch (direction) {
			case "left":
				return myghost[4 * i];
			case "up":
				return myghost[4 * i + 1];
			case "down":
				return myghost[4 * i + 2];
			case "right":
				return myghost[4 * i + 3];
			}
		case "Blue":
			return myghost[20];
		case "White":
			return myghost[21];
		default:
			return null;
		}
	}

	/**
	 * Retourne l'image d'une bonus du tableau mybonus
	 * 
	 * @param name
	 *            nom du bonus
	 * @return l'image correspondante
	 */
	public Image getBonus(String name) {
		switch (name) {
		case "Fraise":
			return mybonus[0];
		case "Orange":
			return mybonus[1];
		case "Cerise":
			return mybonus[2];
		case "Pomme":
			return mybonus[3];
		default:
			return null;
		}
	}

	/**
	 * Retourne l'image d'une direction de pacman du tableau mypacman
	 * 
	 * @param name
	 *            nom de la direction du pacman
	 * @return l'image correspondante
	 */
	public Image getPacman(String name) {
		switch (name) {
		case "left":
			return mypacman[1];
		case "up":
			return mypacman[3];
		case "down":
			return mypacman[4];
		case "right":
			return mypacman[2];
		case "close":
			return mypacman[0];
		case "mort1":
			return mypacman[5];
		case "mort2":
			return mypacman[6];
		case "mort3":
			return mypacman[7];
		default:
			return null;
		}
	}
}
