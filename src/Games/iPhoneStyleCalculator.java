package Games;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class iPhoneStyleCalculator extends JFrame implements ActionListener, KeyListener {
    private JTextField display;
    private double currentValue = 0;
    private String operator = "";
    private boolean startNew = true;
    private boolean lastWasEqual = false;

    public iPhoneStyleCalculator() {
        setTitle("iPhone Style Calculator");
        setSize(400, 550);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setResizable(false);
        addKeyListener(this);
        setFocusable(true);

        // Display
        display = new JTextField("0");
        display.setEditable(false);
        display.setFont(new Font("Helvetica Neue", Font.PLAIN, 48));
        display.setHorizontalAlignment(SwingConstants.RIGHT);
        display.setBackground(Color.BLACK);
        display.setForeground(Color.WHITE);
        display.setBorder(null);

        // Buttons
        String[][] labels = {
                {"C", "±", "%", "÷"},
                {"7", "8", "9", "×"},
                {"4", "5", "6", "−"},
                {"1", "2", "3", "+"},
                {"0", ".", "=", ""}
        };

        JPanel buttonPanel = new JPanel(new GridLayout(5, 4, 10, 10));
        buttonPanel.setBackground(Color.BLACK);
        buttonPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        for (String[] row : labels) {
            for (String label : row) {
                if (label.isEmpty()) {
                    buttonPanel.add(new JLabel());
                    continue;
                }
                JButton button = new JButton(label);
                button.setFont(new Font("Helvetica Neue", Font.PLAIN, 28));
                button.setFocusPainted(false);
                button.setBackground(label.matches("[÷×−+=]") ? new Color(255, 149, 0) : new Color(50, 50, 50));
                button.setForeground(Color.WHITE);
                button.setBorder(BorderFactory.createLineBorder(Color.BLACK));
                button.addActionListener(this);
                buttonPanel.add(button);
            }
        }

        setLayout(new BorderLayout());
        add(display, BorderLayout.NORTH);
        add(buttonPanel, BorderLayout.CENTER);
        setVisible(true);

        SwingUtilities.invokeLater(() -> requestFocusInWindow());
    }

    public void actionPerformed(ActionEvent e) {
        handleInput(e.getActionCommand());
        requestFocusInWindow();
    }

    public void keyTyped(KeyEvent e) {
        char c = e.getKeyChar();
        if (Character.isDigit(c) || "+-*/=%.\n".indexOf(c) != -1) {
            handleInput(String.valueOf(c));
        } else if (c == 'c' || c == 'C') {
            handleInput("C");
        }
    }
    public void keyPressed(KeyEvent e) {}
    public void keyReleased(KeyEvent e) {}

    private void handleInput(String input) {
        String text = display.getText();

        if (input.matches("[0-9]")) {
            if (startNew || text.equals("0")) {
                display.setText(input);
                startNew = false;
            } else {
                display.setText(text + input);
            }
            lastWasEqual = false;
        } else if (input.equals(".")) {
            if (startNew) {
                display.setText("0.");
                startNew = false;
            } else if (!text.contains(".")) {
                display.setText(text + ".");
            }
        } else if (input.equals("±")) {
            double val = Double.parseDouble(text);
            display.setText(String.valueOf(-val));
        } else if (input.equals("%")) {
            double val = Double.parseDouble(text);
            display.setText(String.valueOf(val / 100));
        } else if (input.equals("C")) {
            display.setText("0");
            currentValue = 0;
            operator = "";
            startNew = true;
            lastWasEqual = false;
        } else if (input.matches("[÷×−+]")) {
            operator = input;
            currentValue = Double.parseDouble(text);
            startNew = true;
            lastWasEqual = false;
        } else if (input.equals("=")) {
            if (!lastWasEqual && !operator.isEmpty()) {
                double secondValue = Double.parseDouble(text);
                currentValue = switch (operator) {
                    case "+" -> currentValue + secondValue;
                    case "−" -> currentValue - secondValue;
                    case "×" -> currentValue * secondValue;
                    case "÷" -> secondValue != 0 ? currentValue / secondValue : Double.NaN;
                    default -> secondValue;
                };
                display.setText(removeTrailingZeros(currentValue));
                startNew = true;
                lastWasEqual = true;
            }
        }
    }

    private String removeTrailingZeros(double val) {
        if (val == (long) val) return String.format("%d", (long) val);
        else return String.format("%s", val);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(iPhoneStyleCalculator::new);
    }
}