import java.util.Scanner;

public class FireTheArrows {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Integer n = Integer.parseInt(scanner.nextLine());

        Character[][] matrix = new Character[n][];

        for (int i = 0; i < n; i++) {
             char[] currentLine = scanner.nextLine().toCharArray();
            matrix[i] = new Character[currentLine.length];
            for (int j = 0; j < currentLine.length; j++) {
                char c = currentLine[j];
                matrix[i][j] = c;
            }
        }

        boolean hasMovedArrows = false;

        do {
            hasMovedArrows = arrowsMoved(matrix);
        }while (hasMovedArrows);

        printMatrix(matrix);
    }

    private static void printMatrix(Character[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                System.out.print(matrix[i][j]);
            }
            System.out.println();
        }
    }

    private static boolean arrowsMoved(Character[][] matrix) {
        boolean moved = false;

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
               switch (matrix[i][j]) {
                   case 'o':
                       break;
                   case '<':
                       if ((j - 1) >= 0) {
                           if (matrix[i][j-1] == 'o') {
                               matrix[i][j - 1] = '<';
                               matrix[i][j] = 'o';
                               moved = true;
                           }
                       }
                       break;
                   case '>':
                       if ((j + 1) < matrix[i].length) {
                           if (matrix[i][j+1] == 'o') {
                               matrix[i][j + 1] = '>';
                               matrix[i][j] = 'o';
                               moved = true;
                           }
                       }
                       break;
                   case '^':
                       if ((i - 1) >= 0) {
                           if (matrix[i-1][j] == 'o') {
                               matrix[i - 1][j] = '^';
                               matrix[i][j] = 'o';
                               moved = true;
                           }
                       }
                       break;
                   case 'v':
                       if ((i + 1) < matrix.length) {
                           if (matrix[i+1][j] == 'o') {
                               matrix[i + 1][j] = 'v';
                               matrix[i][j] = 'o';
                               moved = true;
                           }
                       }
                       break;
               }
            }
        }
        return moved;
    }
}
