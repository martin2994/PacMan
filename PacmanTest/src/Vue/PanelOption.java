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
			startpage = ImageIO.read(new File("src/image/startpage.png"));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void paintComponent(Graphics g) {
		g.setColor(Color.black);
		g.fillRect(0, 0, this.getWidth(), this.getHeight());
		g.drawImage(startpage, 0, 0, this);
		Font font = new Font("Courier", Font.BOLD, 25);
		g.setFont(font);
		g.setColor(Color.YELLOW);
		g.drawString("Ghost difficulty:", this.getWidth() / 3 -14, 40);
		drawDifficulty(g);
		g.drawLine(0, this.getHeight()/4+21, this.getWidth(), this.getHeight()/4+21);
		g.drawLine(0, this.getHeight()/4+23, this.getWidth(), this.getHeight()/4+23);
		g.drawString ("Choose level : ", this.getWidth()/3-33,222);
		g.drawLine(0, this.getHeight()/2-55, this.getWidth(), this.getHeight()/2-55);
		g.drawLine(0, this.getHeight()/2-53, this.getWidth(), this.getHeight()/2-53);
		g.drawString ("Sound: ", this.getWidth()/2-50,this.getHeight()/2-8);
	}

	public void drawDifficulty(Graphics g) {
		Font font = new Font("Courier", Font.BOLD, 25);
		g.setFont(font);
		g.setColor(Color.YELLOW);
		g.drawString("Current difficulty: " + difficulty, this.getWidth() / 3 - 88, 150);

	}

	public String getDifficulty() {
		return difficulty;
	}

	public void setDifficulty(String difficulty) {
		this.difficulty = difficulty;
	}
}
