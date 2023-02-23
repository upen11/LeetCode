package Top100Liked;

public class FindFirstMissingPositive {

    // Expected TC: O(n) SC: O(1)

    // 4, 1, 3, 2 => 5
    // -2, 3, 4 => 1
    // 3, 4, 1  => 2
    // 3, 4, 1, 1, 4 => 2
    public static int firstMissingPositive(int[] nums) {

        int len = nums.length;

        // -2, 3, 4
        // 4 ,1, 3, 2
        for (int i = 0; i < len; i++) {
            if (nums[i] <= 0) {
                nums[i] = len + 1;
            }
        }

        // 4, 3, 4
        // 4, 1, 3, 2
        for (int i = 0; i < len; i++) {
            int ind = Math.abs(nums[i]) - 1;

            if (ind < len) {
                nums[ind] = -1 * Math.abs(nums[ind]);   // (handling duplicates) Math.abs because what if the nums is -ve
            }
        }

        // 4, 3, -4
        // -4, -1, -3, -2
        for (int i = 0; i < len; i++) {
            if(nums[i] > 0) {
                return i + 1;
            }
        }

        return len + 1;
    }

    public static void main(String[] args) {

        int[] arr1 = {4, 1, 3, 2};
        int[] arr2 = {-2, 3, 4};
//        int[] arr3 = {3, 4, 1};
        int[] arr3 = {3, 4, 1, 1, 4};

        System.out.println(firstMissingPositive(arr1));
        System.out.println(firstMissingPositive(arr2));
        System.out.println(firstMissingPositive(arr3));
    }

}
