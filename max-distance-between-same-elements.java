public int maxDistance(int[] arr) {
        // HashMap to store the first occurrence index of each element
        HashMap<Integer, Integer> map = new HashMap<>();
        int maxDist = 0; // To track the maximum distance

        for (int i = 0; i < arr.length; i++) {
            if (!map.containsKey(arr[i])) {
                // If element is encountered for the first time, store its index
                map.put(arr[i], i);
            } else {
                // If element is encountered again, calculate the distance
                int firstIndex = map.get(arr[i]);
                int currentDist = i - firstIndex;
                // Update max distance
                maxDist = Math.max(maxDist, currentDist);
            }
        }

        return maxDist;
    }
