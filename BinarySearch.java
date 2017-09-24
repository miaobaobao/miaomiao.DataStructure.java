package Weekend1;

/*
 * 二分法查找对23的查找但是key的值可以任意改动，此处就用了二分查找的算法
 */

import java.util.Scanner;

public class BinarySearch {

	public static int rank (int key, int []a) { //关键字和数组
		int lo = 0;
		int hi = a.length -1; //最右边的hi的数组位置
		while (lo<=hi) {
			int mid = lo + (hi - lo) / 2;
			if (key < a[mid]) hi = mid  - 1;  //mid在key右边时，hi变成mid左边一个数
			else if (key > a[mid]) lo = mid + 1;//mid在key左边时，lo变成mid右边一个数
			else return mid ;
		}
		
		return -1;//当查找不正确的时候(此时lo>hi此时状态找不到key值)需要查找-1次
	}
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner s = new Scanner(System.in);
		System.out.println("请输入要输入的个数：");
		int count = s.nextInt();
		int []b = new int [count];
		System.out.println("请输入" + count + "个正数");
		for( int i=0;i<b.length;i++){
			b[i] = s.nextInt(); //赋值数组
		}
		System.out.println("需要 " + rank(23, b) + " 次查找"); //次处是对23的查找
	}

}
