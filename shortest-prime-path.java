class Solution {
    boolean isPrime(int num) {
        if (num <= 1) return false;
        for (int i = 2; i * i <= num; i++) {
            if (num % i == 0) return false;
        }
        return true;
    }

    int solve(int Num1, int Num2) {
        if (Num1 == Num2) return 0;

        Queue<Integer> queue = new LinkedList<>();
        Set<Integer> visited = new HashSet<>();

        queue.offer(Num1);
        visited.add(Num1);

        int steps = 0;

        while (!queue.isEmpty()) {
            int size = queue.size();

            for (int i = 0; i < size; i++) {
                int current = queue.poll();

                for (int j = 0; j < 4; j++) {
                    for (int k = 0; k <= 9; k++) {
                        if (j == 0 && k == 0) continue;

                        int newNum = getNewNumber(current, j, k);

                        if (newNum == Num2) return steps + 1;

                        if (isPrime(newNum) && !visited.contains(newNum)) {
                            queue.offer(newNum);
                            visited.add(newNum);
                        }
                    }
                }
            }

            steps++;
        }

        return -1; // If Num2 is not reachable from Num1
    }

    int getNewNumber(int num, int position, int digit) {
        int[] digits = new int[4];
        int temp = num;

        for (int i = 3; i >= 0; i--) {
            digits[i] = temp % 10;
            temp /= 10;
        }

        digits[position] = digit;

        int newNum = 1000 * digits[0] + 100 * digits[1] + 10 * digits[2] + digits[3];
        return newNum;
    }
}