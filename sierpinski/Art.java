/* *****************************************************************************
 *  Name:    Wester J. Aldarondo Torres
 *  NetID:   wester.aldarondo@upr.edu
 *  Precept: P00
 *
 *  Description:  Program that plots a recursive pattern of my own design.
 *
 **************************************************************************** */

public class Art {
    private static double height(double sz) {
        double height = (sz / 2 * (Math.sqrt(3) / 2)) + sz;
        return height;
    }

    private static void fractal(int n, int deg, double x, double y, double sz) {
        if (n == 0) return;
        draw(x, y, sz, deg);
        fractal(n - 1, deg - 20, x + sz / 2, y, sz / 2);
        fractal(n - 1, deg + 20, x - sz / 4, y, sz / 2);
    }

    private static void draw(double x, double y, double sz, int deg) {
        int random = StdRandom.uniform(2);
        if (random == 0) StdDraw.setPenColor(StdDraw.GREEN);
        else StdDraw.setPenColor(StdDraw.GRAY);
        double[] a = { x, x, x + sz / 4, x + sz / 2, x + sz / 2 };
        double[] b = { y, y + sz, y + height(sz), y + sz, y };
        StdDraw.filledPolygon(a, b);
    }

    public static void main(String[] args) {
        int n = Integer.parseInt(args[0]), deg = 0;
        double x = 0.0, y = 0.0, sz = 1.0;
        StdDraw.setXscale(-2.0, 2.0);
        StdDraw.setYscale(-2.0, 2.0);
        fractal(n, deg, x, y, sz);
    }
}
