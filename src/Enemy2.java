//Sabrina Hassan 250016774 Scavenger Hunt Game
//this is the second enemy that patrols up and down
package game;

import city.cs.engine.*;
import org.jbox2d.common.Vec2;

public class Enemy2 extends DynamicBody implements StepListener {

    private float bottom;
    private float top;
    private float speed = 3;
    private boolean movingUp = true;
    private Sensor sensor;

    public Enemy2(World world, float bottom, float top) {
        super(world);
        sensor = new Sensor(this, new BoxShape(1, 1));
        addImage(new BodyImage("data/myEnemy2.png", 3));
        this.bottom = bottom;
        this.top = top;
        setGravityScale(0);
        setLinearVelocity(new Vec2(0, speed));
        world.addStepListener(this);
    }

    public void addEnemyCollision(SensorListener listener) {
        sensor.addSensorListener(listener);
    }

    @Override
    public void preStep(StepEvent e) {
        if (getPosition().y >= top) {
            movingUp = false;
        } else if (getPosition().y <= bottom) {
            movingUp = true;
        }

        if (movingUp) {
            setLinearVelocity(new Vec2(0, speed));
        } else {
            setLinearVelocity(new Vec2(0, -speed));
        }
    }

    @Override
    public void postStep(StepEvent e) {
    }
}