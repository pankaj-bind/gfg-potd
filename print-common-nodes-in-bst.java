class Solution
{
    //Function to find the nodes that are common in both BST.
    public static ArrayList<Integer> findCommon(Node root1, Node root2)
    {
        ArrayList<Integer> result = new ArrayList<>();
        Stack<Node> stack1 = new Stack<>();
        Stack<Node> stack2 = new Stack<>();
        Node current1 = root1;
        Node current2 = root2;
        
        while (current1 != null || !stack1.isEmpty() || current2 != null || !stack2.isEmpty())
        {
            while (current1 != null || current2 != null)
            {
                if (current1 != null)
                {
                    stack1.push(current1);
                    current1 = current1.left;
                }
                
                if (current2 != null)
                {
                    stack2.push(current2);
                    current2 = current2.left;
                }
            }
            
            if (!stack1.isEmpty() && !stack2.isEmpty())
            {
                current1 = stack1.pop();
                current2 = stack2.pop();
                
                if (current1.data == current2.data)
                {
                    result.add(current1.data);
                    current1 = current1.right;
                    current2 = current2.right;
                }
                else if (current1.data < current2.data)
                {
                    current1 = current1.right;
                    stack2.push(current2);
                    current2 = null;
                }
                else
                {
                    current2 = current2.right;
                    stack1.push(current1);
                    current1 = null;
                }
            }
            else
            {
                break;
            }
        }
        
        return result;
    }
}
