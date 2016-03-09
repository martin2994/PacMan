package Vue;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.JToggleButton;

import Modele.Ghost;
import Modele.Pacman;

public class Vue extends JFrame {

	PanelInGame panIG;
	PanelStart panS;
	PanelAbout panA;
	PanelOption panO;
	PanelEndGame panEG;
	PanelLeaderBoard panLB;
	KeyboardAndMouseMovementsInputs controle_kammi;
	MouseClic controle_c;
	JButton returnAbout;
	JTextField name;
	JComboBox<String> comboLevel;
	JComboBox<String> comboDelete;

	// Constructeur
	public Vue(int maxX, int maxY) {
		this.setTitle("Pac-Man");
		this.setSize(maxX, maxY);
		create();
	}
	
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
		panLB = new PanelLeaderBoard();
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
		returnAbout.setBounds(5, 570, 135, 50);
		returnAbout.addActionListener(controle_c);
		panLB.add(returnAbout);
		JButton next = new JButton("Next");
		next.setBounds(516, 570, 135, 50);
		next.addActionListener(controle_c);
		panLB.add(next);
		
	}

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

	public void refreshLeaderBoard() {
		panLB.repaint();
	}

	public void refreshEndGame() {
		controle_c.setName(this.name.getText());
		panEG.repaint();
	}

	public void refresh() {
		panIG.repaint();
	}

	public void refreshAbout() {
		panA.repaint();
	}

	public void refreshOption(String difficulty) {
		controle_c.setLevel((String)this.comboLevel.getSelectedItem());
		controle_c.setDelete((String)this.comboDelete.getSelectedItem());
		panO.setDifficulty(difficulty);
		panO.repaint();
	}

	public void refreshStart() {
		panS.repaint();
	}

	/*
	 * Permet de mettre à jour la vue et le panneau avec les coordonnées
	 * actuelles de Pacman et des fantomes
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
			System.out.println("Reset Vue majVue()");
		}
		this.setContentPane(panIG);
	}

	public void showPause() {
		panIG.setPause(true);
	}

	public void hidePause() {
		panIG.setPause(false);
	}

	public void setCounter(int i) {
		panIG.setCounter(i);
	}

	public void setTabLeaderBoard(String[][] extract, String level) {
		panLB.setTab(extract);
		panLB.setLevel(level);
		panLB.repaint();
	}
}
