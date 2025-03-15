package EquationClasses;

import java.util.Scanner;

public class TrigoConverter {

    public  void convert() {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\n===== Math Conversion Menu =====");
            System.out.println("1. Convert between Degrees and Radians");
            System.out.println("2. Convert Polar to Cartesian Coordinates");
            System.out.println("3. Convert Cartesian to Polar Coordinates");
            System.out.println("4. Exit");
            System.out.print("Choose an option: ");

            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    convertAngle(scanner);
                    break;
                case 2:
                    polarToCartesian(scanner);
                    break;
                case 3:
                    cartesianToPolar(scanner);
                    break;
                case 4:
                    System.out.println("Exiting...");
                    scanner.close();
                    return;
                default:
                    System.out.println("Invalid choice. Try again.");
            }
        }
    }


    private static void convertAngle(Scanner scanner) {
        System.out.print("\nEnter angle value: ");
        double angle = scanner.nextDouble();

        System.out.print("Convert to (1) Degrees or (2) Radians? ");
        int type = scanner.nextInt();

        if (type == 1) {
            System.out.printf("Radians to Degrees: %.4f°\n", toDegrees(angle));
        } else if (type == 2) {
            System.out.printf("Degrees to Radians: %.4f rad\n", toRadians(angle));
        } else {
            System.out.println("Invalid choice.");
        }
    }


    private static void polarToCartesian(Scanner scanner) {
        System.out.print("\nEnter radius (r): ");
        double r = scanner.nextDouble();
        System.out.print("Enter angle in degrees: ");
        double theta = scanner.nextDouble();


        double thetaRad = toRadians(theta);


        double x = r * Math.cos(thetaRad);
        double y = r * Math.sin(thetaRad);

        System.out.printf("Cartesian Coordinates: (x = %.4f, y = %.4f)\n", x, y);
    }


    private static void cartesianToPolar(Scanner scanner) {
        System.out.print("\nEnter X coordinate: ");
        double x = scanner.nextDouble();
        System.out.print("Enter Y coordinate: ");
        double y = scanner.nextDouble();


        double r = Math.sqrt(x * x + y * y);

        double theta = toDegrees(Math.atan2(y, x));

        System.out.printf("Polar Coordinates: (r = %.4f, θ = %.4f°)\n", r, theta);
    }


    private static double toDegrees(double radians) {
        return radians * (180.0 / Math.PI);
    }


    private static double toRadians(double degrees) {

        return degrees * (Math.PI / 180.0);

    }
}

