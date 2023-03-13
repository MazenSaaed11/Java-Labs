package Lab1;

public class TestCircle {
    public static void main(String[] args) {

        // rectangle with width = 4 and height = 5.5
        double width = 4.0;
        double height = 5.5;
        System.out.println("Area of the rectangle is : " + width * height);
        System.out.println("perimeter of the rectangle is : " + (2 * width + 2 * height));
        System.out.println("_______________________________________________________\n");

        // square with side = 10;
        double side_length = 10.0;
        System.out.println("Area of the square is : " + side_length * side_length);
        System.out.println("perimeter of the square is : " + 4 * side_length);
        System.out.println("_______________________________________________________\n");

        // circle with side = 3.2
        double r = 3.2;
        System.out.println("Area of the circle is : " + Math.PI * r * r);
        System.out.println("perimeter of the circle is : " + 2 * Math.PI * r);
        System.out.println("_______________________________________________________\n");
    }
}

