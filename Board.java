package at.technikum;

public class Board { 
    private char[][] cells; // Deklariert ein zweidimensionales Array von chars, um das Spielfeld darzustellen

    public Board() { 
        cells = new char[3][3]; 
        clear(); // Ruft die Methode "clear()" auf, um das Spielfeld zu leeren
    }

    public boolean isCellEmpty(int x, int y) { // Methode, die überprüft, ob eine bestimmte Zelle leer ist
        return cells[x][y] == ' '; // Gibt true zurück, wenn die Zelle an der Position (x, y) ein Leerzeichen ist
    }

    public void place(int x, int y, char marker) { // Methode, die einen Marker (z.B. 'X' oder 'O') in eine Zelle setzt
        if (isCellEmpty(x, y)) { // Überprüft, ob die Zelle leer ist
            cells[x][y] = marker; // Setzt den Marker in die Zelle, wenn sie leer ist
        }
    }

    public boolean isFull() { // Methode, die überprüft, ob das Spielfeld voll ist
        for (int i = 0; i < 3; i++) { 
            for (int j = 0; j < 3; j++) { 
                if (cells[i][j] == ' ') { // Überprüft, ob die Zelle leer ist
                    return false; // Gibt false zurück, wenn eine leere Zelle gefunden wird
                }
            }
        }
        return true; // Gibt true zurück, wenn keine leere Zelle gefunden wird
    }

    public void clear() { // Methode, die das Spielfeld leert
        for (int i = 0; i < 3; i++) { 
            for (int j = 0; j < 3; j++) { 
                cells[i][j] = ' '; // Setzt jede Zelle auf ein Leerzeichen
            }
        }
    }

    public void print() { // Methode, die das Spielfeld ausdruckt
        System.out.println("▁▁▁▁▁▁▁"); // Druckt eine obere Rahmenlinie
        for (int i = 0; i < 3; i++) { 
            System.out.print("|"); // Druckt eine linke Rahmenlinie
            for (int j = 0; j < 3; j++) { 
                System.out.print(cells[i][j] == ' ' ? " " : cells[i][j]); // Druckt das Zellenzeichen oder ein Leerzeichen
                System.out.print("|"); // Druckt eine vertikale Trennlinie zwischen den Zellen
            }
            System.out.println(); // Zeilenumbruch nach jeder Zeile
        }
        System.out.println("▔▔▔▔▔▔▔"); // Druckt eine untere Rahmenlinie
    }

    public char[][] getCells() { // Methode, die das Spielfeld zurückgibt
        return cells; // Gibt das Array "cells" zurück
    }
}
