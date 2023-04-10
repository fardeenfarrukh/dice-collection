package dice-collection;

import java.util.Scanner;

/**
 * Main Class
 * @author Syed Fardeen
 */
public class Main {
    /**
     * Main Function
     * @param args
     */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the no. of dice: ");
        int numDice = scanner.nextInt();

        int[] sides = new int[numDice];
        for (int i = 0; i < numDice; i++) {
            System.out.print("Enter the number of sides for die " + (i + 1) + ": ");
            sides[i] = scanner.nextInt();
        }

        DiceCollection diceCollection = new DiceCollection(sides);

        System.out.println(diceCollection);

        while (true) {
            System.out.println("\nSelect an option:");
            System.out.println("1. Roll once");
            System.out.println("2. Roll 100,000 times");
            System.out.println("3. Quit");

            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    diceCollection.rollAll();
                    System.out.println(diceCollection);
                    break;

                case 2:
                    System.out.print("Enter the number of rolls: ");
                    int numRolls = scanner.nextInt();
                    int[] histogram = diceCollection.histogram(numRolls);

                    System.out.println("Histogram of " + numRolls + " rolls:");
                    for (int i = 0; i < histogram.length; i++) {
                        if (histogram[i] != 0) {
                            System.out.println(i + ": " + histogram[i]);
                        }
                    }

                    break;

                case 3:
                    System.exit(0);

                default:
                    System.out.println("Invalid option");
            }
        }
    }
}
