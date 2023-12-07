package Game.minigame;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import java.net.URL;

public class Sound {

    Clip clip;
    URL[] soundURL = new URL[30];

    public Sound(){
        soundURL[0] = getClass().getResource("/Minigame/Sound/coin.wav");
        soundURL[1] = getClass().getResource("/Minigame/Sound/Temple-of-Tomb.wav");
        soundURL[2] = getClass().getResource("/Minigame/Sound/cursed.wav");
        soundURL[3] = getClass().getResource("/Minigame/Sound/complete.wav");
    }

    public void setFile(int i){
        try{
            AudioInputStream ais = AudioSystem.getAudioInputStream(soundURL[i]);
            clip = AudioSystem.getClip();
            clip.open(ais);
        }catch (Exception e){
            e.printStackTrace();
        }
    }
    public void play(){
        clip.start();
    }

    public void loop(){
        clip.loop(Clip.LOOP_CONTINUOUSLY);
    }

    public void stop(){
        clip.stop();
    }
}
