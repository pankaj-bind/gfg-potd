class Solution
{
    static int isRepresentingBST(int arr[], int N)
    {
        // Traverse the array and check if it is sorted and no two adjacent elements are the same
        for (int i = 0; i < N - 1; i++) {
            if (arr[i] >= arr[i + 1]) {
                return 0; // Not in ascending order
            }
        }
        
        return 1; // It represents an inorder traversal of a BST
    }
}
