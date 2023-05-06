import java.util.ArrayList;

class ProvincesNumber {
    public int findCircleNum(int[][] isConnected) {
        int n = isConnected.length;
        int count=0;
        ArrayList<Integer> circles = new ArrayList<>();

        for(int i =0;i<n;i++){
            if(!circles.contains(i)){
                circles.add(i);
                count++;
            }
            for(int j =0;j<n;j++){
                if(i==j) continue;
                if(isConnected[i][j]==1){
                    isConnected[i][j] = 0;
                    isConnected[j][i] = 0;
                    circles.add(j);
                    check(isConnected,j,circles);
                }
            }
        }

        return count;
    }

    public int check(int [][] isConnected, int i, ArrayList<Integer> circles){
        int n = isConnected.length;
        int count=0;
        for(int j =0;j<n;j++){
            if(i==j) continue;
            if(isConnected[i][j]==1){
                isConnected[i][j] = 0;
                isConnected[j][i] = 0;
                circles.add(j);
                check(isConnected,j,circles);
            }
        }
        return 0;
    }
}