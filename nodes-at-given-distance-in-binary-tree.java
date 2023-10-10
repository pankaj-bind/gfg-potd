class Solution
{
    public static ArrayList<Integer> KDistanceNodes(Node root, int target, int k)
    {
        ArrayList<Integer> result = new ArrayList<>();
        findKDistanceNodes(root, target, k, result);
        Collections.sort(result);
        return result;
    }

    private static int findKDistanceNodes(Node root, int target, int k, ArrayList<Integer> result)
    {
        if (root == null)
            return -1;

        if (root.data == target)
        {
            findKDistanceNodesDown(root, k, result);
            return 0;
        }

        int leftDist = findKDistanceNodes(root.left, target, k, result);

        if (leftDist != -1)
        {
            if (leftDist + 1 == k)
                result.add(root.data);
            else
                findKDistanceNodesDown(root.right, k - leftDist - 2, result);

            return 1 + leftDist;
        }

        int rightDist = findKDistanceNodes(root.right, target, k, result);

        if (rightDist != -1)
        {
            if (rightDist + 1 == k)
                result.add(root.data);
            else
                findKDistanceNodesDown(root.left, k - rightDist - 2, result);

            return 1 + rightDist;
        }

        return -1;
    }

    private static void findKDistanceNodesDown(Node root, int k, ArrayList<Integer> result)
    {
        if (root == null || k < 0)
            return;

        if (k == 0)
        {
            result.add(root.data);
            return;
        }

        findKDistanceNodesDown(root.left, k - 1, result);
        findKDistanceNodesDown(root.right, k - 1, result);
    }
}