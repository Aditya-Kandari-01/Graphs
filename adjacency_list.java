import java.util.*;
public class adjacency_list {
    public static void main(String[] args) {
        int[][] edges = {{1,2},{2,3},{3,4},{4,2},{1,3}};
        Map<Integer,List<Integer>> adj_list = new HashMap<>();

        for (int i = 0 ; i < 5 ; i++){
            int a = edges[i][0] , b = edges[i][1];
            adj_list.putIfAbsent(a, new ArrayList<>());
            adj_list.get(a).add(b);
            adj_list.putIfAbsent(b, new ArrayList<>());
            adj_list.get(b).add(a);
        }
        for (Map.Entry<Integer,List<Integer>> enter : adj_list.entrySet()){
            System.out.println(enter.getKey() + " -> " + enter.getValue());
        }
        System.out.println(adj_list);
    }
}