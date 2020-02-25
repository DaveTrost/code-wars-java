package katas;

public class BankerPlan {
    
    public static boolean fortune(int f0, double p, int c0, int n, double i) {
        int years = 0;
        int balance = f0;
        int neededIncome = c0;
        while (balance >= 0 && years < n) {
            balance = (int) (balance * (1 + p / 100) - neededIncome);
            neededIncome = (int) (neededIncome * (1 + i / 100));
            years++;
        }
        System.out.printf("f0=%d p=%f c0=%d n=%d i=%f result=%b\n", f0, p, c0, n, i, years >= n);
        return years >= n;
    }
}