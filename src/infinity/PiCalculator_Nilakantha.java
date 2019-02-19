package infinity;

import java.util.Scanner;

public class PiCalculator_Nilakantha {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		System.out.println(
				"This infinite series was created by Nilakantha, an Indian mathematician of the 15th and 16th Centuries."
						+ "\nIt is one of the many infinite series used to calculate pi."
						+ "\nThis series follows the sequence π = 3 + 4/(2*3*4) - 4/(4*5*6) + 4/(6*7*8)..."
						+ "\nBy default, this series has one term: 4/(2*3*4). The 3 is not counted as a term."
						+ "\nChoose how many terms you want in this series. "
						+ "\nThis series is far superior to Gregory-Leibniz as it converges on pi much faster!");

		int iterations = sc.nextInt();
		sc.close();

		double result = piCalc(iterations);
		System.out.println("The value of pi is calculated to be " + result + " using " + iterations
				+ " terms of the series." + "\nFor comparison, this is the value of pi typically used in Java: "
				+ Math.PI + "." + "\nThis value is " + (result - Math.PI) + " off from Java's PI");
	}

	public static double piCalc(int iterations) {
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
