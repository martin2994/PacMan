
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JPanel;

import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JPanel;

public class Panneau extends JPanel {
	private int posX = 0;
	private int posY = 0;
	private Ghost blinky;
	private Ghost pinky;
	private Ghost inky;
	private Ghost clyde;
	private Modele.Direction go_pacman;
	private boolean form_pacman = false;
	private int timer_anim_pacman = 0;

	public void paintComponent(Graphics g) {
		int mat[][] = Modele.labyrinth;
		// int length=mat.length;
		g.setColor(Color.black);
		g.fillRect(0, 0, this.getWidth(), this.getHeight());
		try { // chargement des images
			Image img0 = ImageIO.read(new File("src/image/case0.png"));
			Image img1 = ImageIO.read(new File("src/image/case1.png"));
			Image img2 = ImageIO.read(new File("src/image/case2.png"));
			Image img3 = ImageIO.read(new File("src/image/case3.png"));
			Image img4 = ImageIO.read(new File("src/image/case4.png"));
			Image img5 = ImageIO.read(new File("src/image/case5.png"));
			Image img6 = ImageIO.read(new File("src/image/case6.png"));
			Image img7 = ImageIO.read(new File("src/image/case7.png"));
			Image img8 = ImageIO.read(new File("src/image/case8.png"));
			Image img9 = ImageIO.read(new File("src/image/case9.png"));
			Image img10 = ImageIO.read(new File("src/image/case10.png"));
			Image img11 = ImageIO.read(new File("src/image/case11.png"));
			Image img12 = ImageIO.read(new File("src/image/case12.png"));
			Image img13 = ImageIO.read(new File("src/image/case13.png"));
			Image img14 = ImageIO.read(new File("src/image/case14.png"));
			Image img15 = ImageIO.read(new File("src/image/case15.png"));
			Image img16 = ImageIO.read(new File("src/image/case16.png"));
			Image img17 = ImageIO.read(new File("src/image/case17.png"));
			Image img18 = ImageIO.read(new File("src/image/case18.png"));
			Image img19 = ImageIO.read(new File("src/image/case19.png"));
			Image img20 = ImageIO.read(new File("src/image/case20.png"));
			Image img21 = ImageIO.read(new File("src/image/case21.png"));
			Image img22 = ImageIO.read(new File("src/image/case22.png"));
			Image img23 = ImageIO.read(new File("src/image/case23.png"));
			Image img24 = ImageIO.read(new File("src/image/case24.png"));
			Image pacman_left = ImageIO.read(new File("src/image/Pacman_left.png"));
			Image pacman_right = ImageIO.read(new File("src/image/Pacman_right.png"));
			Image pacman_up = ImageIO.read(new File("src/image/Pacman_up.png"));
			Image pacman_down = ImageIO.read(new File("src/image/Pacman_down.png"));
			Image pacman_close = ImageIO.read(new File("src/image/Pacman_close.png"));
			Image blinky_left = ImageIO.read(new File("src/image/Blinky_left.png"));
			Image blinky_right = ImageIO.read(new File("src/image/Blinky_right.png"));
			Image clyde_left = ImageIO.read(new File("src/image/Clyde_left.png"));
			Image clyde_right = ImageIO.read(new File("src/image/Clyde_right.png"));
			Image inky_left = ImageIO.read(new File("src/image/Inky_left.png"));
			Image inky_right = ImageIO.read(new File("src/image/Inky_right.png"));
			Image pinky_left = ImageIO.read(new File("src/image/Pinky_left.png"));
			Image pinky_right = ImageIO.read(new File("src/image/Pinky_right.png"));
			Image ghost = ImageIO.read(new File("src/image/Fantome.png"));
			for (int i = 0; i < 19; i++) {
				for (int j = 0; j < 22; j++) {
					switch (mat[i][j]) {
					case 0:
						g.drawImage(img0, i * 28, j * 28, this);
						break;
					case 1:
						g.drawImage(img1, i * 28, j * 28, this);
						break;
					case 2:
						g.drawImage(img2, i * 28, j * 28, this);
						break;
					case 3:
						g.drawImage(img3, i * 28, j * 28, this);
						break;
					case 4:
						g.drawImage(img4, i * 28, j * 28, this);
						break;
					case 5:
						g.drawImage(img5, i * 28, j * 28, this);
						break;
					case 6:
						g.drawImage(img6, i * 28, j * 28, this);
						break;
					case 7:
						g.drawImage(img7, i * 28, j * 28, this);
						break;
					case 8:
						g.drawImage(img8, i * 28, j * 28, this);
						break;
					case 9:
						g.drawImage(img9, i * 28, j * 28, this);
						break;
					case 10:
						g.drawImage(img10, i * 28, j * 28, this);
						break;
					case 11:
						g.drawImage(img11, i * 28, j * 28, this);
						break;
					case 12:
						g.drawImage(img12, i * 28, j * 28, this);
						break;
					case 13:
						g.drawImage(img13, i * 28, j * 28, this);
						break;
					case 14:
						g.drawImage(img14, i * 28, j * 28, this);
						break;
					case 15:
						g.drawImage(img15, i * 28, j * 28, this);
						break;
					case 16:
						g.drawImage(img16, i * 28, j * 28, this);
						break;
					case 17:
						g.drawImage(img17, i * 28, j * 28, this);
						break;
					case 18:
						g.drawImage(img18, i * 28, j * 28, this);
						break;
					case 19:
						g.drawImage(img19, i * 28, j * 28, this);
						break;
					case 20:
						g.drawImage(img20, i * 28, j * 28, this);
						break;
					case 21:
						g.drawImage(img21, i * 28, j * 28, this);
						break;
					case 22:
						g.drawImage(img22, i * 28, j * 28, this);
						break;
					case 23:
						g.drawImage(img23, i * 28, j * 28, this);
						break;
					case 24:
						g.drawImage(img24, i * 28, j * 28, this);
						break;
					}
				}
			}
			if (form_pacman || timer_anim_pacman < 10) {
				switch (go_pacman) {
				case UP:
					g.drawImage(pacman_up, posX, posY, this);
					break;
				case DOWN:
					g.drawImage(pacman_down, posX, posY, this);
					break;
				case LEFT:
					g.drawImage(pacman_left, posX, posY, this);
					break;
				case RIGHT:
					g.drawImage(pacman_right, posX, posY, this);
					break;
				}
				if (timer_anim_pacman == 9)
					form_pacman = false;
			} else {
				g.drawImage(pacman_close, posX, posY, this);
			}
			timer_anim_pacman++;
			if (timer_anim_pacman == 20) {
				timer_anim_pacman = 0;
				form_pacman = true;
			}
			if (blinky.getState() == 0) {
				if (blinky.getGo() == Modele.Direction.UP || blinky.getGo() == Modele.Direction.LEFT)
					g.drawImage(blinky_left, blinky.getCoordX(), blinky.getCoordY(), this);
				else
					g.drawImage(blinky_right, blinky.getCoordX(), blinky.getCoordY(), this);
			} else {
				g.drawImage(ghost, blinky.getCoordX(), blinky.getCoordY(), this);
			}
			if (inky.getState() == 0) {
				if (inky.getGo() == Modele.Direction.UP || inky.getGo() == Modele.Direction.LEFT)
					g.drawImage(inky_left, inky.getCoordX(), inky.getCoordY(), this);
				else
					g.drawImage(inky_right, inky.getCoordX(), inky.getCoordY(), this);
			} else {
				g.drawImage(ghost, inky.getCoordX(), inky.getCoordY(), this);
			}
			if (pinky.getState() == 0) {
				if (pinky.getGo() == Modele.Direction.UP || pinky.getGo() == Modele.Direction.LEFT)
					g.drawImage(pinky_left, pinky.getCoordX(), pinky.getCoordY(), this);
				else
					g.drawImage(pinky_right, pinky.getCoordX(), pinky.getCoordY(), this);
			} else {
				g.drawImage(ghost, pinky.getCoordX(), pinky.getCoordY(), this);
			}
			if (clyde.getState() == 0) {
				if (clyde.getGo() == Modele.Direction.UP || clyde.getGo() == Modele.Direction.LEFT)
					g.drawImage(clyde_left, clyde.getCoordX(), clyde.getCoordY(), this);
				else
					g.drawImage(clyde_right, clyde.getCoordX(), clyde.getCoordY(), this);
			} else {
				g.drawImage(ghost, clyde.getCoordX(), clyde.getCoordY(), this);
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public int getPosX() {
		return posX;
	}

	public void setPosX(int posX) {
		this.posX = posX;
	}

	public int getPosY() {
		return posY;
	}

	public void setPosY(int posY) {
		this.posY = posY;
	}

	public Ghost getBlinky() {
		return blinky;
	}

	public void setBlinky(Ghost blinky) {
		this.blinky = blinky;
	}

	public Ghost getPinky() {
		return pinky;
	}

	public void setPinky(Ghost pinky) {
		this.pinky = pinky;
	}

	public Ghost getInky() {
		return inky;
	}

	public void setInky(Ghost inky) {
		this.inky = inky;
	}

	public Ghost getClyde() {
		return clyde;
	}

	public void setClyde(Ghost clyde) {
		this.clyde = clyde;
	}

	public void setGo_pacman(Modele.Direction new_go_pacman) {
		this.go_pacman = new_go_pacman;
	}

	public boolean getForm_pacman() {
		return this.form_pacman;
	}

	public void setForm_pacman(boolean new_form) {
		this.form_pacman = new_form;
	}

	public int getTimer_anim_pacman() {
		return timer_anim_pacman;
	}

	public void setTimer_anim_pacman(int timer_anim_pacman) {
		this.timer_anim_pacman = timer_anim_pacman;
	}

}
