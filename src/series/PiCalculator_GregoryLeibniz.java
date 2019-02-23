package series;

import java.util.Scanner;

public class PiCalculator_GregoryLeibniz {
	public static void infoPaneGL() {
		Scanner sc = new Scanner(System.in);

		System.out.println(
				"\nThis infinite series is called the Gregory-Leibniz series. It is one of the many infinite series used to calculate pi.\n\n"
						+ "This series follows the sequence π = 4(1 - 1/3 + 1/5 - 1/7...)\n"
						+ "This program calculates within the parentheses first, and then multiplies by four to get pi.\n\n"
						+ "Unfortunately, this series is a poor approximation of pi. It takes over 300 terms to get two accurate decimal places!\n"
						+ "Choose how many terms of the series you want. By default, the -1/3 is the first term.");

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
		
		sc.close();

		double result = piCalcGL(iterations);
		System.out.println(
				"The value of pi is calculated to be " + result + " using " + iterations + " terms of the series."
						+ "\nFor comparison, this is the value of pi typically used in Java: " + Math.PI + "."
						+ "\nThis value is " + (result - Math.PI) + " off from Java's PI");
	}

	public static double piCalcGL(long iterations) {
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


	
