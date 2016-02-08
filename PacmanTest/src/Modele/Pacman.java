package Modele;

import Controller.*;

public class Pacman {

	// Coordonnées de Pacman
	private int coordX;
	private int coordY;
	// Direction dans laquelle Pacman va actuellement
	private Controller.Direction go;
	/*
	 * Direction choisie par l'utilisateur et dans laquelle il faudra aller dès
	 * que Pacman pourra
	 */
	private Controller.Direction toGo;
	// Nombre de vies de Pacman
	private int life;
	// Nombre de pixels parcourus par Pacman à chaque tour de boucle
	private int deplacement;
	// Taille de la hitbox de Pacman
	private int length_box;

	// Constructeur
	public Pacman() {
		this.life = 3;
	}

	/*
	 * Reset entier du pacman à ses coordonnées d'origine et sa direction
	 * d'origine
	 */
	public void reset(int _coordX, int _coordY, Controller.Direction _go, Controller.Direction _toGo, int _deplacement,
			int _length_box) {
		this.coordX = _coordX;
		this.coordY = _coordY;
		this.go = _go;
		this.toGo = _toGo;
		this.deplacement = _deplacement;
		this.length_box = _length_box;
	}

	/*
	 * Actualise les coordonnées x et y de Pacman en fonction de sa direction
	 * actuelle
	 */
	public void actualize_XY() {
		switch (go) {
		case UP:
			if (coordY - deplacement < 0) {
				coordY = Modele.maxY - length_box;
			} else {
				coordY -= deplacement;
			}
			break;
		case DOWN:
			if (coordY + deplacement + length_box > Modele.maxY) {
				coordY = 0;
			} else {
				coordY += deplacement;
			}
			break;
		case LEFT:
			if (coordX - deplacement < 0) {
				coordX = Modele.maxX - length_box - 122;
			} else {
				coordX -= deplacement;
			}
			break;
		case RIGHT:
			if (coordX + deplacement + length_box > Modele.maxX - 122) {
				coordX = 0;
			} else {
				coordX += deplacement;
			}
			break;
		default:
		}
	}

	// Teste si Pacman est contre un mur
	public boolean letMeDoTheSmartThings(int tempX, int tempY) {
		tempX = (tempX / length_box) % 19;
		tempY = (tempY / length_box) % 22;
		if (Modele.labyrinth[tempX][tempY] > 1)
			return false;
		else
			return true;
	}

	// Regarde si Pacman peut avancer dans la direction toTest
	public boolean canIGoHere(Controller.Direction toTest) {

		switch (toTest) {
		case UP:
			return (letMeDoTheSmartThings(coordX + length_box - deplacement, coordY - deplacement)
					&& letMeDoTheSmartThings(coordX, coordY - deplacement));
		case DOWN:
			return (letMeDoTheSmartThings(coordX, coordY + length_box)
					&& letMeDoTheSmartThings(coordX + length_box - deplacement, coordY + length_box));
		case LEFT:
			return letMeDoTheSmartThings(coordX - deplacement, coordY)
					&& letMeDoTheSmartThings(coordX - deplacement, coordY + length_box - deplacement);
		case RIGHT:
			return letMeDoTheSmartThings(coordX + length_box, coordY + length_box - deplacement)
					&& letMeDoTheSmartThings(coordX + length_box, coordY);
		default:
		}
		return false;
	}

	public void looseLife() {
		this.life--;
	}

	public int getLife() {
		return life;
	}

	public void setLife(int _life) {
		this.life = _life;
	}

	public int getLength_box() {
		return length_box;
	}

	public Controller.Direction getGo() {
		return go;
	}

	public void setGo(Controller.Direction go) {
		this.go = go;
	}

	public Controller.Direction getToGo() {
		return toGo;
	}

	public void setToGo(Controller.Direction toGo) {
		this.toGo = toGo;
	}

	/*
	 * Setter spécifique de toGo pour Pacman en cas de clic de la souris de
	 * l'utilisateur
	 */
	public Controller.Direction setToGo(int mouseX, int mouseY) {
		mouseY = mouseY - 25;
		int x = this.coordX - mouseX;
		int y = this.coordY - mouseY;
		if (Math.abs(x) > Math.abs(y)) {
			if (x > 0) {
				this.toGo = Controller.Direction.LEFT;
			} else {
				this.toGo = Controller.Direction.RIGHT;
			}
		} else {
			if (y > 0) {
				this.toGo = Controller.Direction.UP;
			} else {
				this.toGo = Controller.Direction.DOWN;
			}
		}
		return this.toGo;
	}

	public int getCoordX() {
		return coordX;
	}

	public void setCoordX(int coordX) {
		this.coordX = coordX;
	}

	public int getCoordY() {
		return coordY;
	}

	public void setCoordY(int coordY) {
		this.coordY = coordY;
	}
}
