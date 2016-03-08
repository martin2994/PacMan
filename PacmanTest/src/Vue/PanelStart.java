package Vue;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JPanel;

public class PanelStart extends JPanel {

	private Image blinky_down;
	private Image clyde_down;
	private Image inky_down;
	private Image pinky_down;
	private Image startpage;
	private int blinkyX;
	private int blinkyY;
	private int inkyX;
	private int inkyY;
	private int pinkyX;
	private int pinkyY;
	private int clydeX;
	private int clydeY;
	private int inkyDirX;
	private int inkyDirY;
	private int pinkyDirX;
	private int pinkyDirY;
	private int blinkyDirX;
	private int blinkyDirY;
	private int clydeDirX;
	private int clydeDirY;

	public PanelStart() {
		try {
			blinky_down = ImageIO.read(new File("src/image/Blinky_down.png"));
			clyde_down = ImageIO.read(new File("src/image/Clyde_down.png"));
			inky_down = ImageIO.read(new File("src/image/Inky_down.png"));
			pinky_down = ImageIO.read(new File("src/image/Pinky_down.png"));
			startpage=ImageIO.read(new File("src/image/startpage.png"));
		} catch (IOException e) {
			e.printStackTrace();
		}
		blinkyX=(int)(Math.random()*620);
		blinkyY=10;
		inkyX=(int)(Math.random()*620);
		inkyY=10;
		pinkyX=10;
		pinkyY=(int)(Math.random()*590);
		clydeX=10;
		clydeY=(int)(Math.random()*590);
		blinkyDirX=chooseDir();
		blinkyDirY=chooseDir();
		inkyDirX=chooseDir();
		inkyDirY=chooseDir();
		pinkyDirX=chooseDir();
		pinkyDirY=chooseDir();
		clydeDirX=chooseDir();
		clydeDirY=chooseDir();
	}

	private int chooseDir() {
		int random=(int)(Math.random()*2);
		if(random==0){
			return -1;
		} else {
			return 1;
		}
	}

	public void paintComponent(Graphics g) {
		blinkyX+=blinkyDirX;
		blinkyY+=blinkyDirY;
		inkyX+=inkyDirX;
		inkyY+=inkyDirY;
		pinkyX+=pinkyDirX;
		pinkyY+=pinkyDirY;
		clydeX+=clydeDirX;
		clydeY+=clydeDirY;
		changeDirection();
		g.setColor(Color.black);
		g.fillRect(0, 0, this.getWidth(), this.getHeight());
		g.drawImage(startpage, 0,0,this);
		
		g.drawImage(blinky_down,blinkyX, blinkyY, this);
		g.drawImage(inky_down,inkyX, inkyY, this);
		g.drawImage(pinky_down,pinkyX, pinkyY, this);
		g.drawImage(clyde_down,clydeX, clydeY, this);
	}
	
	private void changeDirection(){
		if(blinkyX+28==this.getWidth()){
			blinkyDirX=-1;
		}
		if(blinkyY+28==this.getHeight()){
			blinkyDirY=-1;
		}
		if(blinkyX==0){
			blinkyDirX=+1;
		}
		if(blinkyY==0){
			blinkyDirY=+1;
		}
		if(inkyX+28==this.getWidth()){
			inkyDirX=-1;
		}
		if(inkyY+28==this.getHeight()){
			inkyDirY=-1;
		}
		if(inkyX==0){
			inkyDirX=+1;
		}
		if(inkyY==0){
			inkyDirY=+1;
		}
		if(pinkyX+28==this.getWidth()){
			pinkyDirX=-1;
		}
		if(pinkyY+28==this.getHeight()){
			pinkyDirY=-1;
		}
		if(pinkyX==0){
			pinkyDirX=+1;
		}
		if(pinkyY==0){
			pinkyDirY=+1;
		}
		if(clydeX+28==this.getWidth()){
			clydeDirX=-1;
		}
		if(clydeY+28==this.getHeight()){
			clydeDirY=-1;
		}
		if(clydeX==0){
			clydeDirX=+1;
		}
		if(clydeY==0){
			clydeDirY=+1;
		}
	}
}