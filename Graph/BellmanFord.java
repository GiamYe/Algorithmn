package Graph;

import java.util.List;
import java.util.Queue;
import java.util.LinkedList;
/*
 * 单源最短路径问题,有向图
 * 图中不包含负权回路，返回true.
 */
public class BellmanFord {
	
	private static final int INFINITY = 100;
	private Graph g;
	private int[] d;
	private int[] parent;
	
	public BellmanFord(Graph graph){
		g = graph;
		d = new int[g.size()];
		parent = new int[g.size()];
	}
	
	public void bellmanFord(int s){
		for(int i=0;i<g.size();i++){
			d[i] = INFINITY;
			parent[i] = -1;
		}
		d[s] = 0;
		Vertex[] vertexs = g.V;
		Queue queue = new LinkedList<Integer>();
		queue.add(s);
		int e;
		int[] count = new int[g.size()];
		int max = -1;
		while(!queue.isEmpty() && max<g.size()+1){
			e = (int) queue.remove();
			count[e]++;
			if(max<count[e])
				max=count[e];
			Vertex v = vertexs[e];
			List adj = v.adj;
			for(Object o:adj){
				Vertex.Node vn = (Vertex.Node) o;
				int vNum = vn.getKey();
				if(d[vNum]>d[e]+vn.edgeWeight){
					d[vNum] = d[e] + vn.edgeWeight;
					parent[vNum] = e;
				}
				if(!queue.contains(vNum)){
					queue.add(vNum);
				}
			}
		}
		
		
	}
	
	public int[] getDistance(){
		return d;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] adj0 = {1,3};
		int[] ew0 = {6,7};
		int[] adj1 = {2,3,4};
		int[] ew1 = {5,8,-4};
		int[] adj2 = {1};
		int[] ew2 = {-2};
		int[] adj3 = {2,4};
		int[] ew3 = {-3,9};
		int[] adj4 = {0,2};
		int[] ew4 = {2,7};
		
		Vertex[] vertexs = new Vertex[5];
		vertexs[0] = new Vertex(0, adj0, ew0);
		vertexs[1] = new Vertex(1, adj1, ew1);
		vertexs[2] = new Vertex(1, adj2, ew2);
		vertexs[3] = new Vertex(1, adj3, ew3);
		vertexs[4] = new Vertex(1, adj4, ew4);
		
		Graph g = new Graph(vertexs);
		BellmanFord bf = new BellmanFord(g);
		bf.bellmanFord(0);
		int[] dis = bf.getDistance();
		for(int i=0;i<dis.length;i++){
			System.out.print(dis[i]);
		}
	}

}
