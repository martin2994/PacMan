package Vue;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.JToggleButton;

import Modele.Ghost;
import Modele.Pacman;


/**
 * Vue est la classe centralisant toutes donn�es visibles par l'utilisateur (panneau, input) du Pacman
 * 
 * @author Duchene Herrmann Rety
 * 
 *
 */

public class Vue extends JFrame {
	/**
	 * Panneau qui g�re le jeu
	 */
	PanelInGame panIG;
	/**
	 * Panneau qui g�re le menu
	 */
	PanelStart panS;
	/**
	 * Panneau qui g�re les cr�dits
	 */
	PanelAbout panA;
	/**
	 * Panneau qui g�re les options
	 */
	PanelOption panO;
	/**
	 * Panneau qui g�re la fin de jeu
	 */
	PanelEndGame panEG;
	/**
	 * Panneau qui g�re le leaderboard
	 */
	PanelLeaderBoard panLB;
	/**
	 * controleur du clavier
	 */
	KeyboardAndMouseMovementsInputs controle_kammi;
	/**
	 * controleur de la souris
	 */
	MouseClic controle_c;
	/**
	 * bouton pour retourner au menu
	 */
	JButton returnAbout;
	/**
	 * champs de texte
	 */
	JTextField name;
	/**
	 * choix des niveaux � jouer
	 */
	JComboBox<String> comboLevel;
	/**
	 * choix des fichiers de scores � effacer
	 */
	JComboBox<String> comboDelete;

	/**
	 * Constructeur de la Vue
	 * cr�ation de la fen�tre et des panneaux
	 * 
	 * @param maxX
	 *            largeur de la fen�tre
	 * @param maxY
	 *            hauteur de la fen�tre
	 *
	 */
	public Vue(int maxX, int maxY) {
		this.setTitle("Pac-Man");
		this.setSize(maxX, maxY);
		create();
	}
	/**
	 * Initialisation des panneaux et des boutons d'option
	 * cr�ation du bouton retourn to menu, de choix des niveaux et des textes correspondants 
	 * 
	 */
	public void create(){
		panIG = new PanelInGame();
		panS = new PanelStart();
		panA = new PanelAbout(this.getHeight());
		panO = new PanelOption();
		panEG = new PanelEndGame();
		panLB = new PanelLeaderBoard();
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setResizable(false);
		this.setVisible(true);
		returnAbout = new JButton("Return to menu");
		name = new JTextField(3);
		name.setText("");
		String[] choices_level = { "All", "1", "2", "3", "4", "5", "6" };
		String[] choices_delete = { "None", "General", "Level 1", "Level 2", "Level 3", "Level 4", "Level 5", "Level 6" };
		comboLevel = new JComboBox<String>(choices_level);
		comboDelete = new JComboBox<String>(choices_delete);
	}
	
	public void setPanelLeaderBoard(MouseClic _controle_c, String [][] tab) {
		controle_c = _controle_c;
		panLB.setLayout(null);
		this.setContentPane(panLB);
		this.revalidate();
		panLB.setTab(tab);
		returnAbout.setBounds(5, 570, 135, 50);
		returnAbout.addActionListener(controle_c);
		panLB.add(returnAbout);
		JButton quit = new JButton("Quit");
		quit.setBounds(516, 570, 135, 50);
		quit.addActionListener(controle_c);
		panLB.add(quit);
	}
	
	public void setPanelLeaderBoardFromStartPage(MouseClic _controle_c, String [][] tab, String level){
		controle_c=_controle_c;
		panLB.setLayout(null);
		this.setContentPane(panLB);
		this.revalidate();
		panLB.setTab(tab);
		panLB.setLevel(level);
		returnAbout.setBounds(516, 570, 135, 50);
		returnAbout.addActionListener(controle_c);
		panLB.add(returnAbout);
		JButton next = new JButton("Next");
		next.setBounds(3, 570, 135, 50);
		next.addActionListener(controle_c);
		panLB.add(next);
		
	}
	
