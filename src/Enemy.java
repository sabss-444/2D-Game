package game;

import city.cs.engine.*;
import org.jbox2d.common.Vec2;

import java.awt.event.KeyListener;

public class Enemy extends DynamicBody implements StepListener {

    private float left;
    private float right;
    private float speed = 3;
    private boolean movingRight = true;
    private Sensor sensor;

    public Enemy(World world, float left, float right) {
        super(world);
        sensor = new Sensor(this, new BoxShape(1, 1));
        this.left = left;
        this.right = right;
        addImage(new BodyImage("data/myEnemy.png", 3));
        setGravityScale(0);
        setLinearVelocity(new Vec2(speed, 0));
        setBullet(true);
        world.addStepListener(this);

    }

    public void addEnemyCollision(SensorListener listener) {
        sensor.addSensorListener(listener);
    }

    @Override
    public void preStep(StepEvent e) {
        if(getPosition().x>= right) {
            movingRight = false;
        }
        else if(getPosition().x<= left) {
            movingRight = true;
        }
        if(movingRight) {
            setLinearVelocity(new Vec2(speed, 0));
        } else {
            setLinearVelocity(new Vec2(-speed, 0));
        }
    }

    @Override
    public void postStep(StepEvent e){
    }
}
