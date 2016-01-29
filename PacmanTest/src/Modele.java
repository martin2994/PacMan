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
	}

	public static boolean canIEatTheGum(Pacman hero) {

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
		if (labyrinth[x][y] == -5) {
			labyrinth[x][y] = 0;
			gumGum--;
			return true;
		}
		if (labyrinth[x][y] == 1) {
			labyrinth[x][y] = 0;
			gumGum--;
		}
		return false;
	}

	public static void superPacman(Ghost actual) {
		if (actual.getState() == 0 || actual.getState() == 1)
			actual.setState(1);
	}

	public static void normalPacman(Ghost actual) {
		if (actual.getState() == 1)
			actual.setState(0);
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
		if ((hero.getCoordX() + hero.getLength_box() / 2) >= actual.getCoordX()
				&& (hero.getCoordX() + hero.getLength_box() / 2) <= (actual.getCoordX() + actual.getLength_box())
				&& (hero.getCoordY() + hero.getLength_box() / 2) >= actual.getCoordY()
				&& (hero.getCoordY() + hero.getLength_box() / 2) <= (actual.getCoordY() + actual.getLength_box()) ||
				// Haut-droit
				(hero.getCoordX() + hero.getLength_box() / 2) >= actual.getCoordX()
						&& (hero.getCoordX() + hero.getLength_box() / 2) <= (actual.getCoordX()
								+ actual.getLength_box())
						&& (hero.getCoordY() + hero.getLength_box() / 2) >= actual.getCoordY()
						&& (hero.getCoordY() + hero.getLength_box() / 2) <= (actual.getCoordY()
								+ actual.getLength_box())
				||
				// bas-gauche
				(hero.getCoordX() + hero.getLength_box() / 2) >= actual.getCoordX()
						&& (hero.getCoordX() + hero.getLength_box() / 2) <= (actual.getCoordX()
								+ actual.getLength_box())
						&& (hero.getCoordY() + hero.getLength_box() / 2) >= actual.getCoordY()
						&& (hero.getCoordY() + hero.getLength_box() / 2) <= (actual.getCoordY()
								+ actual.getLength_box())
				||
				// bas-droite
				(hero.getCoordX() + hero.getLength_box() / 2) >= actual.getCoordX()
						&& (hero.getCoordX() + hero.getLength_box() / 2) <= (actual.getCoordX()
								+ actual.getLength_box())
						&& (hero.getCoordY() + hero.getLength_box() / 2) >= actual.getCoordY() && (hero.getCoordY()
								+ hero.getLength_box() / 2) <= (actual.getCoordY() + actual.getLength_box())) {
			return true;
		} else {
			return false;
		}
	}

	public static void main(String[] args) {
		Controleur controle = new Controleur(Direction.UP);
		Vue vue = new Vue(controle);

		// Fantomes
		Ghost blinky;
		Ghost pinky;
		Ghost inky;
		Ghost clyde;
		int cpt = 0;

		Pacman hero = new Pacman();

		// Utilisés plus loin pour lire la matrice
		int x, y;

		// Vrai si pacman se fait attraper
		boolean catchMeIfYouCan = false;
		// Vrai si la partie est gagnée
		boolean win = false;
		whatsTheName();
		fillMyTab();

		while (true) {
			// Init fichier
			if (win) {
				whatsTheName();
				win = false;
				hero.setLife(3);
				// Init labyrinth
				fillMyTab();
			}

			catchMeIfYouCan = false;

			// Init pacman
			hero.reset(252, 448, Direction.UP, Direction.UP, deplacement, length_box);

			// Init fantomes
			blinky = new Ghost(252, 224, 0, "Blinky", deplacement, length_box);
			pinky = new Ghost(280, 280, 0, "Pinky", deplacement, length_box);
			inky = new Ghost(252, 280, 0, "Inky", deplacement, length_box);
			clyde = new Ghost(224, 280, 0, "Clyde", deplacement, length_box);

			vue.majVue(hero, maxX, maxY, blinky, pinky, inky, clyde);

			// Attente de 3 secondes avant le début de chaque partie
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
				if (canIEatTheGum(hero)) {
					cpt = 1;
					superPacman(blinky);
					superPacman(inky);
					superPacman(clyde);
					superPacman(pinky);
				}
				if (cpt == 500) {
					cpt = 0;
					normalPacman(blinky);
					normalPacman(clyde);
					normalPacman(pinky);
					normalPacman(inky);
				}

				// Deplacement des fantomes
				if (blinky.getState() == 2) {
					blinky.returnToTheBase();
				} else {
					if ((blinky.getState() == 1 && (blinky.getGame_lap() % 3) == 0) || blinky.getState()==0) {
						blinky.deplaceTheGhost(hero.getCoordX(), hero.getCoordY(), hero.getGo());
					} else {
						blinky.anotherLap();
					}
				}
				if (pinky.getState() == 2) {
					pinky.returnToTheBase();
				} else {
					if ((pinky.getState() == 1 && pinky.getGame_lap() % 3 == 0) || pinky.getState()==0) {
						pinky.deplaceTheGhost(hero.getCoordX(), hero.getCoordY(), hero.getGo());
					} else {
						pinky.anotherLap();
					}
				}
				if (inky.getState() == 2) {
					inky.returnToTheBase();
				} else {
					if ((inky.getState() == 1 && inky.getGame_lap() % 3 == 0) || inky.getState()==0) {
						inky.deplaceTheGhost(hero.getCoordX(), hero.getCoordY(), hero.getGo());
					} else {
						inky.anotherLap();
					}
				}
				if (clyde.getState() == 2) {
					clyde.returnToTheBase();
				} else {
					if ((clyde.getState() == 1 && clyde.getGame_lap() % 3 == 0) || clyde.getState()==0) {
						clyde.deplaceTheGhost(hero.getCoordX(), hero.getCoordY(), hero.getGo());
					} else {
						clyde.anotherLap();
					}
				}
				vue.refresh();

				if (blinky.getState() == 1 || clyde.getState() == 1 || pinky.getState() == 1 || inky.getState() == 1)
					cpt++;

				if (meetTheFantom(blinky, hero)) {
					if (blinky.getState() == 1) {
						blinky.setState(2);
					} else {
						if (blinky.getState() == 0)
							catchMeIfYouCan = true;
					}
				}
				if (meetTheFantom(inky, hero)) {
					if (inky.getState() == 1) {
						inky.setState(2);
					} else {
						if (inky.getState() == 0)
							catchMeIfYouCan = true;
					}
				}
				if (meetTheFantom(pinky, hero)) {
					if (pinky.getState() == 1) {
						pinky.setState(2);
					} else {
						if (pinky.getState() == 0)
							catchMeIfYouCan = true;
					}
				}
				if (meetTheFantom(clyde, hero)) {
					if (clyde.getState() == 1) {
						clyde.setState(2);
					} else {
						if (clyde.getState() == 0)
							catchMeIfYouCan = true;
					}
				}
				try {
					Thread.sleep(8);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
			if (gumGum == 0) {
				win = true;
			}
			if (hero.getLife() <= 0) {
				System.exit(0);
			}
		}
	}

}
