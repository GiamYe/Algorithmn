package Sort;

public class MergeSort {
	
	public void merge(int[] array, int[] tmp, int left, int right, int rightend){
		int leftend = right-1;
		int tmpleft = left;
		int num = rightend-left+1;
		while(left<=leftend && right<=rightend){
			if(array[left]<=array[right])
				tmp[tmpleft++] = array[left++];
			if(array[left]>array[right])
				tmp[tmpleft++] = array[right++];
		}
		
		while(left<=leftend){
			tmp[tmpleft++] = array[left++];
		}
		while(right<=rightend){
			tmp[tmpleft++] = array[right++];
		}
		
		for(int i=0;i<num;i++,rightend--){
			array[rightend] = tmp[rightend];
		}
	}
	
	public void mergeSort(int[] array, int[] tmp, int left, int right){
		if(left<right){
			int mid = (left+right)/2;
			mergeSort(array, tmp, left, mid);
			mergeSort(array, tmp, mid+1, right);
			merge(array, tmp, left, mid+1, right);
		}
	}
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] array = {3,2,8,9,1,4,10,7};
		int[] tmp = new int[array.length];
		MergeSort ms = new MergeSort();
		ms.mergeSort(array, tmp, 0, array.length-1);
		for(int i=0;i<array.length;i++){
			System.out.print(array[i]+" ");
		}

	}

}
