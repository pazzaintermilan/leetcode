public class Solution {

	/*
	time: O(1)
	space: O(1)
	*/

	// Looking at the binary representation of a number. It is a isPowerOfTwo, such number must have
	// only one bit set.
    public boolean isPowerOfTwo(int n) {
        return (n > 0) && ((n & (n-1)) == 0);
    }
}