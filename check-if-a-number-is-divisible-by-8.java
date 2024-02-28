
class Solution{
    int DivisibleByEight(String s){
        //code here
        int num = 0;
        int i = s.length()-3>=0?s.length()-3:0;
        while(i<s.length()){
            num=num*10+(s.charAt(i)-'0');
            i++;
        }
        return num%8==0?1:-1;
    }
}