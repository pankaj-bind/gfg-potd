class Solution {
    public static int floor(Node root, int x) {
        int floorValue = -1; // Initialize the floor value to -1
        
        while (root != null) {
            if (root.data == x) {
                return x; // Found an exact match, return x as the floor value
            } else if (root.data < x) {
                floorValue = root.data; // Update the floor value
                root = root.right; // Move to the right subtree
            } else {
                root = root.left; // Move to the left subtree
            }
        }
        
        return floorValue;
    }
}
