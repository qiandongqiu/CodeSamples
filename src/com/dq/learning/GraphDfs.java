package com.dq.learning;

import java.util.ArrayList;
import java.util.Iterator;

public class GraphDfs {
	private int V;
	ArrayList<ArrayList<Integer>> adj;
	
	GraphDfs(int v) {
		this.V = v;
		
		adj = new ArrayList<>(V);
		for(int i=0; i<V; i++) {
			adj.add(new ArrayList<Integer>());
		}
	}
	
	public void addEdge(int u, int v) {
		adj.get(u).add(v);
	}

	
	//DFS:  visited
	private void DFSUtil(int u, boolean[] visited) {
		visited[u] = true;
		System.out.print(u+",");
		
		Iterator<Integer> ite = adj.get(u).iterator();
		while(ite.hasNext()) {
			int i = ite.next();
			if(!visited[i]) {
				DFSUtil(i, visited);
			}
		}
		
	}
	
	
	public void DFS(int i) {
		boolean[] visited = new boolean[V];
		
		DFSUtil(i, visited);
	}
	
	
	public static void main(String[] args) {
		GraphDfs g = new GraphDfs(4);
		 
        g.addEdge(0, 1);
        g.addEdge(0, 2);
        g.addEdge(1, 2);
        g.addEdge(2, 0);
        g.addEdge(2, 3);
        g.addEdge(3, 3);
        
        g.DFS(2);
	}
	
	
}
