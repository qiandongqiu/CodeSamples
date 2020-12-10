package test;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;

public class Graph {
	
	private int V; //how many
	
	private LinkedList<Integer> adj[];
	
	@SuppressWarnings("unchecked")
	Graph(int v) {
		this.V=v;
		//adj = new LinkedList<Integer>[V];  //CANNOT new array of generic objects
		adj = new LinkedList[V];
		
		for(int i=0; i<V; i++) {
			adj[i] = new LinkedList<Integer>();
		}
	}
	
	
	public void addEdge(int v, int w) {
		adj[v].add(w);
	}
	

	public void DFSUtil(int v, boolean visited[]) {
		System.out.println(v);
		visited[v]=true;
		
		Iterator<Integer> ite = adj[v].iterator();
		while(ite.hasNext()) {
			int w = ite.next();
			if(!visited[w]) {
				DFSUtil(w, visited);
			}
		}
		
	}
	
	public void DFS(int start) {
		boolean visited[] = new boolean[V];
		
		DFSUtil(start, visited);
	}
	
	
	public void BFS(int start) {
		boolean visited[] = new boolean[V];
		
		LinkedList<Integer> queue = new LinkedList<Integer>();
		
		queue.push(start);
		visited[start]=true;
		
		while(!queue.isEmpty()) {
			int current = queue.poll();
			
			System.out.println(current);
			
			Iterator<Integer> it = adj[current].iterator();
			while(it.hasNext()) {
				Integer next = it.next();
				if(visited[next]==false) {
				    visited[next] = true;
				    queue.push(next);
				}
			}
		}
		
		return;
		
	}
	
	
	
	
	 public static void main(String args[]) 
	    { 
		 /*
		   0 -----> 1
		   x      x
		   |   x
		   Xx
		   2======> 3 ( 3 circles to 3)
		   
		  */
		 
		 
		 
	        Graph g = new Graph(4); 
	  
	        g.addEdge(0, 1); 
	        g.addEdge(0, 2); 
	        g.addEdge(1, 2); 
	        g.addEdge(2, 0); 
	        g.addEdge(2, 3); 
	        g.addEdge(3, 3); 
	  
	        System.out.println("Following is Depth First Traversal "+ 
	                           "(starting from vertex 2)"); 
	  
	        g.DFS(2); 
	        
	        System.out.println("-----");
	        g.BFS(2);
	    } 
	
}

