package Sort;

public class HeapSort {
	
	public void maxHeapify(int[] array, int heapSize, int i){
		int left = 2*i+1; //left child
		int right = 2*i+2; //right child
		int lagest;
		if(left<heapSize && array[left]>array[i])
			lagest = left;
		else 
			lagest = i;
		if(right<heapSize && array[right]>array[lagest])
			lagest = right;
		if(lagest != i){
			swap(array, i, lagest);
			maxHeapify(array, heapSize, lagest);
		}
	}
	
	public void buildMaxHeap(int[] array){
		for(int i=array.length/2-1;i>=0;i--){
			maxHeapify(array, array.length, i);
		}
	}
	
	public void heapSort(int[] array){
		buildMaxHeap(array);
		int heapSize = array.length;
		for(int i=array.length-1;i>0;i--){
			swap(array, 0, i);
			heapSize--;
			maxHeapify(array, heapSize, 0);
		}
	}
	
	public void swap(int[] array, int i, int j){
		int tmp=array[i];
		array[i]=array[j];
		array[j]=tmp;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] array = {3,2,8,9,1,4,10,7};
		HeapSort hs = new HeapSort();
		hs.heapSort(array);
		for(int i=0;i<array.length;i++){
			System.out.print(array[i]+" ");
		}
	}

}
