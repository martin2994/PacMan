public class Pacman {

	private int coordX;
	private int coordY;
	private Modele.Direction go;
	private Modele.Direction toGo;
	private int life;
	private int deplacement;
	private int length_box;

	public Pacman(){
		this.life=3;
	}
	
	public void reset(int _coordX, int _coordY, Modele.Direction _go, Modele.Direction _toGo, int _deplacement, int _length_box){
		this.coordX=_coordX;
		this.coordY=_coordY;
		this.go=_go;
		this.toGo=_toGo;
		this.life--;
		this.deplacement=_deplacement;
		this.length_box=_length_box;
	}
	
	public void actualize_XY() {
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

	public boolean canIGoHere(Modele.Direction toTest) {

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

	public int getLife() {
		return life;
	}

	public Modele.Direction getGo() {
		return go;
	}



	public void setGo(Modele.Direction go) {
		this.go = go;
	}



	public Modele.Direction getToGo() {
		return toGo;
	}



	public void setToGo(Modele.Direction toGo) {
		this.toGo = toGo;
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
