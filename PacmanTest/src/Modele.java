import java.io.IOException;

public class Modele {

	public enum Direction {
		UP, DOWN, LEFT, RIGHT, UNKNOW
	}

	// taille de la fenêtre
	static int maxX = 532;
	static int maxY = 644;
	// placement de Pacman
	static int coordX = 252;
	static int coordY = 448;
	// taille du labyrinthe
	static int[][] labyrinth;
	// vitesse de Pacman
	static int deplacement = 1;
	// taille d'une case en pixels
	static int length_box = 28;

	public static void fillMyTab() {
		try{
			labyrinth=new int[IOTreatment.getWidth()][IOTreatment.getHeigth()];
			IOTreatment.readMatrix(labyrinth);
		}catch (IOException e){
			System.out.println("Erreur IO");
		}
		
		
		
		
		/*for (int i = 0; i < 28; i++) {
			for (int j = 0; j < 31; j++) {
				labyrinth[i][j] = 0;
			}
		}
		labyrinth[2][2] = 21;
		labyrinth[3][2] = 23;
		labyrinth[4][2] = 1;
		labyrinth[1][1] = 18;
		labyrinth[7][7] = 2;
		labyrinth[8][7] = 18;
		labyrinth[9][7] = 1;
		labyrinth[8][5] = 1;
		labyrinth[8][9] = 1;
		labyrinth[8][3] = 1;
		labyrinth[8][1] = 10;
		labyrinth[8][2] = 11;
		labyrinth[8][6] = 3;
		labyrinth[8][0] = 1;
		labyrinth[15][15]=8;
		labyrinth[16][15]=9;*/
	}

	public static boolean letMeDoTheSmartThings(int tempX, int tempY) {
		tempX = (tempX / length_box)%19;
		tempY = (tempY / length_box)%22;
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

	public static void main(String[] args) {
		fillMyTab();
		Direction go = Direction.UP;
		Direction toGo = Direction.UP;
		
		//Instanciation des fantomes
		Ghost blinky=new Ghost(252,224,0, "Blinky", deplacement, length_box);
		Ghost pinky=new Ghost(280,280,0, "Pinky", deplacement, length_box);
		Ghost inky=new Ghost(252,280,0, "Inky", deplacement, length_box);
		Ghost clyde=new Ghost(224,280,0, "Clyde", deplacement, length_box);

		boolean taMereLaBoucle = true;

		Controleur controle = new Controleur(0, 0, 0, 0);
		Vue vue = new Vue(controle, coordX, coordY, maxX, maxY, blinky, pinky, inky, clyde,go);

		while (taMereLaBoucle) {
			toGo = controle.tellMeTheWayToGoPlease();
			
			//Deplacement de Pacman
			if (toGo != go) {
				if (canIGoHere(toGo) == true) {
					go = toGo;
				}
			}
			if (canIGoHere(go)) {
				actualize_XY(go);
			}
			//Deplacement des fantomes
			blinky.deplaceTheFantom(coordX, coordY);
			pinky.deplaceTheFantom(coordX, coordY);
			inky.deplaceTheFantom(coordX, coordY);
			clyde.deplaceTheFantom(coordX, coordY);
			
			vue.refresh(coordX, coordY,go);
			try {
				Thread.sleep(8);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

}

