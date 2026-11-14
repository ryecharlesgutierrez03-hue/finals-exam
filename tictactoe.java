
import java.util.Scanner;

public class TicTacToe {

    static char[] board = {
        '1','2','3',
        '4','5','6',
        '7','8','9'
    };

    static void displayBoard() {
        System.out.println();
        System.out.println(" " + board[0] + " | " + board[1] + " | " + board[2]);
        System.out.println("---+---+---");
        System.out.println(" " + board[3] + " | " + board[4] + " | " + board[5]);
        System.out.println("---+---+---");
        System.out.println(" " + board[6] + " | " + board[7] + " | " + board[8]);
        System.out.println();
    }

    static boolean checkWin(char player) {
        int[][] wins = {
            {0,1,2}, {3,4,5}, {6,7,8},
            {0,3,6}, {1,4,7}, {2,5,8},
            {0,4,8}, {2,4,6}
        };

        for (int[] combination : wins) {
            if (board[combination[0]] == player &&
                board[combination[1]] == player &&
                board[combination[2]] == player) {
                return true;
            }
        }

        return false;
    }

    static boolean isDraw() {
        for (char cell : board) {
            if (cell != 'X' && cell != 'O') {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {

        Scanner qwerty = new Scanner(System.in);
        char currentPlayer = 'X';
        boolean gameOver = false;

        System.out.println("===== TIC-TAC-TOE GAME =====");

        while (!gameOver) {

            displayBoard();

            System.out.print("Player " + currentPlayer +
                             ", choose a position (1-9): ");

            int choice = qwerty.nextInt();

            if (choice < 1 || choice > 9 ||
                board[choice - 1] == 'X' ||
                board[choice - 1] == 'O') {

                System.out.println("Invalid move! Try again.");
                continue;
            }

            board[choice - 1] = currentPlayer;

            if (checkWin(currentPlayer)) {

                displayBoard();
                System.out.println("Player " + currentPlayer + " wins!");
                gameOver = true;

            } else if (isDraw()) {

                displayBoard();
                System.out.println("It's a draw!");
                gameOver = true;

            } else {

                currentPlayer = (currentPlayer == 'X') ? 'O' : 'X';
            }
        }

        System.out.println("Thank you for playing!");
        qwerty.close();
    }
}
