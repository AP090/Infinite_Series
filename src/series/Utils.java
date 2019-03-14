package series;

import java.util.Scanner;

public class Utils {
    private static Scanner sc = new Scanner(System.in);

    private static String infoSeperatorString = "\n----------- INFO --------------------------------------------\n";
    private static String seperatorString = "\n-------------------------------------------------------------\n";
    private static String longIterationsInputRequestString = "long iterations> ";

    public static void printInfo(String str) {
        System.out.print(infoSeperatorString);
        System.out.print(str);
        System.out.println(seperatorString);
    }

    public static long getIterations() {
        long iterations;

        while (true) {
            try {
                System.out.print(longIterationsInputRequestString);
                iterations = sc.nextLong();
                System.out.print("\n");
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

    public static void tryForever(Runnable cb) {
        while (true) {
            try {
                cb.run();
                break;
            } catch (Exception err) {
                System.err.println(err.getMessage());
            }
        }
    }
}