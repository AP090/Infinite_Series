package series.calculators.pifast;

// The Poor Man's Implementation of the factorial.

// All math is on board, no additional libraries
// are needed. Good enough to compute the factorial
// up to n=10000 in a few seconds.

// ported to Java by JaPNaA

public class FactorialPoorMans {
    public FactorialPoorMans() {
    }

    private long N;

    public String factorialStr(int n) {
        return _factorial(n).toString();
    }

    public double factorial(int n) {
        return _factorial(n).toDouble();
    }

    private DecInteger _factorial(int n) {
        if (n < 0) {
            throw new Error(": n >= 0 required, but was " + n);
        }

        if (n < 2) {
            return new DecInteger(1);
        }

        DecInteger p = new DecInteger(1);
        DecInteger r = new DecInteger(1);

        N = 1;

        int h = 0, shift = 0, high = 1;

        int log2n = (int) Math.floor(Math.log(n) * 1.4426950408889634);

        while (h != n) {
            shift += h;
            h = n >> log2n--;
            int len = high;
            high = (h - 1) | 1;
            len = (high - len) / 2;

            if (len > 0) {
                p = DecInteger.multiply(p, product(len));
                r = DecInteger.multiply(r, p);
            }
        }

        r = DecInteger.multiply(r, DecInteger.pow2(shift));
        return r;
    }

    private DecInteger product(int n) {
        int m = n / 2;
        if (m == 0)
            return new DecInteger(N += 2);
        if (n == 2)
            return new DecInteger((N += 2) * (N += 2));
        return DecInteger.multiply(product(n - m), product(m));
    }
}
