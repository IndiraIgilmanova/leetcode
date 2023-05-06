import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Subsets {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        Arrays.sort(nums);
        ans.add(new ArrayList<>());
        set(ans, nums, 0, 0);
        return ans;
    }
    public void set(List<List<Integer>> ans, int[] nums, int n, int k){
        int size = ans.size();
        if(n!=nums.length){
            if(n==0 || nums[n]!=nums[n-1])
                for(int i =0;i<size;i++){
                    ans.add(new ArrayList<Integer>(ans.get(i)) {{add(nums[n]);}});
                }
            else for(int i =k;i<size;i++){
                ans.add(new ArrayList<Integer>(ans.get(i)) {{add(nums[n]);}});
            }
            set(ans, nums, n+1, size);
        }
    }
}