	/**
	 * Met � jour la Vue pour afficher le panneau PanelEndGame
	 * et utiliser le bon controleur
	 * ajout du bouton save et des textes correspondants
	 * 
	 * @param _controle_c
	 *            controleur de la souris
	 *            
	 */
	public void setPanelEndGame(MouseClic _controle_c) {
		controle_c = _controle_c;
		panEG.setLayout(null);
		this.setContentPane(panEG);
		this.revalidate();
		JButton save = new JButton("Save");
		save.setBounds(516, 570, 135, 50);
		save.addActionListener(controle_c);
		panEG.add(save);
		name = new JTextField();
		name.setPreferredSize(name.getPreferredSize());
		panEG.add(name);
		name.setBounds(250, 260, 135, 50);
		name.addActionListener(controle_c);

	}
	/**
	 * Met � jour la Vue pour afficher le panneau PanelInGame
	 * et utiliser le bon controleur
	 * 
	 * @param _controle
	 *            controleur des mouvements du pacman
	 *            
	 */
	public void setPanelIngame(KeyboardAndMouseMovementsInputs _controle) {
		controle_kammi = _controle;
		panIG.setLayout(null);
		this.setContentPane(panIG);
		this.revalidate();
		addMouseListener(controle_kammi);
		addKeyListener(controle_kammi);
		requestFocus();

	}

	/**
	 * Met � jour la Vue pour afficher le panneau PanelAbout
	 * et utiliser le bon controleur
	 * ajout du bouton retournAbout
	 * 
	 * @param _controle
	 *            controleur de la souris
	 *            
	 */
	public void setPanelAbout(MouseClic _controle) {
		controle_c = _controle;
		panA.setLayout(null);
		this.setContentPane(panA);
		this.revalidate();
		panA.add(returnAbout);
		returnAbout.setBounds(516, 570, 135, 50);
		returnAbout.addActionListener(controle_c);
	}

	/**
	 * Met � jour la Vue pour afficher le panneau PanelOption
	 * et utiliser le bon controleur
	 * ajout du bouton retournAbout et de ceux modifiant la difficult�, la musique et le leaderBoard
	 * 
	 * @param _controle
	 *            controleur de la souris
	 * @param stopstartmusic
	 * 			  boolean pour l'activation/d�sactivation de la musique        
	 */
	public void setPanelOption(MouseClic _controle,boolean stopstartmusic) {
		controle_c = _controle;
		panO.setLayout(null);
		this.setContentPane(panO);
		this.revalidate();
		panO.add(returnAbout);
		returnAbout.setBounds(516, 570, 135, 50);
		returnAbout.addActionListener(controle_c);
		JButton easy = new JButton("Easy");
		panO.add(easy);
		easy.setBounds(107, 60, 135, 50);
		easy.addActionListener(controle_c);
		JButton medium = new JButton("Medium");
		panO.add(medium);
		medium.setBounds(257, 60, 135, 50);
		medium.addActionListener(controle_c);
		JButton hard = new JButton("Hard");
		panO.add(hard);
		hard.setBounds(407, 60, 135, 50);
		hard.addActionListener(controle_c);
		JToggleButton music=new JToggleButton("On/Off",!stopstartmusic);
		panO.add(music);
		music.setBounds(this.getWidth()/2-58,this.getHeight()/2,100,50);
		music.addActionListener(controle_c);
		comboLevel.addActionListener(controle_c);
		comboLevel.setBounds(412, 200, 50, 25);
		panO.add(comboLevel);
		comboDelete.addActionListener(controle_c);
		comboDelete.setBounds(200, 490, 80, 25);
		panO.add(comboDelete);
		JButton delete = new JButton("Delete");
		panO.add(delete);
		delete.setBounds(330,475,135,50);
		delete.addActionListener(controle_c);
	}

