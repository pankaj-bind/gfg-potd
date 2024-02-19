class Solution{
    static int minValue(String s, int k){
        // code here
        int[] freq = new int[26];
        for(char c : s.toCharArray()){
            freq[c - 'a']++;
        }
        PriorityQueue<Integer> pq = new PriorityQueue<>((a,b) -> b-a);
        
        for(int i=0; i<26; ++i){
            if(freq[i]>0){
                pq.add(freq[i]);
            }
        }
        while(k-- > 0){
            int temp = pq.poll();
            temp--;
            pq.add(temp);
        }
        int sum=0;
        while(!pq.isEmpty()){
            int num = pq.poll();
            sum += (num*num);
        }
        return sum;
    }
}