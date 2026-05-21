import java.util.Scanner;

public class VeggieNutritionTracker {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("How many vegetables to analyze? ");
        int count = scanner.nextInt();
        scanner.nextLine();

        String[] names = new String[count];
        double[] fibers = new double[count];

        for (int i = 0; i < count; i++) {
            System.out.print("Veggie name: ");
            names[i] = scanner.nextLine();
            System.out.print("Fiber content (g): ");
            fibers[i] = scanner.nextDouble();
            scanner.nextLine();
        }

        System.out.println("\n--- Analysis Report ---");
        for (int i = 0; i < count; i++) {
            String category = getFiberCategory(fibers[i]);
            System.out.println(names[i].toUpperCase() + ": " + category);
        }

        scanner.close();
    }

    public static String getFiberCategory(double fiber) {
        return switch ((int) fiber / 3) {
            case 0 -> "Low Fiber";
            case 1 -> "Good Fiber Source";
            default -> "High Fiber Superfood";
        };
    }
}
