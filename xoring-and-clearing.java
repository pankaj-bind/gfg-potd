class Solution {
    public void printArr(int n, int arr[]) {
        for (int i = 0; i < n; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println(); // Print a newline after printing the array
    }

    public void setToZero(int n, int arr[]) {
        for (int i = 0; i < n; i++) {
            arr[i] = 0; // Set each element to zero
        }
    }

    public void xor1ToN(int n, int arr[]) {
        for (int i = 0; i < n; i++) {
            arr[i] ^= i; // Bitwise XOR each element with its index
        }
    }
}
