class Solution {
    public int lengthOfLongestSubstring(String s) {
        
        int i = -1;
        int j = -1;
        int length = 0;
        
        HashMap<Character, Integer> mMap = new HashMap<>();
        
        while(true) {
        // acquire
        while(i< s.length()-1) {
            i++;
            mMap.put(s.charAt(i), mMap.getOrDefault(s.charAt(i),0)+1);
            if(mMap.get(s.charAt(i))==2) {
                break;
            }   
            if(i-j>length) {
                length = i-j;
            }
        }
        
        //release 
        while(j<i) {
            j++;
            mMap.put(s.charAt(j), mMap.get(s.charAt(j))-1);
             if(mMap.get(s.charAt(j))==1) {
                 break;
             }    
        } 
        if(i>=s.length()-1 && j>=i)    {
           break;
       }  
      }             
     return length;                
  }
}
