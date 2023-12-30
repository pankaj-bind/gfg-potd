class Solution {
    // Function to return the name of the candidate that received maximum votes.
    public static String[] winner(String arr[], int n) {
        // Create a HashMap to store the count of each candidate's votes.
        Map<String, Integer> voteCount = new HashMap<>();

        // Traverse the array and update the vote count for each candidate.
        for (String candidate : arr) {
            voteCount.put(candidate, voteCount.getOrDefault(candidate, 0) + 1);
        }

        // Variables to store the winner and maximum vote count.
        String winnerName = "";
        int maxVotes = 0;

        // Traverse the HashMap to find the winner.
        for (Map.Entry<String, Integer> entry : voteCount.entrySet()) {
            String candidate = entry.getKey();
            int votes = entry.getValue();

            // Update the winner if the current candidate has more votes.
            // If there is a tie, choose the lexicographically smaller candidate.
            if (votes > maxVotes || (votes == maxVotes && candidate.compareTo(winnerName) < 0)) {
                winnerName = candidate;
                maxVotes = votes;
            }
        }

        // Return the result as an array of strings.
        return new String[]{winnerName, String.valueOf(maxVotes)};
    }
}