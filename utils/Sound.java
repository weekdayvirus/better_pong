package utils;

import java.io.BufferedInputStream;
import java.io.InputStream;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;

public class Sound {
    private Clip clip;  

    public void play(String path) {
        try {
            InputStream is = getClass().getResourceAsStream(path);
            AudioInputStream ais = AudioSystem.getAudioInputStream(new BufferedInputStream(is));
            clip = AudioSystem.getClip();
            clip.open(ais);
            clip.start();
        } catch(Exception e) {
            System.err.println(e);
        }
    }
}
