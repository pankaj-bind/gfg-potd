class Solution
{
    public static int sumOfLeafNodes(Node root)
    {
        if(root == null){
            return 0;
        }
        if(root.left== null && root.right==null){
            return root.data;
        }
        return sumOfLeafNodes(root.left)+sumOfLeafNodes(root.right);
    }
}