package Vue;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JButton;
import javax.swing.JPanel;

public class PannelStart extends JPanel {

	private Image blinky_left;
	private Image blinky_up;
	private Image blinky_down;
	private Image blinky_right;
	private Image clyde_left;
	private Image clyde_up;
	private Image clyde_down;
	private Image clyde_right;
	private Image inky_left;
	private Image inky_up;
	private Image inky_down;
	private Image inky_right;
	private Image pinky_left;
	private Image pinky_up;
	private Image pinky_down;
	private Image pinky_right;
	private Image startpage;

	public PannelStart() {
		try {
			blinky_left = ImageIO.read(new File("src/image/Blinky_left.png"));
			blinky_up = ImageIO.read(new File("src/image/Blinky_up.png"));
			blinky_down = ImageIO.read(new File("src/image/Blinky_down.png"));
			blinky_right = ImageIO.read(new File("src/image/Blinky_right.png"));
			clyde_left = ImageIO.read(new File("src/image/Clyde_left.png"));
			clyde_up = ImageIO.read(new File("src/image/Clyde_up.png"));
			clyde_down = ImageIO.read(new File("src/image/Clyde_down.png"));
			clyde_right = ImageIO.read(new File("src/image/Clyde_right.png"));
			inky_left = ImageIO.read(new File("src/image/Inky_left.png"));
			inky_up = ImageIO.read(new File("src/image/Inky_up.png"));
			inky_down = ImageIO.read(new File("src/image/Inky_down.png"));
			inky_right = ImageIO.read(new File("src/image/Inky_right.png"));
			pinky_left = ImageIO.read(new File("src/image/Pinky_left.png"));
			pinky_up = ImageIO.read(new File("src/image/Pinky_up.png"));
			pinky_down = ImageIO.read(new File("src/image/Pinky_down.png"));
			pinky_right = ImageIO.read(new File("src/image/Pinky_right.png"));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void paintComponent(Graphics g) {
		g.setColor(Color.black);
		g.fillRect(0, 0, this.getWidth(), this.getHeight());

	}
}
