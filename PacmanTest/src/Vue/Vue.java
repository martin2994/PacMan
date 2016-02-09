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

	PannelInGame panIG;
	PannelStart panS;
	KeyboardAndMouseMovementsInputs controle_kammi;
	MouseClic controle_c;

	// Constructeur
	public Vue(int maxX, int maxY) {
		System.out.println("constructeur vue");
		this.setTitle("Pac-Man");
		this.setSize(maxX, maxY);
		panIG = new PannelInGame();
		panS = new PannelStart();
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setResizable(false);
		this.setVisible(true);
	}

	public void setPanelIngame(KeyboardAndMouseMovementsInputs _controle) {
		System.out.println("setPanelIG");
		controle_kammi = _controle;
		panIG.setLayout(null);
		this.setContentPane(panIG);
		this.revalidate();
		addMouseListener(controle_kammi);
		addKeyListener(controle_kammi);
		requestFocus();
		
	}

	public void setPanelStart(MouseClic _controle) {
		System.out.println("setPanelS");
		controle_c = _controle;
		panS.setLayout(null);
		this.setContentPane(panS);
		this.revalidate();
		JButton start=new JButton("Start");
		panS.add(start);
		start.setBounds(540, 540, 110, 50);
		start.addActionListener(controle_c);
		
	}

	public void refresh() {
		panIG.repaint();
	}

	/*
	 * Permet de mettre à jour la vue et le panneau avec les coordonnées
	 * actuelles de Pacman et des fantomes
	 */
	public void majVue(Pacman hero, int maxX, int maxY, Ghost blinky, Ghost pinky, Ghost inky, Ghost clyde) {
		System.out.println("majVue");
		panIG.setHero(hero);
		panIG.setBlinky(blinky);
		panIG.setPinky(pinky);
		panIG.setInky(inky);
		panIG.setClyde(clyde);
		this.setContentPane(panIG);
	}

	public void showPause() {
		panIG.setPause(true);
	}

	public void hidePause() {
		panIG.setPause(false);
	}
}
