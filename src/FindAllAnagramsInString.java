import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

class FindAllAnagramsInString {
    public List<Integer> findAnagrams(String s, String p) {
        HashMap<Character,Integer> hmap = new HashMap<>();
        List<Integer> ans = new ArrayList<>();
        int k= p.length();
        for(int i =0;i<k;i++){
            if(hmap.containsKey(p.charAt(i))) hmap.put(p.charAt(i),hmap.get(p.charAt(i))+1);
            else hmap.put(p.charAt(i),1);
        }
        for(int i =0;i<s.length();i++){
            boolean check = true;
            if(hmap.containsKey(s.charAt(i)))
                hmap.put(s.charAt(i),hmap.get(s.charAt(i))-1);
            if(i>=k){
                if(hmap.containsKey(s.charAt(i-k)))
                    hmap.put(s.charAt(i-k),hmap.get(s.charAt(i-k))+1);
            }
            for(Integer j: hmap.values()){
                if(j!=0) check = false;
                //System.out.println(i+" "+j);
            }
            if (check) ans.add(i-k+1);
        }
        return ans;
    }


}