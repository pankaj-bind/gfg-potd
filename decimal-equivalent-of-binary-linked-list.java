class Solution
{
    long mod = 1000000007;
   long DecimalValue(Node head)
   {
        long ans=0;
 	    for(Node curr=head; curr!=null;  curr=curr.next)
 	       ans = ((ans*2)%mod + curr.data)%mod;

 	   return ans;
   }
   
}