package Graph;

import java.util.ArrayList;
import java.util.List;

public class Vertex {
	int num;
	int weight;
	public List adj;
	public boolean known;
	
	public Vertex(int n, int weight, List adj){
		this.num=n;
		this.weight=weight;
		this.adj=adj;
		known = false;
	}
	
	public Vertex(int n, int weight, int[] adjArray){
		List adjList = new ArrayList();
		for(int i=0;i<adjArray.length;i++){
			adjList.add(adjArray[i]);
		}
		this.num = n;
		this.weight = weight;
		this.adj = adjList;
		this.known = false;
	}
	
	// Create Vertex with edge weights
	public Vertex(int n, int[] adjArray, int[] edgeWeights){
		List adjList = new ArrayList<Node>();
		for(int i=0;i<adjArray.length;i++){
			adjList.add(new Node(adjArray[i], edgeWeights[i]));
		}
		this.num = n;
		this.weight = 1;
		this.adj = adjList;
		this.known = false;
	}
	public class Node{
		public int key;
		public int edgeWeight;
		public Node(int k, int ew){
			this.key = k;
			this.edgeWeight = ew;
		}
		public int getKey(){
			return key;
		}
	}
	
	public int adjSize(){
		return adj.size();
	}
}
