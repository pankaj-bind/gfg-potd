class Solution 
{
    public Node flattenBST(Node root) 
    {
        if(root==null||(root.left==null&&root.right==null))
        {
            return root;
        }
        Node l=flattenBST(root.left);
        Node r=flattenBST(root.right);
         root.left=null;
         root.right=r;
         if(l==null)return root; 
         else 
         {  
            Node temp=l;
            while(temp.right!=null) temp=temp.right;
            temp.right=root;
            root=l;
            return root;
         }
    }
}