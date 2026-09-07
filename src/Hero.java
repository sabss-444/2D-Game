//Sabrina Hassan 250016774 Scavenger Hunt Game
//this is where is added the hero
package game;

import city.cs.engine.*;
import org.jbox2d.common.Vec2;

public class Hero extends Walker {
    //define the shape for the hero
    private static final Shape heroShape = new BoxShape(1,1);

    private static final BodyImage imageRight = new BodyImage("data/myCharacterRight.png", 4);
    private static final BodyImage imageLeft = new BodyImage("data/myCharacterLeft.png", 4);
    private static final BodyImage imageIdle = new BodyImage("data/myCharacter.png", 4);

    private int lives = 3;

    public Hero(World world) {
        //super calls the walker constructor
        //must be the first line in your constructor
        super(world, heroShape);
        addImage(new BodyImage("data/myCharacter.png", 4));
    }

    public void faceRight(){
       removeAllImages();
       addImage(imageRight);
    }

    public void faceLeft(){
        removeAllImages();
        addImage(imageLeft);
    }

    public void faceIdle(){
        removeAllImages();
        addImage(imageIdle);
    }
    private long lastHitTime = 0;
    private static final long HIT_COOLDOWN = 2000;

    public void loseLife(){
        long currentTime = System.currentTimeMillis();
        if (currentTime - lastHitTime > HIT_COOLDOWN) {
            lives --;
            lastHitTime = currentTime;
        }
    }
    public int getLives(){
        return lives;
    }

    public void stopWalking() {
        setLinearVelocity(new Vec2(0, getLinearVelocity().y));
    }
}
