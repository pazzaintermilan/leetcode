import java.util.Random;

public class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int m = nums1.length;
        int n = nums2.length;
        int[] num = new int[m+n];
        for(int i=0;i<m;i++)
            num[i]=nums1[i];
        for(int j=0;j<n;j++)
            num[j+m]=nums2[j];
        if((m+n)%2==0){
            return (double)(quickselect(num,(m+n)/2+1)+quickselect(num,(m+n)/2))/2;
        }else{
            return quickselect(num,(m+n)/2+1);
        }
    }
    
    public int quickselect(int[] num, int k) {
		return quickselect(num, 0, num.length - 1, k - 1);
	}

	private int quickselect(int[] num, int first, int last, int k) {
		if (first <= last) {
			int pivot = partition(num, first, last);
			if (pivot == k) 
				return num[k];
			if (pivot > k) 
				return quickselect(num, first, pivot - 1, k);
			return quickselect(num, pivot + 1, last, k);
		}
		return Integer.MIN_VALUE;
	}

	private int partition(int[] num, int first, int last) {
		int pivot = first + new Random().nextInt(last - first + 1);
		swap(num, last, pivot);
		for (int i = first; i < last; i++) {
			if (num[i] > num[last]) {
				swap(num, i, first);
				first++;
			}
		}
		swap(num, first, last);
		return first;
	}

	private void swap(int[] num, int x, int y) {
		int tmp = num[x];
		num[x] = num[y];
		num[y] = tmp;
	}
}