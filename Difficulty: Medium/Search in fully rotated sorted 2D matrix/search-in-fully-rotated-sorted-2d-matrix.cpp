class Solution {
  public:
    bool searchMatrix(vector<vector<int>> &mat, int x) {
        sort(mat.begin(),mat.end());
        
        int m=mat.size(),n=mat[0].size();
        for(auto i=0;i<m;i++){
            sort(mat[i].begin(),mat[i].end());
        }
        for(auto i=0;i<m;i++){
            int start=0,end=n-1;
            while(start<=end){
                int mid=(start+end)/2;
                if(mat[i][mid]==x){
                    return 1;
                }else if(mat[i][mid]>x){
                    end=mid-1;
                }else{
                    start=mid+1;
                }
            }
        }
        return 0;
    }
};
