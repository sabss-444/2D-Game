//Sabrina Hassan 250016774 Scavenger Hunt Game
//this is the collectible gem class for level 2
package game;

import city.cs.engine.*;

public class Collectible extends StaticBody {

    public Collectible(World world, Level2 level2) {
        super(world);
        Sensor sensor = new Sensor(this, new CircleShape(0.7f));
        addImage(new BodyImage("data/MyCollectible.png", 3));
        sensor.addSensorListener(new CollectibleListener(this, level2, null));
    }
    public Collectible(World world, Level3 level3) {
        super(world);
        Sensor sensor = new Sensor(this, new CircleShape(0.7f));
        addImage(new BodyImage("data/MyCollectible.png", 3));
        sensor.addSensorListener(new CollectibleListener(this, null, level3));
    }
}