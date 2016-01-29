import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class Controleur implements KeyListener,MouseListener {


	private Modele.Direction go;
	
	public Controleur(Modele.Direction _go){
		this.go=_go;
	}
	
	public Modele.Direction tellMeTheWayToGoPlease(){
		return go;
	}
	
	@Override
	public void keyPressed(KeyEvent k) {
		switch (k.getKeyCode()){
		case KeyEvent.VK_UP :
			go=Modele.Direction.UP;
			break;
		case KeyEvent.VK_DOWN :
			go=Modele.Direction.DOWN;
			break;
		case KeyEvent.VK_LEFT :
			go=Modele.Direction.LEFT;
			break;
		case KeyEvent.VK_RIGHT :
			go=Modele.Direction.RIGHT;
	}
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyReleased(KeyEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyTyped(KeyEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

}
