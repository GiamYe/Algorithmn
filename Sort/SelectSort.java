package Sort;

public class SelectSort {

	public void selectSort(int[] array){
		for(int i=0;i<array.length-1;i++){
			for(int j=i+1;j<array.length;j++){
				if(array[i]>array[j]){
					swap(array, i, j);
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
		SelectSort hs = new SelectSort();
		hs.selectSort(array);
		for(int i=0;i<array.length;i++){
			System.out.print(array[i]+" ");
		}
	}
}
