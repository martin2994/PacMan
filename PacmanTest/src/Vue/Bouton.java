package Vue;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;

public class Bouton extends JButton implements MouseListener {

	public Bouton (String str){
		super(str);
		this.setFocusPainted(false); 
		this.setMargin(null);         
		this.setBorder(BorderFactory.createEmptyBorder()); 
		this.setContentAreaFilled(false); 
		this.setFont(new Font("Courier", Font.BOLD,25 ));
		this.setForeground(Color.YELLOW);
		this.addMouseListener(this);
	}
	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseEntered(MouseEvent e) {
		this.setForeground(Color.WHITE);

	}

	@Override
	public void mouseExited(MouseEvent e) {
		this.setForeground(Color.YELLOW);

	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseReleased(MouseEvent e) {
		if((e.getY() > 0 && e.getY() < this.getHeight()) && (e.getX() > 0 && e.getX() < this.getWidth()))
			this.setForeground(Color.YELLOW);

	}

}
