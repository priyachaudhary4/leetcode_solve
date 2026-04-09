import java.util.*;

class Solution {
    public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
        if (t < 0) return false;

        Map<Long, Long> map = new HashMap<>();
        long width = (long) t + 1;

        for (int i = 0; i < nums.length; i++) {
            long num = nums[i];
            long bucketId = getBucketId(num, width);

            // Same bucket
            if (map.containsKey(bucketId))
                return true;

            // Neighbor buckets
            if (map.containsKey(bucketId - 1) &&
                Math.abs(num - map.get(bucketId - 1)) < width)
                return true;

            if (map.containsKey(bucketId + 1) &&
                Math.abs(num - map.get(bucketId + 1)) < width)
                return true;

            // Insert into bucket
            map.put(bucketId, num);

            // Maintain window size k
            if (i >= k) {
                long oldBucket = getBucketId(nums[i - k], width);
                map.remove(oldBucket);
            }
        }
        return false;
    }

    private long getBucketId(long num, long width) {
        if (num >= 0) return num / width;
        else return ((num + 1) / width) - 1;
    }
}