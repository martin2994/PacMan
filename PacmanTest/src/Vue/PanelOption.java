package Vue;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JPanel;

public class PanelOption extends JPanel {

	private String difficulty;
	private Image startpage;

	public PanelOption() {
		this.difficulty = "Medium";
		try {
			startpage=ImageIO.read(new File("src/image/startpage.png"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void paintComponent(Graphics g) {
		g.setColor(Color.black);
		g.fillRect(0, 0, this.getWidth(), this.getHeight());

		g.drawImage(startpage, 0,0,this);
		Font font = new Font("Courier", Font.BOLD, 25);
		g.setFont(font);
		g.setColor(Color.YELLOW);
		g.drawString("Ghost level:", this.getWidth() / 3 + 11, 40);
		drawDifficulty(g);
	}

	public void drawDifficulty(Graphics g) {
		Font font = new Font("Courier", Font.BOLD, 25);
		g.setFont(font);
		g.setColor(Color.YELLOW);
		g.drawString("Current level: " + difficulty, this.getWidth() / 3 - 65, 150);

	}

	public String getDifficulty() {
		return difficulty;
	}

	public void setDifficulty(String difficulty) {
		this.difficulty = difficulty;
	}
}
