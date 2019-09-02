import java.util.Arrays;

public class Main {

	public static void main(String[] args) {
//		int n = 5;
//		int[] lost = {2,4};
//		int[] reserve = {1,3,5}; // return 5
		
//		int n = 5;
//		int[] lost = {2,4};
//		int[] reserve = {3}; // return 4
		
//		int n = 3;
//		int[] lost = {3};
//		int[] reserve = {1}; // return 2
		
		int n = 5;
		int[] lost = {1,2,4};
		int[] reserve = {1,3,4}; // return 2
		System.out.println(new Solution().solution(n, lost, reserve));
	}

}
class Solution {
    public int solution(int n, int[] lost, int[] reserve) {
        int answer = n - lost.length;
        Arrays.sort(lost); Arrays.sort(reserve);
        boolean[] got = new boolean[lost.length];
        boolean[] gave = new boolean[reserve.length];
        for (int i = 0; i < lost.length; i++) {
        	for (int j = 0; j < reserve.length; j++) {
        		if (lost[i] == reserve[j]) {
        			got[i] = true;
        			gave[j] = true;
        			break;
        		}
        	}
        }
        
        for (int i = 0; i < lost.length; i++) {
        	if (got[i]) continue;
        	int lostNum = lost[i];
    		for (int j = 0; j < reserve.length; j++) {
        		if (gave[j]) continue;
        		int reserveNum = reserve[j];
        		if (lostNum + 1 < reserveNum) break;
        		if (lostNum == reserveNum - 1 || lostNum == reserveNum + 1) {
        			got[i] = true;
        			gave[j] = true;
        			break;
        		}
        	}
        }
        for (boolean b : got)
        	if (b) answer++;
        
        return answer;
        /* 모범답안
         * 
        answer = n;

        for(int i = 0; i < lost.length; i++) {
            boolean rent = false;
            int j = 0;
            while(!rent) {
                if(j == reserve.length)                   break;
                if(lost[i] == reserve[j])                {reserve[j] = -1; rent=true;}
                else if(lost[i] - reserve[j] == 1 )      {reserve[j] = -1; rent=true;}
                else if(lost[i] - reserve[j] == -1)      {reserve[j] = -1; rent=true;}
                else                                     {j++;                      }
            }
            if(!rent) answer--;
        }
        return answer;
         * */
    
    }
    		
}