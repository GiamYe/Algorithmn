package Graph;


//class Pair implements Comparable{
//public int v;
//public int weight;
//public Pair(int v, int w){
//	this.v = v;
//	this.weight = w;
//}
//@Override
//public int compareTo(Object o) {
//	// TODO Auto-generated method stub
//	if(this.weight>((Pair)o).weight){
//		return 1;
//	}
//	else if(this.weight<((Pair)o).weight){
//		return -1;
//	}
//	else
//		return 0;
//}
//}
//
//class MinHeap{
//
//private int size;
//private Pair[] array;
//
//public MinHeap(Pair[] ps){
//	array = ps;
//	size = ps.length;
//}
//
//
//public void buildMinHeap(){
//	for(int i=array.length/2-1;i>=0;i--){
//		minHeapify(i);
//	}
//}
//
//public int extractMin(){
//	if(size<1){
//		return -1;
//	}
//	int min = array[0].v;
//	array[0] = array[size-1];
//	size--;
//	minHeapify(0);
//	return min;
//}
//
//public void heapDecrease(){
//	
//}
//public void minHeapify(int i){
//	int left = 2*i+1;
//	int right = 2*i+2;
//	int least = i;
//	if(left<size && array[left].compareTo(array[i])<0)
//		least = left;
//	if(right<size && array[right].compareTo(array[least])<0)
//		least = right;
//	if(least!=i){
//		swap(array, i, least);
//		minHeapify(least);
//	}
//}
//
//public void swap(Pair[] array, int i, int j){
//	Pair tmp=array[i];
//	array[i]=array[j];
//	array[j]=tmp;
//}
//
//}
public class MinHeap {

	private int size;
	private int[] array;
	
	public MinHeap(int num){
		array = new int[num];
		size = num;
	}
	
	public void buildMinHeap(int[] array){
		for(int i=array.length/2-1;i>=0;i--){
			minHeapify(array, i);
		}
	}
	
	public void minHeapify(int[] array, int i){
		int left = 2*i+1;
		int right = 2*i+2;
		int least = i;
		if(left<array.length && array[left]<array[i])
			least = left;
		if(right<array.length && array[right]<array[least])
			least = right;
		if(least!=i){
			swap(array, i, least);
			minHeapify(array, least);
		}
	}
	
	public void swap(int[] array, int i, int j){
		int tmp=array[i];
		array[i]=array[j];
		array[j]=tmp;
	}
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
