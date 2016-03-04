package Sort;

public class InsertSort {
	
	public void insertSort(int[] array){
		for(int i=1;i<array.length;i++){
			for(int index=i;index>0;index--){
				if(array[index]<array[index-1])
					swap(array,index,index-1);
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
		InsertSort is = new InsertSort();
		is.insertSort(array);
		for(int i=0;i<array.length;i++){
			System.out.print(array[i]+" ");
		}
	}

}
