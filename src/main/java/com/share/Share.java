package com.share;

import java.lang.reflect.Array;
import java.util.*;
import java.util.Map.Entry;

public class Share {

public static void main(String[] args) {
	
}
  /*
      	 * -----------------------
      	 *
You are given a 0-indexed integer array nums of size 3 which can form the sides of a triangle.

A triangle is called equilateral if it has all sides of equal length.
A triangle is called isosceles if it has exactly two sides of equal length.
A triangle is called scalene if all its sides are of different lengths.
Return a string representing the type of triangle that can be formed or "none" if it cannot form a triangle.

 

Example 1:

Input: nums = [3,3,3]
Output: "equilateral"
Explanation: Since all the sides are of equal length, therefore, it will form an equilateral triangle.
Example 2:

Input: nums = [3,4,5]
Output: "scalene"
Explanation: 
nums[0] + nums[1] = 3 + 4 = 7, which is greater than nums[2] = 5.
nums[0] + nums[2] = 3 + 5 = 8, which is greater than nums[1] = 4.
nums[1] + nums[2] = 4 + 5 = 9, which is greater than nums[0] = 3. 
Since the sum of the two sides is greater than the third side for all three cases, therefore, it can form a triangle.
As all the sides are of different lengths, it will form a scalene triangle.
 

Constraints:

nums.length == 3
1 <= nums[i] <= 100
Seen this question in a real interview before?
1/5
Yes
No
    	 */

  public void getPerspective() {

    String[] words = {"baa", "ada"};
    int groups[] = {1, 2};
    int n = words.length;

    int memo[][] = new int[n + 1][n + 1];
    for (int i[] : memo) {
      Arrays.fill(i, -1);
    }
    
    dp(0, -1, memo, words, groups);
    int [] nums = {3,4,5};
    //valid check - any 2 side sum > third
    Arrays.sort(nums);
    if(nums[0]+nums[1] > nums[2]) {
    	System.out.println("false" ); 
    }
    if(nums[0] == nums[1] && nums[1] == nums[2]) {
    	
    }else if(nums[0] != nums[1] && nums[1] != nums[2] && nums[0] != nums[2]) {
    	
    }else {
    	
    }
    //    List<String> ans = new ArrayList<>();
    //    // Traverse back to print
    //    int i = 0;
    //    int prev = -1;
    //    while (i < words.length) {
    //        int take = -1, skip = -1;
    //        if (prev == -1 || ( groups[i] != groups[prev] && words[i].length() ==
    // words[prev].length() &&  isHammingDistanceOne(words[i], words[prev]))) {
    //            take = 1 + dp(i + 1, i, memo, words, groups);
    //        }
    //        skip = dp(i + 1, prev, memo, words, groups);
    //
    //        if (take >= skip) {
    //        	ans.add(words[i]);
    //        	prev = i;
    //            i++;
    //        } else {
    //            i++;
    //        }
    //    }

    List<String> ans = new ArrayList<>();
    // Traverse back

    int inx = 0, prev = -1;

    while (inx < words.length) {
      int take = -1;
      int notake = -1;

      if (prev == -1
          || (groups[inx] != groups[prev]
              && words[inx].length() == words[prev].length()
              && isHammingDistanceOne(words[inx], words[prev]))) {
        take = dp(inx + 1, inx, memo, words, groups);
      }
      notake = dp(inx + 1, prev, memo, words, groups);

      if (take >= notake) {
        ans.add(words[inx]);
        prev = inx;
        inx++;
      } else {
        inx++;
      }
    }

    System.out.println(ans);
    //  System.out.println(lengthAfterTransformations(s,t, nums));

    adjacencyList();
    adjacencyMatrix();
  }

  public int dp(int inx, int prev, int[][] memo, String[] words, int[] groups) {
    if (inx >= words.length) {
      return 0;
    }
    // memo
    if (prev != -1 && memo[inx][prev] != -1) return memo[inx][prev];

    int maxLen = Integer.MIN_VALUE;
    if (prev == -1
        || (groups[inx] != groups[prev]
            && words[inx].length() == words[prev].length()
            && isHammingDistanceOne(words[inx], words[prev]))) { // take
      maxLen = Math.max(maxLen, 1 + dp(inx + 1, inx, memo, words, groups));
    }
    // notake
    maxLen = Math.max(maxLen, dp(inx + 1, prev, memo, words, groups));

    if (prev != -1) memo[inx][prev] = maxLen;
    return maxLen;
  }

  public boolean isHammingDistanceOne(String s1, String s2) {
    if (s1.length() != s2.length()) return false;

    int diffCount = 0;
    for (int i = 0; i < s1.length(); i++) {
      if (s1.charAt(i) != s2.charAt(i)) {
        diffCount++;
        if (diffCount > 1) return false;
      }
    }
    return diffCount == 1;
  }

//COPIED
  private Map<Integer, List<Integer>> graph = new HashMap<>();

