package Controller;

import Vue.*;
import Modele.*;

public class Controller {

	public enum Direction {
		UP, DOWN, LEFT, RIGHT, SPACE, UNKNOW
	}

	Vue vue;
	KeyboardAndMouseMovementsInputs kammi;
	Pacman hero;

	public Controller(Pacman _hero) {
		this.kammi = new KeyboardAndMouseMovementsInputs(Direction.UP);
		this.vue = new Vue(kammi);
		this.hero=_hero;
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

	public void majVue(Pacman hero, int maxX, int maxY, Ghost blinky, Ghost pinky, Ghost inky, Ghost clyde) {
		vue.majVue(hero, maxX, maxY, blinky, pinky, inky, clyde);
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
}
