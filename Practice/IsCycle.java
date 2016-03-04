package Practice;

import Graph.Graph;
import Graph.Vertex;

public class IsCycle {

	private Graph G;
	private boolean isCycle = false;
	private int[] visitCount;
	
	public IsCycle(Graph G){
		this.G = G;
		visitCount = new int[G.size];
	}
	public void findCycle(int s){
		Vertex[] vertexs = G.V;
		Vertex v = vertexs[s];
//		if(visitCount[s]==2){
//			isCycle = true;
//			return;
//		}
		if(v.known){
			isCycle = true;
			return;
		}
		v.known=true;
		visitCount[s]++;
		int adjSize = v.adj.size();
		if(adjSize!=0){
			for(int i=0;i<adjSize;i++){
				findCycle((int)v.adj.get(i));
			}
		}
	}
	
	public boolean isCycle(){
		findCycle(0);
		return isCycle;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] adj0 = {1, 2};
		int[] adj1 = {0, 3, 4};
		int[] adj2 = {0};
		int[] adj3 = {1};
		int[] adj4 = {1};
		//int[] adj5 = {};
		Vertex[] vertexs = new Vertex[5];
	    vertexs[0] = new Vertex(0, 1, adj0);
		vertexs[1] = new Vertex(1, 1, adj1);
		vertexs[2] = new Vertex(2, 1, adj2);
		vertexs[3] = new Vertex(3, 1, adj3);
		vertexs[4] = new Vertex(4, 1, adj4);
		Graph G = new Graph(vertexs);
		IsCycle ic = new IsCycle(G);
		System.out.print(ic.isCycle());

	}

}
