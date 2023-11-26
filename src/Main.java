import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int choice;

        do {
            System.out.println("Select a shape to draw:");
            System.out.println("1. Circle");
            System.out.println("2. Rectangle");
            System.out.println("3. Triangle");
            System.out.println("4. Exit");

            System.out.print("Enter your choice (1-4): ");
            choice = scanner.nextInt();

            switch (choice) {
                case 1 -> drawCircle(scanner);
                case 2 -> drawRectangle(scanner);
                case 3 -> drawTriangle(scanner);
                case 4 -> System.out.println("Exiting program. Goodbye!");
                default -> System.out.println("Invalid choice. Please choose a valid option (1-4).");
            }
        } while (choice != 4);

        scanner.close();
    }

    public static void drawCircle(Scanner scanner) {
        System.out.print("Enter the radius of the circle: ");
        double radius = getUserInput(scanner);

        double perimeter = Math.PI * (2 * radius);
        double area = Math.PI * Math.pow(radius, 2);
        System.out.println("Drawing a circle with radius " + radius + " has an area of " + area + " and a perimeter of " + perimeter);

        for (int i = 0; i <= 2 * radius; i++) {
            for (int j = 0; j <= 2 * radius; j++) {
                double distance = Math.sqrt(Math.pow(i - radius, 2) + Math.pow(j - radius, 2));

                if (distance < radius + 0.5) {
                    System.out.print("*");
                } else {
                    System.out.print(" ");
                }
            }
            System.out.println();
        }
    }

    public static void drawRectangle(Scanner scanner) {
        System.out.print("Enter the length of the rectangle: ");
        double length = getUserInput(scanner);
        System.out.print("Enter the width of the rectangle: ");
        double width = getUserInput(scanner);

        double area = length * width;
        double perimeter = 2 * (length + width);
        System.out.println("Drawing a rectangle with length " + length + ", width " + width + " has an area of " + area + " and a perimeter of " + perimeter);

        for (int i = 0; i < width; i++) {
            for (int j = 0; j < length; j++) {
                System.out.print("*");
            }
            System.out.println();
        }
    }

    public static void drawTriangle(Scanner scanner) {
        System.out.print("Enter the base of the triangle: ");
        double base = getUserInput(scanner);
        System.out.print("Enter the height of the triangle: ");
        double height = getUserInput(scanner);

        double area = 0.5 * base * height;

        // To calculate the perimeter of a triangle we get its hypotenuse
        // using the Pythagoras theorem a^2 + b^2 = c^2
        double hypotenuse = Math.sqrt(Math.pow(base, 2) + Math.pow(height, 2));
        double perimeter = base + height + hypotenuse;
        System.out.println("Drawing a triangle with base " + base + ", height " + height + " has an area of " + area + " and a perimeter of " + perimeter);

        for (int i = 1; i <= height; i++) {
            for (int j = 1; j <= height - i; j++) {
                System.out.print(" ");
            }
            for (int j = 1; j <= 2 * i - 1; j++) {
                System.out.print("*");
            }
            System.out.println();
        }
    }

    /**
     * Asks the user for input. Input must be a positive double
     *
     */
    public static double getUserInput(Scanner scanner) {
        double value = 0;
        boolean isValidInput = false;

        do {
            if (scanner.hasNextDouble()) {
                value = scanner.nextDouble();
                if (value > 0) {
                    isValidInput = true;
                } else {
                    System.out.println("Please enter a positive value.");
                }
            } else {
                System.out.println("Invalid input. Please enter a valid positive number.");
                scanner.next(); // Consume invalid input
            }
        } while (!isValidInput);

        return value;
    }
}


