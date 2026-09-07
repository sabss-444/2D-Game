//Sabrina Hassan 250016774 Scavenger Hunt Game
//this is the menu screen
package game;

import javax.swing.*;
import java.awt.*;

public class Menu extends JFrame {

    public Menu() {
        setTitle("Scavenger Hunt Game");
        setSize(600, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setResizable(false);
        showMainMenu();
        setVisible(true);
    }

    private void showMainMenu() {
        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new BorderLayout());
        mainPanel.setBackground(new Color(20, 10, 40));

        // title
        JLabel title = new JLabel("** SCAVENGER HUNT **", SwingConstants.CENTER);
        title.setFont(new Font("Georgia", Font.BOLD, 36));
        title.setForeground(new Color(255, 215, 0));
        title.setBorder(BorderFactory.createEmptyBorder(40, 0, 20, 0));
        mainPanel.add(title, BorderLayout.NORTH);

        // subtitle and buttons
        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new GridLayout(4, 1, 0, 15));
        buttonPanel.setBackground(new Color(20, 10, 40));
        buttonPanel.setBorder(BorderFactory.createEmptyBorder(20, 150, 40, 150));

        JLabel subtitle = new JLabel("Can you find all the stars?", SwingConstants.CENTER);
        subtitle.setFont(new Font("Georgia", Font.ITALIC, 16));
        subtitle.setForeground(new Color(200, 200, 255));

        // start button
        JButton startButton = createButton("START GAME", new Color(50, 180, 50));
        startButton.addActionListener(e -> {
            new Game();
            dispose();
        });

        // how to play button
        JButton howToPlayButton = createButton("HOW TO PLAY", new Color(50, 100, 200));
        howToPlayButton.addActionListener(e -> showInstructions());

        // quit button
        JButton quitButton = createButton("QUIT", new Color(180, 50, 50));
        quitButton.addActionListener(e -> System.exit(0));

        buttonPanel.add(subtitle);
        buttonPanel.add(startButton);
        buttonPanel.add(howToPlayButton);
        buttonPanel.add(quitButton);

        mainPanel.add(buttonPanel, BorderLayout.CENTER);

        setContentPane(mainPanel);
        revalidate();
        repaint();
    }

    private void showInstructions() {
        JPanel instrPanel = new JPanel();
        instrPanel.setLayout(new BorderLayout());
        instrPanel.setBackground(new Color(20, 10, 40));

        // title
        JLabel title = new JLabel("HOW TO PLAY", SwingConstants.CENTER);
        title.setFont(new Font("Georgia", Font.BOLD, 28));
        title.setForeground(new Color(255, 215, 0));
        title.setBorder(BorderFactory.createEmptyBorder(30, 0, 20, 0));
        instrPanel.add(title, BorderLayout.NORTH);

        // instructions
        JTextArea instructions = new JTextArea(
                "\n" +
                        "  CONTROLS:\n\n" +
                        "        A  ->  Move Left\n" +
                        "        D  ->  Move Right\n" +
                        "        W  ->  Jump\n\n" +
                        "  GOAL:\n\n" +
                        "        Reach the star to complete each level!\n\n" +
                        "  LEVEL 2:\n\n" +
                        "        Collect all 7 gems before the star appears!\n\n" +
                        "  DANGERS:\n\n" +
                        "        Avoid the lava and the ghost enemy!\n" +
                        "        You have 3 lives - use them wisely!\n"
        );
        instructions.setEditable(false);
        instructions.setBackground(new Color(20, 10, 40));
        instructions.setForeground(Color.WHITE);
        instructions.setFont(new Font("Arial", Font.PLAIN, 15));
        instrPanel.add(instructions, BorderLayout.CENTER);

        // back button
        JButton backButton = createButton("BACK", new Color(100, 50, 150));
        backButton.addActionListener(e -> showMainMenu());
        JPanel backPanel = new JPanel();
        backPanel.setBackground(new Color(20, 10, 40));
        backPanel.setBorder(BorderFactory.createEmptyBorder(0, 150, 20, 150));
        backPanel.add(backButton);
        instrPanel.add(backPanel, BorderLayout.SOUTH);

        setContentPane(instrPanel);
        revalidate();
        repaint();
    }

    private JButton createButton(String text, Color color) {
        JButton button = new JButton(text);
        button.setFont(new Font("Arial", Font.BOLD, 16));
        button.setBackground(color);
        button.setForeground(Color.WHITE);
        button.setFocusPainted(false);
        button.setBorderPainted(false);
        button.setCursor(new Cursor(Cursor.HAND_CURSOR));
        return button;
    }
}
