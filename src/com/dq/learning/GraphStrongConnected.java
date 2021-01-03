package com.dq.learning;
import java.util.Iterator;
import java.util.LinkedList;

//check to see whether a directed graph is strong connected or not
//   https://www.geeksforgeeks.org/connectivity-in-a-directed-graph/?ref=lbp
// algorithm: do DFS on graph, if there is any not visited, then return false
//            transpose the graph
//             do DFS again, if there is any not visited, then return false

public class GraphStrongConnected {
	private int V; //number of vertices
	private LinkedList<Integer> adj[];
	
	@SuppressWarnings("unchecked")
	GraphStrongConnected(int v) {
		this.V = v;
		adj = new LinkedList[V];
		for(int i=0; i<V; i++) {
			adj[i] = new LinkedList<Integer>();
		}
	}
	
	public void addEdge(int u, int v) {
		adj[u].add(v);
	}
	
	private void dfsUtil(int u, boolean[] visited) {
		visited[u] = true;
		Iterator<Integer> ite = adj[u].iterator();
		while(ite.hasNext()) {
			int v = ite.next();
			if(!visited[v]) {
				dfsUtil(v, visited);
			}
		}
	}
	
	private GraphStrongConnected getTraspose() {
		GraphStrongConnected graph = new GraphStrongConnected(V);
		for(int i=0; i<V; i++) {
			LinkedList<Integer> adjacent= adj[i];
			Iterator<Integer> ite=adjacent.iterator();
			while(ite.hasNext()) {
				int v = ite.next();
				graph.addEdge(v, i);
			}
		}
		return graph;
	}
	
	public boolean isSCC() {
		boolean visited[] = new boolean[V];
		dfsUtil(0, visited);
		
		for(int i=0; i<V; i++) {
			if(visited[i]==false) return false;  //if any vertex is not visited, then it is not SCC
			else visited[i]=false;  //set it to false for next DFS
		}
		
		//now, get traspose graph
		GraphStrongConnected graph = this.getTraspose();
		graph.dfsUtil(0, visited);
		
		for(int i=0; i<V; i++) {
			if(visited[i]==false) return false;  //if any vertex is not visited, then it is not SCC
			
		}
		
		return true;
		
	}
	
	
	
	
	
	public static void main(String[] args) {
		GraphStrongConnected g1 = new GraphStrongConnected(5);
		 g1.addEdge(0, 1); 
	        g1.addEdge(1, 2); 
	        g1.addEdge(2, 3); 
	        g1.addEdge(3, 0); 
	        g1.addEdge(2, 4); 
	        g1.addEdge(4, 2); 
	        
	        System.out.println(g1.isSCC());
	        
	        GraphStrongConnected g2 = new GraphStrongConnected(4); 
	        g2.addEdge(0, 1); 
	        g2.addEdge(1, 2); 
	        g2.addEdge(2, 3); 
	        System.out.println(g2.isSCC());
	}

	
	
}
