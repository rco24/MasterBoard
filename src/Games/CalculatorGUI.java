package Games;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class CalculatorGUI extends JFrame implements ActionListener, KeyListener {
    private JTextField display;
    private JPanel buttonPanel;
    private String operator = "";
    private double currentValue = 0;
    private boolean startNewNumber = true;
    private boolean lastPressedEquals = false;

    public CalculatorGUI() {
        setTitle("Calculator");
        setSize(450, 550);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        addKeyListener(this);
        setFocusable(true);
        requestFocusInWindow();

        display = new JTextField("0");
        display.setEditable(false);
        display.setFont(new Font("Consolas", Font.BOLD, 42));
        display.setHorizontalAlignment(SwingConstants.RIGHT);
        display.setBackground(Color.BLACK);
        display.setForeground(Color.GREEN);

        buttonPanel = new JPanel(new GridLayout(4, 4, 10, 10));
        String[] buttons = {
                "7", "8", "9", "/",
                "4", "5", "6", "*",
                "1", "2", "3", "-",
                "0", "C", "=", "+"
        };

        for (String text : buttons) {
            JButton button = new JButton(text);
            button.setFont(new Font("Arial", Font.BOLD, 30));
            button.setBackground(Color.DARK_GRAY);
            button.setForeground(Color.WHITE);
            button.addActionListener(this);
            buttonPanel.add(button);
        }

        setLayout(new BorderLayout(20, 20));
        add(display, BorderLayout.NORTH);
        add(buttonPanel, BorderLayout.CENTER);
        setVisible(true);

        SwingUtilities.invokeLater(() -> {
            setFocusable(true);
            requestFocusInWindow();
        });
    }

    public void actionPerformed(ActionEvent e) {
        processInput(e.getActionCommand());
        requestFocusInWindow();
    }

    public void keyTyped(KeyEvent e) {
        char key = e.getKeyChar();
        if (Character.isDigit(key) || "+-*/=".indexOf(key) != -1) {
            processInput(String.valueOf(key));
        } else if (key == '\n') {
            processInput("=");
        } else if (key == 'c' || key == 'C') {
            processInput("C");
        }
    }

    public void keyPressed(KeyEvent e) {}
    public void keyReleased(KeyEvent e) {}

    private void processInput(String input) {
        String currentText = display.getText();

        if ("0123456789".contains(input)) {
            if (startNewNumber || currentText.equals("0") || lastPressedEquals) {
                display.setText(input);
                startNewNumber = false;
                lastPressedEquals = false;
            } else {
                display.setText(currentText + input);
            }

        } else if ("+-*/".contains(input)) {
            operator = input;
            currentValue = Double.parseDouble(display.getText());
            display.setText(currentValue + " " + operator + " ");
            startNewNumber = true;
            lastPressedEquals = false;

        } else if ("=".equals(input)) {
            String[] parts = display.getText().split("[" + "\\" + operator + "]");
            if (parts.length < 2) return;

            try {
                double secondValue = Double.parseDouble(parts[1].trim());
                currentValue = switch (operator) {
                    case "+" -> currentValue + secondValue;
                    case "-" -> currentValue - secondValue;
                    case "*" -> currentValue * secondValue;
                    case "/" -> secondValue != 0 ? currentValue / secondValue : Double.NaN;
                    default -> currentValue;
                };
                display.setText(String.valueOf(currentValue));
                lastPressedEquals = true;
            } catch (Exception ex) {
                display.setText("Error");
            }

        } else if ("C".equals(input)) {
            display.setText("0");
            operator = "";
            currentValue = 0;
            startNewNumber = true;
            lastPressedEquals = false;
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(CalculatorGUI::new);
    }
}