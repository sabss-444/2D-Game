//Sabrina Hassan 250016774 Scavenger Hunt Game
//this is the lava class
package game;

import city.cs.engine.*;

public class Lava extends StaticBody {

    public Lava(World world) {
        super(world);
        addImage(new BodyImage("data/Lava1.png", 10));
        // no sensor, no death logic, purely decorative
    }
}
