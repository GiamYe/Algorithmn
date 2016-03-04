package Graph;
import java.util.Stack;

public class Topo {

	private Graph G;
	private Vertex[] V;
	public int size;
	private int[] parent;
	private int time = 0;
	public int[] d;
	public int[] f;
	public Stack topoStack = new Stack();
	
	public Topo(Graph G){
		this.G = G;
		this.V = G.V;
		this.size = G.size;
		this.parent = new int[size];
		this.d = new int[size];
		this.f = new int[size];
	}
	
	public void topo(){
		for(int i=0;i<size;i++){
			parent[i]=-1;
		}
		for(int j=0;j<V.length;j++){
			if(!V[j].known==true){
				dfsVisit(j);
			}
		}
	}
	public void dfsVisit(int u){
		Vertex v = V[u];
		time++;
		d[u] = time;
		if(!v.known){
			v.known = true;
			System.out.print(u+" ");
		if(v.adj.size()!=0){
		for(int k=0;k<v.adj.size();k++){
			int adjV = (int)v.adj.get(k);
			if(!V[adjV].known){
				parent[adjV] = u;
				dfsVisit(adjV);
			}
		}
		}
		}
		f[u] = ++time;
		topoStack.push(u);
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] adj0 = {1, 2};
		int[] adj1 = {3, 4};
		int[] adj2 = {3};
		int[] adj3 = {};
		int[] adj4 = {};
		//int[] adj5 = {};
		Vertex[] vertexs = new Vertex[5];
		vertexs[0] = new Vertex(0, 1, adj0);
		vertexs[1] = new Vertex(1, 1, adj1);
		vertexs[2] = new Vertex(2, 1, adj2);
		vertexs[3] = new Vertex(3, 1, adj3);
		vertexs[4] = new Vertex(4, 1, adj4);
		Graph G = new Graph(vertexs);
		Topo t = new Topo(G);
		t.topo();
		//System.out.print(t.stack.size());
		System.out.println("");
		while(!t.topoStack.isEmpty()){
			System.out.print((int)t.topoStack.pop() + " ");
		}
	}
}
