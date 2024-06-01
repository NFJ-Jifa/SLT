package at.technikum;

import java.util.Scanner;

public class TicTacToe {
    private Player player1;
    private Player player2;
    private Player currentPlayer;
    private Board board;

    public TicTacToe() {
        player1 = new Player('X');
        player2 = new Player('O');
        currentPlayer = player1;
        board = new Board();
    }

    public void start() {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            board.print();
            System.out.println("Current Player: " + currentPlayer.getMarker());
            System.out.print("row (0-2): ");
            int row = scanner.nextInt();
            System.out.print("column (0-2): ");
            int col = scanner.nextInt();

            if (board.isCellEmpty(row, col)) {
                board.place(row, col, currentPlayer.getMarker());
                if (hasWinner()) {
                    board.print();
                    System.out.println("Player " + currentPlayer.getMarker() + " wins!");
                    break;
                } else if (board.isFull()) {
                    board.print();
                    System.out.println("It's a draw!");
                    break;
                } else {
                    switchCurrentPlayer();
                }
            } else {
                System.out.println("Cell is not empty! Try again.");
            }
        }
        System.out.println("Game over. Starting a new game...");
        board.clear();
        start();
    }

    private void switchCurrentPlayer() {
        currentPlayer = (currentPlayer == player1) ? player2 : player1;
    }

    private boolean hasWinner() {
        char[][] cells = board.getCells();
        for (int i = 0; i < 3; i++) {
            // Check rows and columns
            if ((cells[i][0] == currentPlayer.getMarker() && cells[i][1] == currentPlayer.getMarker() && cells[i][2] == currentPlayer.getMarker()) ||
                    (cells[0][i] == currentPlayer.getMarker() && cells[1][i] == currentPlayer.getMarker() && cells[2][i] == currentPlayer.getMarker())) {
                return true;
            }
        }
        // Check diagonals
        if ((cells[0][0] == currentPlayer.getMarker() && cells[1][1] == currentPlayer.getMarker() && cells[2][2] == currentPlayer.getMarker()) ||
                (cells[0][2] == currentPlayer.getMarker() && cells[1][1] == currentPlayer.getMarker() && cells[2][0] == currentPlayer.getMarker())) {
            return true;
        }
        return false;
    }

    public static void main(String[] args) {
        TicTacToe game = new TicTacToe();
        game.start();
    }
}
