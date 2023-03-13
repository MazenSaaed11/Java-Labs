package Lab3;
import java.util.Scanner;
import static java.lang.Math.*;

public class Exercise1And2 {
    public static void main(String[] args) {
        Line l = new Line(0,0,4,5);
        l.print();
    }
}
class Vector {
    private double x;
    private double y;

    Vector() {
        this(0.0, 0.0);
    }

    Vector(double x, double y) {
        this.x = x;
        this.y = y;
    }

    double getX() {
        return x;
    }

    double getY() {
        return y;
    }
    void read(){
        Scanner s = new Scanner(System.in);
        System.out.print("Enter the x value: ");
        x = s.nextDouble();
        System.out.print("Enter the y value: ");
        y = s.nextDouble();
    }
    void setX(double x) {
        this.x = x;
    }

    void setY(double y) {
        this.y = y;
    }

    double magnitude() {
        return Math.sqrt(x * x + y * y);
    }

    double angle() {
        return toDegrees(Math.atan(y / x));  // radian
    }

    void print_direc()
    {
        System.out.println(x + "i + " + y + "j");
    }

    void print() {
        System.out.println(x + "i + " + y + "j");
        System.out.println(magnitude() + "[" + angle() + "]");
    }

    static Vector add(Vector v1,Vector v2) {
        return new Vector(v1.x + v2.x, v1.y + v2.y);
    }

    static Vector sub(Vector v1,Vector v2) {
        return new Vector(v1.x - v2.x, v1.y - v2.y);
    }
}
class Line {
    private double x;
    private double y;
    private Vector direc;

    Line(double x, double y, Vector v) {
        this.x = x;
        this.y = y;
        direc = new Vector(v.getX(), v.getY());
    }

    Line(double x1, double y1, double x2, double y2) {
        this.x = x1;
        this.y = y1;
        direc = new Vector((x2 - x1), (y2 - y1));
    }

    Line() {
        this(0, 0, new Vector(0, 0));
    }

    void print() {
        System.out.println("Position is : " + "(" + x + " , " + y + ")");
        System.out.print("Direction is : ");
        direc.print_direc();
    }
}
