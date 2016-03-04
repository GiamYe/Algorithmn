package Graph;

public class DisjSets implements DisjSetsInterface  {

	private int[] sets;
	private int[] rank;
	
	public DisjSets(int num){
		sets = new int[num];
		rank = new int[num];
		for(int i=0;i<num;i++){
			sets[i]=i;
			rank[i]=0;
		}
	}
	public int findSet(int t){
		if(t!=sets[t]){
			return findSet(sets[t]);
		}
		return sets[t];
	}
	
	public void union(int u, int v){
		int x = findSet(u);
		int y = findSet(v);
		if(x!=y){
		if(rank[x]>rank[y]){
			sets[y] = x;
		}
		else{
			sets[x] = y;
			if(rank[x]==rank[y]){
				rank[y]++;
			}
		}
		}
	}
	//从根开始打印向下打印节点
	public void print(int p){
		System.out.print(p+" ");
		for(int i=0;i<sets.length;i++){
			if(sets[i]!=i && sets[i]==p)
				print(i);
		}
	}
	
	public void printSets(){
		for(int i=0;i<sets.length;i++){
			if(sets[i]==i){
			System.out.println("The set is:");
			print(i);
			System.out.println("");
			}
		}
	}
	
	public int size(){
		int count = 0;
		for(int i=0;i<sets.length;i++){
			if(sets[i]==i){
				count++;
			}
		}
		return count;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		DisjSets ds = new DisjSets(6);
		ds.union(2,3);
		ds.union(2,5);
		//System.out.print(ds.findSet(5));
		ds.printSets();
		System.out.print("The size of disjSets is "+ ds.size());

	}

}
