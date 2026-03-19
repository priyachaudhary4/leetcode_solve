class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        boolean[] used = new boolean[nums.length];
        backtrack(nums, res, new ArrayList<>(), used);
        return res;
    }

    private void backtrack(int[] nums, List<List<Integer>> res,
                           List<Integer> temp, boolean[] used) {

        if (temp.size() == nums.length) {
            res.add(new ArrayList<>(temp));
            return;
        }

        for (int i = 0; i < nums.length; i++) {
            if (used[i]) continue;

            temp.add(nums[i]);
            used[i] = true;

            backtrack(nums, res, temp, used);

            // backtrack
            temp.remove(temp.size() - 1);
            used[i] = false;
        }
    }
}