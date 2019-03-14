package series.calculators;

import series.Utils;

public class PiCalculator_GregoryLeibniz {

	public static void main() {
		Utils.printInfo(
				"This infinite series is called the Gregory-Leibniz series. It is one of the many infinite series used to calculate pi.\n\n"
						+ "This series follows the sequence π = 4(1 - 1/3 + 1/5 - 1/7...)\n"
						+ "This program calculates within the parentheses first, and then multiplies by four to get pi.\n\n"
						+ "Unfortunately, this series is a poor approximation of pi. It takes over 300 terms to get two accurate decimal places!\n"
						+ "Choose how many terms of the series you want. By default, the -1/3 is the first term.");

		long iterations = Utils.getIterations();

		double result = piCalc(iterations);
		Utils.printCalcResults(result, iterations);
	}

	public static double piCalc(long iterations) {
		double sum = 1;
		int denom = 3;

		for (int i = 1; i <= iterations; i++) {
			if (i % 2 == 0) {
				sum += (1f / denom);
			} else {
				sum -= (1f / denom);
			}

			denom += 2;
		}

		return sum * 4;
	}
}
