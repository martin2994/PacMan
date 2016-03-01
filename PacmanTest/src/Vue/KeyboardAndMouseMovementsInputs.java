package Vue;

import Controller.*;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

/* G�re toutes les entr�es utilisateur, que ce soit au clavier ou � la souris */
public class KeyboardAndMouseMovementsInputs implements KeyListener, MouseListener {

	// Direction demand�e
	private Controller.Direction go;
	// Coordon�es de la souris
	private int mouseX;
	private int mouseY;
	// Vrai si l'utilisateur a cliqu� dans la fen�tre
	private boolean gimmeACheese;

	public KeyboardAndMouseMovementsInputs(Controller.Direction _go) {
		this.go = _go;
		this.mouseX = -1;
		this.mouseY = -1;
		this.gimmeACheese = false;
	}

	/*
	 * Retourne la direction demand�e par l'utilisateur en cas d'entr�e au
	 * clavier
	 */
	public Controller.Direction tellMeTheWayToGoPlease() {
		return go;
	}

	// D�clench� en cas d'entr�e clavier
	public void keyPressed(KeyEvent k) {
		switch (k.getKeyCode()) {
		case KeyEvent.VK_UP:
			go = Controller.Direction.UP;
			break;
		case KeyEvent.VK_DOWN:
			go = Controller.Direction.DOWN;
			break;
		case KeyEvent.VK_LEFT:
			go = Controller.Direction.LEFT;
			break;
		case KeyEvent.VK_RIGHT:
			go = Controller.Direction.RIGHT;
			break;
		case 32:
			go = Controller.Direction.SPACE;
			break;
		}
	}

	public void keyReleased(KeyEvent arg0) {
	}

	public void keyTyped(KeyEvent arg0) {
	}

	public void mouseClicked(MouseEvent e) {
	}

	public void mouseEntered(MouseEvent e) {
	}

	public void mouseExited(MouseEvent e) {
	}

	// D�clench�e en cas de clic de souris
	public void mousePressed(MouseEvent e) {
		this.mouseX = e.getX();
		this.mouseY = e.getY();
		this.gimmeACheese = true;
	}

	public void mouseReleased(MouseEvent e) {
	}

	public boolean isGimmeACheese() {
		return gimmeACheese;
	}

	public void setGimmeACheese(boolean gimmeACheese) {
		this.gimmeACheese = gimmeACheese;
	}

	public int getMouseX() {
		return mouseX;
	}

	public int getMouseY() {
		return mouseY;
	}

	public void setGo(Controller.Direction go) {
		this.go = go;
	}
}
