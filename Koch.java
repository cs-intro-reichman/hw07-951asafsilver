public class Koch {

    public static void main(String[] args) {
        if (args.length > 0) {
            snowFlake(Integer.parseInt(args[0]));
        }
    }

    public static void curve(int n, double x1, double y1, double x5, double y5) {
        if (n == 0) {
            StdDraw.line(x1, y1, x5, y5);
            return;
        }

        double dx = x5 - x1;
        double dy = y5 - y1;

        double x2 = x1 + dx / 3.0;
        double y2 = y1 + dy / 3.0;

        double x4 = x1 + 2.0 * dx / 3.0;
        double y4 = y1 + 2.0 * dy / 3.0;

        double sin60 = Math.sqrt(3) / 2.0;
        double cos60 = 0.5;
        double x3 = x2 + (dx / 3.0) * cos60 + (dy / 3.0) * sin60;
        double y3 = y2 - (dx / 3.0) * sin60 + (dy / 3.0) * cos60;

        curve(n - 1, x1, y1, x2, y2);
        curve(n - 1, x2, y2, x3, y3);
        curve(n - 1, x3, y3, x4, y4);
        curve(n - 1, x4, y4, x5, y5);
    }

    public static void snowFlake(int n) {
        StdDraw.setYscale(0, 1.1);
        StdDraw.setXscale(0, 1.1);
        StdDraw.enableDoubleBuffering();
        StdDraw.clear();

        double xA = 0.25;
        double yA = 0.25;
        double xB = 0.85;
        double yB = 0.25;
        double xC = 0.55;
        double yC = 0.25 + (0.6 * Math.sqrt(3) / 2.0);

        curve(n, xA, yA, xB, yB);
        curve(n, xB, yB, xC, yC);
        curve(n, xC, yC, xA, yA);

        StdDraw.show();
    }
}