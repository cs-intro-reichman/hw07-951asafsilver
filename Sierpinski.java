public class Sierpinski {
    
    public static void main(String[] args) {
        if (args.length > 0) {
            sierpinski(Integer.parseInt(args[0]));
        }
    }
    
    public static void sierpinski(int n) { 
        StdDraw.setCanvasSize(800, 800);
        StdDraw.setXscale(0, 1);
        StdDraw.setYscale(0, 1);
        StdDraw.enableDoubleBuffering();
        StdDraw.clear(StdDraw.WHITE);
        
        double h = Math.sqrt(3) / 2.0;
        
        // ציור המשולש השחור הגדול כצורה מלאה
        StdDraw.setPenColor(StdDraw.BLACK);
        double[] vx = {0, 1, 0.5};
        double[] vy = {0, 0, h};
        StdDraw.filledPolygon(vx, vy);
        
        sierpinski(n, 0, 1, 0.5, 0, 0, h);
        StdDraw.show();
    }
    
    private static void sierpinski(int n, double x1, double x2, double x3,
                                         double y1, double y2, double y3) {
        if (n <= 0) {
            return;
        }

        double x12 = (x1 + x2) / 2.0;
        double y12 = (y1 + y2) / 2.0;
        double x23 = (x2 + x3) / 2.0;
        double y23 = (y2 + y3) / 2.0;
        double x31 = (x3 + x1) / 2.0;
        double y31 = (y3 + y1) / 2.0;

        // ציור המשולש הפנימי כפוליגון לבן מלא
        StdDraw.setPenColor(StdDraw.WHITE);
        double[] midX = {x12, x23, x31};
        double[] midY = {y12, y23, y31};
        StdDraw.filledPolygon(midX, midY);
        
        // חשוב: הצגת השינוי
        StdDraw.show();

        sierpinski(n - 1, x1, x12, x31, y1, y12, y31);
        sierpinski(n - 1, x2, x12, x23, y2, y12, y23);
        sierpinski(n - 1, x3, x23, x31, y3, y23, y31);
    }
}