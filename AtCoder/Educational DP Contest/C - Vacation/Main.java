import java.util.Scanner;

public class Main {
    private static int findMaxHappiness(int[][] matrix, int n) {
        int[] prev = new int[3], temp = new int[3];
        System.arraycopy(matrix[0], 0, prev, 0, 3);
        for(int i = 1; i < n; i++) {
            for(int j = 0; j < 3; j++) {
                int max = 0;
                for(int j1 = 0; j1 < 3; j1++) {
                    if(j == j1)
                        continue;
                    max = Math.max(max, prev[j1]);
                }
                temp[j] = matrix[i][j] + max;
            }
            System.arraycopy(temp, 0, prev, 0, 3);
        }
        int max = 0;
        for(int i = 0; i < 3; i++)
            max = Math.max(max, prev[i]);
        return max;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[][] matrix = new int[n][3];
        for(int i = 0; i < n; i++) 
            for(int j = 0; j < 3; j++) 
                matrix[i][j] = sc.nextInt();
        sc.close();
        System.out.println(findMaxHappiness(matrix, n));
    }
}