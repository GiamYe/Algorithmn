package Graph;

import Graph.Vertex.Node;

public class Prim {
	private static final int INFINITY = 100;
	private Graph g;
	private int[] vs;
	private int[] key;
	private int[] parent;
	private int[] out;
	private int heapSize;
	

	public Prim(Graph graph){
		g = graph;
		vs = new int[g.size()];
		key = new int[vs.length];
		heapSize = vs.length;
		parent = new int[vs.length];
		out = new int[vs.length];
		for(int i=0;i<vs.length;i++){
			vs[i] = i;
			key[i] = INFINITY;
			out[i] = 0;
			parent[i] = -1;
		}
	}
	
	public Prim(int[] v, int[] k){
		vs = v;
		key = k;
		heapSize = vs.length;
	}

	public void buildMinHeap(){
		for(int i=vs.length/2-1;i>=0;i--){
			minHeapify(vs, i);
		}
	}
	
	public int extractMin(){
		if(heapSize<1){
			return -1;
		}
		int min = vs[0];
		out[min] = 1;
		vs[0] = vs[heapSize-1];
		heapSize--;
		minHeapify(vs, 0);
		return min;
	}
	
	public void decreaseKey(int v, int k){
		if(k>key[v]){
			System.out.print("new key is larger than current key");
		}
		key[v] = k;
		int pos = getIndex(vs, v);
		while(pos>0 && key[vs[(pos-1)/2]] > key[v]){
			swap(vs, pos, (pos-1)/2 );
			pos = (pos-1)/2;
		}
	}

	public int getIndex(int[] array, int v){
		for(int i=0;i<array.length;i++){
			if(array[i]==v)
				return i;
		}
		return -1;
	}
	
	public void minHeapify(int[] array, int i){
		int left = 2*i+1;
		int right = 2*i+2;
		int least = i;
		if(left<heapSize && key[vs[left]]<key[vs[least]]){
			least = left;
		}
		if(right<heapSize && key[vs[right]]<key[vs[least]]){
			least = right;
		}
		if(least!=i){
			swap(vs, i, least);
			minHeapify(vs, least);
		}
	}
	
	public void swap(int[] array, int i, int j){
		int tmp = array[i];
		array[i] = array[j];
		array[j] = tmp;
	}

	public void mstPrim(int s){
		key[s] = 0;
		buildMinHeap();
		int u;
		System.out.println("The path of prim is:");
		while(heapSize>0){
			u = extractMin();
			System.out.print(parent[u]+ "->"+ u +" ");
			//Vertex.Node vn = (Node) g.getAdj(u).get(0);
			for(Object o: g.getAdj(u)){
				Vertex.Node vn = (Vertex.Node) o;
				int v = vn.key;
				if(out[v]==0 && vn.edgeWeight<key[v]){
					parent[v] = u;
					decreaseKey(v, vn.edgeWeight);
				}
			}
		}
		System.out.println("");
	}
	
	public void printVs(){
		System.out.println("vs is");
		for(int i=0;i<heapSize;i++){
			System.out.print(vs[i]+" ");
		}
		System.out.println("");
	}
	
	public void printKey(){
		System.out.println("key is");
		for(int i=0;i<key.length;i++){
			System.out.print(key[i]+" ");
		}
		System.out.println("");
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int[] adj0 = {1,7};
		int[] ew0 = {4, 8};
		int[] adj1 = {0,2,7};
		int[] ew1 = {4,8,11};
		int[] adj2 = {1,3,5,8};
		int[] ew2 = {8,7,4,2};
		int[] adj3 = {2,4,5};
		int[] ew3 = {7,9,14};
		int[] adj4 = {3,5};
		int[] ew4 = {9,10};
		int[] adj5 = {2,3,4,6};
		int[] ew5 = {4,14,10,2};
		int[] adj6 = {5,7,8};
		int[] ew6 = {2,1,6};
		int[] adj7 = {0,1,6,8};
		int[] ew7 = {8,11,1,7};
		int[] adj8 = {2,6,7};
		int[] ew8 = {2,6,7};
		
		Vertex[] vertexs = new Vertex[9];
		vertexs[0] = new Vertex(0, adj0, ew0);
		vertexs[1] = new Vertex(1, adj1, ew1);
		vertexs[2] = new Vertex(2, adj2, ew2);
		vertexs[3] = new Vertex(3, adj3, ew3);
		vertexs[4] = new Vertex(4, adj4, ew4);
		vertexs[5] = new Vertex(5, adj5, ew5);
		vertexs[6] = new Vertex(6, adj6, ew6);
		vertexs[7] = new Vertex(7, adj7, ew7);
		vertexs[8] = new Vertex(8, adj8, ew8);
		
		Graph g = new Graph(vertexs);
		Prim p = new Prim(g);
		p.mstPrim(0);
		p.printKey();
//		int[] test = {0,1,2,3,4};
//		int[] tkey = {3,1,4,2,5};
//		Prim p = new Prim(test, tkey);
//		p.buildMinHeap();
//		p.printVs();
//		System.out.println(p.extractMin());
//		p.printVs();
//		p.decreaseKey(4,1);
//		p.printVs();
		
	}

}
