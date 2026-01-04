public class Binomial {

    // אפשרות 1: השם binomial
    public static long binomial(int n, int k) {
        return memoBinomial(n, k);
    }

    // אפשרות 2: השם binomial1 (שהופיע בשגיאה האחרונה שלך)
    public static long binomial1(int n, int k) {
        return memoBinomial(n, k);
    }

    // הפונקציה שמבצעת את החישוב המהיר עם הזיכרון (Memoization)
    public static long memoBinomial(int n, int k) {
        if (k < 0 || k > n) return 0;
        long[][] memo = new long[n + 1][k + 1];
        return memoBinomial(n, k, memo);
    }

    // פונקציית העזר הפרטית
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