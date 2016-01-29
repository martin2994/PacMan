import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class Controleur implements KeyListener,MouseListener {

	private int up;
	private int down;
	private int left;
	private int right;
	
	public Controleur(int _up, int _down, int _right, int _left){
		this.up=_up;
		this.down=_down;
		this.left=_left;
		this.right=_right;
	}
	
	//public enum Direction { UP,DOWN,LEFT,RIGHT }
	
	private void reset_values(){
		this.up=0;
		this.down=0;
		this.left=0;
		this.right=0;
	}
	
	public Modele.Direction tellMeTheWayToGoPlease(){
		if(this.up==1){
			return Modele.Direction.UP;
		}
		if(this.down==1){
			return Modele.Direction.DOWN;
		}
		if(this.left==1){
			return Modele.Direction.LEFT;
		}
		if(this.right==1){
			return Modele.Direction.RIGHT;
		}
		return Modele.Direction.UNKNOW;
	}
	
	@Override
	public void keyPressed(KeyEvent k) {
		switch (k.getKeyCode()){
		case KeyEvent.VK_UP :
			reset_values();
			this.up=1;
			break;
		case KeyEvent.VK_DOWN :
			reset_values();
			this.down=1;
			break;
		case KeyEvent.VK_LEFT :
			reset_values();
			this.left=1;
			break;
		case KeyEvent.VK_RIGHT :
			reset_values();
			this.right=1;
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
