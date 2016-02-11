package Controller;

import Vue.*;
import Modele.*;

public class Controller {

	public enum Direction {
		UP, DOWN, LEFT, RIGHT, SPACE, UNKNOW
	}

	Vue vue;
	KeyboardAndMouseMovementsInputs kammi;
	MouseClic mc;
	Pacman hero;

	public Controller(int maxX, int maxY) {
		this.kammi = new KeyboardAndMouseMovementsInputs(Direction.UP);
		this.mc = new MouseClic();
		this.vue = new Vue(maxX, maxY);

	}

	public boolean isItAClickOrATap() {
		return kammi.isGimmeACheese();
	}

	public static int getScore() {
		return Modele.score;
	}

	public static int[][] getLabyrinth() {
		return Modele.labyrinth;
	}

	public void showPause() {
		vue.showPause();
	}

	public void hidePause() {
		vue.hidePause();
	}

	public void majVue(Pacman hero, int maxX, int maxY, Ghost blinky, Ghost pinky, Ghost inky, Ghost clyde,
			boolean[] bonus) {
		vue.majVue(hero, maxX, maxY, blinky, pinky, inky, clyde, bonus);
	}

	public void tellMeTheWayToGoPlease() {

		// On prend la Controller.Direction de la souris s'il y a eu un clic...
		if (kammi.isGimmeACheese()) {
			kammi.setGimmeACheese(false);
			hero.setToGo(kammi.getMouseX(), kammi.getMouseY());
			kammi.setGo(hero.setToGo(kammi.getMouseX(), kammi.getMouseY()));
			// ... ou sinon l'entrée clavier par défaut
		} else {
			// Test si l'utilisateur souhaite mettre en pause le jeu
			if (kammi.tellMeTheWayToGoPlease() == Direction.SPACE) {
				kammi.setGo(hero.getGo());
				hero.setToGo(Direction.SPACE);
			} else {
				hero.setToGo(kammi.tellMeTheWayToGoPlease());
			}
		}
	}

	public void refresh() {
		vue.refresh();
	}

	public void startPage() {
		vue.setPanelStart(mc);
	}

	public void refreshAbout() {
		vue.refreshAbout();
	}

	public void aboutPage() {
		vue.setPanelAbout(mc);
	}

	public void optionPage() {
		vue.setPanelOption(mc);
	}

	public void startGame() {
		vue.setPanelIngame(kammi);
	}

	public void setHero(Pacman hero) {
		this.hero = hero;
	}

	public String majStartPage() {
		return mc.getAction();
	}

	public void refreshOption(int difficulty) {
		String difficultyString;
		switch (difficulty) {
		case 0:
			difficultyString = "Hard";
			break;
		case 50:
			difficultyString = "Medium";
			break;
		case 100:
			difficultyString = "Easy";
			break;
		default:
			difficultyString = "Unknow";
		}
		vue.refreshOption(difficultyString);
	}

	public void refreshStart() {
		vue.refreshStart();
	}

}
