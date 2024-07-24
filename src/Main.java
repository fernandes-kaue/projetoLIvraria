public class Main {

    public static void main(String[] args) {

        int[][] numsA = new int[10][7];
        double totalOdds = 0, finalOddRate = 0, totalEvens = 0, finalEvenRate = 0;

        for (int i = 0; i < numsA.length; i++) {
            for (int j = 0; j < numsA[i].length; j++) {
                numsA[i][j] = i*(j+1);
            }
        }

        for (int[] nums : numsA) {
            for (int num : nums) {
                System.out.print(num + " ");
            }
            System.out.println();
        }

        int totalElements = numsA.length * numsA[0].length;

        for (int[] ints : numsA) {
            for (int anInt : ints) {
                if (anInt % 2 == 0) {
                    totalOdds++;
                } else {
                    totalEvens++;
                }
                finalOddRate = (totalOdds / totalElements) * 100;
                finalEvenRate = (totalEvens / totalElements) * 100;
            }
        }

        System.out.println();

        System.out.println("Total of Odd numbers: " + totalOdds + "\nTotal of Even Numbers: " + totalEvens + "\n");

        System.out.println("Final Odd Rate: " + finalOddRate + "\nFinal Even Rate: " + finalEvenRate);


    }



}
