class Solution {
  public:
    string addStrings(string num1, string num2) {
        string result = "";
        int i = num1.size() - 1, j = num2.size() - 1, carry = 0;
        
        while (i >= 0 || j >= 0 || carry) {
            int sum = carry;
            if (i >= 0) sum += num1[i--] - '0';
            if (j >= 0) sum += num2[j--] - '0';
            result += (sum % 10 + '0');
            carry = sum / 10;
        }
        
        reverse(result.begin(), result.end());
        int start = 0;
        while (start < result.length() - 1 && result[start] == '0') start++;
        return result.substr(start);
    }

    string minSum(vector<int> &arr) {
        sort(arr.begin(), arr.end());

        string num1 = "", num2 = "";
        for (int i = 0; i < arr.size(); i++) {
            if (i % 2 == 0)
                num1 += (arr[i] + '0');
            else
                num2 += (arr[i] + '0');
        }

        return addStrings(num1, num2);
    }
};
