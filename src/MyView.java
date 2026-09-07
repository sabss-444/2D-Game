//Sabrina Hassan 250016774 Scavenger Hunt Game
//this is the background and HUD
package game;

import city.cs.engine.*;
import javax.swing.*;
import java.awt.*;

public class MyView extends UserView {

    private Image background;
    private Image heart;
    private int levelNumber;
    private Hero hero;
    private World world;

    public MyView(World world, int width, int height, int levelNumber, Hero hero) {
        super(world, width, height);
        this.world = world;
        this.levelNumber = levelNumber;
        this.hero = hero;
        heart = new ImageIcon("data/MyStats.png").getImage();

        if (levelNumber == 1) {
            background = new ImageIcon("data/MyBackground.jpg").getImage();
        } else if (levelNumber == 2) {
            background = new ImageIcon("data/Lvl2Background.jpg").getImage();
        } else {
            background = new ImageIcon("data/Lvl3Background.jpg").getImage();
        }
    }

    @Override
    protected void paintBackground(Graphics2D g) {
        g.drawImage(background, 0, 0, this.getWidth(), this.getHeight(), this);
    }

    @Override
    protected void paintForeground(Graphics2D g) {
        g.setColor(Color.WHITE);
        g.setFont(new Font("Arial", Font.BOLD, 20));

        if (levelNumber == 2 && world instanceof Level2) {
            Level2 level2 = (Level2) world;
            g.drawString(level2.getCollectedCount() + "/" + level2.getTotalCollectibles()
                    + " gems collected - get them all to get the star!", 20, 30);
        } else if (levelNumber == 3 && world instanceof Level3) {
            Level3 level3 = (Level3) world;
            g.drawString(level3.getCollectedCount() + "/" + level3.getTotalCollectibles()
                    + " gems collected - get them all to get the star!", 20, 30);
        } else {
            g.drawString("Goal: Reach the star!", 20, 30);
            g.drawString("Watch out for the lava!", 20, 55);
        }

        g.drawString("Level: " + levelNumber, 20, 80);

        for (int i = 0; i < hero.getLives(); i++) {
            g.drawImage(heart, 20 + (i * 40), 90, 35, 35, this);
        }
    }
}