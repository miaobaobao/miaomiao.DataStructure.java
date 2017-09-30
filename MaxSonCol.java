package miaomiao.DataStructure;

import java.awt.List;

public class MaxSonCol {
	 private static final int MaxLeftSumMaxRightSum = 0;


	/*
	 * 方法一：从左边相加到右边比较当前与最大值相比T(N) = O(N^2)
	 */
	static int MethOne ( int[]List,int N) {   
		int MethOneThisSum = 0 , MethOneMaxSum = 0;
		for ( int i = 0;i < N;i++) {//i从左边开始
			MethOneThisSum = 0; //此步骤非常重要这是区分算法复杂度是立方还是平方的关键
			for ( int j = i;j < N;j++) { //j从i的右边开始到特定位置
				MethOneThisSum += List[j];
				if(MethOneThisSum > MethOneMaxSum)
					MethOneMaxSum = MethOneThisSum;
			}
		}
		return MethOneMaxSum;
	}
	/*
	 * 方法二：分而治之，先分左边再分右边的最后分中间的一块从这三者中找最大的子列T(N) = O(N*LogN)
	 */
	//int Max3 (int A,int B,int C) {
	//	return A > B ?( A > C ? A : C) :( B > C ? B : C) ;//条件运算符的结合方向是从右到左
	//}
	 static int DivideAndConquer( int []List,int left,int right ) {/* 分治法求List[left]到List[right]的最大子列和 */
		int MaxLeftSum,MaxRightSum;//存放左右子问题的解
		int MaxLeftBorderSum,MaxRightBorderSum;//存放跨分界线的结果
		int LeftBorderSum ,RightBorderSum;
		int center , i;
		
		/*递归终止条件只有一个数字*/
		if(left == right) {
			 if( List[left] > 0 )  return List[left];
			else return 0;
		}
		
		center = ( left + right ) / 2;
		
		/* 递归求两边子列的最大和*/
		MaxLeftSum = DivideAndConquer(List, left, center);
		MaxRightSum = DivideAndConquer(List, center+1, right);
		/*球跨分界线的最大子列和*/
		
		MaxLeftBorderSum = 0;
		LeftBorderSum = 0;
		for (i = center;i >= left;i--) {
			LeftBorderSum += List[i];
			if(LeftBorderSum > MaxLeftBorderSum )
				MaxLeftBorderSum = LeftBorderSum;
		}/*左边扫面结束*/
		

	    MaxRightBorderSum = 0; RightBorderSum = 0;
	    for( i=center+1; i<=right; i++ ) { 
	        RightBorderSum += List[i];
	        if( RightBorderSum > MaxRightBorderSum )
	            MaxRightBorderSum = RightBorderSum;
	    } /* 右边扫描结束 */
		
	    return MaxLeftSum > MaxRightSum ?(MaxLeftSum > (MaxLeftBorderSum + MaxRightBorderSum ) ? MaxLeftSum :(MaxLeftBorderSum + MaxRightBorderSum )):
	    	   (MaxRightSum > (MaxLeftBorderSum + MaxRightBorderSum ) ? MaxRightSum :(MaxLeftBorderSum + MaxRightBorderSum ) );
	   //return A > B ?( A > C ? A : C) :( B > C ? B : C) ;//条件运算符的结合方向是从右到左
	}
	/*
	 * 方法三在线处理，没输入的一个数字从左往右及时处理左边为负抛弃从右边最近的数字开始计算T(N) = O(N)
	 */
	static int MaxSubSeqSum(int arr[], int n) {
	    int thisSum, maxSum;
	    thisSum = maxSum = 0;
	    for(int i=0; i<n; i++) {
	        thisSum += arr[i];  /* 向右累加 */
	        if(thisSum > maxSum) {  /* 发现更大值 更新最大值 */
	            maxSum = thisSum;
	        }else if(thisSum < 0){  /* 如果当前子列为负 舍弃 置零 */
	            thisSum = 0;
	        }
	    }
	    return maxSum;
	}
	
	
	public static void main(String[] args) {
		// TODO 自动生成的方法存根
		int [] List = {-2,11,-4,13,-5,-2};
		System.out.println("方法一的输出: " + MethOne(List,6));//没有声明一个对象就直接引用函数需要在函数名字前面加上static;
		System.out.println("方法二的输出: " + DivideAndConquer(List,0,5));
		System.out.println("方法三的输出: " +MaxSubSeqSum(List, 6));
		
	}

}
