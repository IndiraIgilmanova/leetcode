
class NumberOfIslands {
    public int numIslands(char[][] grid) {
        int sum = 0;
        for(int i=0;i<grid.length;i++)
            for(int j =0;j<grid[0].length;j++){
                sum+=isLand(grid, i,j);
            }
        return sum;

    }

    public int isLand(char[][] grid, int i, int j){
        if(i<0 || j<0|| i>=grid.length ||j>=grid[0].length)
            return 0;


        if(grid[i][j]=='1'){
            grid[i][j]=0;
            isLand(grid,i+1,j);
            isLand(grid,i,j+1);
            isLand(grid,i-1,j);
            isLand(grid,i,j-1);
            return 1;
        }
        else return 0;
    }
}