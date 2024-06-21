class Solution {

    String compareFrac(String str) {
        // Splitting the input string into two fractions
        String[] fractions = str.split(", ");
        String[] firstFraction = fractions[0].split("/");
        String[] secondFraction = fractions[1].split("/");

        // Parsing the numerators and denominators
        int a = Integer.parseInt(firstFraction[0]);
        int b = Integer.parseInt(firstFraction[1]);
        int c = Integer.parseInt(secondFraction[0]);
        int d = Integer.parseInt(secondFraction[1]);

        // Calculating the decimal values of the fractions
        double firstValue = (double) a / b;
        double secondValue = (double) c / d;

        // Comparing the two values and returning the result
        if (firstValue > secondValue) {
            return fractions[0];
        } else if (secondValue > firstValue) {
            return fractions[1];
        } else {
            return "equal";
        }
    }
}