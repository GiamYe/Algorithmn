package Interview;
import java.util.Random;

public class SortedRandom {

	public static void sortedRandom(int[] array){
		Random rd = new Random();
		int tmp;
		for(int i=0;i<array.length;i++){
			int index = rd.nextInt(1000)%(array.length-i)+i;
			if(index!=i){
				tmp=array[i];
				array[i] = array[index];
				array[index]=tmp;
			}
		}
		
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] num = new int[100];
		for(int i=0;i<num.length;i++){
			num[i] = i;
		}
		sortedRandom(num);
		for(int j=0;j<num.length;j++){
			System.out.print(num[j]+" ");
		}
	}

}
