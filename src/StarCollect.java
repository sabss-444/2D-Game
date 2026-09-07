//Sabrina Hassan 250016774 Scavenger Hunt Game
//this is for the collisions when they win/lose
package game;

import city.cs.engine.*;
import org.jbox2d.common.Vec2;
import javax.swing.JOptionPane;

public class StarCollect implements CollisionListener {

    private Hero hero;
    private Game game;

    public StarCollect(Hero hero, Game game) {
        this.hero = hero;
        this.game = game;
    }

    @Override
    public void collide(CollisionEvent e) {
        if (e.getOtherBody().getPosition().y > 8) {
            if (game.getLevelNumber() == 2) {
                Level2 level2 = (Level2) game.getCurrentLevel();
                if (!level2.allCollected()) {
                    return;
                }
            }
            if (game.getLevelNumber() == 3) {
                Level3 level3 = (Level3) game.getCurrentLevel();
                if (!level3.allCollected()) {
                    return;
                }
            }
            SoundManager.stopMusic();
            SoundManager.playSound("CoinCollected.wav");
            int nextLevel = game.getLevelNumber() + 1;
            game.loadLevel(nextLevel);
        }
    }
}