package miaomiao.DataStructure;
/*
 *  Maximum Subsequence Sum:
Given a sequence of K integers { N1,N2, ...,NK}. A continuous subsequence is defined to be { Ni,Ni+1, ..., Nj} where 1≤i≤j≤K.
The Maximum Subsequence is the continuous subsequence which has the largest sum of its elements.
For example, given sequence { -2, 11, -4, 13, -5, -2 }, its maximum subsequence is { 11, -4, 13 } with the largest sum being 20.

Now you are supposed to find the largest sum, together with the first and the last numbers of the maximum subsequence.

Input Specification:

Each input file contains one test case. Each case occupies two lines. The first line contains a positive integer K (≤10000).
The second line contains K numbers, separated by a space.

Output Specification:

For each test case, output in one line the largest sum, together with the first and the last numbers of the maximum subsequence. 
The numbers must be separated by one space, but there must be no extra space at the end of a line.
In case that the maximum subsequence is not unique, output the one with the smallest indices i and j (as shown by the sample case). 
If all the K numbers are negative, then its maximum sum is defined to be 0, and you are supposed to output the first and the last numbers of the whole sequence.


 */

public class MaximumSubsequenceSum {

	static void  MaxSubSeqSum(int arr[], int n) {
	    int thisSum, maxSum;
	    int left = 0,right=0,templeft = 0;
	    thisSum = maxSum = 0;
	    for(int i=0; i<n; i++) {
	    	if (thisSum >= 0) {//此处一直进行没有取到最大子列
	    	   thisSum += arr[i];
	    	}
	    	else{ //thissum小于0时此时在左templeft的值在左侧
	    		thisSum = arr[i];
	    		templeft = i;
	    	}
	    	if (thisSum > maxSum) {
	    		right = i;
	    		left = templeft;
	    		maxSum = thisSum;
	    	}
	    	if (maxSum < 0) { //最终结果为负输出收尾元素
				maxSum = 0;
				left = 0;
				right = n-1;
			}
	    }
	    System.out.println(maxSum + " " + arr[left] + " " + arr[right]);
	}
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int []a = {-10,1,2,3,4,-5,-23,3,7,-21};
		MaxSubSeqSum(a, 10);
	}

}
