package series.calculators.pifast;

import series.Utils;

public class PiCalculator_PiFast {

    public static void main() {
        Utils.printInfo("This is the fastest algorithm to calculate PI I found on the internet.\n\n"
                + "It is one of the many infinite series used to calculate pi.\n\n"
                + "This series follows the sequence who's terms are too long to list here.\n\n"
                + "Choose how many terms you want in this series. (But don't go too high because Java can't handle it)\n"
                + "This series is far superior than every other algorithm in this repo!");

        long iterations = Utils.getIterations();

        double result = piCalc(iterations);
        Utils.printCalcResults(result, iterations);
    }

    public static double piCalc(long iterations) {
        FactorialPoorMans f = new FactorialPoorMans();
        double sum = 0;

        for (int i = 0; i < iterations; i++) {
            final double nFactorial = f.factorial(i);

            // saving time on repeat calculations
            final int n3 = i * 3;

            // because this is faster than Math.pow(n, 3)
            final double nFactorialCubed = nFactorial * nFactorial * nFactorial;

            sum += ((f.factorial(6 * i) * (545140134 * i + 13591409))
                    / (nFactorialCubed * f.factorial(n3) * Math.pow(-640320, n3)));
        }

        return (426880 * Math.sqrt(10005)) / sum;
    }
}
