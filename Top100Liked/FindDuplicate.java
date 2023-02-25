package Top100Liked;

public class FindDuplicate {

    // arr[] = {1, 4 ,2, 3, 2, 5, 2}

    // T: O(n) S: O(1)

    // without modifying the original array
    public static int findDuplicate(int[] arr) {

        int slow = arr[0];
        int fast = arr[0];

        // phase1
        do {
            slow = arr[slow];
            fast = arr[arr[fast]];
        }
        while(slow != fast);

        // phase2
        slow = arr[0];
        while(slow != fast) {
            slow = arr[slow];
            fast = arr[fast];
        }

        return slow;
    }

    // with modifying the original array
    public static int findDuplicate2(int[] arr) {

        int dup = 0;

        for(int i = 0; i < arr.length; i++) {
            int ind = Math.abs(arr[i]);

            if(arr[ind] < 0) {
              dup = Math.abs(arr[i]);
              break;
            }

            arr[ind] = -1 * arr[ind];
        }

        return dup;
    }

    public static void main(String[] args) {

        int[] arr1 = {1, 4 ,2, 3, 2, 5, 2};
        int[] arr2 = {3, 3, 4, 2, 1};
        int[] arr3 = {2, 2, 2};

        System.out.println(findDuplicate(arr1));
        System.out.println(findDuplicate(arr2));
        System.out.println(findDuplicate(arr3));
    }
}
