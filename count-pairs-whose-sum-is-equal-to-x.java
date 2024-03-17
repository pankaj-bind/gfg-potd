class Solution {

    public static int countPairs(LinkedList<Integer> head1, LinkedList<Integer> head2,
                          int x) {
                              
        // add your code here
        Map<Integer, Integer> mp=new HashMap<>();
        for(int i:head1){
            mp.put(i,1);
        }
        int count=0;
        for(int j:head2){
            if(mp.containsKey(x-j)){
                count++;
            }
        }
        return count;
    }
}