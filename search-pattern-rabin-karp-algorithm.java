class Solution
{
    
    ArrayList<Integer> search(String pattern, String text)
    {
        // your code here
       StringBuilder s=new StringBuilder(text);
       ArrayList<Integer> a=new ArrayList<>();
       int ans=0;
       int co=0;
       while(ans!=-1)
       {
           ans=s.indexOf(pattern,ans);
           if(ans!=-1)
           {
               a.add(ans+co+1);
               s.deleteCharAt(ans);
               co++;
           }


       }

        return a;
    }
}