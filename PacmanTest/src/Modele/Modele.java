package Modele;

import java.io.File;
import java.io.IOException;

import Controller.*;

public class Modele {

	// taille de la fenêtre
	public static int maxX = 660;
	public static int maxY = 652;
	// taille du labyrinthe
	public static int[][] labyrinth;
	// taille d'une case en pixels
	public static int length_box = 28;
	// nombre de gommes dans le labyrinthe
	public static int gumGum;
	// nombre de gommes total
	public static int totalGumGum;
	// Nom du fichier dans lequel le niveau est enregistré
	public static String file_name = "new";
	// nombre de pixels parcourus par tour
	public static int deplacement = 1;
	/*
	 * tableau des bonus : false : Bonus pas encore apparu true : Bonus apparu
	 */
	public static boolean[] bonus_pop;

	public static boolean[] bonus_eat;

	public static int score;

	public static int difficulty = 50;

	public static String username = "";

	/*
	 * Stage choisi par l'utilisateur
	 */
	public static int stagePlaying = 0;

	/*
	 * Remplit la matrice en fonction des labyrinthes préchargés dans des
	 * fichiers texte
	 */
	public static void fillMyTab() {
		try {
			IOTreatment.readMatrix(file_name);
		} catch (IOException e) {
			System.out.println("Erreur IO");
		}
	}

	public static void pause(Controller controle, Pacman hero, boolean loop, Ghost blinky, Ghost pinky, Ghost inky,
			Ghost clyde) {
		while (loop) {
			try {
				Thread.sleep(10);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			controle.showPause();
			controle.tellMeTheWayToGoPlease();
			updateVue(controle, hero, blinky, pinky, inky, clyde, bonus_eat, false);
			if (hero.getToGo().equals(Controller.Direction.SPACE)) {
				controle.hidePause();
				loop = false;
			}
		}
	}

	public static void updateVue(Controller controle, Pacman hero, Ghost blinky, Ghost pinky, Ghost inky, Ghost clyde,
			boolean[] bonus, boolean reset) {
		controle.majVue(hero, maxX, maxY, blinky, pinky, inky, clyde, bonus, reset);
	}

	/*
	 * Regarde si Pacman est en train de manger une gomme ou un super gomme afin
	 * de mettre à jour le score et l'affichage
	 */
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
		default:
		}
		if (labyrinth[x][y] == -5) {
			labyrinth[x][y] = 0;
			gumGum--;
			score += 50;
			return true;
		}
		if (labyrinth[x][y] < 0 && labyrinth[x][y] > -5) {
			switch (labyrinth[x][y]) {
			case -1:
				bonus_eat[0] = true;
				break;
			case -2:
				bonus_eat[1] = true;
				break;
			case -3:
				bonus_eat[2] = true;
				break;
			case -4:
				bonus_eat[3] = true;
				break;
			}
			labyrinth[x][y] = 0;
			score += 100;
		}

