//Sabrina Hassan 250016774 Scavenger Hunt Game
//this handles when hero collects a gem
package game;

import city.cs.engine.*;

public class CollectibleListener implements SensorListener {

    private Collectible collectible;
    private Level2 level2;
    private Level3 level3;

    public CollectibleListener(Collectible collectible, Level2 level2, Level3 level3) {
        this.collectible = collectible;
        this.level2 = level2;
        this.level3 = level3;
    }

    @Override
    public void beginContact(SensorEvent e) {
        if (e.getContactBody() instanceof Hero) {
            SoundManager.playSound("CoinCollected.wav");
            collectible.destroy();
            if (level2 != null) {
                level2.incrementCollected();
            }
            if (level3 != null) {
                level3.incrementCollected();
            }
        }
    }

    @Override
    public void endContact(SensorEvent e) {
    }
}