
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public boolean carPooling(int[][] trips, int capacity) {
        int n = 1000;
        int[] result = new int[n];
        for (int[] trip : trips) {
            int numPassengersi = trip[0];
            if (numPassengersi > capacity) {
                return false;
            }

            int start = trip[1] - 1;
            int end = trip[2] - 1 - 1;
            result[start] += numPassengersi;
            if (end + 1 < n) {
                result[end + 1] -= numPassengersi;
            }
        }

        for (int i = 0; i < 10; i++) {
            System.out.print(result[i] + "  ");
        }
        System.out.println();

        for (int i = 1; i < n; i++) {
            result[i] += result[i - 1];
        }

        for (int i = 0; i < 10; i++) {
            System.out.print(result[i] + "  ");
        }
        System.out.println();

        for (int i = 1; i < n; i++) {
            if (result[i] > capacity) {
                System.out.println(result[i] + "  " + capacity);
                return false;
            }
        }
        return true;


    }
}
//leetcode submit region end(Prohibit modification and deletion)
