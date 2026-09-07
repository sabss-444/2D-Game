//Sabrina Hassan 250016774 Scavenger Hunt Game
//this is level 3
package game;

import city.cs.engine.*;
import city.cs.engine.Shape;
import org.jbox2d.common.Vec2;
import java.awt.*;

public class Level3 extends Level {

    private int collectedCount = 0;
    private static final int TOTAL_COLLECTIBLES = 7;
    private StaticBody star;

    public Level3(Game game) {
        super(game);
    }

    public void incrementCollected() {
        collectedCount++;
        if (allCollected()) {
            star.addImage(new BodyImage("data/MyStar.png", 3));
            star.setFillColor(new Color(255, 255, 255, 0));
        }
    }

    public int getCollectedCount() {
        return collectedCount;
    }

    public int getTotalCollectibles() {
        return TOTAL_COLLECTIBLES;
    }

    public boolean allCollected() {
        return collectedCount >= TOTAL_COLLECTIBLES;
    }

    @Override
    protected void initialise() {
        // ground
        Shape groundShape = new BoxShape(2, 0.5f);
        StaticBody ground = new StaticBody(this, groundShape);
        ground.setPosition(new Vec2(0, -9));
        ground.setFillColor(new Color(150, 0, 150));
        ground.setLineColor(new Color(150, 0, 150));

        // lava
        for (int i = -3; i <= 3; i++) {
            Lava lava = new Lava(this);
            lava.setPosition(new Vec2(i * 6, -10.5f));
        }

        // death floor
        DeathFloor deathFloor = new DeathFloor(this, getPlayer(), game);
        deathFloor.setPosition(new Vec2(0, -15));

        // platforms
        Shape platShape = new BoxShape(1.2f, 0.5f);

        StaticBody p1 = new StaticBody(this, platShape);
        p1.setPosition(new Vec2(-5, -6));
        p1.setFillColor(new Color(150, 0, 150));

        StaticBody p2 = new StaticBody(this, platShape);
        p2.setPosition(new Vec2(-10, -3));
        p2.setFillColor(new Color(150, 0, 150));

        StaticBody p3 = new StaticBody(this, platShape);
        p3.setPosition(new Vec2(-4, 0));
        p3.setFillColor(new Color(150, 0, 150));

        StaticBody p4 = new StaticBody(this, platShape);
        p4.setPosition(new Vec2(3, -2));
        p4.setFillColor(new Color(150, 0, 150));

        StaticBody p5 = new StaticBody(this, platShape);
        p5.setPosition(new Vec2(9, 1));
        p5.setFillColor(new Color(150, 0, 150));

        StaticBody p6 = new StaticBody(this, platShape);
        p6.setPosition(new Vec2(13, 5));
        p6.setFillColor(new Color(150, 0, 150));

        StaticBody p7 = new StaticBody(this, platShape);
        p7.setPosition(new Vec2(6, 8));
        p7.setFillColor(new Color(150, 0, 150));

        // collectibles just above each platform
        addCollectible(-5, -4.5f);
        addCollectible(-10, -1.5f);
        addCollectible(-4, 1.5f);
        addCollectible(3, -0.5f);
        addCollectible(9, 2.5f);
        addCollectible(13, 6.5f);
        addCollectible(6, 9.5f);

        // player start
        getPlayer().setPosition(new Vec2(0, -7));

        // star hidden until all collectibles collected
        Shape starShape = new CircleShape(0.8f);
        star = new StaticBody(this, starShape);
        star.setPosition(new Vec2(3, 11));
        star.setFillColor(new Color(0, 0, 0, 0));
        star.setLineColor(new Color(0, 0, 0, 0));

        // ghost enemy patrols left and right
        Enemy enemy1 = new Enemy(this, -8, 8);
        enemy1.setPosition(new Vec2(0, -3));
        enemy1.addEnemyCollision(new EnemyCollision(getPlayer(), game));

// second enemy patrols up and down
        Enemy2 enemy2 = new Enemy2(this, -5, 5);
        enemy2.setPosition(new Vec2(5, 0));
        enemy2.addEnemyCollision(new EnemyCollision(getPlayer(), game));
    }

    private void addCollectible(float x, float y) {
        Collectible c = new Collectible(this, this);
        c.setPosition(new Vec2(x, y));
    }
}