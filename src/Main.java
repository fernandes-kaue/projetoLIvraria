public class Main {

    public static void main(String[] args) {

        /* matriz a 7x7
        * matriz b = valor do elemento correspondente em a + seus indices
        * exceto quando os indices da diagonal principal forem impares, neste caso, b = a!
        * */

        int[][] vetorA = new int[7][7];
        int[][] vetorB = new int[7][7];

        // Populating vetorA
        for (int i = 0; i < vetorA.length; i++) {
            for (int j = 0; j < vetorA[i].length; j++) {
                vetorA[i][j] = i + j + 1;
            }
        }

        // Populating vetorB
        for (int i = 0; i < vetorB.length; i++) {
            for (int j = 0; j < vetorB[i].length; j++) {
                if (i == j && i % 2 != 0) {
                    vetorB[i][j] = (int) factorial(vetorA[i][j]); // Set factorial for diagonal
                } else {
                    vetorB[i][j] = vetorA[i][j] + i + j; // Regular case
                }
            }
        }

        // Print vetorA and vetorB side by side
        System.out.println("Matrix A and Matrix B:");
        for (int i = 0; i < vetorA.length; i++) {
            for (int j = 0; j < vetorA[i].length; j++) {
                System.out.print(vetorA[i][j] + " ");
            }
            System.out.print("   "); // Spacer between matrices
            for (int j = 0; j < vetorB[i].length; j++) {
                System.out.print(vetorB[i][j] + " ");
            }
            System.out.println();
        }

    }

    // Method to calculate factorial
    public static long factorial(int n) {
        if (n < 0) {
            throw new IllegalArgumentException("Factorial is not defined for negative numbers");
        }
        long result = 1;
        for (int i = 1; i <= n; i++) {
            result *= i;
        }
        return result;
    }

}