  public int countCompleteComponents(int n, int[][] edges) {
      for (int[] edge : edges) {
          graph.computeIfAbsent(edge[0], k -> new ArrayList<>()).add(edge[1]);
          graph.computeIfAbsent(edge[1], k -> new ArrayList<>()).add(edge[0]);
      }

      Set<Integer> visited = new HashSet<>();
      int count = 0;

      for (int i = 0; i < n; i++) {
          if (!visited.contains(i)) {
              Set<Integer> component = new HashSet<>();
              dfs(i, component, visited);
              if (isCompleteComponent(component)) count++;
          }
      }
      return count;
  }

  private void dfs(int node, Set<Integer> component, Set<Integer> visited) {
      component.add(node);
      visited.add(node);
      for (int neighbor : graph.getOrDefault(node, new ArrayList<>())) {
          if (!visited.contains(neighbor)) {
              dfs(neighbor, component, visited);
          }
      }
  }

  private boolean isCompleteComponent(Set<Integer> component) {
      for (int node : component) {
          if (graph.getOrDefault(node, new ArrayList<>()).size() != component.size() - 1) {
              return false;
          }
      }
      return true;
  }
  
  
  public void printBFS(ArrayList<ArrayList<Integer>> graph) {

    ArrayList<Integer> bfs = new ArrayList<>();

    Queue<Integer> queue = new LinkedList<>();
    int[] visited = new int[graph.size()];

    queue.add(0); // head 0

    while (!queue.isEmpty()) {
      int poped = queue.poll();
      bfs.add(poped);
      ArrayList<Integer> childs = graph.get(poped); // refer graph

      for (int i : childs) {
        if (visited[i] != 1) {
          visited[i] = 1;
          queue.add(i);
        }
      }
    }
    System.out.println(bfs);
  }

  public void printDFS(ArrayList<ArrayList<Integer>> graph) {

    ArrayList<Integer> dfs = new ArrayList<>();

    int[] visited = new int[graph.size()];

    dfs(0, visited, dfs, graph);
    System.out.println(dfs);
  }

  public void dfs(
      int inx, int[] visited, ArrayList<Integer> dfs, ArrayList<ArrayList<Integer>> graph) {
    if (visited[inx] != 1) {
      visited[inx] = 1;
      dfs.add(inx);
      ArrayList<Integer> childs = graph.get(inx);
      for (int i : childs) {
        dfs(i, visited, dfs, graph);
      }
    }
  }

  public void printBFS_mat(int[][] graph) {

    ArrayList<Integer> bfs = new ArrayList<>();
    
    Queue<Integer> queue = new LinkedList<>();
    int [] visited = new int [graph.length];
    
    queue.add(0);
    visited[0] = 1;
    
    while(!queue.isEmpty()) {
    	int poped = queue.poll();
    	bfs.add(poped);
    	for(int j = 0; j < graph[poped].length; j++) {
    		if(graph[poped][j] == 1 && visited[j] == 0) {
    			visited[j] = 1;
    			queue.add(j);
    		}
    	}
    			
    }
    System.out.println(bfs);
  }
  
  public void printDFS_mat(int [][] graph) {
	    ArrayList<Integer> dfs = new ArrayList<>();

	    int[] visited = new int[graph.length];
	    dfs_mat(0, visited, dfs, graph);
	    System.out.println(dfs); 
  }

  public void dfs_mat(int inx, int [] visited, ArrayList<Integer> dfs, int [][] graph) {
	  if (visited[inx] != 1) {
		  visited[inx] = 1;
	      dfs.add(inx);
	      for(int j = 0; j < graph[inx].length; j++) {
	    	  if(graph[inx][j] == 1 && visited[j] == 0) {
	    		  dfs_mat(j, visited, dfs, graph);
	    	  }
	      }

	  }

  }
  
  public void countProvinces(int[][] edgesMat) {
	  int cnt = 0;
	  int [] visited = new int[edgesMat.length];
	 
	  for(int i = 0; i < edgesMat.length; i++) {
		  for(int j = 0; j < edgesMat[i].length; j++) {
			  if(edgesMat[i][j] == 1 && visited[j] != 1) {
				  cnt++;
				  dfs1(j, visited, edgesMat);
			  }
		  }
	  }
	  System.out.println(cnt);
  }
  
  public void dfs1(int inx, int [] visited, int [][] edgesMat) {
	  visited[inx] = 1;
	  System.out.println(inx ); 

	  for(int j = 0; j < edgesMat[inx].length; j++) {
		  if(edgesMat[inx][j] == 1 && visited[j] != 1) {
			  dfs1(j, visited, edgesMat);
		  }
	  }
  }
  class Pair {
	    int x, y;
	    Pair(int x, int y) { this.x = x; this.y = y; }
	}

