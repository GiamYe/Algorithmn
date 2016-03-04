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
		//ѭ��ʱi��ҪС�ڵ���right
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
	    //ѭ��ʱ����С�ڵ���right����Ϊpivot��������ұ�
//		for(i=left;i<right;i++){
//			if(array[i]<pivot)
//				swap(array, ++last, i);
//		}
//      ����last+1����Ϊlastָ�����С��pivot�ģ���pivot�����ұߣ��ұ��Ǵ��ڵ���pivot�����Ծ�Ҫ������pivot��ֵ��last����һ��ֵ��
//      ��pivot����
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
