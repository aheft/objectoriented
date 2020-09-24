import java.util.*;
import java.io.*;
import java.lang.Math;

public class Euclidean {

    /**
     * Initialize two Point objects with 3 points each; (a1, b1, c1) and (a2, b2, c2)
     * You will need to add Point member variables to the class that you initialize here
     */


    Point p1;
    Point p2;

    public void initPoints(double a1, double b1, double c1, double a2, double b2, double c2) {
        //TODO:
        p1=new Point(a1, b1, c1);
        p2=new Point(a2, b2, c2);
    }

    /**
     * Calclulate the distance between the two Point variables, following the
     * Euclidean distance formula listed in the sample description.
     * The built in Math class will have useful methods for this calculation:
     * https://docs.oracle.com/javase/8/docs/api/java/lang/Math.html
     *
     * @return the distance between the two Points as a double.
     */
    public double calculateDistance() {
        //TODO:
        double a=p1.getx()-p2.getx();
        a=a*a;
        double b=p1.gety()-p2.gety();
        b=b*b;
        double c=p1.getz()-p2.getz();
        c=c*c;
        return Math.sqrt(a+b+c);
    }
}