//Sabrina Hassan 250016774 Scavenger Hunt Game
//this is level 2
package game;

import city.cs.engine.*;
import city.cs.engine.Shape;
import org.jbox2d.common.Vec2;
import java.awt.*;

public class Level2 extends Level {

    private int collectedCount = 0;
    private static final int TOTAL_COLLECTIBLES = 7;
    private StaticBody star;

    public Level2(Game game) {
        super(game);
    }

    public void incrementCollected() {
        collectedCount++;
        if (allCollected()) {
            // reveal the star
            star.addImage(new BodyImage("data/MyStar.png", 3.0f));
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

        // lava
        for (int i = -3; i <= 3; i++) {
            Lava lava = new Lava(this);
            lava.setPosition(new Vec2(i * 6, -10.5f));
        }

        DeathFloor deathFloor = new DeathFloor(this, getPlayer(), game);
        deathFloor.setPosition(new Vec2(0, -15));

        // platforms
        Shape platShape = new BoxShape(1.5f, 0.5f);

        StaticBody p1 = new StaticBody(this, platShape);
        p1.setPosition(new Vec2(-6, -6));
        p1.setFillColor(new Color(0, 100, 100));

        StaticBody p2 = new StaticBody(this, platShape);
        p2.setPosition(new Vec2(0, -2));
        p2.setFillColor(new Color(0, 100, 100));

        StaticBody p3 = new StaticBody(this, platShape);
        p3.setPosition(new Vec2(8, 0));
        p3.setFillColor(new Color(0, 100, 100));

        StaticBody p4 = new StaticBody(this, platShape);
        p4.setPosition(new Vec2(-1, 4));
        p4.setFillColor(new Color(0, 100, 100));

        StaticBody p5 = new StaticBody(this, platShape);
        p5.setPosition(new Vec2(-10, 0));
        p5.setFillColor(new Color(0, 100, 100));

        StaticBody p6 = new StaticBody(this, platShape);
        p6.setPosition(new Vec2(-16, 4));
        p6.setFillColor(new Color(0, 100, 100));

        StaticBody p7 = new StaticBody(this, platShape);
        p7.setPosition(new Vec2(-9, 7));
        p7.setFillColor(new Color(0, 100, 100));

        // collectibles just above each platform
        addCollectible(-6, -4.5f);
        addCollectible(0, -0.5f);
        addCollectible(8, 1.5f);
        addCollectible(-1, 5.5f);
        addCollectible(-10, 1.5f);
        addCollectible(-16, 5.5f);
        addCollectible(-9, 8.5f);

        // player start
        getPlayer().setPosition(new Vec2(0, -8));

        // star hidden until all gems collected
        // star hidden until all gems collected
        Shape starShape = new CircleShape(0.8f);
        star = new StaticBody(this, starShape);
        star.setPosition(new Vec2(-4, 13));
        star.setFillColor(new Color(0, 0, 0, 0)); // invisible
        star.setLineColor(new Color(0, 0, 0, 0)); // invisible

        Enemy enemy = new Enemy(this, -5, 5);
        enemy.setPosition(new Vec2(1, 3));
        enemy.addEnemyCollision(new EnemyCollision(getPlayer(), game));

    }

    private void addCollectible(float x, float y) {
        Collectible c = new Collectible(this, this);
        c.setPosition(new Vec2(x, y));
    }
}
