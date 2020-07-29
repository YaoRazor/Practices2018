package ninechapter.hash_and_heap.related;

public class ImplementThreeStacksbySingleArray {

    int[] stack;
    int[] pointer = new int[3];

    /*
     * @param size: An integer
     */public ImplementThreeStacksbySingleArray(int size) {
        stack = new int[3*size];
        for(int i=0; i<3; i++) {
            pointer[i] = i*size;
        }
    }

    /*
     * @param stackNum: An integer
     * @param value: An integer
     * @return: nothing
     */
    public void push(int stackNum, int value) {
        stack[pointer[stackNum]++] = value;
    }

    /*
     * @param stackNum: An integer
     * @return: the top element
     */
    public int pop(int stackNum) {
        return stack[--pointer[stackNum]];
        // Pop and return the top element from stackNum stack
    }

    /*
     * @param stackNum: An integer
     * @return: the top element
     */
    public int peek(int stackNum) {
        return stack[pointer[stackNum]-1];
        // Return the top element
    }

    /*
     * @param stackNum: An integer
     * @return: true if the stack is empty else false
     */
    public boolean isEmpty(int stackNum) {
        return pointer[stackNum] == stackNum*stack.length/3;
        // write your code here
    }
}
