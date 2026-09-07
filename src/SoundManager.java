//Sabrina Hassan 250016774 Scavenger Hunt Game
//this manages all the sounds in the game
package game;

import javax.sound.sampled.*;
import java.io.File;

public class SoundManager {

    private static Clip backgroundMusic;

    // play a sound once
    public static void playSound(String filename) {
        try {
            AudioInputStream audio = AudioSystem.getAudioInputStream(new File("data/" + filename));
            Clip clip = AudioSystem.getClip();
            clip.open(audio);
            clip.start();
        } catch (Exception e) {
            System.out.println("Could not play sound: " + filename);
        }
    }

    // play background music on loop
    public static void playMusic(String filename) {
        try {
            stopMusic();
            File file = new File("data/" + filename);
            System.out.println("Looking for file: " + file.getAbsolutePath());
            System.out.println("File exists: " + file.exists());
            AudioInputStream audio = AudioSystem.getAudioInputStream(file);
            backgroundMusic = AudioSystem.getClip();
            backgroundMusic.open(audio);
            backgroundMusic.loop(Clip.LOOP_CONTINUOUSLY);
            backgroundMusic.start();
            System.out.println("Music started successfully!");
        } catch (Exception e) {
            System.out.println("Could not play music: " + filename);
            System.out.println("Error: " + e.getMessage());
        }
    }

    // stop background music
    public static void stopMusic() {
        if (backgroundMusic != null && backgroundMusic.isRunning()) {
            backgroundMusic.stop();
            backgroundMusic.close();
        }
    }
}