class Solution {
    int minimumMultiplications(int[] arr, int start, int end) {
        int maxLimit = 100000; 
        
        boolean[] visited = new boolean[maxLimit];
        
        Queue<Integer> queue = new LinkedList<>();
        
        queue.offer(start);
        visited[start] = true;
        
        int steps = 0;
        
        while (!queue.isEmpty()) {
            int size = queue.size();
            
            for (int i = 0; i < size; i++) {
                int currentValue = queue.poll();
                
                if (currentValue == end) {
                    return steps; 
                }
                
                for (int num : arr) {
                    int nextValue = (currentValue * num) % maxLimit;
                    
                    if (!visited[nextValue]) {
                        queue.offer(nextValue);
                        visited[nextValue] = true;
                    }
                }
            }
            
            steps++;
        }
        
        return -1; 
    }
}