class Solution
{
    // Function to find the maximum profit and the number of jobs done.
    int[] JobScheduling(Job arr[], int n)
    {
        // Step 1: Sort the jobs by descending order of profit.
        Arrays.sort(arr, (a, b) -> (b.profit - a.profit));
        
        // Step 2: Initialize the maximum deadline to find the size of the slots array.
        int maxDeadline = 0;
        for (Job job : arr) {
            if (job.deadline > maxDeadline) {
                maxDeadline = job.deadline;
            }
        }
        
        // Step 3: Create a result array to store the slots and a boolean array to keep track of free slots.
        int[] result = new int[maxDeadline + 1];
        boolean[] slot = new boolean[maxDeadline + 1];
        
        // Step 4: Iterate through the sorted jobs and assign them to the available slots.
        int jobCount = 0, maxProfit = 0;
        for (Job job : arr) {
            // Start from the job's deadline and move backwards to find a free slot.
            for (int j = job.deadline; j > 0; j--) {
                if (!slot[j]) {
                    slot[j] = true;
                    result[j] = job.id;
                    jobCount++;
                    maxProfit += job.profit;
                    break;
                }
            }
        }
        
        // Step 5: Return the number of jobs done and the maximum profit.
        return new int[] { jobCount, maxProfit };
    }
}
