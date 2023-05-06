import java.util.ArrayList;
import java.util.List;

class FromSourceToTarget {
    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        List<List<Integer>> ans = new ArrayList<>();
        List<List<Integer>> ans2 = new ArrayList<>();
        graph[graph.length-1] = new int[] {};
        for(int j =0;j<graph[0].length;j++){
            ans.add(new ArrayList<>());
            ans.get(j).add(0);
            ans.get(j).add(graph[0][j]);
        }

        for(int j =0;j<graph[0].length;j++){
            finish(ans, ans.get(j),graph);
        }
        int n = graph.length-1;
        for(int i =0;i<ans.size();i++){
            if(ans.get(i).contains(n))
                ans2.add(ans.get(i));
        }
        return ans2;
    }
    public void finish(List<List<Integer>> ans, List<Integer> list, int[][] graph){
        int x = list.get(list.size()-1);

        for(int i =1;i<graph[x].length;i++){
            ans.add(new ArrayList<>(list));
            ans.get(ans.size()-1).add(graph[x][i]);
            finish(ans, ans.get(ans.size()-1),graph);
        }
        if(graph[x].length>0){
            list.add(graph[x][0]);
            finish(ans, list ,graph);
        }

    }
}