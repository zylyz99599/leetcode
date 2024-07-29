import java.util.Arrays;

public class classic150 {

    // region leetcode88 合并两个有序数组
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int len = m + n;
        int[] newNum = new int[len];
        int i = 0, j = 0, l = 0;
        for (; i < m && j < n && l < len; l++) {
            if (nums1[i] <= nums2[j]) {
                newNum[l] = nums1[i++];
            } else newNum[l] = nums2[j++];
        }
        while (i < m) {
            newNum[l++] = nums1[i++];
        }
        while (j < n) {
            newNum[l++] = nums2[j++];
        }
        for (int x = 0; x < m + n; ++x) {
            nums1[x] = newNum[x];
        }
    }
    // endregion

    // region leetcode27 移除元素
    public int removeElement(int[] nums, int val) {
        int len = nums.length;
        int count = 0;
        for (int i = 0; i < len; i++) {
            if (nums[i] != val) {
                nums[i - count] = nums[i];
            } else count++;
        }
        return len - count;
    }
    // endregion

    // region leetcode26 删除有序数组中的重复项
    public int removeDuplicates(int[] nums) {
        int count = 0;
        int n = nums.length;
        for (int i = 1; i < n; i++) {
            int j = i - 1;
            while (i < n && nums[i] == nums[j]) {
                i++;
                count++;
            }
            if (i < n)
                nums[i - count] = nums[i];
        }
//        for (int i = 0; i < n - count; i++) {
//            System.out.println(nums[i] + "_");
//        }
        return n - count;
    }

    // endregion

    // region leetcode80 删除有序数组中的重复项II
    public int removeDuplicates2(int[] nums) {
        int count = 0;
        int n = nums.length;
        for (int i = 1; i < n; i++) {
            int j = i - 1;
            int ncount = 1;
            while (i < n && nums[i] == nums[j]) {
                i++;
                ncount++;
            }
            if (ncount >= 2)
                count += ncount - 2;
            if (i + 1 < n && nums[i + 1] == nums[i]) {
                nums[i - count] = nums[i];
                nums[i + 1 - count] = nums[i + 1];
            } else if (i == n - 1 || (i + 1 < n) && nums[i + 1] != nums[i]) nums[i - count] = nums[i];

        }
        for (int i = 0; i < n - count; i++) {
            System.out.println(nums[i] + "_");
        }
        return n - count;
    }

    // endregion

    // region leetcode169 多数元素
    public int majorityElement(int[] nums) {
        int count = 0;
        Integer candidate = null;
        for (int num : nums) {
            if (count == 0)
                candidate = num;
            count += (num == candidate) ? 1 : -1;
        }
        return candidate;
    }
    // endregion

    // region leetcode189 轮转数组
    public void rotate(int[] nums, int k) {
        if (k == 0 || nums.length == 0) return;
        int[] num = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            num[(i + k) % (nums.length)] = nums[i];
        }
        for (int i = 0; i < num.length; i++) {
            nums[i] = num[i];
        }
    }

    // endregion

    // region leetcode121 买卖股票的最佳时机
    public int maxProfit(int[] prices) {
        int max = 0;
        int minPrice = prices[0];
        for (int cost : prices) {
            minPrice = Math.min(cost, minPrice);
            max = Math.max(max, cost - minPrice);
        }
        return max;
    }
    // endregion
    public static void main(String[] args) {
        classic150 c = new classic150();
        int[] n = new int[]{0, 0, 1, 1, 1, 1, 2, 3, 3};
        c.removeDuplicates2(n);
    }
};

