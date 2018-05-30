package miscellaneous;


public class PalindromeNumber {
    // Use long to avoid overflow
    public boolean isPalindrome(int x) {
        if (x < 0) {
            return false;
        }
        else {
            long reverse = 0;
            int original = x;
            while (x > 0) {
                reverse = reverse*10+x%10;
                x = x / 10;
            }
            return reverse == original;
        }
    }

    // Skip last digit to avild overflow, Leetcode solution给的方法比较Hacky, 因为要handle x结尾为0的情况
    public boolean isPalindromeTwo(int x) {
        if (x < 0) {
            return false;
        }
        else {
            int reverse = 0;
            int original = x;
            while (x >= 10) {
                reverse = reverse*10+x%10;
                x = x / 10;
            }
            return reverse == original/10;
        }
    }
}
