package Weekend1;

/*
 * ���ַ����Ҷ�23�Ĳ��ҵ���key��ֵ��������Ķ����˴������˶��ֲ��ҵ��㷨
 */

import java.util.Scanner;

public class BinarySearch {

	public static int rank (int key, int []a) { //�ؼ��ֺ�����
		int lo = 0;
		int hi = a.length -1; //���ұߵ�hi������λ��
		while (lo<=hi) {
			int mid = lo + (hi - lo) / 2;
			if (key < a[mid]) hi = mid  - 1;  //mid��key�ұ�ʱ��hi���mid���һ����
			else if (key > a[mid]) lo = mid + 1;//mid��key���ʱ��lo���mid�ұ�һ����
			else return mid ;
		}
		
		return -1;//�����Ҳ���ȷ��ʱ��(��ʱlo>hi��ʱ״̬�Ҳ���keyֵ)��Ҫ����-1��
	}
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner s = new Scanner(System.in);
		System.out.println("������Ҫ����ĸ�����");
		int count = s.nextInt();
		int []b = new int [count];
		System.out.println("������" + count + "������");
		for( int i=0;i<b.length;i++){
			b[i] = s.nextInt(); //��ֵ����
		}
		System.out.println("��Ҫ " + rank(23, b) + " �β���"); //�δ��Ƕ�23�Ĳ���
	}

}
