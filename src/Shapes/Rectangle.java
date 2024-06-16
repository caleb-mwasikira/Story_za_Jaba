package  Shapes;

public class Rectangle implements Shape {
    public double length;
    public double width;

    public Rectangle(double length, double width) {
        this.length = length;
        this.width = width;
    }

    @Override
    public double area() {
        return this.length * this.width;
    }

    @Override
    public double perimeter() {
        return 2 * (this.length + this.width);
    }

    @Override
    public void draw() {
        System.out.println("Drawing a rectangle of length " + this.length + ", width " + this.width);

        for (int i = 0; i < this.width; i++) {
            for (int j = 0; j < this.length; j++) {
                System.out.print("*");
            }
            System.out.println();
        }

        System.out.println();
    }
}
