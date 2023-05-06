import java.util.HashMap;
import java.util.Map;

class MakeTwoAnagrams {
    public int minSteps(String s, String t) {
        int sum=0;
        Map<Character, Integer> chSet = new HashMap<>();
        for(int i =0;i<s.length();i++)
            if(chSet.containsKey(s.charAt(i)))
                chSet.put(s.charAt(i), chSet.get(s.charAt(i))+1);
            else chSet.put(s.charAt(i),1);

        for(int i =0;i<t.length();i++)
            if(chSet.containsKey(t.charAt(i)))
                chSet.put(t.charAt(i), chSet.get(t.charAt(i))-1);
            else chSet.put(t.charAt(i),-1);

        for(Integer i:chSet.values())
            sum+=Math.abs(i);
        return sum;
    }
}