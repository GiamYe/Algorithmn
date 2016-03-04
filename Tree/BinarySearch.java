package Tree;

public class BinarySearch {

	public int binarySearch(int[] array, int target){
		int left=0;
		int right=array.length-1;
		while(left<=right){
		int mid = (left+right)/2;
		if(array[mid]>target){
			right = mid-1;
		}
		else if(array[mid]<target){
			left = mid+1;
		}
		else {
			return mid;
		}
		}
		return -1;
	}

	/*
	 * recursive version
	 */
	public int binarySearch(int[] array, int left, int right, int target){
		if(left<=right){
			int mid = (left+right)/2;
			if(array[mid]>target)
				return binarySearch(array, left,mid-1,target);
			else if(array[mid]<target)
				return binarySearch(array, mid+1, right, target);
			else {
				return mid;
			}
		}
		return -1;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int[] test = {1,2,3,4,6,9,10};
		int target = 3;
		BinarySearch bs = new BinarySearch();
		System.out.print(bs.binarySearch(test, 0, test.length-1,target));
	}

}
