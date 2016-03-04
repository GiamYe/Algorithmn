package Graph;

public interface DisjSetsInterface {

	public int findSet(int t);
	public void union(int u, int v);
	public int size();
	public void printSets();
	
}
