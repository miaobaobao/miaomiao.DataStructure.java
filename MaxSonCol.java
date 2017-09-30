package miaomiao.DataStructure;

import java.awt.List;

public class MaxSonCol {
	 private static final int MaxLeftSumMaxRightSum = 0;


	/*
	 * ����һ���������ӵ��ұ߱Ƚϵ�ǰ�����ֵ���T(N) = O(N^2)
	 */
	static int MethOne ( int[]List,int N) {   
		int MethOneThisSum = 0 , MethOneMaxSum = 0;
		for ( int i = 0;i < N;i++) {//i����߿�ʼ
			MethOneThisSum = 0; //�˲���ǳ���Ҫ���������㷨���Ӷ�����������ƽ���Ĺؼ�
			for ( int j = i;j < N;j++) { //j��i���ұ߿�ʼ���ض�λ��
				MethOneThisSum += List[j];
				if(MethOneThisSum > MethOneMaxSum)
					MethOneMaxSum = MethOneThisSum;
			}
		}
		return MethOneMaxSum;
	}
	/*
	 * ���������ֶ���֮���ȷ�����ٷ��ұߵ������м��һ���������������������T(N) = O(N*LogN)
	 */
	//int Max3 (int A,int B,int C) {
	//	return A > B ?( A > C ? A : C) :( B > C ? B : C) ;//����������Ľ�Ϸ����Ǵ��ҵ���
	//}
	 static int DivideAndConquer( int []List,int left,int right ) {/* ���η���List[left]��List[right]��������к� */
		int MaxLeftSum,MaxRightSum;//�������������Ľ�
		int MaxLeftBorderSum,MaxRightBorderSum;//��ſ�ֽ��ߵĽ��
		int LeftBorderSum ,RightBorderSum;
		int center , i;
		
		/*�ݹ���ֹ����ֻ��һ������*/
		if(left == right) {
			 if( List[left] > 0 )  return List[left];
			else return 0;
		}
		
		center = ( left + right ) / 2;
		
		/* �ݹ����������е�����*/
		MaxLeftSum = DivideAndConquer(List, left, center);
		MaxRightSum = DivideAndConquer(List, center+1, right);
		/*���ֽ��ߵ�������к�*/
		
		MaxLeftBorderSum = 0;
		LeftBorderSum = 0;
		for (i = center;i >= left;i--) {
			LeftBorderSum += List[i];
			if(LeftBorderSum > MaxLeftBorderSum )
				MaxLeftBorderSum = LeftBorderSum;
		}/*���ɨ�����*/
		

	    MaxRightBorderSum = 0; RightBorderSum = 0;
	    for( i=center+1; i<=right; i++ ) { 
	        RightBorderSum += List[i];
	        if( RightBorderSum > MaxRightBorderSum )
	            MaxRightBorderSum = RightBorderSum;
	    } /* �ұ�ɨ����� */
		
	    return MaxLeftSum > MaxRightSum ?(MaxLeftSum > (MaxLeftBorderSum + MaxRightBorderSum ) ? MaxLeftSum :(MaxLeftBorderSum + MaxRightBorderSum )):
	    	   (MaxRightSum > (MaxLeftBorderSum + MaxRightBorderSum ) ? MaxRightSum :(MaxLeftBorderSum + MaxRightBorderSum ) );
	   //return A > B ?( A > C ? A : C) :( B > C ? B : C) ;//����������Ľ�Ϸ����Ǵ��ҵ���
	}
	/*
	 * ���������ߴ���û�����һ�����ִ������Ҽ�ʱ�������Ϊ���������ұ���������ֿ�ʼ����T(N) = O(N)
	 */
	static int MaxSubSeqSum(int arr[], int n) {
	    int thisSum, maxSum;
	    thisSum = maxSum = 0;
	    for(int i=0; i<n; i++) {
	        thisSum += arr[i];  /* �����ۼ� */
	        if(thisSum > maxSum) {  /* ���ָ���ֵ �������ֵ */
	            maxSum = thisSum;
	        }else if(thisSum < 0){  /* �����ǰ����Ϊ�� ���� ���� */
	            thisSum = 0;
	        }
	    }
	    return maxSum;
	}
	
	
	public static void main(String[] args) {
		// TODO �Զ����ɵķ������
		int [] List = {-2,11,-4,13,-5,-2};
		System.out.println("����һ�����: " + MethOne(List,6));//û������һ�������ֱ�����ú�����Ҫ�ں�������ǰ�����static;
		System.out.println("�����������: " + DivideAndConquer(List,0,5));
		System.out.println("�����������: " +MaxSubSeqSum(List, 6));
		
	}

}
