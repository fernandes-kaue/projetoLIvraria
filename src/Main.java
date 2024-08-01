import java.util.Scanner;

public class MatrixMultiplication {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int linhas1, colunas1, linhas2, colunas2;

        while (true) {
            System.out.println("Digite o número de linhas da primeira matriz (máximo 10):");
            linhas1 = sc.nextInt();
            System.out.println("Digite o número de colunas da primeira matriz (máximo 10):");
            colunas1 = sc.nextInt();
            System.out.println("Digite o número de linhas da segunda matriz (máximo 10):");
            linhas2 = sc.nextInt();
            System.out.println("Digite o número de colunas da segunda matriz (máximo 10):");
            colunas2 = sc.nextInt();

            if (linhas1 > 10 || colunas1 > 10 || linhas2 > 10 || colunas2 > 10) {
                System.out.println("Tamanho máximo para linhas e colunas é 10. Tente novamente.");
                continue;
            }

            if (colunas1 != linhas2) {
                System.out.println("O número de colunas da primeira matriz deve ser igual ao número de linhas da segunda matriz para a multiplicação. Tente novamente.");
                continue;
            }
            break;
        }

        int[][] matrix1 = new int[linhas1][colunas1];
        int[][] matrix2 = new int[linhas2][colunas2];

        System.out.println("Digite os elementos da primeira matriz:");
        for (int i = 0; i < linhas1; i++) {
            for (int j = 0; j < colunas1; j++) {
                matrix1[i] = sc.nextInt();
            }
        }

        System.out.println("Digite os elementos da segunda matriz:");
        for (int i = 0; i < linhas2; i++) {
            for (int j = 0; j < colunas2; j++) {
                matrix2[i][j] = sc.nextInt();
            }
        }

        int[][] result = multiplyMatrices(matrix1, matrix2, linhas1, colunas1, colunas2);

        System.out.println("O resultado da multiplicação das matrizes é:");
        for (int i = 0; i < linhas1; i++) {
            for (int j = 0; j < colunas2; j++) {
                System.out.print(result[i][j] + " ");
            }
            System.out.println();
        }

        sc.close();
    }

    public static int[][] multiplyMatrices(int[][] matrix1, int[][] matrix2, int rows1, int cols1, int cols2) {
        int[][] result = new int[rows1][cols2];

        for (int i = 0; i < rows1; i++) {
            for (int j = 0; j < cols2; j++) {
                for (int k = 0; k < cols1; k++) {
                    result[i][j] += matrix1[i][k] * matrix2[k][j];
                }
            }
        }

        return result;
    }
}