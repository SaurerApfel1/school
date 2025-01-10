package Games.Overtale.Gameplay;

import javax.sound.sampled.*;
import java.io.File;
import java.io.IOException;

public class SoundEffect {

    public Clip clip;

    public void setFile(String filePath) {
        File file = new File(filePath);
        try {
            AudioInputStream sound = AudioSystem.getAudioInputStream(file);
            clip = AudioSystem.getClip();
            clip.open(sound);
        } catch (UnsupportedAudioFileException | IOException | LineUnavailableException e) {
            throw new RuntimeException(e);
        }
    }

    public void play(){

        clip.setFramePosition(0);
        clip.start();
    }

}
