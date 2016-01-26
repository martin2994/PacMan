public class Ghost {

	private int coordX;
	private int coordY;
	private int state;
	private String name;
	private Modele.Direction go;
	private Modele.Direction goToTheOtherSide;
	private int deplacement;
	private int length_box;
	private int game_lap;

	public Ghost(int _coordX, int _coordY, int _state, String _name, int _deplacement, int _length_box) {
		this.coordX = _coordX;
		this.coordY = _coordY;
		this.state = _state;
		this.name = _name;
		this.deplacement = _deplacement;
		this.length_box = _length_box;
		this.go = Modele.Direction.UP;
		this.goToTheOtherSide = theOtherSide(go);
		this.game_lap = 0;
	}

	public void deplaceTheFantom(int coordXPacman, int coordYPacman) {
		game_lap++;
		switch (name) {
		case "Blinky":
				deplaceBlinky(coordXPacman, coordYPacman, false);
			break;
		case "Pinky":
			if (game_lap > 1000) {
				deplacePinky(coordXPacman, coordYPacman);
			}
			break;
		case "Inky":
			if (game_lap > 1500) {
				deplaceInky(coordXPacman, coordYPacman);
			}
			break;
		case "Clyde":
			if (game_lap > 500) {
				deplaceClyde();
			}
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

	// Clyde se d�place de mani�re al�atoire sur la carte
	private void deplaceClyde() {
		// d�part
		if (coordX == 224 && coordY == 280) {
			go = Modele.Direction.RIGHT;
			goToTheOtherSide = theOtherSide(go);
		} else {
			if (coordX == 252 && coordY == 280) {
				go = Modele.Direction.UP;
				goToTheOtherSide = theOtherSide(go);
			} else {
				// Il suffit de le faire aller de mani�re al�atoire sur
				// n'importe quelle
				// case
				// qui n'est pas un mur ou une marche arri�re

				Modele.Direction toGo;
				do {
					toGo = getRandomDirection();
				} while (goToTheOtherSide.equals(toGo) || !canIGoHere(toGo));
				go = toGo;
				goToTheOtherSide = theOtherSide(toGo);
			}
		}
		move();
	}

	public void move() {
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

	public boolean letMeDoTheSmartThings(int tempX, int tempY, Modele.Direction goTest) {
		tempX = (tempX / length_box) % 19;
		tempY = (tempY / length_box) % 22;
		// Cas de d�part quand le fantome doit sortir
		if ((Modele.labyrinth[tempX][tempY] == 24) && (goTest == Modele.Direction.UP)) {
			return true;
		}
		if (Modele.labyrinth[tempX][tempY] > 1)
			return false;
		else
			return true;
	}

	private boolean canIGoHere(Modele.Direction goTest) {
		switch (goTest) {
		case UP:
			return (letMeDoTheSmartThings(coordX + length_box - deplacement, coordY - deplacement, goTest)
					&& letMeDoTheSmartThings(coordX, coordY - deplacement, goTest));
		case DOWN:
			return (letMeDoTheSmartThings(coordX, coordY + length_box, goTest)
					&& letMeDoTheSmartThings(coordX + length_box - deplacement, coordY + length_box, goTest));
		case LEFT:
			return letMeDoTheSmartThings(coordX - deplacement, coordY, goTest)
					&& letMeDoTheSmartThings(coordX - deplacement, coordY + length_box - deplacement, goTest);
		case RIGHT:
			return letMeDoTheSmartThings(coordX + length_box, coordY + length_box - deplacement, goTest)
					&& letMeDoTheSmartThings(coordX + length_box, coordY, goTest);
		default:
		}
		return false;
	}

	private void deplacePinky(int coordXPacman, int coordYPacman) {
		// Vise l'endroit o� va se trouver Pacman

	}

	private void deplaceInky(int coordXPacman, int coordYPacman) {
		// 75% : Suit Pacman
		// 25% : Fuit Pacman
		if (coordX == 252 && coordY <= 280 && coordY >= 252) {
			go = Modele.Direction.UP;
			goToTheOtherSide = theOtherSide(go);
			move();
		} else {
			deplaceBlinky(coordXPacman, coordYPacman, true);
		}

	}

	private int distance(int coordXG, int coordYG, int coordXP, int coordYP) {
		return Math.abs(coordXP - coordXG) + Math.abs(coordYP - coordYG);
	}

	private void deplaceBlinky(int coordXPacman, int coordYPacman, boolean helloIAmInky) {
		// Suit Pacman

		int left = 0;
		int right = 0;
		int up = 0;
		int down = 0;

		if (canIGoHere(Modele.Direction.LEFT) && goToTheOtherSide != Modele.Direction.LEFT) {
			left = 1;
		}
		if (canIGoHere(Modele.Direction.RIGHT) && goToTheOtherSide != Modele.Direction.RIGHT) {
			right = 1;
		}
		if (canIGoHere(Modele.Direction.UP) && goToTheOtherSide != Modele.Direction.UP) {
			up = 1;
		}
		if (canIGoHere(Modele.Direction.DOWN) && goToTheOtherSide != Modele.Direction.DOWN) {
			down = 1;
		}
		int min_distance = 1000;

		// si c'est Inky, il y a une chance sur 4 pour qu'il d�cide de partir
		// dans la direction oppos�e de pacman
		if (helloIAmInky) {
			int random = (int) (Math.random() * 4);
			if (random == 0) {
				helloIAmInky = true;
				min_distance = 0;
			} else {
				helloIAmInky = false;
			}
		}

		Modele.Direction toGo = Modele.Direction.UNKNOW;
		boolean whereWillIGo;
		if (left == 1) {
			if (!helloIAmInky) {
				whereWillIGo = min_distance > distance(coordX - deplacement, coordY, coordXPacman, coordYPacman);
			} else {
				whereWillIGo = min_distance < distance(coordX - deplacement, coordY, coordXPacman, coordYPacman);
			}
			if (whereWillIGo) {
				min_distance = distance(coordX - deplacement, coordY, coordXPacman, coordYPacman);
				toGo = Modele.Direction.LEFT;
			}
		}
		if (right == 1) {
			if (!helloIAmInky) {
				whereWillIGo = min_distance > distance(coordX + deplacement, coordY, coordXPacman, coordYPacman);
			} else {
				whereWillIGo = min_distance < distance(coordX + deplacement, coordY, coordXPacman, coordYPacman);
			}
			if (whereWillIGo) {
				min_distance = distance(coordX + deplacement, coordY, coordXPacman, coordYPacman);
				toGo = Modele.Direction.RIGHT;
			}
		}
		if (up == 1) {
			if (!helloIAmInky) {
				whereWillIGo = min_distance > distance(coordX, coordY - deplacement, coordXPacman, coordYPacman);
			} else {
				whereWillIGo = min_distance < distance(coordX, coordY - deplacement, coordXPacman, coordYPacman);
			}
			if (whereWillIGo) {
				min_distance = distance(coordX, coordY - deplacement, coordXPacman, coordYPacman);
				toGo = Modele.Direction.UP;
			}
		}
		if (down == 1) {
			if (!helloIAmInky) {
				whereWillIGo = min_distance > distance(coordX, coordY + deplacement, coordXPacman, coordYPacman);
			} else {
				whereWillIGo = min_distance < distance(coordX, coordY + deplacement, coordXPacman, coordYPacman);
			}
			if (whereWillIGo) {
				min_distance = distance(coordX, coordY + deplacement, coordXPacman, coordYPacman);
				toGo = Modele.Direction.DOWN;
			}
		}
		go = toGo;
		goToTheOtherSide = theOtherSide(go);
		move();
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
