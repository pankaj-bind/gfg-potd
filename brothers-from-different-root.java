class Solution
{
    // Helper function to perform inorder traversal of BST and store values in a list
    private static void inorderTraversal(Node root, List<Integer> list)
    {
        if (root != null)
        {
            inorderTraversal(root.left, list);
            list.add(root.data);
            inorderTraversal(root.right, list);
        }
    }

    // Helper function to perform reverse inorder traversal of BST and store values in a list
    private static void reverseInorderTraversal(Node root, List<Integer> list)
    {
        if (root != null)
        {
            reverseInorderTraversal(root.right, list);
            list.add(root.data);
            reverseInorderTraversal(root.left, list);
        }
    }

    public static int countPairs(Node root1, Node root2, int x)
    {
        // Lists to store inorder and reverse inorder traversals of the BSTs
        List<Integer> list1 = new ArrayList<>();
        List<Integer> list2 = new ArrayList<>();

        // Perform inorder and reverse inorder traversals
        inorderTraversal(root1, list1);
        reverseInorderTraversal(root2, list2);

        // Pointers for traversal
        int i = 0, j = 0;
        int count = 0;

        // Two-pointer approach to find pairs with sum equal to x
        while (i < list1.size() && j < list2.size())
        {
            int sum = list1.get(i) + list2.get(j);

            if (sum == x)
            {
                count++;
                i++;
                j++;
            }
            else if (sum < x)
            {
                i++;
            }
            else
            {
                j++;
            }
        }

        return count;
    }
}
