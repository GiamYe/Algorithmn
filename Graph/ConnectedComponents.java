package Graph;

/*
 * 无向图连通子图问题
 * 1. 无向图连通子图的个数
 * 2. 判断无向图两个顶点是否在同一个连通子图中
 */
public class ConnectedComponents {

	private DisjSetsInterface ds;
	public ConnectedComponents(Graph g){
		DisjSetsInterface ads = new DisjSets(g.size());
		//DisjSetsInterface ads = new LinkedDisjSets(g.size());
		for(int i=0; i<g.V.length;i++){
			Vertex v = g.V[i];
			for(int j=0;j<v.adjSize();j++){
				int u = (int)v.adj.get(j);
				if(ads.findSet(v.num)!=ads.findSet(u)){
					ads.union(v.num, u);
				}
			}
			}
		this.ds = ads;
	}
	
	public int getNumofConComponents(){
		return ds.size();
	}
	
	public boolean sameComponent(int u, int v){
		if(ds.findSet(u)==ds.findSet(v))
			return true;
		else
			return false;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//创建邻接表式的graph
		int[] adj0 = {1,2,3};
		int[] adj1 = {0,3};
		int[] adj2 = {0,1};
		int[] adj3 = {1};
		int[] adj4 = {5,6};
		int[] adj5 = {4};
		int[] adj6 = {4};
		int[] adj7 = {8};
		int[] adj8 = {7};
		Vertex[] vertexs = new Vertex[9];
		vertexs[0] = new Vertex(0, 1, adj0);
		vertexs[1] = new Vertex(1, 1, adj1);
		vertexs[2] = new Vertex(2, 1, adj2);
		vertexs[3] = new Vertex(3, 1, adj3);
		vertexs[4] = new Vertex(4, 1, adj4);
		vertexs[5] = new Vertex(5, 1, adj5);
		vertexs[6] = new Vertex(6, 1, adj6);
		vertexs[7] = new Vertex(7, 1, adj7);
		vertexs[8] = new Vertex(8, 1, adj8);
		Graph g = new Graph(vertexs);
		ConnectedComponents cc = new ConnectedComponents(g);
		int count = cc.getNumofConComponents();
		System.out.println("The number of connected components in this graph is " + count);
		System.out.println("1 and 5 is in the same component:" + cc.sameComponent(1, 5));
	}

}
