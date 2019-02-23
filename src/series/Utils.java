package series;

import java.util.Scanner;

public class Utils {
    private static Scanner sc = new Scanner(System.in);

    public static void printInfo(String str) {
        System.out.print("\n");
        System.out.println(str);
    }

    public static long getIterations() {
        long iterations;

        while (true) {
            try {
                iterations = sc.nextLong();
                break;
            } catch (Exception fail) {
                System.out.println("You entered something stupid. Try again.");
                sc.nextLine();
            }
        }

        return iterations;
    }

    public static void printCalcResults(double result, long iterations) {
        System.out.println("The value of pi is calculated to be " + result + " using " + iterations
                + " terms of the series." + "\nFor comparison, this is the value of pi typically used in Java: "
                + Math.PI + "." + "\nThis value is " + Math.abs(result - Math.PI) + " off from Java's PI");
    } 
}