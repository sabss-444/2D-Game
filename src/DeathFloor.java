package game;

import city.cs.engine.*;
import org.jbox2d.common.Vec2;

public class DeathFloor extends StaticBody {
    public DeathFloor(World world, Hero hero, Game game) {
        super(world);
        Shape floorShape = new BoxShape(20, 0.5f);
        Sensor sensor = new Sensor(this, floorShape);

        sensor.addSensorListener(new SensorListener() {
            @Override
            public void beginContact(SensorEvent e) {
                if (e.getContactBody() instanceof Hero) {
                    hero.loseLife();
                    if (hero.getLives() <= 0) {
                        SoundManager.stopMusic();
                        SoundManager.playSound("GameOver.wav");
                        javax.swing.JOptionPane.showMessageDialog(null, "GAME OVER!! YOU HAVE NO LIVES LEFT!!");
                        System.exit(0);
                    } else {
                        SoundManager.playSound("YouDied.wav");
                        hero.setPosition(new Vec2(0, -5));
                    }
                }
            }
            @Override
            public void endContact(SensorEvent e) {}
        });
    }
}