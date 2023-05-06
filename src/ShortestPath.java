import java.util.LinkedList;
import java.util.Queue;

class ShortestPath {
    public int shortestPathBinaryMatrix(int[][] grid) {
        int n = grid.length;
        int ans = 0;
        if(grid[0][0]==1 || grid[n-1][n-1]==1)
            return -1;

        int [][] coor = new int[][] {{0,1},{1,0},{1,1},{-1,-1},{-1,0},{0,-1},{1,-1},{-1,1}};
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{0,0});
        while(!q.isEmpty()){
            int size = q.size();
            for(int p=0;p<size;p++){
                int[] curr = q.remove();

                if(curr[0]==n-1 && curr[1]==n-1)
                    return ++ans;
                for(int i =0;i<8;i++){
                    int x = curr[0]+coor[i][0];
                    int y = curr[1]+coor[i][1];
                    if(x>=0 && x<n && y>=0 && y<n && grid[x][y]==0){
                        q.add(new int[] {x,y});
                        grid[x][y]=1;
                    }
                }

            }
            ans++;
        }
        return -1;

    }
}


