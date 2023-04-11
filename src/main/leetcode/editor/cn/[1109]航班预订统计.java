
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int[] corpFlightBookings(int[][] bookings, int n) {
        int[] result = new int[n];
        for (int[] booking : bookings) {
            int start = booking[0] - 1;
            int end = booking[1] - 1;
            int seat = booking[2];
            result[start] += seat;

            for (int i = 0; i < n; i++) {
                System.out.print(" " + result[i]+" ");
            }
            System.out.println();

            if (end + 1 < n) {

                result[end + 1] -= seat;
                System.out.println("res: 差分 " + end + ":" + result[start]);

            }


        }

        for (int i = 0; i < n; i++) {
            System.out.println(result[i]);
        }

        for (int i = 1; i < n; i++) {
            result[i] += result[i - 1];
        }

        return result;
    }

}
//leetcode submit region end(Prohibit modification and deletion)
