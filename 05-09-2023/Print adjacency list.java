class Solution {
    public List<List<Integer>> printGraph(int V, int edges[][]) {
        List<List<Integer>> al = new  ArrayList<>();
              for( int i =0 ; i<V;i++)
              {
                  al.add(new ArrayList<Integer>());
              }
            for( int i =0 ; i<edges.length;i++)
            {
               al.get(edges[i][0]).add(edges[i][1]);
               al.get(edges[i][1]).add(edges[i][0]);
            }
            // al=adj;
            return al;
    }
}