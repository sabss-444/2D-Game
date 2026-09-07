//Sabrina Hassan 250016774 Scavenger Hunt Game
//this is how users control the character
package game;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class Controller extends KeyAdapter {
    private Hero hero;
    private static final float WALKING_SPEED = 8;

    public Controller(Hero hero) {
        this.hero = hero;
    }

    @Override
    public void keyPressed(KeyEvent e) {
        int code = e.getKeyCode();
        System.out.println("Key Pressed: " + code); //testing
        if (code == KeyEvent.VK_D) {
            hero.startWalking(WALKING_SPEED);
            hero.faceRight();
        } else if (code == KeyEvent.VK_A) {
            hero.startWalking(-WALKING_SPEED);
            hero.faceLeft();
        } else if (code == KeyEvent.VK_W) {
            hero.jump(10);
        }
    }
    @Override
    public void keyReleased(KeyEvent e) {
        int code = e.getKeyCode();
        if (code == KeyEvent.VK_A || code == KeyEvent.VK_D || code == KeyEvent.VK_W) {
            hero.startWalking(0);
            hero.faceIdle();
        }
    }
}
