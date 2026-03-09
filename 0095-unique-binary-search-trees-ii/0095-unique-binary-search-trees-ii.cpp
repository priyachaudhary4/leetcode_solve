class Solution {
public:
    vector<TreeNode*> generate(int start, int end) {
        vector<TreeNode*> trees;

        if (start > end) {
            trees.push_back(NULL);
            return trees;
        }

        for (int i = start; i <= end; i++) {

            vector<TreeNode*> left = generate(start, i - 1);
            vector<TreeNode*> right = generate(i + 1, end);

            for (auto l : left) {
                for (auto r : right) {

                    TreeNode* root = new TreeNode(i);
                    root->left = l;
                    root->right = r;

                    trees.push_back(root);
                }
            }
        }

        return trees;
    }

    vector<TreeNode*> generateTrees(int n) {
        if (n == 0) return {};
        return generate(1, n);
    }
};