class Solution {
    double power(double b, int e) {
        // If exponent is 0, return 1 as any number to the power of 0 is 1
        if (e == 0) {
            return 1.0;
        }

        // Handle negative exponent by calculating the positive exponent and taking reciprocal
        if (e < 0) {
            b = 1 / b;
            e = -e;
        }

        double result = 1.0;
        while (e > 0) {
            // If exponent is odd, multiply result by b
            if (e % 2 != 0) {
                result *= b;
            }

            // Square the base and halve the exponent
            b *= b;
            e /= 2;
        }

        return result;
    }
}
