package infinity.pifast;

class DecInteger {
    private final static long mod = 100000000L;
    private int[] digits;
    private int digitsLength;

    public DecInteger(long value) {
        digits = new int[] {
                //
                (int) value, //
                (int) (value >> 32) //
                //
        };

        digitsLength = 2;
    }

    private DecInteger(int[] digits, int length) {
        this.digits = digits;
        digitsLength = length;
    }

    public static DecInteger pow2(int e) {
        if (e < 31) {
            return new DecInteger((int) Math.pow(2, e));
        }
        return DecInteger.multiply(pow2(e / 2), pow2(e - e / 2));
    }

    public static DecInteger multiply(DecInteger a, DecInteger b) {
        int alen = a.digitsLength, blen = b.digitsLength;
        int clen = alen + blen + 1;
        int[] digits = new int[clen];

        for (int i = 0; i < alen; i++) {
            long temp = 0;

            for (int j = 0; j < blen; j++) {
                temp = temp + ((long) a.digits[i] * (long) b.digits[j]) + digits[i + j];
                digits[i + j] = (int) (temp % mod);
                temp = temp / mod;
            }

            digits[i + blen] = (int) temp;
        }

        int k = clen - 1;
        while (digits[k] == 0)
            k--;

        return new DecInteger(digits, k + 1);
    }

    public double toDouble() {
        return Double.parseDouble(toString()); // how inefficient! (TODO)
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder(digitsLength * 10);

        sb = sb.append(digits[digitsLength - 1]);

        for (int j = digitsLength - 2; j >= 0; j--) {
            sb = sb.append(String.valueOf(digits[j] + (int) mod).substring(1));
        }

        return sb.toString();
    }
}