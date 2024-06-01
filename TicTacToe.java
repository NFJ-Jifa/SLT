package at.technikum; 

import java.util.Scanner; 

public class TicTacToe { 
    private Player player1; 
    private Player player2; 
    private Player currentPlayer; 
    private Board board; 

    public TicTacToe() { 
        player1 = new Player('X'); // Initialisiert Spieler 1 mit dem Marker 'X'
        player2 = new Player('O'); // Initialisiert Spieler 2 mit dem Marker 'O'
        currentPlayer = player1; // Setzt den aktuellen Spieler auf Spieler 1
        board = new Board(); // Initialisiert das Spielfeld
    }

    public void start() { // Methode, die das Spiel startet
        Scanner scanner = new Scanner(System.in); 
        while (true) { // Endlosschleife für das Spiel
            board.print(); // Druckt das Spielfeld aus
            System.out.println("Current Player: " + currentPlayer.getMarker()); // Zeigt den aktuellen Spieler an
            System.out.print("row (0-2): "); // Fragt nach der Zeile für den nächsten Zug
            int row = scanner.nextInt(); // Liest die Zeile ein
            System.out.print("column (0-2): "); // Fragt nach der Spalte für den nächsten Zug
            int col = scanner.nextInt(); 

            if (board.isCellEmpty(row, col)) { // Überprüft, ob die gewählte Zelle leer ist
                board.place(row, col, currentPlayer.getMarker()); // Platziert den Marker des aktuellen Spielers
                if (hasWinner()) { // Überprüft, ob der aktuelle Spieler gewonnen hat
                    board.print(); 
                    System.out.println("Player " + currentPlayer.getMarker() + " wins!"); // Gibt den Gewinner bekannt
                    break; // Beendet die Schleife und damit das Spiel
                } else if (board.isFull()) { // Überprüft, ob das Spielfeld voll ist
                    board.print(); 
                    System.out.println("It's a draw!"); // Gibt bekannt, dass das Spiel unentschieden ist
                    break; 
                } else {
                    switchCurrentPlayer(); // Wechselt den aktuellen Spieler
                }
            } else {
                System.out.println("Cell is not empty! Try again."); // Gibt eine Fehlermeldung aus, wenn die Zelle nicht leer ist
            }
        }
        System.out.println("Game over. Starting a new game..."); // Gibt bekannt, dass das Spiel vorbei ist und ein neues Spiel gestartet wird
        board.clear(); // Leert das Spielfeld
        start(); // Startet das Spiel erneut
    }

    private void switchCurrentPlayer() { // Methode, die den aktuellen Spieler wechselt
        currentPlayer = (currentPlayer == player1) ? player2 : player1; // Wechselt zwischen Spieler 1 und Spieler 2
    }

    private boolean hasWinner() { // Methode, die überprüft, ob es einen Gewinner gibt
        char[][] cells = board.getCells(); 
        for (int i = 0; i < 3; i++) { // Schleife, die jede Zeile und Spalte überprüft
            // Überprüft, ob eine Zeile oder Spalte den gleichen Marker hat
            if ((cells[i][0] == currentPlayer.getMarker() && cells[i][1] == currentPlayer.getMarker() && cells[i][2] == currentPlayer.getMarker()) ||
                    (cells[0][i] == currentPlayer.getMarker() && cells[1][i] == currentPlayer.getMarker() && cells[2][i] == currentPlayer.getMarker())) {
                return true; // Gibt true zurück, wenn es einen Gewinner gibt
            }
        } // Überprüft die Diagonalen
        
        if ((cells[0][0] == currentPlayer.getMarker() && cells[1][1] == currentPlayer.getMarker() && cells[2][2] == currentPlayer.getMarker()) ||
                (cells[0][2] == currentPlayer.getMarker() && cells[1][1] == currentPlayer.getMarker() && cells[2][0] == currentPlayer.getMarker())) {
            return true; // Gibt true zurück, wenn es einen Gewinner auf einer Diagonale gibt
        }
        return false; // Gibt false zurück, wenn es keinen Gewinner gibt
    }

    public static void main(String[] args) { // Hauptmethode, die das Programm startet
        TicTacToe game = new TicTacToe(); // Erstellt ein neues TicTacToe-Spiel
        game.start(); // Startet das Spiel
    }
}
