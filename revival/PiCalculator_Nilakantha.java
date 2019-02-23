package series;

import java.util.Scanner;

public class PiCalculator_Nilakantha {

	static Scanner sc = new Scanner(System.in);

	public static void infoPanelNK() {

		System.out.println(
				"\nThis infinite series was created by Nilakantha, an Indian mathematician of the 15th and 16th Centuries.\n"
						+ "It is one of the many infinite series used to calculate pi.\n\n"
						+ "This series follows the sequence π = 3 + 4/(2*3*4) - 4/(4*5*6) + 4/(6*7*8)...\n"
						+ "This series is far superior to Gregory-Leibniz as it converges on pi much faster!\n\n"
						+ "Choose how many terms of the series you want. By default, 4/(2*3*4) is the first term.");
		long wantedTerms;
		while (true) {
			try {
				wantedTerms = sc.nextLong();
				break;
			} catch (Exception fail) {
				System.out.println("You entered something stupid. Try again.");
				sc.nextLine();
			}
		}
		piCalcNK(wantedTerms);
	}

	public static void piCalcNK(long wantedTerms) {
		double sum = 3;
		double denomA = 2;
		double denomB = 3;
		double denomC = 4;
		for (int i = 1; i <= wantedTerms; i++) {
			if (i % 2 != 0) {
				sum += (4 / (denomA * denomB * denomC));
			} else {
				sum -= (4 / (denomA * denomB * denomC));
			}
			denomA += 2;
			denomB += 2;
			denomC += 2;
		}
		System.out.println("\nThe value of pi is calculated to be " + sum + " using " + wantedTerms
				+ " terms of the series\n.\n" + "For comparison, this is the value of pi typically used in Java: "
				+ Math.PI + ".\n" + "This value is " + (Math.abs(sum - Math.PI)) + " off from Java's pi.");
	}

}
