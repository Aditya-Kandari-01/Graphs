import java.util.*;

public class dfs {
    private static void dfs_traverse (int node , int[][] graph,int [] visited, ArrayList<Integer> result){
        visited[node] = 1;
        result.add(node);
        for(int i : graph[node]){
            if (visited[i] == 0){
                dfs_traverse(i,graph,visited,result);
            }
        }
    }
    public static void main(String[] args) {
        int adj[][] = {{2, 3, 1}, {0}, {0, 4}, {0}, {2}};
        ArrayList<Integer> result = new ArrayList<>();
        int visited[] = new int[adj.length];
        dfs_traverse(0,adj,visited,result);
        System.out.println(result);
    }
}
