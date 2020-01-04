/* *****************************************************************************
 *  Name:    Wester J. Aldarondo Torres
 *  NetID:   wester.aldarondo@upr.edu
 *  Precept: P00
 *
 *  Description:  Program that plots a Sierpinski triangle with a recursive
 *  algorithm.
 *
 **************************************************************************** */

public class Sierpinski {
    //  Height of an equilateral triangle whose sides are of the specified length.
    public static double height(double length) {
        double height;
        height = length * (Math.sqrt(3) / 2);
        return height;
    }

    //  Draws a filled equilateral triangle whose bottom vertex is (x, y)
    //  of the specified side length.
    public static void filledTriangle(double x, double y, double length) {
        double[] a = { x, x + length / 2, x - length / 2 };
        double[] b = { y, y + height(length), y + height(length) };
        StdDraw.filledPolygon(a, b);
    }

    //  Draws a Sierpinski triangle of order n, such that the largest filled
    //  triangle has bottom vertex (x, y) and sides of the specified length.
    public static void sierpinski(int n, double x, double y, double length) {
        if (n == 0) return;
        filledTriangle(x, y, length);
        //Draws every left triangle
        sierpinski(n - 1, x - length / 2, y, length / 2);
        //Draws every right triangle
        sierpinski(n - 1, x + length / 2, y, length / 2);
        //Top triangles
        sierpinski(n - 1, x, y + height(length), length / 2);
    }

    //  Takes an integer command-line argument n;
    //  draws the outline of an equilateral triangle (pointed upwards) of length 1;
    //  whose bottom-left vertex is (0, 0) and bottom-right vertex is (1, 0); and
    //  draws a Sierpinski triangle of order n that fits snugly inside the outline.
    public static void main(String[] args) {
        int n = Integer.parseInt(args[0]);
        //Outline of equilateral triangle
        StdDraw.setPenColor(StdDraw.BLACK);
        StdDraw.line(0.0, 0.0, 1.0, 0.0);
        StdDraw.line(0.0, 0.0, 0.5, height(1.0));
        StdDraw.line(0.5, height(1.0), 1.0, 0.0);
        //Starts drawing sierpinski triangle with recursion
        sierpinski(n, 0.5, 0.0, 0.5);
    }
}
