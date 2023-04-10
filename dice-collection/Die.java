package assignment4_000906029;

/**
 * Implements Die object
 * @author Syed Fardeen
 */
public class Die {
    private int numberSides;
    private int currentSide;

    public Die(int numberSides) {
        this.numberSides = numberSides;
        roll();
    }

    /**
     * Calculates the number of sides
     * @return number of sides of the object
     */
    public int getNumSides() {
        return numberSides;
    }

    /**
     * Calculates the Current side of the object
     * @return The current side of the object
     */
    public int getCurrentSide() {
        return currentSide;
    }

    /**
     * rolls the dice to get the current side
     */
    public void roll() {
        currentSide = (int) (Math.random() * numberSides) + 1;
    }

    /**
     * toString method for Die
     * @return The number of sides and the number that is currently showing
     */
    public String toString() {
        return "assignment4_000906029.Die with " + numberSides + " sides showing " + currentSide;
    }
}
