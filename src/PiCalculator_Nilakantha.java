package infinity;

import java.util.Scanner;

public class PiCalculator_Nilakantha {

	static Scanner sc = new Scanner(System.in);
	static int wantedTerms, i;
	static double denomA, denomB, denomC, sum, piApprox;

	public static void main(String[] args) {

		System.out.println(
				"This infinite series was created by Nilakantha, an Indian mathematician of the 15th and 16th Centuries."
						+ "\nIt is one of the many infinite series used to calculate pi."
						+ "\nThis series follows the sequence π = 3 + 4/(2*3*4) - 4/(4*5*6) + 4/(6*7*8)..."
						+ "\nBy default, this series has one term: 4/(2*3*4). The 3 is not counted as a term."
						+ "\nChoose how many terms you want in this series. "
						+ "\nThis series is far superior to Gregory-Leibniz as it converges on pi much faster!");
		wantedTerms = sc.nextInt();
		sc.close();
		piCalc(wantedTerms);
	}

	public static void piCalc(int wantedTerms) {
		sum = 3;
		denomA = 2;
		denomB = 3;
		denomC = 4;
		for (i = 1; i <= wantedTerms; i++) {
			if (i % 2 != 0) {
				sum = piCalcAddTerm(sum, denomA, denomB, denomC);
			} else if (i % 2 == 0) {
				sum = piCalcSubTerm(sum, denomA, denomB, denomC);
			} else {
				System.out.print("Something wierd happened.");
				main(new String[0]); // This actually isn't necessary, but it'll annoy Leone, so I'll let it stay
			}
			denomA += 2;
			denomB += 2;
			denomC += 2;
		}
		System.out.println(
				"The value of pi is calculated to be " + sum + " using " + wantedTerms + " terms of the series."
						+ "\nFor comparison, this is the value of pi typically used in Java: " + Math.PI + ".");
	}

	public static double piCalcAddTerm(double sum, double denomA, double denomB, double denomC) {
		return sum = sum + (4 / (denomA * denomB * denomC));
	}

	public static double piCalcSubTerm(double sum, double denomA, double denomB, double denomC) {
		return sum = sum - (4 / (denomA * denomB * denomC));
	}
}
