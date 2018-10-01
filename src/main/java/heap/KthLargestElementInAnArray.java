package heap;

import java.util.PriorityQueue;

public class KthLargestElementInAnArray {

    public int findKthLargest(int[] nums, int k) {

        PriorityQueue<Integer> pq = new PriorityQueue<>();

        for(int num: nums) {
            pq.offer(num);

            if(pq.size()>k) {
                pq.poll();
            }
        }

        return pq.peek();
    }


    public int findKthLargestTwo(int[] nums, int k) {

        int left = 0;
        int right = nums.length-1;


        while (true) {

            int index = partition(nums, left, right);

            if(index==k-1) {
                return nums[k-1];
            } else if(index>k-1) {
                right = index-1;
            } else {
                left = index+1;
            }
        }

    }


    private int partition(int[] nums, int l, int r) {
        int pivot = nums[l];
        int left = l+1;
        int right = r;

        while (left<=right) {
            if(nums[left]<=pivot && nums[right]>pivot) {
                swap(nums, left, right);
                left++;
                right--;
            } else if(nums[left]>pivot) {
                left++;
            } else if(nums[right]<=pivot) {
                right--;
            }

        }

        swap(nums, l, left-1);

        return left-1;

    }


    private void swap(int[] nums, int i, int j) {

        int tmp = nums[j];
        nums[j] = nums[i];
        nums[i] = tmp;

    }



}
