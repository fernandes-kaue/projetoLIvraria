
public class Main {

    public static void main(String[] args) {

        int somaTotal = 0;
        int[][] vetorA = new int[7][7];
        int[][] vetorB = new int[7][7];

        //populating vector a
        for (int i = 0; i < vetorA.length; i++) {
            for (int j = 0; j < vetorA[i].length; j++) {
                vetorA[i][j] = i + j + 1;
            }
        }

        for (int i = 0; i < vetorB.length; i++) {
            for (int j = 0; j < vetorB[i].length; j++) {
                vetorB[i][j] = vetorA[i][j] + i + j;
            }
        }

        //counting the total of the odds indexes
        for (int i = 0; i < vetorA.length; i++) {
            for (int j = 0; j < vetorA[i].length; j++) {
                if ((i == j) && (i % 2 != 0)) {
                    somaTotal += vetorA[i][j];
                }
            }
        }

        for (int i = 0; i < vetorA.length; i++) {
            for (int j = 0; j < vetorA[i].length; j++) {
                System.out.print(vetorA[i][j] + " ");
            }
            System.out.println();
        }

        System.out.println();

        for (int i = 0; i < vetorB.length; i++) {
            for (int j = 0; j < vetorB[i].length; j++) {
                System.out.print(vetorB[i][j] + " ");
            }
            System.out.println();
        }

        System.out.println();

        System.out.println("a soma total das valores das diagonais é igual a: " + somaTotal);


    }


}
