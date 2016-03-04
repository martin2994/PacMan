package Vue;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;

import javax.swing.JPanel;

public class PanelLeaderBoard extends JPanel {

	private String tab[][];

	public void paintComponent(Graphics g) {
		g.setColor(Color.BLACK);
		g.fillRect(0, 0, this.getWidth(), this.getHeight());
		Font font = new Font("Courrier", Font.BOLD, 25);
		g.setFont(font);
		g.setColor(Color.YELLOW);
		g.drawString("LEADERBOARD", this.getWidth() / 3 + 17, 30);
		for (int i = 0; i < tab.length; i++) {
			g.drawString(i + 1 + " -", 10, 130 + 35 * i);
			g.drawString(tab[i][1], 160, 130 + 35 * i);
			g.drawString(tab[i][0], 340, 130 + 35 * i);
		}
	}

	public void setTab(String _tab[][]) {
		this.tab = new String[_tab.length][_tab[0].length];
		for (int i = 0; i < tab.length; i++) {
			for (int j = 0; j < tab[0].length; j++) {
				tab[i][j] = _tab[i][j];
			}
		}
	}
}
