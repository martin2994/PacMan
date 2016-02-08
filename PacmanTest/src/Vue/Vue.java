package Vue;
import Controller.*;

import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JButton;
import javax.swing.JFrame;

import Modele.Ghost;
import Modele.Pacman;

public class Vue extends JFrame {

	Panneau pan;
	KeyboardAndMouseMovementsInputs controle;

	// Constructeur
	public Vue(KeyboardAndMouseMovementsInputs _controle) {
		controle = _controle;
		pan = new Panneau();
		pan.setLayout(null);
		addMouseListener(controle);
		addKeyListener(controle);
		addWindowListener(new WindowAdapter() {
			public void windowOpened(WindowEvent e) {
				requestFocus();
			}
		});
		this.setResizable(false);
		this.setVisible(true);
	}

	public void refresh() {
		pan.repaint();
	}

	/*
	 * Permet de mettre à jour la vue et le panneau avec les coordonnées
	 * actuelles de Pacman et des fantomes
	 */
	public void majVue(Pacman hero, int maxX, int maxY, Ghost blinky, Ghost pinky, Ghost inky, Ghost clyde) {
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
