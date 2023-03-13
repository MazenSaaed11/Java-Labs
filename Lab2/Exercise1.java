package Lab2;

public class Exercise1 {
    public static void main(String[] args) {
        Vector v = new Vector();
        v.print();
        System.out.print("\n________________________________________________\n");

        Vector v1 = new Vector(2, 4);
        v1.print();
        System.out.print("\n________________________________________________\n");

        Vector v2 = new Vector();
        v2.setX(-4);
        v2.setY(1);
        System.out.println("x is : " + v2.getX() + " y is : " + v2.getY());
        System.out.print("\n________________________________________________\n");

        Vector v3 = new Vector();
        System.out.println(v3.magnitude() + "[" + v3.angle() + "]");
        System.out.print("\n________________________________________________\n");

        v3 = v1.add(v2);
        v3.print();
        System.out.print("\n________________________________________________\n");

        v3 = v1.sub(v2);
        v3.print();
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
        return Math.toDegrees(Math.atan(y / x));  // radian
    }

    void print() {
        System.out.println(x + "i + " + y + "j");
        System.out.println(magnitude() + "[" + angle() + "]");
    }

    Vector add(Vector v) {
        return new Vector(v.x + x, v.y + y);
    }

    Vector sub(Vector v) {
        return new Vector(x - v.x, y - v.y);
    }
}