  public void totalTimeToRot( int[][] grid) {
	  // 0 - empty, 1 - fresh,  2 - rotten
	  int n = grid.length;
	  int m = grid[0].length;
	  int [][] visited = new int[n][m];
	  int freshOranges = 0;	  
	  Queue<Pair>queue = new LinkedList<>();

	  for(int i = 0; i < n; i++) {
		  for(int j = 0; j < m; j++) {
			  if(grid[i][j] == 2) {
				  queue.add(new Pair(i,j)); // add starting points
				  visited[i][j] = 1;
			  }else if(grid[i][j] == 1){
				  freshOranges++;
			  }
		  }
	  }
	  int minTime = bfs(queue, freshOranges, visited, grid);

	  System.out.println(minTime);
	  
	  
  }
  public int bfs(Queue<Pair> queue , int freshOranges, int [][]visited, int [][] grid) {
	  
	  int cnt  = 0;
	  
	  while(!queue.isEmpty() && freshOranges > 0) {
		  
		  //pop all curr oranges
		  int n = queue.size();
		  boolean rotten = false;
		  for(int k = 0; k < n; k++) {
			  Pair poped = queue.poll();
			  //add neighbour
			  int i = poped.x;
			  int j = poped.y;
			  if(i-1 >= 0 && visited[i-1][j] == 0 && grid[i-1][j] != 0 ) {
				  queue.add(new Pair(i-1, j));
				  visited[i-1][j] = 1;
				  freshOranges--;
			  }
			  if(j-1 >= 0 && visited[i][j-1] == 0 && grid[i][j-1] != 0 ) {
				  queue.add(new Pair(i, j-1));
				  visited[i][j-1] = 1;
				  freshOranges--;
			  }
			  if(i+1 < grid.length && visited[i+1][j] == 0 && grid[i+1][j] != 0 ) {
				  queue.add(new Pair(i+1, j));
				  visited[i+1][j] = 1;
				  freshOranges--;
			  }
			  if(j+1 < grid[0].length && visited[i][j+1] == 0 && grid[i][j+1] != 0 ) {
				  queue.add(new Pair(i, j+1));
				  visited[i][j+1] = 1;
				  freshOranges--;
			  }
		  }
		cnt++;

	  }
	  if(freshOranges > 0) {
		  return -1;
	  }else {
		  return cnt;
	  }

  }
  
  public void adjacencyList() {

    //  pair data
    int[][] edges = {{0, 1}, {1, 2}, {2, 0}, {1, 3}};

    // Create Adjacency List - UNDIRECTED

    ArrayList<ArrayList<Integer>> graph = new ArrayList<>();

    for (int i = 0; i < edges.length; i++) {
      graph.add(new ArrayList<>());
    }

    for (int edge[] : edges) {
      graph.get(edge[0]).add(edge[1]);
      graph.get(edge[1]).add(edge[0]); // remove - line for DIRECTED
    }

    for (int i = 0; i < graph.size(); i++) {
      //System.out.println(i + " - " + graph.get(i));
    }

    // ************ BFS
    //printBFS(graph);

    // ************ DFS
    //printDFS(graph);
  }

  public void adjacencyMatrix() {

    // matrix data
    int[][] edgesMat = {{2,1,1},{1,1,0},{0,1,1}};
    int n = edgesMat.length;

    // ************ BFS
    //printBFS_mat(edgesMat);
    
    // ************ DFS
    //printDFS_mat(edgesMat);
    
    //countProvinces(edgesMat);
    totalTimeToRot(edgesMat);
  }

  /*
   * 
   * grid =
[[0]]

Use Testcase
Output
-1
Expected
0

   * You are given an m x n grid where each cell can have one of three values:

0 representing an empty cell,
1 representing a fresh orange, or
2 representing a rotten orange.
Every minute, any fresh orange that is 4-directionally adjacent to a rotten orange becomes rotten.

Return the minimum number of minutes that must elapse until no cell has a fresh orange. If this is impossible, return -1.

 

Example 1:


Input: grid = [[2,1,1],[1,1,0],[0,1,1]]
Output: 4
Example 2:

Input: grid = [[2,1,1],[0,1,1],[1,0,1]]
Output: -1
Explanation: The orange in the bottom left corner (row 2, column 0) is never rotten, because rotting only happens 4-directionally.
Example 3:

Input: grid = [[0,2]]
Output: 0
Explanation: Since there are already no fresh oranges at minute 0, the answer is just 0.
 






You are given an integer n. There is an undirected graph with n vertices, numbered from 0 to n - 1. You are given a 2D integer array edges where edges[i] = [ai, bi] denotes that there exists an undirected edge connecting vertices ai and bi.

Return the number of complete connected components of the graph.

A connected component is a subgraph of a graph in which there exists a path between any two vertices, and no vertex of the subgraph shares an edge with a vertex outside of the subgraph.

A connected component is said to be complete if there exists an edge between every pair of its vertices.

 

Example 1:



Input: n = 6, edges = [[0,1],[0,2],[1,2],[3,4]]
Output: 3
Explanation: From the picture above, one can see that all of the components of this graph are complete.
Example 2:



Input: n = 6, edges = [[0,1],[0,2],[1,2],[3,4],[3,5]]
Output: 1
Explanation: The component containing vertices 0, 1, and 2 is complete since there is an edge between every pair of two vertices. On the other hand, the component containing vertices 3, 4, and 5 is not complete since there is no edge between vertices 4 and 5. Thus, the number of complete components in this graph is 1.
 
     * */
  
  // --------------------------------------------------------------------------------------

}
