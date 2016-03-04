package Graph;

import java.util.ArrayList;
import java.util.List;

public class Graph {
	public int size;
	public Vertex[] V;
	public Graph(Vertex[] vertexs){
		this.size = vertexs.length;
		this.V = vertexs;
	}
	
	public int size(){
		return V.length;
	}
	
	public Graph reverseGraph(){
		Vertex[] vertexs = new Vertex[this.size()];
		//init
		for(int i=0;i<vertexs.length;i++){
			vertexs[i] = new Vertex(i, 1, new ArrayList());
		}
		for(Vertex v : this.V){
			for(Object adjV : v.adj){
				vertexs[(int)adjV].adj.add(v.num);
			}
		}
		return new Graph(vertexs);
	}
	
	public List getAdj(int v){
		return V[v].adj;
	}
	
	public void printGraph(){
		for(Vertex v : V){
			System.out.print(v.num + "-> ");
			for(Object adjV : v.adj){
				System.out.print((int)adjV+" ");
			}
			System.out.println("");
		}
	}
}
