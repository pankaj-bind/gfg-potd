class Solution {
  public:
    bool sameFreq(string& s) {

         unordered_map<char, int> freq;

        for (char ch : s) {
            freq[ch]++;
        }

        unordered_map<int, int> freqCount;

        for (auto it = freq.begin(); it != freq.end(); ++it) {
            freqCount[it->second]++;
        }

        if (freqCount.size() == 1) return true;

        if (freqCount.size() == 2) {
            auto it = freqCount.begin();
            int f1 = it->first, c1 = it->second;
            ++it;
            int f2 = it->first, c2 = it->second;

            if ((f1 == 1 && c1 == 1) || (f2 == 1 && c2 == 1)) return true;

            if ((abs(f1 - f2) == 1) && ((f1 > f2 && c1 == 1) || (f2 > f1 && c2 == 1))) return true;
        }

        return false;
    }
};
