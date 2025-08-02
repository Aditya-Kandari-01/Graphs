import java.util.*;
class reorder_routes {
    private int result = 0 ; // counter for the reversed edges
    private void dfs_traversal(int node,List<Integer>[] forward,List<Integer>[] reverse,int[] visited){
        visited[node] = 1;
        for (int i : forward[node]){
            if ( visited[i] == 0){
                result++; // edge to be reversed
                dfs_traversal(i,forward,reverse,visited);
            }
        }
        for (int i : reverse[node]){
            if ( visited[i] == 0){
                dfs_traversal(i,forward,reverse,visited);
            }
        }
    }
    public int minReorder(int n, int[][] connections) {
        int[] visited = new int[n];
        List<Integer>[] forward = new ArrayList[n]; //contains the from node to neighbors
        List<Integer>[] reverse = new ArrayList[n]; //contains the towards the node from neighbors
        for (int i=0 ; i < n ; i++){
            forward[i] = new ArrayList<>();
            reverse[i] = new ArrayList<>();
        }
        for (int[] node : connections){
            int a = node[0];
            int b = node[1];
            forward[a].add(b); // neighbours a -> b
            reverse[b].add(a); // neighbours b -> a (imaginary line just for traversal of more forward lines)
        }
        dfs_traversal(0,forward,reverse,visited);
        return result;
    }

 public static void main(String[] args) {
        reorder_routes sol = new reorder_routes();

        int n = 6;
        int[][] connections = {
            {0, 1},
            {1, 3},
            {2, 3},
            {4, 0},
            {4, 5}
        };

        int output = sol.minReorder(n, connections);
        System.out.println("Minimum number of edges to reverse: " + output);
    }
}