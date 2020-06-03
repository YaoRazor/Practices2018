package advanced.chapterfour;

public class FindTheDuplicateNumber {

    // The tricky part of this problem is that you can not sort and you have to use constant space
    // and you have to be better than O(n^2)
    // Check the notes in LinkedList Cycle Two
    // Consider each element in the array as an edge in graph
    // for example nums[0] = 1 can be viewed as edge: 0-->1
    // there is n vertices and n+1 edges, meaning multiple vertex
    // will point to the same vertex, which will be the entry point
    // of the cycle
    // TC: O(n), n is the length of array
    public int findDuplicate(int[] nums) {
        int slow = 0;
        int fast = 0;

        while(nums[slow]!=nums[nums[fast]]) {
            slow = nums[slow];
            fast = nums[nums[fast]];
        }

        slow = nums[slow]; // move the slow pointer to the cycle entry point
        fast = 0;

        while(slow!=fast) {
            slow = nums[slow];
            fast = nums[fast];
        }

        return slow;
    }
}
