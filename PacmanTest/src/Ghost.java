public class Ghost {

	private int coordX;
	private int coordY;
	private int state;
	private String name;
	private Modele.Direction go;
	private Modele.Direction goToTheOtherSide;
	private int deplacement;
	private int length_box;

	public Ghost(int _coordX, int _coordY, int _state, String _name, int _deplacement, int _length_box) {
		this.coordX = _coordX;
		this.coordY = _coordY;
		this.state = _state;
		this.name = _name;
		this.deplacement = _deplacement;
		this.length_box = _length_box;
		this.go = Modele.Direction.UP;
		this.goToTheOtherSide = theOtherSide(go);
	}

	public void deplaceTheFantom(int coordXPacman, int coordYPacman) {
		switch (name) {
		case "Blinky":
			deplaceBlinky(coordXPacman, coordYPacman);
			break;
		case "Pinky":
			deplacePinky(coordXPacman, coordYPacman);
			break;
		case "Inky":
			deplaceInky(coordXPacman, coordYPacman);
			break;
		case "Clyde":
			deplaceClyde();
			break;
		default:
		}
	}

	private Modele.Direction theOtherSide(Modele.Direction actualGo) {
		switch (actualGo) {
		case UP:
			return Modele.Direction.DOWN;
		case DOWN:
			return Modele.Direction.UP;
		case LEFT:
			return Modele.Direction.RIGHT;
		case RIGHT:
			return Modele.Direction.LEFT;
		default:
			return Modele.Direction.UNKNOW;
		}
	}

	private Modele.Direction getRandomDirection() {
		int a = (int) (Math.random() * 4);
		switch (a) {
		case 0:
			return Modele.Direction.UP;
		case 1:
			return Modele.Direction.DOWN;
		case 2:
			return Modele.Direction.LEFT;
		case 3:
			return Modele.Direction.RIGHT;
		default:
			return Modele.Direction.UNKNOW;
		}
	}

	// Clyde se déplace de manière aléatoire sur la carte
	private void deplaceClyde() {

		// Il suffit de le faire aller de manière aléatoire sur n'importe quelle
		// case
		// qui n'est pas un mur ou une marche arrière

		Modele.Direction toGo;
		do {
			toGo = getRandomDirection();
		} while (goToTheOtherSide.equals(toGo) || !canIGoHere(toGo));
		go = toGo;
		goToTheOtherSide = theOtherSide(toGo);

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
				coordX = Modele.maxX - length_box;
			} else {
				coordX -= deplacement;
			}
			break;
		case RIGHT:
			if (coordX + deplacement + length_box > Modele.maxX) {
				coordX = 0;
			} else {
				coordX += deplacement;
			}
			break;
		default:
		}
	}

	public boolean letMeDoTheSmartThings(int tempX, int tempY) {
		tempX = (tempX / length_box) % 19;
		tempY = (tempY / length_box) % 22;
		if (Modele.labyrinth[tempX][tempY] > 1)
			return false;
		else
			return true;
	}

	private boolean canIGoHere(Modele.Direction goTest) {
		switch (goTest) {
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

	private void deplacePinky(int coordXPacman, int coordYPacman) {
		// Vise l'endroit où va se trouver Pacman

	}

	private void deplaceInky(int coordXPacman, int coordYPacman) {
		// 50% : Suit Pacman
		// 50% : Fuit Pacman

	}

	private void deplaceBlinky(int coordXPacman, int coordYPacman) {
		// Suit Pacman
	}

	public int getState() {
		return state;
	}

	public void setState(int _state) {
		this.state = _state;
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