		if (labyrinth[x][y] == 1) {
			labyrinth[x][y] = 0;
			gumGum--;
			score += 10;
		}
		return false;
	}

	/*
	 * Met l'état des fantomes en "mangeables" par Pacman
	 */
	public static void superPacman(Ghost actual) {
		if (actual.getState() == 0 || actual.getState() == 1)
			actual.setState(1);
	}

	/*
	 * Met l'état des fantomes en "non-mangeables" par Pacman
	 */
	public static void normalPacman(Ghost actual) {
		if (actual.getState() == 1)
			actual.setState(0);
	}

	/*
	 * Charge le labyrinthe correspondant au niveau actuel
	 */
	public static void whatsTheName(Controller controle) {

		switch (file_name) {
		case "new":
			if (stagePlaying != 0) {
				file_name = "stage" + Integer.toString(stagePlaying) + ".txt";
			} else {
				file_name = "stage1.txt";
			}
			break;
		case "stage1.txt":
			file_name = "stage2.txt";
			break;
		case "stage2.txt":
			file_name = "stage3.txt";
			break;
		default:
			controle.endPage();
			runEndPage(controle);
			try {
				saveHighScore(score, file_name);
			} catch (IOException e) {
				System.out.println("Erreur écriture");
			}
			System.exit(0);
		}
		switch(file_name){
		case "stage1.txt":
			controle.changeMusic("music/lvl1.wav");
			break;
		case "stage2.txt":
			controle.changeMusic("music/lvl2.wav");
			break;
		}
	}

	/*
	 * On teste si un le centre de Pacman se trouve dans un des quatre coins de
	 * la hitbox du fantome actual
	 */
	public static boolean meetTheFantom(Ghost actual, Pacman hero) {

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

	public static void putBonus() {
		int cpt = ((totalGumGum - gumGum) * 100 / totalGumGum);
		if (cpt == 80 && bonus_pop[0] == false) {
			labyrinth[6][8] = -1;
			bonus_pop[0] = true;
			// placerbonus
		}
		if (cpt == 60 && bonus_pop[1] == false) {
			labyrinth[12][8] = -2;
			bonus_pop[1] = true;
			// placerbonus
		}
		if (cpt == 40 && bonus_pop[2] == false) {
			labyrinth[6][12] = -3;
			bonus_pop[2] = true;
			// placerbonus
		}
		if (cpt == 20 && bonus_pop[3] == false) {
			labyrinth[12][12] = -4;
			bonus_pop[3] = true;
			// placerbonus
		}
	}

	public static void runAboutPage(Controller controle) {
		boolean userAction = false;
		String action;
		controle.aboutPage();
		while (!userAction) {
			controle.refreshAbout();
			action = controle.majStartPage();
			switch (action) {
			case "ReturnAbout":
				userAction = true;
				break;
			default:
			}
			try {
				Thread.sleep(5);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		controle.startPage();
	}

	public static void runOptionPage(Controller controle) {
		boolean userAction = false;
		String action;
		controle.optionPage();
		while (!userAction) {
			controle.refreshOption(difficulty);
			action = controle.majStartPage();
			switch (action) {
			case "ReturnAbout":
				userAction = true;
				break;
			case "Easy":
				difficulty = 100;
				break;
			case "Medium":
				difficulty = 50;
				break;
			case "Hard":
				difficulty = 0;
				break;
			case "On/Off":
				controle.stopMusic();
			default:
			}
			try {
				Thread.sleep(5);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			action = controle.whichLevel();
			switch (action) {

			case "1":
			case "2":
			case "3":
			case "4":
			case "5":
			case "6":
				stagePlaying = Integer.parseInt(action);
				break;
			case "All":
				stagePlaying = 0;
				break;
			}
		}
		controle.startPage();
	}

	public static void runEndPage(Controller controle) {
		boolean userAction = false;
		String action = "";
		while (!userAction) {
			controle.refreshEnd();
			action = controle.majStartPage();
			if (action.equals("Save")) {
				userAction = true;
				username = controle.getUserName();
			}
			try {
				Thread.sleep(5);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
	
	public static void runLeaderBoard (Controller controle) {
		boolean userAction = false;
		String action ="";
		while(!userAction) {
			controle.refreshLeaderBoard();
			action = controle.majStartPage();
			if (action.equals("Quit")){
				System.exit(0);
			}
			if (action.equals("ReturnAbout")) {
				userAction=true;
			}
		}
	}

	public static void runStartPage(Controller controle) {
		boolean userAction = false;
		String action;
		while (!userAction) {
			controle.refreshStart();
			action = controle.majStartPage();
			switch (action) {
			case "Start":
				userAction = true;
				break;
			case "Options":
				runOptionPage(controle);
				break;
			case "About":
				runAboutPage(controle);
				break;
			case "Quit":
				System.exit(0);
			default:
			}
			try {
				Thread.sleep(5);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

	/*
	 * Enregistre les meilleurs scores dans un fichier
	 */
	public static void saveHighScore(int score, String file_name) throws IOException {
		if (username.equals("")) {
			username = "ABC";
		}
		username = username.replaceAll(" ", "");
		String[][] current_score = new String[10][2];
		File current_file;
		if (stagePlaying != 0) {
			current_file = new File(IOTreatment.findFile(file_name));
		} else {
			current_file = new File("HighScore.txt");
		}
		current_score = IOTreatment.extract(current_file);
		if (Integer.parseInt(current_score[current_score.length-1][current_score[0].length-1]) < score) {
			int count = 0;
			while (Integer.parseInt(current_score[count][1]) > score) {
				count++;
			}
			IOTreatment.put(current_score, count, score, username, current_file);
		}
	}

	public static void run(Controller controle) {
		controle.startPage();
		runStartPage(controle);

		bonus_pop = new boolean[4];
		bonus_eat = new boolean[4];
		for (int i = 0; i < bonus_pop.length; i++) {
			bonus_pop[i] = false;
			bonus_eat[i] = false;
		}

		// Déclaration des fantomes
		Ghost blinky;
		Ghost pinky;
		Ghost inky;
		Ghost clyde;

		// Déclaration du bonus de combo
		int combo = 1;

		// Déclaration du Pacman
		Pacman hero = new Pacman();

		// Vrai si pacman se fait attraper
		boolean catchMeIfYouCan = false;

		// Vrai si la partie est gagnée
		boolean win = false;
		whatsTheName(controle);
		fillMyTab();

		// On initialise le controller
		controle.setHero(hero);
		controle.startGame();

		boolean loop=true;
		// On tourne tant que l'utilisateur n'a pas gagné ou perdu
		while (loop) {
			// Init fichier
			if (win) {
				for (int i = 0; i < bonus_pop.length; i++) {
					bonus_pop[i] = false;
				}
				whatsTheName(controle);
				win = false;
				hero.setLife(3);
				// Init labyrinth
				fillMyTab();
			}

			catchMeIfYouCan = false;

			// Init pacman
			hero.reset(252, 448, Controller.Direction.UP, Controller.Direction.UP, deplacement, length_box);

			// Init fantomes
			blinky = new Ghost(252, 224, 0, "Blinky", deplacement, length_box, difficulty);
			pinky = new Ghost(280, 280, 0, "Pinky", deplacement, length_box, difficulty);
			inky = new Ghost(252, 280, 0, "Inky", deplacement, length_box, difficulty);
			clyde = new Ghost(224, 280, 0, "Clyde", deplacement, length_box, difficulty);

			updateVue(controle, hero, blinky, pinky, inky, clyde, bonus_eat, true);
			controle.setCounter(4);
			// Attente de 3 secondes avant le début de chaque partie
			try {
				controle.refresh();
				Thread.sleep(1000);
				controle.refresh();
				Thread.sleep(1000);
				controle.refresh();
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}

			// Remet par défaut la direction de pacman vers le haut
			controle.resetDirection();

			/*
			 * Tant que Pacman ne se fait pas attraper et qu'il reste des
			 * gommes, on tourne
			 */
			while (gumGum > 0 && !catchMeIfYouCan) {

				// Test s'il faut placer un bonus
				putBonus();

				controle.tellMeTheWayToGoPlease();
				if (hero.getToGo() == Controller.Direction.SPACE) {
					hero.setToGo(hero.getGo());
					pause(controle, hero, true, blinky, pinky, inky, clyde);
				}

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
					hero.reset_Timer_superPacman();
					superPacman(blinky);
					superPacman(inky);
					superPacman(clyde);
					superPacman(pinky);
				}

				/*
				 * Si on arrive à la fin du compteur, on repasse les fantomes en
				 * mode normal
				 */
				if (hero.getTimer_superPacman() == 875) {
					hero.reset_Timer_superPacman();
					combo = 1;
					normalPacman(blinky);
					normalPacman(clyde);
					normalPacman(pinky);
					normalPacman(inky);
				}

				// Deplacement des fantomes en fonction de leur état
				if (blinky.getState() == 2) {
					blinky.returnToTheBase();
				} else {
					if ((blinky.getState() == 1 && (blinky.getGame_lap() % 2) == 0) || blinky.getState() == 0) {
						blinky.deplaceTheGhost(hero.getCoordX(), hero.getCoordY(), hero.getGo());
					} else {
						blinky.anotherLap();
					}
				}
				if (pinky.getState() == 2) {
					pinky.returnToTheBase();
				} else {
					if ((pinky.getState() == 1 && pinky.getGame_lap() % 2 == 0) || pinky.getState() == 0) {
						pinky.deplaceTheGhost(hero.getCoordX(), hero.getCoordY(), hero.getGo());
					} else {
						pinky.anotherLap();
					}
				}
				if (inky.getState() == 2) {
					inky.returnToTheBase();
				} else {
					if ((inky.getState() == 1 && inky.getGame_lap() % 2 == 0) || inky.getState() == 0) {
						inky.deplaceTheGhost(hero.getCoordX(), hero.getCoordY(), hero.getGo());
					} else {
						inky.anotherLap();
					}
				}
				if (clyde.getState() == 2) {
					clyde.returnToTheBase();
				} else {
					if ((clyde.getState() == 1 && clyde.getGame_lap() % 2 == 0) || clyde.getState() == 0) {
						clyde.deplaceTheGhost(hero.getCoordX(), hero.getCoordY(), hero.getGo());
					} else {
						clyde.anotherLap();
					}
				}
				controle.refresh();

				/*
				 * Si les fantomes sont en mode "mangeables", on incrémente le
				 * compteur
				 */
				if (blinky.getState() == 1 || clyde.getState() == 1 || pinky.getState() == 1 || inky.getState() == 1)
					hero.increment_Timer_superPacman();

				/*
				 * On gère les interaction entre pacman et un fantome s'il y en
				 * a un, et en fonction de l'état du fantome
				 */
				if (meetTheFantom(blinky, hero)) {
					if (blinky.getState() == 1) {
						score += combo * 200;
						combo *= 2;
						blinky.setState(2);
					} else {
						if (blinky.getState() == 0)
							catchMeIfYouCan = true;
					}
				}
				if (meetTheFantom(inky, hero)) {
					if (inky.getState() == 1) {
						score += combo * 200;
						combo *= 2;
						inky.setState(2);
					} else {
						if (inky.getState() == 0)
							catchMeIfYouCan = true;
					}
				}
				if (meetTheFantom(pinky, hero)) {
					if (pinky.getState() == 1) {
						score += combo * 200;
						combo *= 2;
						pinky.setState(2);
					} else {
						if (pinky.getState() == 0)
							catchMeIfYouCan = true;
					}
				}
				if (meetTheFantom(clyde, hero)) {
					if (clyde.getState() == 1) {
						score += combo * 200;
						combo *= 2;
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
				if (stagePlaying != 0) {
					controle.endPage();
					runEndPage(controle);
					try {
						saveHighScore(score, file_name);
					} catch (IOException e) {
						System.out.println("Erreur IO");
					}
					File file;
					if(stagePlaying != 0){
						file=new File(file_name);
					} else {
						file=new File("HighScore.txt");
					}
					try {
						controle.leaderBoard(IOTreatment.extract(file));
						runLeaderBoard(controle);
						loop=false;
					} catch (IOException e1) {
						e1.printStackTrace();
					}
				}
			} else {
				hero.looseLife();
			}
			if (hero.getLife() <= 0) {
				controle.endPage();
				runEndPage(controle);
				try {
					saveHighScore(score, file_name);
				} catch (IOException e) {
					System.out.println("Erreur d'écriture");
				}

				File file;
				if(stagePlaying != 0){
					file=new File(file_name);
				} else {
					file=new File("HighScore.txt");
				}
				try {
					controle.leaderBoard(IOTreatment.extract(file));
					runLeaderBoard(controle);
					loop=false;
				} catch (IOException e1) {
					e1.printStackTrace();
				}
			}
		}
	}

	public static void main(String[] args) {
		Controller controle = new Controller(maxX, maxY);
		while(true){
			score=0;
			run(controle);
		}
	}
}
