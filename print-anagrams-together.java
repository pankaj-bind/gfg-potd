public ArrayList<ArrayList<String>> anagrams(String[] arr) {
        // code here
        ArrayList<ArrayList<String>> ans = new ArrayList<>();
        HashMap<String,ArrayList<String>> mm = new HashMap<>();
        for(String x:arr)
        {
            char[] temp = x.toCharArray();
            Arrays.sort(temp);
            String str = new String(temp);
            mm.putIfAbsent(str,new ArrayList<>());
            mm.get(str).add(x);
        }
        for(ArrayList<String> x:mm.values())
        {
            ans.add(x);
        }
        return ans;
    }
