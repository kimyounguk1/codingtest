package cote;

public class programmersPalindrome12904 {

    static int max = Integer.MIN_VALUE;
    static Boolean[][] dp;
    public int solution(String s)
    {
        int answer = 0;
        int n = s.length();
        dp = new Boolean[n][n];
	        
        for(int i=0; i<s.length(); i++){
            for(int j=i; j<s.length(); j++){
                boolean r = pali(i,j,s);
                if(r){
	                int len = j-i+1;
                    if(len>max) max = len;	                
                    }
	        }
	    }
	    answer = max;
	    
	    return answer;
	}
	    
	public static boolean pali(int c, int e, String s){
	    if(c>=e) return true;
	    if(dp[c][e]!=null) return dp[c][e];
	    if(s.charAt(c)!=s.charAt(e)) return false;
	    dp[c][e] = pali(c+1,e-1,s);
	    return dp[c][e];
	}
}
