package Shapes;

public class Triangle implements Shape {
    public double base;
    public double height;
    public double hypotenuse;

    public Triangle(double base, double height) {
        this.base = base;
        this.height = height;

        // Use Pythagoras theorem a^2 + b^2 = c^2 to get hypotenuse of triangle
        this.hypotenuse = Math.sqrt(Math.pow(base, 2) + Math.pow(height, 2));
    }


    @Override
    public double area() {
        return 0.5 * this.base * this.height;
    }

    @Override
    public double perimeter() {
        return this.base + this.height + this.hypotenuse;
    }

    @Override
    public void draw() {
        System.out.println("Drawing a triangle with base " + this.base + ", height " + this.height);

        for (int i = 1; i <= height; i++) {
            for (int j = 1; j <= height - i; j++) {
                System.out.print(" ");
            }
            for (int j = 1; j <= 2 * i - 1; j++) {
                System.out.print("*");
            }
            System.out.println();
        }

        System.out.println("\n\n");
    }
}
