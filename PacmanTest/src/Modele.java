import java.io.IOException;

public class Modele {

	public enum Direction {
		UP, DOWN, LEFT, RIGHT, UNKNOW
	}

	// taille de la fenêtre
	static int maxX = 532;
	static int maxY = 644;
	// taille du labyrinthe
	static int[][] labyrinth;
	// taille d'une case en pixels
	static int length_box = 28;
	// nombre de gommes dans le labyrinthe
	static int gumGum;
	// Nom du fichier dans lequel le niveau est enregistré
	static String file_name = "new";
	// nombre de pixels parcourus par tour
	static int deplacement = 1;

	public static void fillMyTab() {
		try {
			IOTreatment.readMatrix(file_name);
		} catch (IOException e) {
			System.out.println("Erreur IO");
		}

		/*
		 * for (int i = 0; i < 19; i++) { for (int j = 0; j < 22; j++) {
		 * labyrinth[i][j] = ; }}
		 */

	}

	public static void canIEatTheGum(Pacman hero) {

		int x = (hero.getCoordX() / length_box) % 19;
		int y = (hero.getCoordY() / length_box) % 22;
		switch (hero.getGo()) {
		case DOWN:
			y = ((hero.getCoordY() + (length_box / 2)) / length_box) % 22;
			break;
		case UP:
			y = ((hero.getCoordY() + (length_box / 2)) / length_box) % 22;
			break;
		case LEFT:
			x = ((hero.getCoordX() + (length_box / 2)) / length_box) % 19;
			break;
		case RIGHT:
			x = ((hero.getCoordX() + (length_box / 2)) / length_box) % 19;
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
		case "stage1.txt":
			file_name = "stage2.txt";
			break;
		default:
			System.exit(0);
		}
	}

	public static boolean meetTheFantom(Ghost actual, Pacman hero) {
		// tester si un des 4 coins de pacman se trouve dans la hitbox du
		// fantome actual

		// haut-gauche
		if (hero.getCoordX() >= actual.getCoordX() && hero.getCoordX() <= (actual.getCoordX() + actual.getLength_box())
				&& hero.getCoordY() >= actual.getCoordY()
				&& hero.getCoordY() <= (actual.getCoordY() + actual.getLength_box()) ||
				// Haut-droit
				(hero.getCoordX() + length_box) >= actual.getCoordX()
						&& (hero.getCoordX() + length_box) <= (actual.getCoordX() + actual.getLength_box())
						&& hero.getCoordY() >= actual.getCoordY()
						&& hero.getCoordY() <= (actual.getCoordY() + actual.getLength_box())
				||
				// bas-gauche
				hero.getCoordX() >= actual.getCoordX()
						&& hero.getCoordX() <= (actual.getCoordX() + actual.getLength_box())
						&& (hero.getCoordY() + length_box) >= actual.getCoordY()
						&& (hero.getCoordY() + length_box) <= (actual.getCoordY() + actual.getLength_box())
				||
				// bas-droite
				(hero.getCoordX() + length_box) >= actual.getCoordX()
						&& (hero.getCoordX() + length_box) <= (actual.getCoordX() + actual.getLength_box())
						&& (hero.getCoordY() + length_box) >= actual.getCoordY()
						&& (hero.getCoordY() + length_box) <= (actual.getCoordY() + actual.getLength_box())) {
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

		Pacman hero = new Pacman();

		// Utilisés plus loin pour lire la matrice
		int x, y;

		// Vrai si pacman se fait attraper
		boolean catchMeIfYouCan = false;
		// Vrai si la partie est gagnée
		boolean win = false;
		whatsTheName();

		while (true) {
			// Init fichier
			if (win) {
				whatsTheName();
				win=false;
			}
			// Init labyrinth
			fillMyTab();

			catchMeIfYouCan = false;

			// Init pacman
			hero.reset(252, 448, Direction.UP, Direction.UP, deplacement, length_box);

			// Init fantomes
			blinky = new Ghost(252, 224, 0, "Blinky", deplacement, length_box);
			pinky = new Ghost(280, 280, 0, "Pinky", deplacement, length_box);
			inky = new Ghost(252, 280, 0, "Inky", deplacement, length_box);
			clyde = new Ghost(224, 280, 0, "Clyde", deplacement, length_box);

			vue.majVue(hero, maxX, maxY, blinky, pinky, inky, clyde);

			// Attente de 5 secondes avant le début de chaque partie
			try {
				Thread.sleep(3000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			while (gumGum > 0 && !catchMeIfYouCan) {
				hero.setToGo(controle.tellMeTheWayToGoPlease());

				// Deplacement de Pacman
				if (hero.getToGo() != hero.getGo()) {
					if (hero.canIGoHere(hero.getToGo()) == true) {
						hero.setGo(hero.getToGo());
					}
				}
				if (hero.canIGoHere(hero.getGo())) {
					hero.actualize_XY();
				}

				// Test si on mange une gomme
				canIEatTheGum(hero);

				// Deplacement des fantomes
				blinky.deplaceTheFantom(hero.getCoordX(), hero.getCoordY(), hero.getGo());
				pinky.deplaceTheFantom(hero.getCoordX(), hero.getCoordY(), hero.getGo());
				inky.deplaceTheFantom(hero.getCoordX(), hero.getCoordY(), hero.getGo());
				clyde.deplaceTheFantom(hero.getCoordX(), hero.getCoordY(), hero.getGo());

				vue.refresh();

				// si on se fait attraper par un fantome
				if (meetTheFantom(blinky, hero) || meetTheFantom(pinky, hero) || meetTheFantom(inky, hero)
						|| meetTheFantom(clyde, hero)) {
					catchMeIfYouCan = true;
				}
				try {
					Thread.sleep(8);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
			if(gumGum==0){
				win=true;
			}
			if (hero.getLife() <= 0) {
				System.exit(0);
			}
		}
	}

}
