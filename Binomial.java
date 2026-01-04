public class Binomial {

    // הפונקציה שהטסטר מחפש בשם "binomial"
    public static long binomial(int n, int k) {
        if (k < 0 || k > n) return 0;
        if (k == 0 || k == n) return 1;
        return binomial(n - 1, k - 1) + binomial(n - 1, k);
    }

    // פונקציית ה-Memoization שהטסטר מחפש עבור השאלה השנייה
    public static long memoBinomial(int n, int k) {
        if (k < 0 || k > n) return 0;
        long[][] memo = new long[n + 1][k + 1];
        return memoBinomial(n, k, memo);
    }

    // פונקציית עזר פרטית לחישוב עם הזיכרון
    private static long memoBinomial(int n, int k, long[][] memo) {
        if (k < 0 || k > n) return 0;
        if (k == 0 || k == n) return 1;
        
        if (memo[n][k] != 0) return memo[n][k];
        
        memo[n][k] = memoBinomial(n - 1, k - 1, memo) + memoBinomial(n - 1, k, memo);
        return memo[n][k];
    }

    public static void main(String[] args) {
        if (args.length < 2) return;
        int n = Integer.parseInt(args[0]);
        int k = Integer.parseInt(args[1]);
        System.out.println(memoBinomial(n, k));
    }
}