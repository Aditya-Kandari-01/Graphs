class adjacency_matrix{
    public static void main(String[] args){
        int[][] arr = {{1,2},{2,3},{3,4},{4,2},{1,3}};

        int[][] edges = new int[5][5];

        for ( int i = 0 ; i < arr.length ; i++){
            int a = arr[i][0],b = arr[i][1];
            edges[a][b] = 1;
            edges[b][a] = 1;
        }
        for (int i = 1 ; i < 5 ; i ++){
            System.out.print("Node "+i+"-> Node : ");
            for (int j = 1 ; j < 5 ; j++){
                if (edges[i][j] == 1){
                    System.out.print(" "+j);
                }
            }
            System.out.println("");
        }
    }
}