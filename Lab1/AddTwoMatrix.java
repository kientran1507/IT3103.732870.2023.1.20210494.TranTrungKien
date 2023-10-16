import java.util.Scanner;

public class AddTwoMatrix {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the number of rows: ");
        int rows = scanner.nextInt();

        System.out.print("Enter the number of columns: ");
        int columns = scanner.nextInt();

        int[][] matrix1 = new int[rows][columns];
        int[][] matrix2 = new int[rows][columns];

        System.out.println("Enter the elements of the first matrix:");
        inputMatrix(matrix1, scanner);

        System.out.println("Enter the elements of the second matrix:");
        inputMatrix(matrix2, scanner);

        int[][] sumMatrix = addMatrices(matrix1, matrix2);

        System.out.println("Resultant Matrix:");
        displayMatrix(sumMatrix);

        scanner.close();
    }

    public static void inputMatrix(int[][] matrix, Scanner scanner) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                System.out.print("Element at row " + (i + 1) + ", column " + (j + 1) + ": ");
                matrix[i][j] = scanner.nextInt();
                displayMatrix(matrix);
            }
        }
    }

    public static int[][] addMatrices(int[][] matrix1, int[][] matrix2) {
        int rows = matrix1.length;
        int columns = matrix1[0].length;
        int[][] result = new int[rows][columns];

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                result[i][j] = matrix1[i][j] + matrix2[i][j];
            }
        }

        return result;
    }

    public static void displayMatrix(int[][] matrix) {
        for (int[] row : matrix) {
            for (int element : row) {
                System.out.print(element + " ");
            }
            System.out.println();
        }
    }
}
