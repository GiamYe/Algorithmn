package Sort;

public class QuickSort {

/*
 * put the pivot in the first element in array
 */
	public void quickSort(int[] array, int left, int right){
		if(left>=right){
			return;
		}
		swap(array, left, (left+right)/2);
		int pivot = array[left];
		int last = left;
		int i;
		//循环时i需要小于等于right
		for(i=left+1;i<=right;i++){
			if(array[i]<pivot)
				swap(array, ++last, i);
		}
		swap(array, last, left);
		quickSort(array, left, last-1);
		quickSort(array, last+1, right);
	}
/*
 * put the pivot in the last element in array, the way implemented in Introduce to Algorithm
 */
//	public void quickSort(int[] array, int left, int right){
//		if(left>=right){
//			return;
//		}
//		swap(array, right, (left+right)/2);
//		int pivot = array[right];
//		int last = left-1;
//		int i;
	    //循环时不用小于等于right，因为pivot存放在最右边
//		for(i=left;i<right;i++){
//			if(array[i]<pivot)
//				swap(array, ++last, i);
//		}
//      这里last+1是因为last指向的是小于pivot的，而pivot在最右边，右边是大于等于pivot，所以就要将大于pivot的值即last后面一个值，
//      和pivot交换
//		swap(array, last+1, right);
//		quickSort(array, left, last);
//		quickSort(array, last+2, right);
//	}
//	
	public void swap(int[] array, int i, int j){
		int tmp = array[i];
		array[i] = array[j];
		array[j] = tmp;
	} 

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int[] array = {6,10,9,7,8,11};
		QuickSort qSort = new QuickSort();
		qSort.quickSort(array, 0, array.length-1);
		for(int i=0;i<array.length;i++){
			System.out.print(array[i]+" ");
		}
	}

}
