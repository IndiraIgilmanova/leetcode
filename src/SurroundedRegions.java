class SurroundedRegions {
    public void solve(char[][] board) {
        int m = board.length;
        int n = board[0].length;
        boolean[][] visited = new boolean[m][n];
        for(int i = 0; i<m; i++){
            if(board[i][0]=='O'){
                visited[i][0] = true;
                check2(board, visited, i, 0);
            }
            if(board[i][n-1]=='O'){
                visited[i][n-1] = true;
                check2(board, visited, i, n-1);
            }
        }
        for(int j = 0; j<n; j++){
            if(board[0][j]=='O'){
                visited[0][j] = true;
                check2(board, visited, 0, j);
            }
            if(board[m-1][j]=='O'){
                visited[m-1][j] = true;
                check2(board, visited, m-1, j);
            }
        }
        for(int i = 1; i<m-1; i++)
            for(int j = 1; j<n-1; j++){
                if(!visited[i][j] && board[i][j]=='O')
                    board[i][j]='X';
            }

    }

    public void check2(char[][] board,boolean[][] visited, int i, int j){
        int m = board.length;
        int n = board[0].length;
        if(i+1<m && (!visited[i+1][j]) && board[i+1][j]=='O'){
            visited[i+1][j] = true;
            check2(board, visited, i+1, j);
        }
        if(i-1>=0 &&(!visited[i-1][j]) &&board[i-1][j]=='O'){
            visited[i-1][j] = true;
            check2(board, visited, i-1, j);
        }
        if(j+1<n &&(!visited[i][j+1]) &&board[i][j+1]=='O'){
            visited[i][j+1] = true;
            check2(board, visited, i, j+1);
        }
        if(j-1>=0 &&(!visited[i][j-1]) &&board[i][j-1]=='O'){
            visited[i][j-1] = true;
            check2(board, visited, i, j-1);
        }
    }

    public boolean check(char[][] board, int i, int j, int i2, int j2){
        if(board[i][j]=='X')
            return false;
        else {
            int m = board.length;
            int n = board[0].length;
            if(i==m-1 || j==n-1||i==0 ||j==0)
                return false;
            return ((i2==i+1 && j2==j) || board[i+1][j]=='X' || check(board, i+1,j,i,j)) && ((i2==i-1 && j2==j) || board[i-1][j]=='X' || check(board, i-1,j,i,j)) && ((i2==i && j2==j+1) ||board[i][j+1]=='X' || check(board, i,j+1,i,j)) && ((i2==i && j2==j-1) ||board[i][j-1]=='X' || check(board, i,j-1,i,j));
        }
    }
}
