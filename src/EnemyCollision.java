package game;

import city.cs.engine.*;
import org.jbox2d.common.Vec2;

public class EnemyCollision implements SensorListener {
    private Hero hero;
    private Game game;

    public EnemyCollision(Hero hero, Game game) {
        this.hero = hero;
        this.game = game;
    }

    @Override
    public void beginContact(SensorEvent e) {
        if (e.getContactBody() instanceof Hero) {
            hero.loseLife();
            if (hero.getLives() <= 0) {
                SoundManager.stopMusic();
                SoundManager.playSound("GameOver.wav");
                javax.swing.JOptionPane.showMessageDialog(null, "GAME OVER!! YOU HAVE NO LIVES LEFT!");
                System.exit(0);
            } else {
                SoundManager.playSound("YouDied.wav");
                hero.setPosition(new Vec2(0, -5));
            }
        }
    }

    @Override
    public void endContact(SensorEvent e) {
    }
}