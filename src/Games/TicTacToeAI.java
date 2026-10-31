package Games;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

// Main class extending JFrame and handling button events
public class TicTacToeAI extends JFrame implements ActionListener {

    JButton[][] buttons = new JButton[3][3]; // 3x3 grid of buttons
    char[][] board = new char[3][3];         // Internal board representation
    char currentPlayer = 'X';                // 'X' is human, 'O' is AI

    public TicTacToeAI() {
        setTitle("Tic Tac Toe with AI");
        setSize(300, 300);
        setLayout(new GridLayout(3, 3));
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        // Initialize buttons and board
        for (int i = 0; i < 3; i++)
            for (int j = 0; j < 3; j++) {
                buttons[i][j] = new JButton("");
                buttons[i][j].setFont(new Font("Arial", Font.BOLD, 60));
                buttons[i][j].addActionListener(this);
                add(buttons[i][j]);
                board[i][j] = ' ';
            }

        setVisible(true);
    }

    // Handles player's move
    public void actionPerformed(ActionEvent e) {
        JButton clicked = (JButton) e.getSource();

        // Find the button's position
        for (int i = 0; i < 3; i++)
            for (int j = 0; j < 3; j++) {
                if (clicked == buttons[i][j] && board[i][j] == ' ') {
                    makeMove(i, j, 'X'); // Human move
                    if (checkWin('X')) {
                        showMessage("Player wins!");
                        resetGame();
                        return;
                    } else if (isFull()) {
                        showMessage("It's a draw!");
                        resetGame();
                        return;
                    }
                    aiMove(); // AI responds
                    if (checkWin('O')) {
                        showMessage("AI wins!");
                        resetGame();
                        return;
                    } else if (isFull()) {
                        showMessage("It's a draw!");
                        resetGame();
                        return;
                    }
                    return;
                }
            }
    }

    // Makes a move for given player at [row][col]
    void makeMove(int row, int col, char player) {
        board[row][col] = player;
        buttons[row][col].setText(String.valueOf(player));
    }

    // AI selects optimal move using minimax
    void aiMove() {
        int bestScore = Integer.MIN_VALUE;
        int moveRow = -1, moveCol = -1;

        // Check all empty spots
        for (int i = 0; i < 3; i++)
            for (int j = 0; j < 3; j++) {
                if (board[i][j] == ' ') {
                    board[i][j] = 'O'; // Try move
                    int score = minimax(board, 0, false); // Evaluate using minimax
                    board[i][j] = ' '; // Undo move
                    if (score > bestScore) {
                        bestScore = score;
                        moveRow = i;
                        moveCol = j;
                    }
                }
            }

        makeMove(moveRow, moveCol, 'O'); // Perform best move
    }

    // Minimax algorithm: evaluates move scores recursively
    int minimax(char[][] b, int depth, boolean isMaximizing) {
        if (checkWin('O')) return 10 - depth;     // AI wins
        if (checkWin('X')) return depth - 10;     // Player wins
        if (isFull()) return 0;                   // Draw

        if (isMaximizing) {
            int best = Integer.MIN_VALUE;
            for (int i = 0; i < 3; i++)
                for (int j = 0; j < 3; j++)
                    if (b[i][j] == ' ') {
                        b[i][j] = 'O';
                        best = Math.max(best, minimax(b, depth + 1, false));
                        b[i][j] = ' ';
                    }
            return best;
        } else {
            int best = Integer.MAX_VALUE;
            for (int i = 0; i < 3; i++)
                for (int j = 0; j < 3; j++)
                    if (b[i][j] == ' ') {
                        b[i][j] = 'X';
                        best = Math.min(best, minimax(b, depth + 1, true));
                        b[i][j] = ' ';
                    }
            return best;
        }
    }

    // Checks for winner
    boolean checkWin(char p) {
        // Rows, columns, diagonals
        for (int i = 0; i < 3; i++)
            if ((board[i][0] == p && board[i][1] == p && board[i][2] == p) ||
                    (board[0][i] == p && board[1][i] == p && board[2][i] == p))
                return true;

        return (board[0][0] == p && board[1][1] == p && board[2][2] == p) ||
                (board[0][2] == p && board[1][1] == p && board[2][0] == p);
    }

    // Checks if board is full
    boolean isFull() {
        for (char[] row : board)
            for (char cell : row)
                if (cell == ' ') return false;
        return true;
    }

    // Shows winner message
    void showMessage(String msg) {
        JOptionPane.showMessageDialog(this, msg);
    }

    // Resets game board and buttons
    void resetGame() {
        for (int i = 0; i < 3; i++)
            for (int j = 0; j < 3; j++) {
                board[i][j] = ' ';
                buttons[i][j].setText("");
            }
        currentPlayer = 'X';
    }

    // Launch the GUI
    public static void main(String[] args) {
        new TicTacToeAI();
    }
}

