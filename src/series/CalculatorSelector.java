package series;

import java.util.Scanner;

import series.calculators.PiCalculator_GregoryLeibniz;
import series.calculators.PiCalculator_Nilakantha;
import series.calculators.pifast.PiCalculator_PiFast;

enum Series {
    gregoryLeibniz, nilakantha, piFast
};

public class CalculatorSelector {

    private static Scanner sc = new Scanner(System.in);
    final static String options = "  GregoryLeibniz\n  Nilakantha\n  PiFast\n";

    public static void main(String[] args) {

        System.out.println("So, you'd like to calculate the value of pi?\n\n" + "You can choose between:\n" + options
                + "\n" + "The latter series is superior as it uses fewer terms to approximate pi well.\n\n"
                + "Choose your series.");

        Series selectedSeries = getSeries();

        Utils.tryForever(() -> postalService(selectedSeries));
    }

    private static Series getSeries() {
        while (true) {
            System.out.print("series> ");

            String line = sc.nextLine();

            if (line.length() <= 0) {
                line = "\0";
            }

            // (Character.toLowerCase) less efficient, but, less redundant code to write
            // and does it really matter? The user enters input so slowly anyway
            final char firstChar = Character.toLowerCase(line.charAt(0));
            System.out.print("\n");

            switch (firstChar) {
            case 'g':
            case 'l':
            case '1':
                return Series.gregoryLeibniz;
            case 'n':
            case 'k':
            case '2':
                return Series.nilakantha;
            case 'f':
            case 'p':
            case '3':
                return Series.piFast;
            default:
                System.out.println(
                        "Not an option! Try again. (Insert something here to say that your dumb)\nChoose between:\n");
                System.out.println(options);
            }
        }
    }

    private static void postalService(Series chosenSeries) {
        // fields it out to separate packages
        switch (chosenSeries) {
        case gregoryLeibniz:
            PiCalculator_GregoryLeibniz.main();
            break;
        case nilakantha:
            PiCalculator_Nilakantha.main();
            break;
        case piFast:
            PiCalculator_PiFast.main();
            break;
        default:
            throw new Error("Congrats on screwing up. You are the bane of developers everywhere. Please try again.");
        }

    }

}
