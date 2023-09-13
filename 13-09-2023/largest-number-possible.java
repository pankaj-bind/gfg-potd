class Solution{
    static String findLargest(int N, int S){
        if (N == 1 && S == 0) {
            return "0";
        }

        if (S == 0 || S > 9*N) {
            return "-1";
        }

        StringBuilder result = new StringBuilder();
        while (N > 0) {
            if (S >= 9) {
                result.append('9');
                S -= 9;
            } else {
                result.append(S);
                S = 0;
            }
            N--;
        }

        return result.toString();
    }
}
