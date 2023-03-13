package Lab2;
public class Exercise2 {
    static double averageVectorsMagnitude(Vector[] v) {
        double mag = 0;
        for (Vector vector : v) {
            mag += vector.magnitude();
        }
        return (mag / v.length);
    }
    public static void main(String[] args) {
        Vector[] v = new Vector[5];
        v[0] = new Vector(3, 2);
        v[1] = new Vector(-1, 2);
        v[2] = new Vector(3, 0);
        v[3] = new Vector(9, 12);
        v[4] = new Vector(-4, 23);
        System.out.println(averageVectorsMagnitude(v));
    }

}
