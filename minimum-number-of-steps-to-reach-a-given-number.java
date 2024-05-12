class Solution {
    static int minSteps(int d) {
        int steps = 0;
        int sum = 0;

        // We'll keep adding the steps until the sum becomes greater than or equal to d.
        // We need to handle both even and odd cases separately.
        while (true) {
            steps++;
            sum += steps;

            // If the sum reaches or exceeds d, we break the loop.
            if (sum >= d)
                break;
        }

        // If the sum exactly matches d, we return the current number of steps.
        if (sum == d)
            return steps;

        // If the sum exceeds d, we need to adjust the number of steps.
        // If the difference between sum and d is even, then we need to add an extra step.
        // If the difference between sum and d is odd, then we need to add an extra step if the number of steps is even.
        // Otherwise, no extra step is required.
        if ((sum - d) % 2 == 0)
            return steps;
        else
            return steps % 2 == 0 ? steps + 1 : steps + 2;
    }
}
