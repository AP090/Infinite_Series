package series;

import java.util.Scanner;

import series.calculators.PiCalculator_GregoryLeibniz;
import series.calculators.PiCalculator_Nilakantha;
import series.calculators.pifast.PiCalculator_PiFast;

public class Sorting {

    static int chosenSeries;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("So, you'd like to calculate the value of pi?\n\n"
                + "You can use the Gregory-Leibniz series (option 1) or the Nilakantha series (option 2).\n"
                + "The latter series is superior as it uses fewer terms to approximate pi well.\n\n"
                + "Choose your series.");

        while (true) {
            try {
                chosenSeries = sc.nextInt();
                postalService(chosenSeries);
                break;
            } catch (Exception fail) {
                System.out.println("Something went wrong. Inputs have been reset and you must try again.");
                sc.nextLine();
            }
        }

        sc.close();
    }

    public static void postalService(int chosenSeries) throws Exception {
        // fields it out to separate packages
        switch (chosenSeries) {
        case 1:
            PiCalculator_GregoryLeibniz.main();
            break;
        case 2:
            PiCalculator_Nilakantha.main();
            break;
        case 3:
            PiCalculator_PiFast.main();
            break;
        default:
            throw new Exception(
                    "Congrats on screwing up. You are the bane of developers everywhere. Please try again.");
        }

    }

}
