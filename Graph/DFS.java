package Graph;

import java.util.ArrayList;

public class DFS {
	private Graph G;
	private Vertex[] V;
	public int size;
	private int[] parent;
	private int time = 0;
	public int[] d;
	public int[] f;
	
	public DFS(Graph G){
		this.G = G;
		this.V = G.V;
		this.size = G.size;
		this.parent = new int[size];
		this.d = new int[size];
		this.f = new int[size];
		for(int i=0;i<size;i++){
			parent[i]=-1;
		}
	}
	
	public void dfs(){
		for(int j=0;j<V.length;j++){
			if(!V[j].known==true){
				System.out.print("* ");
				dfsVisit(j);
				System.out.print("* ");
			}
//			if(j==1 && V[j].known && d[j]>f[j-1]){
//				System.out.print(" / ");
//			}
		}
	}
	public void dfsVisit(int u){
		Vertex v = V[u];
		time++;
		d[u] = time;
		if(!v.known){
			v.known = true;
			System.out.print(u+" ");
		for(int k=0;k<v.adj.size();k++){
			int adjV = (int)v.adj.get(k);
			if(!V[adjV].known){
				parent[adjV] = u;
				dfsVisit(adjV);
			}
		}
		}
		f[u] = ++time;
	}
	
	public int[] finishTime(){
		return f;
	}
	
	public Vertex[] adj(){
		return V;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] adj0 = {1, 3};
		int[] adj1 = {4};
		int[] adj2 = {4, 5};
		int[] adj3 = {1};
		int[] adj4 = {3};
		int[] adj5 = {4};
		//ArrayList<Vertex> vertexs = new ArrayList<Vertex>();
		Vertex[] vertexs = new Vertex[6];
		Vertex v0 = new Vertex(0, 1, adj0);
		Vertex v1 = new Vertex(1, 1, adj1);
		Vertex v2 = new Vertex(2, 1, adj2);
		Vertex v3 = new Vertex(3, 1, adj3);
		Vertex v4 = new Vertex(4, 1, adj4);
		Vertex v5 = new Vertex(5, 1, adj5);
		vertexs[0] = v0;
		vertexs[1] = v1;
		vertexs[2] = v2;
		vertexs[3] = v3;
		vertexs[4] = v4;
		vertexs[5] = v5;
		Graph G = new Graph(vertexs);
		DFS d = new DFS(G);
		d.dfs();
		System.out.println("");
		for(int i=0;i<d.d.length;i++)
			System.out.print(d.d[i]+" "+d.f[i]+"; ");
	}

}
