public class iteratorPyramid {

    static void IterativePrintPyramid(int height) {
        int i, j, a = 6;
        for (i = 0; i < a; i++) {
            for (j = a - i; j > 1; j--) {
                System.out.print(" ");
            }
            for (j = 0; j <= i; j++) {
                System.out.print("* ");
            }
            System.out.println();
        }
    }
    public static void main(String args[]) {
        int height = 5;
        IterativePrintPyramid(height);
    }
}
