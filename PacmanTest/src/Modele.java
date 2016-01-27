import java.io.IOException;

public class Modele {

	public enum Direction {
		UP, DOWN, LEFT, RIGHT, UNKNOW
	}

	// taille de la fenêtre
	static int maxX = 532;
	static int maxY = 644;
	// placement de Pacman
	static int coordX;
	static int coordY;
	// taille du labyrinthe
	static int[][] labyrinth;
	// vitesse de Pacman
	static int deplacement = 1;
	// taille d'une case en pixels
	static int length_box = 28;
	// nombre de gommes dans le labyrinthe
	static int gumGum;
	// Nom du fichier dans lequel le niveau est enregistré
	static String file_name = "new";

	public static void fillMyTab() {
		try {
			IOTreatment.readMatrix(file_name);
		} catch (IOException e) {
			System.out.println("Erreur IO");
		}

		/*
		 * for (int i = 0; i < 28; i++) { for (int j = 0; j < 31; j++) {
		 * labyrinth[i][j] = 0; } } labyrinth[2][2] = 21; labyrinth[3][2] = 23;
		 * labyrinth[4][2] = 1; labyrinth[1][1] = 18; labyrinth[7][7] = 2;
		 * labyrinth[8][7] = 18; labyrinth[9][7] = 1; labyrinth[8][5] = 1;
		 * labyrinth[8][9] = 1; labyrinth[8][3] = 1; labyrinth[8][1] = 10;
		 * labyrinth[8][2] = 11; labyrinth[8][6] = 3; labyrinth[8][0] = 1;
		 * labyrinth[15][15]=8; labyrinth[16][15]=9;
		 */
	}

	public static boolean letMeDoTheSmartThings(int tempX, int tempY) {
		tempX = (tempX / length_box) % 19;
		tempY = (tempY / length_box) % 22;
		if (labyrinth[tempX][tempY] > 1)
			return false;
		else
			return true;
	}

	public static boolean canIGoHere(Direction toTest) {

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

	public static void actualize_XY(Direction go) {
		switch (go) {
		case UP:
			if (coordY - deplacement < 0) {
				coordY = maxY - length_box;
			} else {
				coordY -= deplacement;
			}
			break;
		case DOWN:
			if (coordY + deplacement + length_box > maxY) {
				coordY = 0;
			} else {
				coordY += deplacement;
			}
			break;
		case LEFT:
			if (coordX - deplacement < 0) {
				coordX = maxX - length_box;
			} else {
				coordX -= deplacement;
			}
			break;
		case RIGHT:
			if (coordX + deplacement + length_box > maxX) {
				coordX = 0;
			} else {
				coordX += deplacement;
			}
			break;
		default:
		}
	}

	public static void canIEatTheGum(Direction go) {

		int x = (coordX / length_box) % 19;
		int y = (coordY / length_box) % 22;
		switch (go) {
		case DOWN:
			y = ((coordY + (length_box / 2)) / length_box) % 22;
			break;
		case UP:
			y = ((coordY + (length_box / 2)) / length_box) % 22;
			break;
		case LEFT:
			x = ((coordX + (length_box / 2)) / length_box) % 19;
			break;
		case RIGHT:
			x = ((coordX + (length_box / 2)) / length_box) % 19;
			break;
		}
		if (labyrinth[x][y] == 1) {
			labyrinth[x][y] = 0;
			gumGum--;
		}
	}

	public static void whatsTheName() {

		switch (file_name) {
		case "new":
			file_name = "stage1.txt";
			break;
		case "matrix.txt":
			file_name = "stage2.txt";
			break;
		default:
			System.exit(0);
		}
	}

	public static boolean meetTheFantom(Ghost actual) {
		// tester si un des 4 coins de pacman se trouve dans la hitbox du
		// fantome actual

		// haut-gauche
		if (coordX >= actual.getCoordX() && coordX <= (actual.getCoordX() + actual.getLength_box())
				&& coordY >= actual.getCoordY() && coordY <= (actual.getCoordY() + actual.getLength_box()) ||
				// Haut-droit
				(coordX + length_box) >= actual.getCoordX()
						&& (coordX + length_box) <= (actual.getCoordX() + actual.getLength_box())
						&& coordY >= actual.getCoordY() && coordY <= (actual.getCoordY() + actual.getLength_box())
				||
				// bas-gauche
				coordX >= actual.getCoordX() && coordX <= (actual.getCoordX() + actual.getLength_box())
						&& (coordY + length_box) >= actual.getCoordY()
						&& (coordY + length_box) <= (actual.getCoordY() + actual.getLength_box())
				||
				// bas-droite
				(coordX + length_box) >= actual.getCoordX()
						&& (coordX + length_box) <= (actual.getCoordX() + actual.getLength_box())
						&& (coordY + length_box) >= actual.getCoordY()
						&& (coordY + length_box) <= (actual.getCoordY() + actual.getLength_box())) {
			return true;
		} else {
			return false;
		}
	}

	public static void main(String[] args) {
		Controleur controle = new Controleur(0, 0, 0, 0);
		Vue vue = new Vue(controle);

		// Fantomes
		Ghost blinky;
		Ghost pinky;
		Ghost inky;
		Ghost clyde;

		// Utilisés plus loin pour lire la matrice
		int x, y;

		while (true) {
			// Init fichier
			whatsTheName();
			// Init labyrinth
			fillMyTab();
			// Init direction de pacman
			Direction go = Direction.UP;
			Direction toGo = Direction.UP;
			// Init position de pacman
			coordX = 252;
			coordY = 448;

			// Init fantomes
			blinky = new Ghost(252, 224, 0, "Blinky", deplacement, length_box);
			pinky = new Ghost(280, 280, 0, "Pinky", deplacement, length_box);
			inky = new Ghost(252, 280, 0, "Inky", deplacement, length_box);
			clyde = new Ghost(224, 280, 0, "Clyde", deplacement, length_box);

			vue.majVue(coordX, coordY, maxX, maxY, blinky, pinky, inky, clyde, go);

			// Attente de 5 secondes avant le début de chaque partie
			try {
				Thread.sleep(5000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			while (gumGum > 0) {
				toGo = controle.tellMeTheWayToGoPlease();

				// Deplacement de Pacman
				if (toGo != go) {
					if (canIGoHere(toGo) == true) {
						go = toGo;
					}
				}
				if (canIGoHere(go)) {
					actualize_XY(go);
				}

				// Test si on mange une gomme
				canIEatTheGum(go);

				// Deplacement des fantomes
				blinky.deplaceTheFantom(coordX, coordY, go);
				pinky.deplaceTheFantom(coordX, coordY, go);
				inky.deplaceTheFantom(coordX, coordY, go);
				clyde.deplaceTheFantom(coordX, coordY, go);

				vue.refresh(coordX, coordY, go);

				if (meetTheFantom(blinky) || meetTheFantom(pinky) || meetTheFantom(inky) || meetTheFantom(clyde)) {
					coordX = 252;
					coordY = 448;
				}
				try {
					Thread.sleep(8);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}
	}

}
