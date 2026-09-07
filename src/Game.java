//Sabrina Hassan 250016774 Scavenger Hunt Game
//this is game launcher and links the classes
package game;

import javax.swing.JFrame;
import city.cs.engine.*;
import javax.swing.*;
import java.awt.*;

public class Game {

    private Level currentLevel;
    private MyView view;
    private JFrame frame;
    private int levelNumber = 1;

    public Game() {
        frame = new JFrame("Scavenger Game");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        loadLevel(1);
        frame.pack();
        frame.setVisible(true);
    }
    public void loadLevel(int number) {
        levelNumber = number;

        if (currentLevel != null) {
            currentLevel.stop();
        }

        if (number == 1) {
            currentLevel = new Level1(this);
        } else if (number == 2) {
            currentLevel = new Level2(this);
        } else if (number == 3) {
            currentLevel = new Level3(this);
        } else {
            javax.swing.JOptionPane.showMessageDialog(null, "YOU COMPLETED ALL LEVELS! YOU WIN!!");
            System.exit(0);
        }

        view = new MyView(currentLevel, 800, 600, levelNumber, currentLevel.getPlayer());
        view.addKeyListener(new Controller(currentLevel.getPlayer()));
        view.setFocusable(true);

        currentLevel.getPlayer().addCollisionListener(new StarCollect(currentLevel.getPlayer(), this));

        // create exit button panel
        JPanel bottomPanel = new JPanel();
        bottomPanel.setBackground(Color.BLACK);
        JButton exitButton = new JButton("EXIT GAME");
        exitButton.setBackground(Color.RED);
        exitButton.setForeground(Color.WHITE);
        exitButton.setFont(new Font("Arial", Font.BOLD, 14));
        exitButton.addActionListener(e -> System.exit(0));
        bottomPanel.add(exitButton);

        frame.getContentPane().removeAll();
        frame.add(view, BorderLayout.CENTER);
        frame.add(bottomPanel, BorderLayout.SOUTH);
        frame.revalidate();
        frame.repaint();
        view.requestFocusInWindow();

        currentLevel.start();
        SoundManager.playMusic("BackgroundMusic.wav");
    }
    public int getLevelNumber() {
        return levelNumber;
    }
    public Level getCurrentLevel() {
        return currentLevel;
    }
    public static void main(String[] args) {
        new Menu();
    }
}
