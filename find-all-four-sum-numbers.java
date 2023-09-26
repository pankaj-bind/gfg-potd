class Solution {
    public ArrayList<ArrayList<Integer>> fourSum(int[] arr, int k) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        int n = arr.length;
        Arrays.sort(arr);
        
        for (int i = 0; i < n-3; i++) {
            if (i > 0 && arr[i] == arr[i-1]) continue;
            
            for (int j = i+1; j < n-2; j++) {
                if (j > i+1 && arr[j] == arr[j-1]) continue;
                
                int left = j+1;
                int right = n-1;
                
                while (left < right) {
                    int sum = arr[i] + arr[j] + arr[left] + arr[right];
                    if (sum == k) {
                        ArrayList<Integer> quadruple = new ArrayList<>();
                        quadruple.add(arr[i]);
                        quadruple.add(arr[j]);
                        quadruple.add(arr[left]);
                        quadruple.add(arr[right]);
                        result.add(quadruple);
                        
                        while (left < right && arr[left] == arr[left+1]) left++;
                        while (left < right && arr[right] == arr[right-1]) right--;
                        left++;
                        right--;
                    } else if (sum < k) {
                        left++;
                    } else {
                        right--;
                    }
                }
            }
        }
        
        return result;
    }
}