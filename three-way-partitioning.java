class Solution{
    //Function to partition the array around the range such 
    //that array is divided into three parts.
    public void threeWayPartition(int array[], int a, int b)
    {
        int n = array.length;
        int low = 0, mid = 0, high = n - 1;
        
        while (mid <= high) {
            if (array[mid] < a) {
                swap(array, low, mid);
                low++;
                mid++;
            } else if (array[mid] >= a && array[mid] <= b) {
                mid++;
            } else {
                swap(array, mid, high);
                high--;
            }
        }
    }
    
    //Function to swap two elements of an array.
    private void swap(int[] array, int i, int j) {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }
}
