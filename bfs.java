import java.util.*;
public class bfs {
    static void traverse(int src,Map<Integer,List<Integer>> graph,int nodes){
        Queue<Integer> queue = new ArrayDeque<>();
        ArrayList<Integer> visited = new ArrayList<>();
        for (int i=0 ; i < nodes+1 ; i++){
            visited.add(0);
        }
        queue.add(src);
        visited.set(src,1);
        while (!queue.isEmpty()){
            int a = queue.peek();
            queue.poll();
            System.out.print(a + " ");
            List<Integer> neighbour = graph.getOrDefault(a, new ArrayList<>());
            for (int nbr : neighbour){
                if (visited.get(nbr) == 0){
                    visited.set(nbr,1);
                    queue.add(nbr);
                }
            }
        }

    }
    public static void main(String[] args) {
        int[][] edges = {{0,1},{1,4},{1,2},{2,3}};
        Map<Integer,List<Integer>> adj_list = new HashMap<>();
        for (int i=0; i<edges.length ; i++){
            int a = edges[i][0] , b = edges[i][1];
            adj_list.putIfAbsent(a,new ArrayList<>());
            adj_list.get(a).add(b);
            adj_list.putIfAbsent(b,new ArrayList<>());
            adj_list.get(b).add(a);
        }
        System.out.println("The BFS order traversal is : ");
        traverse(0,adj_list,4);
    }
}
