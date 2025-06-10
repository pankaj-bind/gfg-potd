class Solution {
  public:
    int countStrings(string &s) {
        int n = s.size();
        int ans = n*(n-1)/2;
        vector<int> freq(26, 0);
        for(auto z : s){
            freq[z-97]++;
        }
        bool flag = false;
        for(int i=0;i<26;i++){
            if(freq[i]>1){
                flag = true;
                ans = ans - ((freq[i]*(freq[i]-1))/2);
            }
        }
        return flag==0?ans:ans+1;
    }
};

