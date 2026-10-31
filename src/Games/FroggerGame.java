package Games;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;
import java.util.Random;

public class FroggerGame extends JPanel implements ActionListener, KeyListener {
    final int WIDTH = 600, HEIGHT = 400;
    final int FROG_SIZE = 40, CAR_WIDTH = 60, CAR_HEIGHT = 30;
    Timer timer = new Timer(20, this);
    Rectangle frog;
    ArrayList<Rectangle> cars = new ArrayList<>();
    Random rand = new Random();
    int score = 0;

    public FroggerGame() {
        setPreferredSize(new Dimension(WIDTH, HEIGHT));
        setBackground(Color.GREEN);
        frog = new Rectangle(WIDTH / 2 - FROG_SIZE / 2, HEIGHT - FROG_SIZE - 10, FROG_SIZE, FROG_SIZE);
        addKeyListener(this);
        setFocusable(true);
        spawnCars();
        timer.start();
    }

    void spawnCars() {
        for (int i = 0; i < 5; i++) {
            int y = 60 + i * 50;
            int x = rand.nextInt(WIDTH);
            cars.add(new Rectangle(x, y, CAR_WIDTH, CAR_HEIGHT));
        }
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.setColor(Color.BLUE);
        g.fillRect(frog.x, frog.y, frog.width, frog.height);

        g.setColor(Color.RED);
        for (Rectangle car : cars) {
            g.fillRect(car.x, car.y, car.width, car.height);
        }

        g.setColor(Color.BLACK);
        g.drawString("Score: " + score, 10, 20);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        for (Rectangle car : cars) {
            car.x += 5;
            if (car.x > WIDTH) car.x = -CAR_WIDTH;
        }

        checkCollision();
        repaint();
    }

    void checkCollision() {
        for (Rectangle car : cars) {
            if (frog.intersects(car)) {
                //playSound("/car_crash.wav");
                timer.stop();
                JOptionPane.showMessageDialog(this, "Game Over! Score: " + score);
                System.exit(0);
            }
        }

        if (frog.y <= 0) {
            score++;
            //playSound("/level_up.wav");
            frog.y = HEIGHT - FROG_SIZE - 10;
        }
    }

    @Override
    public void keyPressed(KeyEvent e) {
        int code = e.getKeyCode();
        if (code == KeyEvent.VK_UP) frog.y -= 10;
        if (code == KeyEvent.VK_DOWN) frog.y += 10;
        if (code == KeyEvent.VK_LEFT) frog.x -= 10;
        if (code == KeyEvent.VK_RIGHT) frog.x += 10;

        playSound("/frog_jump.wav");
        repaint();
    }

    void playSound(String filename) {
        try {
            AudioInputStream audioIn = AudioSystem.getAudioInputStream(getClass().getResource(filename));
            Clip clip = AudioSystem.getClip();
            clip.open(audioIn);
            clip.start();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override public void keyReleased(KeyEvent e) {}
    @Override public void keyTyped(KeyEvent e) {}

    public static void main(String[] args) {
        JFrame frame = new JFrame("Frogger");
        FroggerGame game = new FroggerGame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(false);
        frame.add(game);
        frame.pack();
        frame.setVisible(true);
    }
}