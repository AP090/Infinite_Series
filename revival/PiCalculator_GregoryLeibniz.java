package series;

import java.util.Scanner;

public class PiCalculator_GregoryLeibniz {

	static Scanner sc = new Scanner(System.in);

	public static void infoPanelGL() {

		System.out.println(
				"\nThis infinite series is called the Gregory-Leibniz series. It is one of the many infinite series used to calculate pi.\n\n"
						+ "This series follows the sequence π = 4(1 - 1/3 + 1/5 - 1/7...)\n"
						+ "This program calculates within the parentheses first, and then multiplies by four to get pi.\n\n"
						+ "Unfortunately, this series is a poor approximation of pi. It takes over 300 terms to get two accurate decimal places!\n"
						+ "Choose how many terms of the series you want. By default, the -1/3 is the first term.");
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
		piCalcGL(wantedTerms);
	}

	public static void piCalcGL(long wantedTerms) {
		double sum = 1;
		double denom = 3;
		for (int i = 1; i <= wantedTerms; i++) {
			if (i % 2 != 0) {
				sum -= (1 / denom);
			} else {
				sum += (1 / denom);
			}
			denom += 2;
		}
		double piApprox = sum * 4;

		System.out.println("\nThe value of pi is calculated to be " + piApprox + " using " + wantedTerms
				+ " terms of the series.\n\n" + "For comparison, this is the value of pi typically used in Java: "
				+ Math.PI + ".\n" + "This value is " + (Math.abs(piApprox - Math.PI)) + " off from Java's pi.");
	}

}
