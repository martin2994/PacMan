public class Ghost {

	// Coordonn�es x et y du fantome
	private int coordX;
	private int coordY;
	/*
	 * Etat du fantome : 0 - "Non mangeable" par Pacman 1 - "Mangeable" par
	 * Pacman 2 - Forme d'yeux retournant � la base
	 */
	private int state;
	// Nom du fantome
	private String name;
	// Direction actuelle du fantome
	private Modele.Direction go;
	// Direction oppos�e de la directio nactuelle du fantome
	private Modele.Direction goToTheOtherSide;
	// No�bre de pixels parcourus � chaque tour de boucle
	private int deplacement;
	// Taille de la hitbox
	private int length_box;
	// Tour de jeu actuel
	private int game_lap;

	// Constructeur
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

	// D�place le fantome selon son nom
	public void deplaceTheGhost(int coordXPacman, int coordYPacman, Modele.Direction goPacman) {
		game_lap++;
		switch (name) {
		case "Blinky":
			deplaceBlinky(coordXPacman, coordYPacman, false);
			break;
		case "Pinky":
			if (game_lap > 1000) {
				deplacePinky(coordXPacman, coordYPacman, goPacman);
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

	// Bouge dans une direction al�atoire
	private void moveToARandomWay() {
		Modele.Direction IWantToGoHere;
		do {
			IWantToGoHere = getRandomDirection();
		} while (!canIGoHere(IWantToGoHere) || IWantToGoHere == goToTheOtherSide);
		go = IWantToGoHere;
		goToTheOtherSide = theOtherSide(IWantToGoHere);
		move();
	}

	// Calcule la direction oppos�e � actualGO
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

	// Donne une direction al�atoire
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
			move();
		} else {
			if (coordX == 252 && coordY == 280) {
				go = Modele.Direction.UP;
				goToTheOtherSide = theOtherSide(go);
				move();
			} else {
				// Il suffit de le faire aller de mani�re al�atoire sur
				// n'importe quelle
				// case
				// qui n'est pas un mur ou une marche arri�re
				moveToARandomWay();
			}
		}
	}

	// Bouge le fantome en fonctio nde la direction actuelle
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

	// Regarde si la fantome va dans un mur
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

	// Regarde si le fantome peut aller dans la direction goTest
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

	// Vise l'endroit o� va se trouver Pacman
	private void deplacePinky(int coordXPacman, int coordYPacman, Modele.Direction goPacman) {
		// Cas de d�part
		if (coordX <= 280 && coordX > 252 && coordY == 252) {
			go = Modele.Direction.LEFT;
			goToTheOtherSide = theOtherSide(go);
			move();
		} else {
			if (coordX == 252 && coordY <= 280 && coordY >= 252) {
				go = Modele.Direction.UP;
				goToTheOtherSide = theOtherSide(go);
				move();
			} else {
				int random = (int) (Math.random() * 2);
				if (random == 0) {
					moveToARandomWay();
				} else {
					coordXPacman = (coordXPacman / length_box) % 19;
					coordYPacman = (coordYPacman / length_box) % 22;
					boolean bordure = false;
					while ((Modele.labyrinth[coordXPacman][coordYPacman] < 2) && !bordure) {
						switch (goPacman) {
						case UP:
							coordYPacman = (coordYPacman - 1) % 22;
							if (Math.abs(coordYPacman) != (coordYPacman)) {
								coordYPacman = 0;
								bordure = true;
							}
							break;
						case DOWN:
							coordYPacman = (coordYPacman + 1) % 22;
							break;
						case LEFT:
							coordXPacman = (coordXPacman - 1) % 19;
							if (Math.abs(coordXPacman) != (coordXPacman) % 19) {
								coordXPacman = 0;
								bordure = true;
							}
							break;
						case RIGHT:
							coordXPacman = (coordXPacman + 1) % 19;
							break;
						default:
						}
					}
					coordXPacman = coordXPacman * length_box;
					coordYPacman = coordYPacman * length_box;
					deplaceBlinky(coordXPacman, coordYPacman, false);
				}
			}
		}
	}

	// Suit Pacman 75% du temps et le fuit sinon
	private void deplaceInky(int coordXPacman, int coordYPacman) {
		if (coordX == 252 && coordY <= 280 && coordY >= 252) {
			go = Modele.Direction.UP;
			goToTheOtherSide = theOtherSide(go);
			move();
		} else {
			deplaceBlinky(coordXPacman, coordYPacman, true);
		}

	}

	// Retourne la distance de Manhattan entre deux coordonn�es
	private int distance(int coordXG, int coordYG, int coordXP, int coordYP) {
		return Math.abs(coordXP - coordXG) + Math.abs(coordYP - coordYG);
	}

	// Suit Pacman
	private void deplaceBlinky(int coordXPacman, int coordYPacman, boolean helloIAmInky) {
		int r = (int) (Math.random() * 2);
		if (r == 0) {
			moveToARandomWay();
		} else {
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

			// si c'est Inky, il y a une chance sur 4 pour qu'il d�cide de
			// partir
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
	}

	/*
	 * Si le fantome se trouve en �tat 2, cette m�thode se substitue � la
	 * m�thode de d�placement habituelle du fantome pour le faire revenir � sa
	 * case de d�part
	 */
	public void returnToTheBase() {
		int left = 0;
		int right = 0;
		int up = 0;
		int down = 0;

		int iComeFromX = 252;
		int iComeFromY = 224;

		if (coordX == iComeFromX && coordY == iComeFromY) {
			this.state = 0;
		} else {

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

			/*
			 * On calcule grace � la distance de Manhattan un chemin pour
			 * retourner relativement rapidement au point de spawn
			 */
			Modele.Direction toGo = Modele.Direction.UNKNOW;
			boolean whereWillIGo;
			if (left == 1) {
				whereWillIGo = min_distance > distance(coordX - deplacement, coordY, iComeFromX, iComeFromY);
				if (whereWillIGo) {
					min_distance = distance(coordX - deplacement, coordY, iComeFromX, iComeFromY);
					toGo = Modele.Direction.LEFT;
				}
			}
			if (right == 1) {
				whereWillIGo = min_distance > distance(coordX + deplacement, coordY, iComeFromX, iComeFromY);
				if (whereWillIGo) {
					min_distance = distance(coordX + deplacement, coordY, iComeFromX, iComeFromY);
					toGo = Modele.Direction.RIGHT;
				}
			}
			if (up == 1) {
				whereWillIGo = min_distance > distance(coordX, coordY - deplacement, iComeFromX, iComeFromY);
				if (whereWillIGo) {
					min_distance = distance(coordX, coordY - deplacement, iComeFromX, iComeFromY);
					toGo = Modele.Direction.UP;
				}
			}
			if (down == 1) {
				whereWillIGo = min_distance > distance(coordX, coordY + deplacement, iComeFromX, iComeFromY);
				if (whereWillIGo) {
					min_distance = distance(coordX, coordY + deplacement, iComeFromX, iComeFromY);
					toGo = Modele.Direction.DOWN;
				}
			}
			go = toGo;
			goToTheOtherSide = theOtherSide(go);
			move();
		}
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

	public String toString() {
		return this.name;
	}

	public Modele.Direction getGo() {
		return go;
	}

	public int getLength_box() {
		return length_box;
	}

	public int getGame_lap() {
		return game_lap;
	}

	public void anotherLap() {
		this.game_lap++;
	}
}
