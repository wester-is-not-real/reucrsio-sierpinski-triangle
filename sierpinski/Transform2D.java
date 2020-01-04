/* *****************************************************************************
 *  Name:    Wester J. Aldarondo Torres
 *  NetID:   wester.aldarondo@upr.edu
 *  Precept: P00
 *
 *  Description: This assignment consists of three parts. First, write a library
 *  of static methods that performs geometric transforms on polygons. Next,
 *  write a program that plots a Sierpinski triangle. Finally, develop a program
 *  that plots a recursive pattern of your own design.
 *
 **************************************************************************** */

public class Transform2D {
    // Returns a new array object that is an exact copy of the given array.
    // The given array is not mutated.
    public static double[] copy(double[] array) {
        double[] a = new double[array.length];
        for (int i = 0; i < array.length; i++) {
            a[i] = array[i];
        }
        return a;
    }

    // Scales the polygon by the factor alpha.
    public static void scale(double[] x, double[] y, double alpha) {
        for (int i = 0; i < x.length; i++) {
            x[i] = x[i] * alpha;
            y[i] = y[i] * alpha;
        }
    }

    // Translates the polygon by (dx, dy).
    public static void translate(double[] x, double[] y, double dx, double dy) {
        for (int i = 0; i < x.length; i++) {
            x[i] = x[i] + dx;
            y[i] = y[i] + dy;
        }
    }

    // Rotates the polygon theta degrees counterclockwise, about the origin.
    public static void rotate(double[] x, double[] y, double theta) {
        double radians = Math.toRadians(theta);
        double a, b;
        for (int i = 0; i < x.length; i++) {
            a = (x[i] * Math.cos(radians)) - (y[i] * Math.sin(radians));
            b = (y[i] * Math.cos(radians)) + (x[i] * Math.sin(radians));
            x[i] = a;
            y[i] = b;
        }
    }
}
