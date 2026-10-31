package Games;

import javax.swing.*;
import java.awt.*;

public class ConnectFourSwing extends JFrame {
    static final int ROWS = 6, COLS = 7;
    static final char EMPTY = '.', PLAYER = 'P', AI = 'A';
    static char[][] board = new char[ROWS][COLS];
    JButton[][] buttons = new JButton[ROWS][COLS];

    public ConnectFourSwing() {
        initBoard();
        setTitle("Connect Four - Swing Edition");
        setSize(700, 600);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(new GridLayout(ROWS, COLS));

        for (int r = 0; r < ROWS; r++) {
            for (int c = 0; c < COLS; c++) {
                JButton btn = new JButton();
                btn.setBackground(Color.LIGHT_GRAY);
                buttons[r][c] = btn;
                final int col = c;
                btn.addActionListener(e -> playerMove(col));
                add(btn);
            }
        }

        setVisible(true);
    }

    void playerMove(int col) {
        if (placeToken(col, PLAYER)) {
            updateBoard();
            if (checkWin(PLAYER)) {
                showWinner("You win!");
                return;
            }

            int aiCol = getAIMove();
            placeToken(aiCol, AI);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException ex){
                ex.printStackTrace();
            }
            updateBoard();
            if (checkWin(AI)) {
                showWinner("AI wins!");
            }
        }
    }

    void updateBoard() {
        for (int r = 0; r < ROWS; r++) {
            for (int c = 0; c < COLS; c++) {
                char token = board[r][c];
                buttons[r][c].setBackground(switch (token) {
                    case PLAYER -> Color.RED;
                    case AI -> Color.YELLOW;
                    default -> Color.LIGHT_GRAY;
                });
            }
        }
    }

    static void initBoard() {
        for (int r = 0; r < ROWS; r++)
            for (int c = 0; c < COLS; c++)
                board[r][c] = EMPTY;
    }

    static boolean placeToken(int col, char token) {
        if (col < 0 || col >= COLS) return false;
        for (int row = ROWS - 1; row >= 0; row--) {
            if (board[row][col] == EMPTY) {
                board[row][col] = token;
                return true;
            }
        }
        return false;
    }

    static boolean checkWin(char token) {
        for (int r = 0; r < ROWS; r++)
            for (int c = 0; c < COLS; c++)
                if (
                        c + 3 < COLS &&
                                token == board[r][c] &&
                                token == board[r][c + 1] &&
                                token == board[r][c + 2] &&
                                token == board[r][c + 3] ||
                                r + 3 < ROWS &&
                                        token == board[r][c] &&
                                        token == board[r + 1][c] &&
                                        token == board[r + 2][c] &&
                                        token == board[r + 3][c] ||
                                r + 3 < ROWS && c + 3 < COLS &&
                                        token == board[r][c] &&
                                        token == board[r + 1][c + 1] &&
                                        token == board[r + 2][c + 2] &&
                                        token == board[r + 3][c + 3] ||
                                r + 3 < ROWS && c - 3 >= 0 &&
                                        token == board[r][c] &&
                                        token == board[r + 1][c - 1] &&
                                        token == board[r + 2][c - 2] &&
                                        token == board[r + 3][c - 3]
                ) return true;
        return false;
    }

    static int getAIMove() {
        for (int col = 0; col < COLS; col++) {
            if (simulateMove(col, AI)) return col;
        }
        for (int col = 0; col < COLS; col++) {
            if (simulateMove(col, PLAYER)) return col;
        }
        for (int col = 0; col < COLS; col++) {
            if (board[0][col] == EMPTY) return col;
        }
        return 0;
    }

    static boolean simulateMove(int col, char token) {
        for (int row = ROWS - 1; row >= 0; row--) {
            if (board[row][col] == EMPTY) {
                board[row][col] = token;
                boolean win = checkWin(token);
                board[row][col] = EMPTY;
                return win;
            }
        }
        return false;
    }

    void showWinner(String message) {
        JOptionPane.showMessageDialog(this, message);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(ConnectFourSwing::new);
    }
}