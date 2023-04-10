package assignment4_000906029;

/**
 * Implements DiceCollection object that holds a set of Die objects in an array.
 * The user can roll create an array of dice with multiple sides and can roll all together.
 * @author Syed Fardeen
 */
public class DiceCollection {
    /**
     * Collection of dice array
     */
    private Die[] dice;

    /**
     * DiceCollection contructor that takes in an array of dice sides
     * @param numSidesArray
     */
    public DiceCollection(int[] numSidesArray) {
        dice = new Die[numSidesArray.length];
        for (int i = 0; i < numSidesArray.length; i++) {
            dice[i] = new Die(numSidesArray[i]);
        }
    }

    /**
     * Calculates sum of dice sides with current sides of dice array
     * @return current sum of all current sides of dice array
     */
    public int getCurrentSum() {
        int sum = 0;
        for (Die die : dice) {
            sum += die.getCurrentSide();
        }
        return sum;
    }

    /**
     * Calculates minimum possible sum of current sides of dice array
     * @return minimum possible sum of all sides of dice array
     */
    public int getMinPossibleSum() {
        int sum = 0;
        for (Die die : dice) {
            sum += 1;
        }
        return sum;
    }

    /**
     * Calculates maximum possible sum of current sides of dice array
     * @return maximum possible sum of all sides of dice array
     */
    public int getMaxPossibleSum() {
        int sum = 0;
        for (Die die : dice) {
            sum += die.getNumSides();
        }
        return sum;
    }

    /**
     * Rolls all the die together
     */
    public void rollAll() {
        for (Die die : dice) {
            die.roll();
        }
    }

    /**
     * ToString function for DiceCollection class
     * @return reports all the dice, the minimum possible roll, the
     * maximum possible roll, and the current total showing on the dice
     */
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (Die die : dice) {
            sb.append(die.toString() + "\n");
        }
        sb.append("Minimum possible roll: " + getMinPossibleSum() + "\n");
        sb.append("Maximum possible roll: " + getMaxPossibleSum() + "\n");
        sb.append("Current total showing on the dice: " + getCurrentSum());
        return sb.toString();
    }

    /**
     * Creates a histogram with the multiple rolls in the DiceCollection
     * @param numRolls number of times dice should be rolled
     * @return returns an integer array of counters to keep track
     * of how many times each possible sum gets rolled
     */
    public int[] histogram(int numRolls) {
        int[] counters = new int[getMaxPossibleSum() - getMinPossibleSum() + 1];
        for (int i = 0; i < numRolls; i++) {
            rollAll();
            int sum = getCurrentSum();
            counters[sum - getMinPossibleSum()]++;
        }
        return counters;
    }
}