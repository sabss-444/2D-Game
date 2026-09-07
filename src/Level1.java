//this replacing the gameWorld  class
package game;

import city.cs.engine.*;
import org.jbox2d.common.Vec2;
import java.awt.*;
import city.cs.engine.Shape;

public class Level1 extends Level {

    public Level1(Game game) {
        super(game);
    }

    @Override
    protected void initialise() {
        //the ground
        Shape groundShape = new BoxShape(2,0.5f);
        StaticBody ground = new StaticBody(this, groundShape);
        ground.setPosition(new Vec2(0, -9));
        ground.setFillColor(new Color(30, 60, 30));
        ground.setLineColor(new Color(30, 60, 30));

        for (int i = -3; i <= 3; i++) {
            Lava lava = new Lava(this);
            lava.setPosition(new Vec2(i * 6, -10.5f));
        }

        DeathFloor deathFloor = new DeathFloor(this, getPlayer(), game);
        deathFloor.setPosition(new Vec2(0, -15));

        //platforms
        Shape platShape = new BoxShape(2, 0.5f);
        StaticBody p1 = new StaticBody(this, platShape);
        p1.setPosition(new Vec2(-4, -7));
        p1.setFillColor(new Color(30, 60, 30));
        //p2
        StaticBody p2 = new StaticBody(this, platShape);
        p2.setPosition(new Vec2(6, -4));
        p2.setFillColor(new Color(30, 60, 30));
        //p3
        StaticBody p3 = new StaticBody(this, platShape);
        p3.setPosition(new Vec2(11, 0));
        p3.setFillColor(new Color(30, 60, 30));
        //p4
        StaticBody p4 = new StaticBody(this, platShape);
        p4.setPosition(new Vec2(-11, 4));
        p4.setFillColor(new Color(30, 60, 30));
        //p5
        StaticBody p5 = new StaticBody(this, platShape);
        p5.setPosition(new Vec2(-7, 0));
        p5.setFillColor(new Color(30, 60, 30));
        //p6
        StaticBody p6 = new StaticBody(this, platShape);
        p6.setPosition(new Vec2(3, 3));
        p6.setFillColor(new Color(30, 60, 30));
        //p7
        StaticBody p7 = new StaticBody(this, platShape);
        p7.setPosition(new Vec2(-3, 7));
        p7.setFillColor(new Color(30, 60, 30));

        //this is the players staring postion
        getPlayer().setPosition(new Vec2(0, -7));

        //the star
        Shape starShape = new CircleShape(0.8f);//increasing the number to see what it does
        StaticBody star = new StaticBody(this, starShape);
        star.setPosition(new Vec2(0, 10));
        star.addImage(new BodyImage("data/MyStar.png", 3.0f));

        Enemy enemy = new Enemy(this, -5, 5);
        enemy.setPosition(new Vec2(0, -3));
        enemy.addEnemyCollision(new EnemyCollision(getPlayer(), game));
    }
}
