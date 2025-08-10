import java.util.*;
class cycle_detect_dfs {
    private boolean bfs(int node,boolean[] visited,Map<Integer,List<Integer>> adjList){
        Queue<int[]> queue = new ArrayDeque<>();
        visited[node] = true;
        queue.add(new int[]{node,-1});
        while (!queue.isEmpty()){
            int[] node_pair = queue.poll();
            int u_node = node_pair[0];
            int parent = node_pair[1];
            List<Integer> neighbours = adjList.getOrDefault(u_node,new ArrayList<>());
            for (int v_node : neighbours){
                if ( !visited[v_node] ){
                    visited[v_node] = true;
                    queue.add(new int[]{v_node,u_node});
                }
                else if (v_node != parent){
                    return true;
                }
            }
        }
        return false;
    }
    public boolean isCycle(int V, int[][] edges) {
        Map<Integer,List<Integer>> adjList = new HashMap<>();
        boolean[] visited = new boolean[V];
        for (int i=0 ; i < edges.length ; i++){
            int u = edges[i][0], v = edges[i][1];
            adjList.putIfAbsent(u,new ArrayList<>());
            adjList.get(u).add(v);
            adjList.putIfAbsent(v,new ArrayList<>());
            adjList.get(v).add(u);
        }
        for (int i = 0 ; i < V ; i++){
            if (!visited[i] && bfs(i,visited,adjList)){
                return true;
            }
        }
        return false;
    }
}
