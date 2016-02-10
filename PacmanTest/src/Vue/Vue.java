package Vue;

import Controller.*;

import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

import Modele.Ghost;
import Modele.Pacman;

public class Vue extends JFrame {

	PannelInGame panIG;
	PannelStart panS;
	PannelAbout panA;
	PannelOption panO;
	KeyboardAndMouseMovementsInputs controle_kammi;
	MouseClic controle_c;
	JButton returnAbout;

	// Constructeur
	public Vue(int maxX, int maxY) {
		this.setTitle("Pac-Man");
		this.setSize(maxX, maxY);
		panIG = new PannelInGame();
		panS = new PannelStart();
		panA = new PannelAbout();
		panO = new PannelOption();
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setResizable(false);
		this.setVisible(true);
		returnAbout = new JButton("Return to menu");
	}

	public void setPanelIngame(KeyboardAndMouseMovementsInputs _controle) {
		controle_kammi = _controle;
		panIG.setLayout(null);
		this.setContentPane(panIG);
		this.revalidate();
		addMouseListener(controle_kammi);
		addKeyListener(controle_kammi);
		requestFocus();

	}

	public void setPanelAbout(MouseClic _controle) {
		controle_c = _controle;
		panA.setLayout(null);
		this.setContentPane(panA);
		this.revalidate();
		panA.add(returnAbout);
		returnAbout.setBounds(516, 570, 135, 50);
		returnAbout.addActionListener(controle_c);
	}

	public void setPanelOption(MouseClic _controle) {
		controle_c = _controle;
		panO.setLayout(null);
		this.setContentPane(panO);
		this.revalidate();
		panO.add(returnAbout);
		returnAbout.setBounds(516, 570, 135, 50);
		returnAbout.addActionListener(controle_c);
		JButton easy = new JButton("Easy");
		panO.add(easy);
		easy.setBounds(100, 60, 135, 50);
		easy.addActionListener(controle_c);
		JButton medium = new JButton("Medium");
		panO.add(medium);
		medium.setBounds(250, 60, 135, 50);
		medium.addActionListener(controle_c);
		JButton hard = new JButton("Hard");
		panO.add(hard);
		hard.setBounds(400, 60, 135, 50);
		hard.addActionListener(controle_c);
	}

	public void setPanelStart(MouseClic _controle) {
		controle_c = _controle;
		panS.setLayout(null);
		this.setContentPane(panS);
		this.revalidate();
		JButton start = new JButton("Start");
		panS.add(start);
		start.setBounds(260, 100, 110, 50);
		start.addActionListener(controle_c);
		JButton options = new JButton("Options");
		panS.add(options);
		options.setBounds(260, 200, 110, 50);
		options.addActionListener(controle_c);
		JButton about = new JButton("About");
		panS.add(about);
		about.setBounds(260, 300, 110, 50);
		about.addActionListener(controle_c);
		JButton quit = new JButton("Quit");
		panS.add(quit);
		quit.setBounds(260, 400, 110, 50);
		quit.addActionListener(controle_c);

	}

	public void refresh() {
		panIG.repaint();
	}

	public void refreshAbout() {
		panA.repaint();
	}

	public void refreshOption(String difficulty) {
		panO.setDifficulty(difficulty);
		panO.repaint();
	}

	/*
	 * Permet de mettre à jour la vue et le panneau avec les coordonnées
	 * actuelles de Pacman et des fantomes
	 */
	public void majVue(Pacman hero, int maxX, int maxY, Ghost blinky, Ghost pinky, Ghost inky, Ghost clyde,
			boolean[] bonus) {
		panIG.setHero(hero);
		panIG.setBlinky(blinky);
		panIG.setPinky(pinky);
		panIG.setInky(inky);
		panIG.setClyde(clyde);
		panIG.setBonus(bonus);
		this.setContentPane(panIG);
	}

	public void showPause() {
		panIG.setPause(true);
	}

	public void hidePause() {
		panIG.setPause(false);
	}
}
