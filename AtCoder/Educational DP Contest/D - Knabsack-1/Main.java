import java.util.Scanner;

public class Main {
    private static long maxValue(long [][] items, int n, int W) {
        long[] prev = new long[W+1];
        for(int i = 0; i < n; i++) {
            long[] temp = new long[W+1];
            for(int w = 0; w <= W; w++) {
                long[] item = items[i];
                temp[w] = (item[0] <= w) ? Math.max(prev[w], prev[(int)(w-item[0])] + item[1]) : prev[w];
            }
            prev = temp;
        }
        return prev[W];
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(), W = sc.nextInt();
        long[][] items = new long[n][2];
        for(int i = 0; i < n; i++) 
            for(int j = 0; j < 2; j++) 
                items[i][j] = sc.nextLong();
        sc.close();
        System.out.println(maxValue(items, n, W));
    }
}