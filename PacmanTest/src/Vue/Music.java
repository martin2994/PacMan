package Vue;

import java.net.URL;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;

public class Music {
	
	URL current_music;
	Clip current_clip;

		public Music(){
			setMusic("music/startpage.wav");
		}
		public void changeMusic(String music){
			if (current_clip.isRunning()){
				current_clip.close();
			}
			setMusic(music);
		}
		public void setMusic(String music){
			try{
				current_music=Vue.class.getResource(music);
				AudioInputStream audioIn=AudioSystem.getAudioInputStream(current_music);
				current_clip=AudioSystem.getClip();
				current_clip.open(audioIn);
				current_clip.start();
				current_clip.loop(Clip.LOOP_CONTINUOUSLY);
			}catch(Exception e){
				System.out.println("error sound");
			}
		}
		
		public void stopMusic(){
			if (current_clip.isRunning()){
				current_clip.stop();
			}else{
				current_clip.start();
			}
		}

	
}
