package Graph;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/*
 * 强连通图
 */
public class StronglyConnComponents {

	public void getStronglyConnComponents(Graph g){
		
		//转置图
		Graph reversedG = g.reverseGraph();
//		g.printGraph();
//		System.out.println("reversed graph");
//		reversedG.printGraph();
		
		// 做一次深度遍历
		DFS dfs = new DFS(g);
		dfs.dfs();
		//获取完成时间
		int[] finishedTime = dfs.finishTime();
		
		//将图中各个节点按完成时间从大到小的顺序排序
		Map finishMap = new HashMap<Integer, Integer>();
		for(int i=0;i<finishedTime.length;i++){
			finishMap.put(finishedTime[i], i);
		}
		//System.out.print(finishMap);
		List<Map.Entry<Integer, Integer>> list = new ArrayList<Map.Entry<Integer,Integer>>(finishMap.entrySet());
		Collections.sort(list, new Comparator<Map.Entry<Integer, Integer>>() {
			public int compare(Map.Entry<Integer, Integer> o1, Map.Entry<Integer, Integer> o2){
				if(o1.getValue()!=null && o2.getValue()!=null && o1.getValue().compareTo(o1.getValue())>0){
					return 1;
				}
				else {
					return -1;
				}
			}
		});
//		System.out.println("");
//		System.out.print(list);
		System.out.println("\n强连通分支分别为：");
		
		//各个节点按完成时间从大到小依次进行深度遍历
		DFS strongDfs = new DFS(reversedG);
		Vertex[] v = strongDfs.adj();
		for(Map.Entry<Integer, Integer> entry : list){
			if(!v[entry.getValue()].known){
				System.out.print("* ");
				strongDfs.dfsVisit(entry.getValue());
				System.out.print("* ");
			}
		}
	}
	
	public void quickSort(int[] target, int[] array, int left, int right){
		if(left>=right){
			return;
		}
		swap(array, right, (left+right)/2);
		swap(target, right, (left+right)/2);
		int pivot = array[right];
		int last = left-1;
		int i;
		for(i=left;i<right;i++){
			if(array[i]<pivot){
				last = last + 1;
				swap(array, last, i);
				swap(target, last, i);
			}
		}
		swap(array, last+1, right);
		swap(target, last+1, right);
		quickSort(target, array, left, last);
		quickSort(target, array, last+2, right);
	}
	
	private void swap(int[] array, int i, int j){
		int tmp = array[i];
		array[i] = array[j];
		array[j] = tmp;
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
		Graph g = new Graph(vertexs);
		StronglyConnComponents scc = new StronglyConnComponents();
		scc.getStronglyConnComponents(g);
		
		int[] target =  {0,1,2,3,4,5};
		int[] weights = {6,10,9,7,8,11};
		scc.quickSort(target, weights, 0, target.length-1);
		System.out.println("");
		for(int i=0; i<target.length;i++){
			System.out.print(target[i]+" ");
		}
		System.out.println("");
		for(int j=0; j<target.length;j++){
			System.out.print(weights[j]+" ");
		}
		
	}

}
