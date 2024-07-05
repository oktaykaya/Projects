public class pyramid {

    // function to print spaces
    static void printSpace(int space) {
        // base case
        if (space == 0)
            return;
        System.out.print(" ");

        // recursively calling print_space()
        printSpace(space - 1);
    }

    // function to print starIcons
    static void printstarIcon(int starIcon) {
        // base case
        if (starIcon == 0)
            return;
        System.out.print("* ");

        // recursively calling starIcon()
        printstarIcon(starIcon - 1);
    }

    // function to print the pattern
    static void RecusivePrintPyramid(int stars, int height) {
        // base case
        if (stars == 0)
            return;
        printSpace(stars - 1);
        printstarIcon(height - stars + 1);
        System.out.println("");

        // recursively calling pattern()
        RecusivePrintPyramid(stars - 1, height);
    }

    // Driver code
    public static void main(String[] args) {
        int stars = 6;
        RecusivePrintPyramid(stars, stars);
    }
}

