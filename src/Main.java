import Shapes.Circle;
import Shapes.Rectangle;
import Shapes.Shape;
import Shapes.Triangle;

import java.util.Scanner;

public class Main {
    /**
     * Asks the user for input. Input must be a positive double
     */
    public static double getShapeDimensions(Scanner scanner, String inputMessage) {
        System.out.print(inputMessage);

        double value = 0;
        boolean isValidInput = false;

        do {
            if (scanner.hasNextDouble()) {
                value = scanner.nextDouble();
                if (value >= 0) {
                    isValidInput = true;
                } else {
                    System.out.println("Please enter a positive value.");
                }
            } else {
                System.out.println("Invalid input. Please enter a valid float or whole number.");
                if (scanner.hasNext()) {
                    scanner.next(); // Consume invalid input
                }
            }
        } while (!isValidInput);

        return value;
    }

    /**
     * Asks the user for input. Input must be a positive int
     */
    public static int selectUserChoice(Scanner scanner) {
        int value = 0;
        boolean isValidInput = false;

        do {
            if (scanner.hasNextInt()) {
                value = scanner.nextInt();
                if (value >= 0) {
                    isValidInput = true;
                } else {
                    System.out.println("Please enter a positive value.");
                }
            } else {
                System.out.println("Invalid input. Please enter a valid whole number");
                if (scanner.hasNext()) {
                    scanner.next(); // Consume invalid input
                }
            }
        } while (!isValidInput);

        return value;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int choice;
        boolean isExitingProgram = false;

        do {
            Shape selectedShape = null;

            System.out.println("Select a shape to draw");
            System.out.println("1. Circle");
            System.out.println("2. Rectangle");
            System.out.println("3. Triangle");
            System.out.println("4. Exit");

            choice = selectUserChoice(scanner);

            switch (choice) {
                case 1:
                    double radius = getShapeDimensions(scanner, "Enter the radius of the circle: ");
                    selectedShape = new Circle(radius);
                    break;
                case 2:
                    double length = getShapeDimensions(scanner, "Enter the length of the rectangle: ");
                    double width = getShapeDimensions(scanner, "Enter the width of the rectangle: ");
                    selectedShape = new Rectangle(length, width);
                    break;
                case 3:
                    double base = getShapeDimensions(scanner, "Enter the base of the triangle: ");
                    double height = getShapeDimensions(scanner, "Enter the height of the triangle: ");
                    selectedShape = new Triangle(base, height);
                    break;
                case 4:
                    System.out.println("Exiting program. Goodbye!");
                    isExitingProgram = true;
                    break;
                default:
                    System.out.println("Invalid choice. Please select a number between 1-4");
            }

            if (selectedShape != null) {
                System.out.println("\n\nSelected shape: " + selectedShape.getClass().getName());
                System.out.println("Perimeter: " + selectedShape.perimeter());
                System.out.println("Area: " + selectedShape.area());
                selectedShape.draw();
            }

        } while (!isExitingProgram);

        scanner.close();
    }
}


