public class Solution {
	/*
	time: O(1)
	space: O(1)
	*/
    public int computeArea(int A, int B, int C, int D, int E, int F, int G, int H) {
        int area = (C-A)*(D-B) + (G-E)*(H-F);
        long coverLength = (long)Math.min(C,G) - (long)Math.max(A,E); // be careful that after deduction, coverLength and coverHeight could be long
        long coverHeight = (long)Math.min(D,H) - (long)Math.max(B,F);
        if(coverLength<=0||coverHeight<=0)
            return area;
        else
            return (int) (area-coverLength*coverHeight);
    }
}