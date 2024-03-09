class Solution
{
    public char nthCharacter(String s, int r, int n)
    {
        //code here
        StringBuilder temp = new StringBuilder();
        while(r!=0){
            for(int i=0;i<s.length();i++){
                if(s.charAt(i)=='1')temp.append("10");
                else temp.append("01");
                if(temp.length()>n)break;
            }
            s=temp.toString();
            temp.setLength(0);
            r--;
        }
        return s.charAt(n);
    }
}