package nothing;

import java.util.PriorityQueue;
import java.util.Queue;

class Demo {
    /*
     *输入整数数组 arr ，找出其中最小的 k 个数。例如，输入4、5、1、6、2、7、3、8这8个数字，则最小的4个数字是1、2、3、4。
     *
     * LeetCode解法：小根堆（因为Java中提供了现成的 PriorityQueue（默认小根堆））
     *      保持堆大小为 k，遍历数组并判断：
     *
     *      1.若目前堆大小小于 k，将当前元素放入堆中
     *
     *      2.否则判断当前数字与大根堆堆顶元素的大小关系，如果当前数字比大根堆堆顶还大，这个数就直接跳过；
     *          反之如果当前数字比大根堆堆顶小，先poll掉堆顶，再将该数字放入堆中。
     * */
    public int[] getLeastNumbers(int[] arr, int k) {
        if (k == 0) {
            return new int[0];
        }
        Queue<Integer> queue = new PriorityQueue<>((v1, v2) -> v2 - v1);
        for (int i : arr) {
            if (queue.size() < k) {
                queue.offer(i);
            } else if (i < queue.peek()) {
                queue.poll();
                queue.offer(i);
            }
        }
        int temp = 0;
        int[] x = new int[queue.size()];
        for (int i : queue) {
            x[temp++] = i;
        }
        return x;
    }
}
