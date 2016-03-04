package Practice;

import Graph.Graph;
import Graph.Vertex;

public class Tonglu {
	
	private Graph G;
	private int count = 0;
	
	public Tonglu(Graph G){
		this.G = G;
	}
	
	public void findTonglu(int s, int d){
		Vertex[] vertexs = G.V;
		Vertex v = vertexs[s];
		if(s==d){
			return;
		}
		if(!v.known){
			v.known = true;
			int adjSize = v.adj.size();
			if(adjSize!=0){
				for(int i=0;i<adjSize;i++){
					int adjV = (int)v.adj.get(i);
					if(!vertexs[adjV].known){
						if(adjV==d){
							count++;
							return;
						}
						findTonglu(adjV, d);
					}
				}
			}
		}
		
	}
	
	public int getCount(){
		return count;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] adj0 = {1, 2};
		int[] adj1 = {3, 4};
		int[] adj2 = {};
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
		Tonglu t = new Tonglu(G);
		t.findTonglu(1, 0);
		int result = t.getCount();
		System.out.print(result);
		System.out.println("");
	}

}
