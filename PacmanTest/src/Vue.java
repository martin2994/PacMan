import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JFrame;

public class Vue extends JFrame {

	Panneau pan;

	public Vue(Controleur controle){
		pan = new Panneau();
		addKeyListener(controle);		
		addWindowListener(new WindowAdapter(){
			public void windowOpened(WindowEvent e){
				requestFocus();
			}	
		});
		this.setResizable(false);
		this.setVisible(true);
	}

	public void refresh(int x, int y, Modele.Direction go) {
		pan.setPosX(x);
		pan.setPosY(y);
		pan.setGo_pacman(go);
		pan.repaint();
	}

	public void majVue(int x, int y, int maxX, int maxY, Ghost blinky, Ghost pinky, Ghost inky,
			Ghost clyde, Modele.Direction go) {
		this.setTitle("Pac-Man");
		this.setSize(maxX, maxY);
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setContentPane(pan);
		pan.setPosX(x);
		pan.setPosY(y);
		pan.setBlinky(blinky);
		pan.setPinky(pinky);
		pan.setInky(inky);
		pan.setClyde(clyde);
		pan.setGo_pacman(go);
	}
}
