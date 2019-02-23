package series;

import java.util.Scanner;

public class PiCalculator_Nilakantha {

	public static void infoPanelNK(String[] args) {
		Scanner sc = new Scanner(System.in);

		System.out.println(
				"\nThis infinite series was created by Nilakantha, an Indian mathematician of the 15th and 16th Centuries.\n"
						+ "It is one of the many infinite series used to calculate pi.\n\n"
						+ "This series follows the sequence π = 3 + 4/(2*3*4) - 4/(4*5*6) + 4/(6*7*8)...\n"
						+ "This series is far superior to Gregory-Leibniz as it converges on pi much faster!\n\n"
						+ "Choose how many terms of the series you want. By default, 4/(2*3*4) is the first term.");

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

		double result = piCalcNK(iterations);
		System.out.println("The value of pi is calculated to be " + result + " using " + iterations
				+ " terms of the series." + "\nFor comparison, this is the value of pi typically used in Java: "
				+ Math.PI + "." + "\nThis value is " + (result - Math.PI) + " off from Java's PI");
	}

	public static double piCalcNK(long iterations) {
		double sum = 3;

		for (int i = 1; i <= iterations; i++) {
			final double denom = i * 2;

			if (i % 2 == 0) {
				sum -= (4 / (denom * (denom + 1) * (denom + 2)));
			} else {
				sum += (4 / (denom * (denom + 1) * (denom + 2)));
			}
		}

		return sum;
	}
}
