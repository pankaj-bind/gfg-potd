class Solution {
    // Function to return a list of integers denoting the node
    // values of both the BST in a sorted order.
    public List<Integer> merge(Node root1, Node root2) {
        List<Integer> list1 = new ArrayList<>();
        List<Integer> list2 = new ArrayList<>();
        
        // Perform in-order traversal of both trees to get the sorted elements
        inorderTraversal(root1, list1);
        inorderTraversal(root2, list2);
        
        // Merge the two sorted lists
        return mergeSortedLists(list1, list2);
    }
    
    // Helper function to perform in-order traversal of a BST and store the elements in a list
    private void inorderTraversal(Node root, List<Integer> list) {
        if (root == null) {
            return;
        }
        inorderTraversal(root.left, list);
        list.add(root.data);
        inorderTraversal(root.right, list);
    }
    
    // Helper function to merge two sorted lists
    private List<Integer> mergeSortedLists(List<Integer> list1, List<Integer> list2) {
        List<Integer> mergedList = new ArrayList<>();
        int i = 0, j = 0;
        
        while (i < list1.size() && j < list2.size()) {
            if (list1.get(i) <= list2.get(j)) {
                mergedList.add(list1.get(i));
                i++;
            } else {
                mergedList.add(list2.get(j));
                j++;
            }
        }
        
        // Add remaining elements from list1, if any
        while (i < list1.size()) {
            mergedList.add(list1.get(i));
            i++;
        }
        
        // Add remaining elements from list2, if any
        while (j < list2.size()) {
            mergedList.add(list2.get(j));
            j++;
        }
        
        return mergedList;
    }
}
