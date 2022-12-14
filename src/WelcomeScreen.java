import java.awt.event.*;
import java.awt.*;
import javax.swing.*;

public class WelcomeScreen {
    // GUI Components
    JFrame frame = new JFrame();
    JLabel titleLabel = new JLabel();
    JButton startButton = new JButton();

    public WelcomeScreen() {
        // Set up the frame
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(600, 400);
        frame.getContentPane().setBackground(new Color(50,50,50));
        frame.setLayout(null);
        frame.setResizable(false);

        // Set up the title label
        titleLabel.setBounds(100, 50, 400, 50);
        titleLabel.setFont(new Font("Ink Free", Font.BOLD, 30));
        titleLabel.setForeground(Color.WHITE);
        titleLabel.setHorizontalAlignment(JLabel.CENTER);
        titleLabel.setText("Welcome to the Game!");

        // Set up the start button
        startButton.setBounds(200, 200, 200, 50);
        startButton.setFont(new Font("Ink Free", Font.BOLD, 30));
        startButton.setForeground(Color.BLACK);
        startButton.setText("Start Game");
        startButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Start the game when the button is pressed
                Quiz quiz = new Quiz();
            }
        });

        // Add the components to the frame
        frame.add(titleLabel);
        frame.add(startButton);

        // Show the frame
        frame.setVisible(true);
    }

    // Method to start the game
    public void startGame() {
        // Code to start the game goes here...
    }

    public static void main(String[] args) {
        new WelcomeScreen();
    }
}

