import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class Controleur implements KeyListener,MouseListener {


	private Modele.Direction go;
	private int mouseX;
	private int mouseY;
	private boolean gimmeACheese;
	
	public Controleur(Modele.Direction _go){
		this.go=_go;
		this.mouseX=-1;
		this.mouseY=-1;
		this.gimmeACheese=false;
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
		this.mouseX=e.getX();
		this.mouseY=e.getY();
		this.gimmeACheese=true;
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
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

}
