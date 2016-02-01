import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

/* G�re toutes les entr�es utilisateur, que ce soit au clavier ou � la souris */
public class Controleur implements KeyListener, MouseListener, ActionListener {

	// Direction demand�e
	private Modele.Direction go;
	// Coordon�es de la souris
	private int mouseX;
	private int mouseY;
	// Vrai si l'utilisateur a cliqu� dans la fen�tre
	private boolean gimmeACheese;

	public Controleur(Modele.Direction _go) {
		this.go = _go;
		this.mouseX = -1;
		this.mouseY = -1;
		this.gimmeACheese = false;
	}

	/*
	 * Retourne la direction demand�e par l'utilisateur en cas d'entr�e au
	 * clavier
	 */
	public Modele.Direction tellMeTheWayToGoPlease() {
		return go;
	}

	// D�clench� en cas d'entr�e clavier
	public void keyPressed(KeyEvent k) {
		switch (k.getKeyCode()) {
		case KeyEvent.VK_UP:
			go = Modele.Direction.UP;
			break;
		case KeyEvent.VK_DOWN:
			go = Modele.Direction.DOWN;
			break;
		case KeyEvent.VK_LEFT:
			go = Modele.Direction.LEFT;
			break;
		case KeyEvent.VK_RIGHT:
			go = Modele.Direction.RIGHT;
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

	public void setGo(Modele.Direction go) {
		this.go = go;
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		System.out.println("Tu cliques, tu niques");
	}

}
