package infinity;

import java.util.Scanner;

public class PiCalculator_GregoryLeibniz {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		System.out.println(
				"This infinite series is called the Gregory-Leibniz series. It is one of the many infinite series used to calculate pi."
						+ "\nThis series follows the sequence π = 4(1 - 1/3 + 1/5 - 1/7...)"
						+ "\nThis program calculates within the parentheses first, and then multiplies by four to get pi."
						+ "\nBy default, this series has one term: -1/3. The 1 is not counted as a term."
						+ "\nChoose how many terms you want in this series. Unfortunately, this series converges slowly. "
						+ "\nIt takes 300 terms to calculate pi to two decimal places, so pick a large number!");

		int iterations = sc.nextInt();
		sc.close();

		double result = piCalc(iterations);
		System.out.println(
				"The value of pi is calculated to be " + result + " using " + iterations + " terms of the series."
						+ "\nFor comparison, this is the value of pi typically used in Java: " + Math.PI + ".");
	}

	public static double piCalc(int iterations) {
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
