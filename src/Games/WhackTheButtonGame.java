package Games;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.swing.*;
import java.util.Random;

public class WhackTheButtonGame extends JFrame {
    JButton moleButton = new JButton("Whack Me!");
    JLabel scoreLabel = new JLabel("Score: 0");
    JLabel timerLabel = new JLabel("Time: 30");
    int score = 0;
    int timeLeft = 30;
    Timer moveTimer, countdownTimer;
    Random rand = new Random();

    public WhackTheButtonGame() {
        setTitle("Whack the Button!");
        setSize(500, 500);
        setLayout(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        moleButton.setBounds(200, 200, 120, 50);
        moleButton.addActionListener(e -> {
            score++;
            scoreLabel.setText("Score: " + score);
            playSound("/bonk.wav"); // make sure this path points to your sound file!
            moveButton();
        });

        scoreLabel.setBounds(20, 20, 100, 30);
        timerLabel.setBounds(400, 20, 100, 30);

        add(scoreLabel);
        add(timerLabel);
        add(moleButton);
        setVisible(true);

        // Button jumps every 800 ms
        moveTimer = new Timer(800, e -> moveButton());
        moveTimer.start();

        // Countdown timer
        countdownTimer = new Timer(1000, e -> {
            timeLeft--;
            timerLabel.setText("Time: " + timeLeft);
            if (timeLeft <= 0) endGame();
        });
        countdownTimer.start();
    }

    // Moves button to a random location
    void moveButton() {
        int x = rand.nextInt(getWidth() - moleButton.getWidth() - 20);
        int y = rand.nextInt(getHeight() - moleButton.getHeight() - 60);
        moleButton.setLocation(x, y);
    }

    // Ends game and shows score
    void endGame() {
        moveTimer.stop();
        countdownTimer.stop();
        moleButton.setEnabled(false);
        JOptionPane.showMessageDialog(this, "Time’s up! Your score: " + score);
    }

    // Plays silly sound effect when button is clicked
    void playSound(String filename) {
        try {
            AudioInputStream audioIn = AudioSystem.getAudioInputStream(getClass().getResource(filename));
            Clip clip = AudioSystem.getClip();
            clip.open(audioIn);
            clip.start();
        } catch (Exception e) {
            e.printStackTrace(); // optional: show error dialog for missing sound file
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(WhackTheButtonGame::new);
    }
}
