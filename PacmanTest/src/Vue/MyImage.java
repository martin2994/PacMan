package Vue;

import java.awt.Image;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class MyImage {
	private Image[] mylab;
	private Image[] mybonus;
	private Image[] mypacman;
	private Image[] myghost;

	public MyImage() {
			mylab=new Image[26];
			mybonus=new Image[4];
			mypacman=new Image[5];
			myghost=new Image[22];
		try { // chargement des images
			mylab[0] = ImageIO.read(new File("src/image/case0.png"));
			mylab[1] = ImageIO.read(new File("src/image/case1.png"));
			mylab[25] = ImageIO.read(new File("src/image/case-5.png"));
			mylab[2] = ImageIO.read(new File("src/image/case2.png"));
			mylab[3] = ImageIO.read(new File("src/image/case3.png"));
			mylab[4] = ImageIO.read(new File("src/image/case4.png"));
			mylab[5] = ImageIO.read(new File("src/image/case5.png"));
			mylab[6] = ImageIO.read(new File("src/image/case6.png"));
			mylab[7] = ImageIO.read(new File("src/image/case7.png"));
			mylab[8] = ImageIO.read(new File("src/image/case8.png"));
			mylab[9] = ImageIO.read(new File("src/image/case9.png"));
			mylab[10] = ImageIO.read(new File("src/image/case10.png"));
			mylab[11] = ImageIO.read(new File("src/image/case11.png"));
			mylab[12] = ImageIO.read(new File("src/image/case12.png"));
			mylab[13] = ImageIO.read(new File("src/image/case13.png"));
			mylab[14] = ImageIO.read(new File("src/image/case14.png"));
			mylab[15] = ImageIO.read(new File("src/image/case15.png"));
			mylab[16] = ImageIO.read(new File("src/image/case16.png"));
			mylab[17] = ImageIO.read(new File("src/image/case17.png"));
			mylab[18] = ImageIO.read(new File("src/image/case18.png"));
			mylab[19] = ImageIO.read(new File("src/image/case19.png"));
			mylab[20] = ImageIO.read(new File("src/image/case20.png"));
			mylab[21] = ImageIO.read(new File("src/image/case21.png"));
			mylab[22] = ImageIO.read(new File("src/image/case22.png"));
			mylab[23] = ImageIO.read(new File("src/image/case23.png"));
			mylab[24] = ImageIO.read(new File("src/image/case24.png"));
			mypacman[1] = ImageIO.read(new File("src/image/Pacman_left.png"));
			mypacman[2]= ImageIO.read(new File("src/image/Pacman_right.png"));
			mypacman[3] = ImageIO.read(new File("src/image/Pacman_up.png"));
			mypacman[4] = ImageIO.read(new File("src/image/Pacman_down.png"));
			mypacman[0] = ImageIO.read(new File("src/image/Pacman_close.png"));
			myghost[0] = ImageIO.read(new File("src/image/Blinky_left.png"));
			myghost[1] = ImageIO.read(new File("src/image/Blinky_up.png"));
			myghost[2] = ImageIO.read(new File("src/image/Blinky_down.png"));
			myghost[3] = ImageIO.read(new File("src/image/Blinky_right.png"));
			myghost[4] = ImageIO.read(new File("src/image/Clyde_left.png"));
			myghost[5] = ImageIO.read(new File("src/image/Clyde_up.png"));
			myghost[6] = ImageIO.read(new File("src/image/Clyde_down.png"));
			myghost[7] = ImageIO.read(new File("src/image/Clyde_right.png"));
			myghost[8] = ImageIO.read(new File("src/image/Inky_left.png"));
			myghost[9] = ImageIO.read(new File("src/image/Inky_up.png"));
			myghost[10] = ImageIO.read(new File("src/image/Inky_down.png"));
			myghost[11] = ImageIO.read(new File("src/image/Inky_right.png"));
			myghost[12] = ImageIO.read(new File("src/image/Pinky_left.png"));
			myghost[13] = ImageIO.read(new File("src/image/Pinky_up.png"));
			myghost[14] = ImageIO.read(new File("src/image/Pinky_down.png"));
			myghost[15] = ImageIO.read(new File("src/image/Pinky_right.png"));
			myghost[20] = ImageIO.read(new File("src/image/Blue_Ghost.png"));
			myghost[21] = ImageIO.read(new File("src/image/White_Ghost.png"));
			myghost[19] = ImageIO.read(new File("src/image/eyes_right.png"));
			myghost[17] = ImageIO.read(new File("src/image/eyes_up.png"));
			myghost[18] = ImageIO.read(new File("src/image/eyes_down.png"));
			myghost[16] = ImageIO.read(new File("src/image/eyes_left.png"));
			mybonus[0] = ImageIO.read(new File("src/image/fraise.png"));
			mybonus[1] = ImageIO.read(new File("src/image/orange.png"));
			mybonus[2] = ImageIO.read(new File("src/image/cerise.png"));
			mybonus[3] = ImageIO.read(new File("src/image/pomme.png"));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	public Image getCase(int i){
		return mylab[i];
	}
	public Image getGhost(String name,String direction){
		int i;
		switch (name){
		case "Blinky":
			i=0;
			switch (direction){
			case "left":return myghost[4*i];
			case "up":return myghost[4*i+1];
			case "down":return myghost[4*i+2];
			case "right":return myghost[4*i+3];
			}
		case "Pinky":
			i=3;
			switch (direction){
			case "left":return myghost[4*i];
			case "up":return myghost[4*i+1];
			case "down":return myghost[4*i+2];
			case "right":return myghost[4*i+3];
			}
		case "Clyde":
			i=1;
			switch (direction){
			case "left":return myghost[4*i];
			case "up":return myghost[4*i+1];
			case "down":return myghost[4*i+2];
			case "right":return myghost[4*i+3];
			}
		case "Inky":
			i=2;
			switch (direction){
			case "left":return myghost[4*i];
			case "up":return myghost[4*i+1];
			case "down":return myghost[4*i+2];
			case "right":return myghost[4*i+3];
			}
		case "Eye":
			i=4;
			switch (direction){
			case "left":return myghost[4*i];
			case "up":return myghost[4*i+1];
			case "down":return myghost[4*i+2];
			case "right":return myghost[4*i+3];
			}
		case "Blue":return myghost[20];
		case "White":return myghost[21];
		default:return null;
		}
	}
	public Image getBonus(String name){
		switch (name){
		case "Fraise":return mybonus[0];
		case "Orange":return mybonus[1];
		case "Cerise":return mybonus[2];
		case "Pomme":return mybonus[3];
		default: return null;
		}
	}
	public Image getPacman(String name){
		switch (name){
			case "left":return mypacman[1];
			case "up":return mypacman[3];
			case "down":return mypacman[4];
			case "right":return mypacman[2];
			case "close":return mypacman[0];
			default: return null;
		}
	}
}
