import java.util.*;
class Solution {
    int[][] coordinates = {{-2,-1},{-2,1},{-1,2},{1,2},{2,1},{2,-1},{1,-2},{-1,-2}};
    
    private int steps_counter(int src_x,int src_y,int tar_x,int tar_y,int n){
        Queue<int[]> queue_pairs = new ArrayDeque<>(); // To add the pairs of current position of the knight
        int[][] visited = new int[n][n];// contains the visited pairs of the current posistions of the knight
        
        queue_pairs.add(new int[]{src_x,src_y});
        visited[src_x][src_y] = 1;
        
        int steps = 0;
        while (!queue_pairs.isEmpty()){ 
            int qsize = queue_pairs.size();// findout the size of the current position pairs 
            
            while (qsize>0){
                int[] pair = queue_pairs.poll();// removes the first pair 
                if (pair[0] == tar_x && pair[1] == tar_y){ //checks whether the pair is the destination
                    return steps; 
                }
                for (int i = 0 ; i < coordinates.length ; i++){
                    int x_cord = pair[0] + coordinates[i][0];
                    int y_cord = pair[1] + coordinates[i][1];
                    if (x_cord >= 0 && y_cord >= 0 && x_cord < n && y_cord < n && visited[x_cord][y_cord] == 0){
                        visited[x_cord][y_cord] = 1;
                        queue_pairs.add(new int[]{x_cord,y_cord});//new pair posistions are added
                    }
                }
                qsize--;
            }
            steps++;
        }
        return -1;// No able to reach the destination
    }
    
    private int minStepToReachTarget(int knightPos[], int targetPos[], int n) {
        // Conversion of the coordinates into 2 d matrix
        int src_x = n - knightPos[1]; 
        int src_y = knightPos[0] - 1;
        int tar_x = n - targetPos[1];
        int tar_y = targetPos[0] - 1;
        
        return steps_counter(src_x,src_y,tar_x,tar_y,n);
    }
    public static void main(String[] args) {
        Solution sol = new Solution();
        int[] knightPos = {4, 5};  // Starting from top-left (1-based)
        int[] targetPos = {1, 1};  // Target at (3, 3)
        int boardSize = 6;

        System.out.println("Minimum steps: " + sol.minStepToReachTarget(knightPos, targetPos, boardSize));
    }
}