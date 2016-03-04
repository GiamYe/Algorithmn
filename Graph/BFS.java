package Graph;
import java.util.ArrayList;
import java.util.List;
import java.util.LinkedList;
import java.util.Queue;

import Graph.Vertex;
import Graph.Graph;
public class BFS {
	private Graph G;
	private Queue queue = new LinkedList<Integer>();
	public int[] dist;
	public int[] parent;
	
	public BFS(Graph G){
		this.G = G;
		dist = new int[G.size];
		parent = new int[G.size];
	}
	public void bfs(int s){
		Vertex[] V = G.V;
		for(int i=0;i<parent.length;i++){
			parent[i]=-1;
		}
		queue.add(s);
		dist[s]=0;
		int e;
		while(!queue.isEmpty()){
			e = (int)queue.remove();
			Vertex v = V[e];
			if(!v.known){
			System.out.print(e+" ");
			List adj = v.adj;
			for(int i=0; i<adj.size();i++){
				int t = (int) adj.get(i);
				if(!V[t].known){
					queue.add(t);
					dist[t] = dist[e]+1;
					parent[t] = e;
				}
			}
			v.known = true;
		}
		}
	
	}
	
	public void printPath(int s, int v){
		if(s==v)
			System.out.print(s+" ");
		else if (parent[v]==-1) {
			System.out.print("no path to "+s + "to " + v);
		}
		else{
			printPath(s, parent[v]);
			System.out.print(v+" ");
		}
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//initiate graph
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
		BFS bs = new BFS(G);
		bs.bfs(2);
		System.out.println("");
		for(int i=0;i<bs.dist.length;i++){
			System.out.print(bs.dist[i]+" ");
		}
		System.out.println("");
		//bs.printPath(2,1);
		for(int j=0;j<bs.parent.length;j++){
			System.out.print(bs.parent[j]+" ");
		}
		
		System.out.println("");
		bs.printPath(2,1);
	}
	
	

}