	/**
	 * Met � jour la Vue pour afficher le panneau Start
	 * et utiliser le bon controleur
	 * ajout des boutons des diff�rents menu (start,option,about,scoreboard et quit)
	 * 
	 * @param _controle
	 *            controleur de la souris
	 *        
	 */
	public void setPanelStart(MouseClic _controle) {
		controle_c = _controle;
		panS.setLayout(null);
		this.setContentPane(panS);
		this.revalidate();
		JButton start = new JButton("Start");
		panS.add(start);
		start.setBounds(260, 86, 110, 50);
		start.addActionListener(controle_c);
		JButton options = new JButton("Options");
		panS.add(options);
		options.setBounds(260, 186, 110, 50);
		options.addActionListener(controle_c);

		JButton scoreboard = new JButton("Scoreboard");
		panS.add(scoreboard);
		scoreboard.setBounds(260, 286, 110, 50);
		scoreboard.addActionListener(controle_c);
		
		JButton about = new JButton("About");
		panS.add(about);
		about.setBounds(260, 386, 110, 50);
		about.addActionListener(controle_c);
		JButton quit = new JButton("Quit");
		panS.add(quit);
		quit.setBounds(260, 486, 110, 50);
		quit.addActionListener(controle_c);

	}

	/**
	 * Actualise le panneau PanelLeaderBoard
	 *     
	 */
	public void refreshLeaderBoard() {
		panLB.repaint();
	}

	/**
	 * Actualise le panneau PanelEndGame
	 *     
	 */
	public void refreshEndGame() {
		controle_c.setName(this.name.getText());
		panEG.repaint();
	}

	/**
	 * Actualise le panneau PanelInGame
	 *     
	 */
	public void refresh() {
		panIG.repaint();
	}

	/**
	 * Actualise le panneau PanelAbout
	 *     
	 */
	public void refreshAbout() {
		panA.repaint();
	}

	/**
	 * Actualise le panneau PanelOption
	 * et la difficult� du pacman
	 *   
	 * @param difficulty
	 * 			choix de la difficult�    
	 */
	public void refreshOption(String difficulty) {
		controle_c.setLevel((String)this.comboLevel.getSelectedItem());
		controle_c.setDelete((String)this.comboDelete.getSelectedItem());
		panO.setDifficulty(difficulty);
		panO.repaint();
	}

	/**
	 * Actualise le panneau PanelStart
	 *     
	 */
	public void refreshStart() {
		panS.repaint();
	}

	/**
	 * Permet de mettre � jour la vue et le panneau avec les coordonn�es
	 * actuelles de Pacman et des fantomes
	 * 
	 * @param hero
	 *            Le Pacman courant
	 * @param maxX
	 *            Largeur de la fen�tre
	 * @param maxY
	 *            Hauteur de la fen�tre
	 * @param blinky
	 *            Fantome Blinky
	 * @param pinky
	 *            Fantome Pinky
	 * @param inky
	 *            Fantome Inky
	 * @param clyde
	 *            Fantome Clyde
	 * @param bonus
	 *            tableau des bonus mang�s
	 * @param reset
	 *            boolean de reset de partie
	 *     
	 */
	public void majVue(Pacman hero, int maxX, int maxY, Ghost blinky, Ghost pinky, Ghost inky, Ghost clyde,
			boolean[] bonus, boolean reset) {
		panIG.setHero(hero);
		panIG.setBlinky(blinky);
		panIG.setPinky(pinky);
		panIG.setInky(inky);
		panIG.setClyde(clyde);
		panIG.setBonus(bonus);
		if (reset) {
			panIG.resetCounter();
		}
		this.setContentPane(panIG);
	}

	/**
	 * Affichage de la pause
	 *     
	 */
	public void showPause() {
		panIG.setPause(true);
	}

	/**
	 * Annulation de la pause
	 *     
	 */
	public void hidePause() {
		panIG.setPause(false);
	}

	/**
	 * Permet de mettre � jour le compteur
	 *     
	 */
	public void setCounter(int i) {
		panIG.setCounter(i);
	}

	public void setTabLeaderBoard(String[][] extract, String level) {
		panLB.setTab(extract);
		panLB.setLevel(level);
		panLB.repaint();
	}
}
