package com.zero.test;

/**
 * 
 * @author Zero-me
 *
 */
public class testSort {
	
	
	public static void main(String[] args) {
		
		int[] array = {1,2,3,4,5,6,2,4,8,44,21,88};
		quickSort(array, 0, array.length-1);
		for(int item:array) {
			System.out.print(item);
			System.out.print(" ");
		}
		
	
	}
	
	/**
	 * 快排
	 * @param ins
	 * @param start
	 * @param end
	 * @return
	 */
	public static int[] quickSort(int[] ins ,int start,int end){
		if(start>=end){
			return ins;//这个返回值并没有影响，因为这个返回值没有使用到。
		}
//		1,2,3,4,5,6,2,4,8,44,21,88
		int mid = ins[start];
		int low = start;
		int hight = end;
		while(low < hight){
			while(low < hight && ins[hight]>=mid){//
				hight -=1;
			}
			ins[low] = ins[hight];
			
			while(low < hight && ins[low] < mid){
				low +=1;
			}
			ins[hight] = ins[low];
			System.out.println("hight="+hight+";low="+low);
		}
		ins[low] = mid;
		quickSort(ins, start, low-1);
		quickSort(ins, low+1, end);
		return ins;
	}
	
	
	/**
	 * 冒泡
	 * @param array
	 * @return
	 */
	public static int[] maopao(int[] array) {
		for(int i=0;i<array.length;i++) {
			int temp;
			for(int j=i+1;j<array.length;j++) {
				if(array[i] > array[j]) {
					temp = array[i];
					array[i] = array[j];
					array[j] = temp;
				}
			}
		}
		return array;
	}

}
