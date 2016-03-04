package Sort;

public class BubbleSort {
	
	public void bubbleSort(int[] array){
		for(int i=0;i<array.length;i++){
			for(int j=0;j<array.length-i-1;j++){
				if(array[j]>array[j+1]){
				swap(array, j, j+1);
				}
			}
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
		BubbleSort hs = new BubbleSort();
		hs.bubbleSort(array);
		for(int i=0;i<array.length;i++){
			System.out.print(array[i]+" ");
		}
	}
}
