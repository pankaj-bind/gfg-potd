class Solution {
  public:
    vector<int> topView(Node *root) {
        vector<int> result;
        if (!root) return result;

        map<int, int> topNode; 
        queue<pair<Node*, int>> q; 

        q.push({root, 0});

        while (!q.empty()) {
            auto front = q.front();
            q.pop();

            Node* node = front.first;
            int hd = front.second;

            if (topNode.find(hd) == topNode.end()) {
                topNode[hd] = node->data;
            }

            if (node->left) {
                q.push({node->left, hd - 1});
            }

            if (node->right) {
                q.push({node->right, hd + 1});
            }
        }

        for (auto it : topNode) {
            result.push_back(it.second);
        }

        return result;
    }
};
