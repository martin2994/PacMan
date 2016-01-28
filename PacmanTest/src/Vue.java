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

	public void refresh() {
		pan.repaint();
	}

	public void majVue(Pacman hero, int maxX, int maxY, Ghost blinky, Ghost pinky, Ghost inky,
			Ghost clyde) {
		this.setTitle("Pac-Man");
		this.setSize(maxX, maxY);
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setContentPane(pan);
		pan.setHero(hero);
		pan.setBlinky(blinky);
		pan.setPinky(pinky);
		pan.setInky(inky);
		pan.setClyde(clyde);
	}
}
