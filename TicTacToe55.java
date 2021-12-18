/**
 *  Java 1. Homework #4
 *
 *  @ author Alex Gavrikov
 *  @ version 18/12/2021
 *
 */
import java.util.Random;
import java.util.Scanner;

class TicTacToe55 {
    final char SIGN_X = 'x';
    final char SIGN_O = 'o';
    final char SIGN_EMPTY = '.';
    char[][]table;
    Random random;
    Scanner sc;

    public static void main(String[]args) {

        new TicTacToe55().game();

    }

    TicTacToe55() {
        table = new char[5][5];
        random = new Random();
        sc = new Scanner(System.in);
    }

    void game() {
        initTable();
        printTable();
        while (true) {
            turnHuman();
            if (isWin(SIGN_X)) {
                System.out.println("YOU WON!");
                break;
            }
            if (isTableFull()) {
                System.out.println("Sorry, DRAW!");
                break;
            }
            turnAI();
            printTable();
            if (isWin(SIGN_O)) {
                System.out.println("AI WON!");
                break;
            }
            if (isTableFull()) {
                System.out.println("Sorry, DRAW!");
                break;
            }
        }
        System.out.println("GAME OVER.");
        printTable();
    }

    void initTable() {
        for (int row = 0; row < table.length; row++)
            for (int col = 0; col < table.length; col++)
                table[row][col] = SIGN_EMPTY;
    }

    void printTable() {
        for (int row = 0; row < table.length; row++) {
            for (int col = 0; col < table.length; col++) {
                System.out.print(table[row][col] + " ");

            }
            System.out.println();
        }

    }

    void turnHuman() {
        int x,
        y;
        do {
            System.out.print("Enter X and Y (1..5):");
            x = sc.nextInt() - 1;
            y = sc.nextInt() - 1;
        } while (!isCellValid(x, y));
        table[y][x] = SIGN_X;
    }

    boolean isCellValid(int x, int y) {
        if (x < 0 || y < 0 || x >= 5 || y >= 5)
            return false;
        return table[y][x] == SIGN_EMPTY;
    }

    void turnAI() {
        int x,
        y;
        do {
            x = random.nextInt(5);
            y = random.nextInt(5);
        } while (!isCellValid(x, y));
        table[y][x] = SIGN_O;
    }

    boolean isWin(char ch) {
        for (int i = 0; i < table.length; i++)
            if ((table[i][0] == ch && table[i][1] == ch && table[i][2] == ch && table[i][3] == ch)
                 || (table[0][i] == ch && table[1][i] == ch && table[2][i] == ch && table[3][i] == ch))
				return true;
		for (int i = table.length-1; i > -1; i--)
            if ((table[i][1] == ch && table[i][2] == ch && table[i][3] == ch && table[i][4] == ch)
                 || (table[1][i] == ch && table[2][i] == ch && table[3][i] == ch && table[4][i] == ch))
				return true;
				
        // 1st diagonal
        if ((table[0][0] == ch && table[1][1] == ch && table[2][2] == ch && table[3][3] == ch)
             || (table[1][1] == ch && table[2][2] == ch && table[3][3] == ch && table[4][4] == ch)
        // 2nd diagonal
             || (table[4][0] == ch && table[3][1] == ch && table[2][2] == ch && table[1][3] == ch)
             || (table[3][1] == ch && table[2][2] == ch && table[1][3] == ch && table[0][4] == ch)
		// 3d diagonal
             || (table[1][0] == ch && table[2][1] == ch && table[3][2] == ch && table[4][3] == ch)
             || (table[0][1] == ch && table[1][2] == ch && table[2][3] == ch && table[3][4] == ch)
		// 4th diagonal
             || (table[3][0] == ch && table[2][1] == ch && table[1][2] == ch && table[0][3] == ch)
             || (table[4][1] == ch && table[3][2] == ch && table[2][3] == ch && table[1][4] == ch)
			 )
            return true;
        return false;
    }

    boolean isTableFull() {
        for (int row = 0; row < table.length; row++)
            for (int col = 0; col < table.length; col++)
                if (table[row][col] == SIGN_EMPTY)
                    return false;
        return true;
    }

}
