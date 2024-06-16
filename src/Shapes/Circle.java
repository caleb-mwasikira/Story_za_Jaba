package Shapes;

public class Circle implements Shape {
    public double radius;

    public Circle(double radius) {
        this.radius = radius;
    }

    @Override
    public double area() {
        return Math.PI * radius * radius;
    }

    @Override
    public double perimeter() {
        return Math.PI * (this.radius * 2);
    }

    @Override
    public void draw() {
        System.out.println("Drawing circle of radius: " + this.radius);
        System.out.println();
    }
}