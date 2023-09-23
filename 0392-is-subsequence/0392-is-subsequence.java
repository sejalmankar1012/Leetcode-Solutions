class Solution {
    public boolean isSubsequence(String s, String t) {
        if (s.length() == 0) return true;
        
        int s_pointer = 0;
        int t_pointer = 0;
        
        while (t_pointer < t.length()){
            if(t.charAt(t_pointer) == s.charAt(s_pointer)){
                s_pointer++;
                
                if(s_pointer == s.length()) return true;
            }
            
            t_pointer++;
        }
        
        return false;
    }
}