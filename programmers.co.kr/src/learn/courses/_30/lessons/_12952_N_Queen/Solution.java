package learn.courses._30.lessons._12952_N_Queen;

import java.util.*;

//테스트 1 〉	통과 (0.02ms, 83.1MB)
//테스트 2 〉	통과 (0.03ms, 75.2MB)
//테스트 3 〉	통과 (0.03ms, 73.5MB)
//테스트 4 〉	통과 (0.17ms, 76.5MB)
//테스트 5 〉	통과 (0.47ms, 72.9MB)
//테스트 6 〉	통과 (0.83ms, 75.1MB)
//테스트 7 〉	통과 (1.67ms, 76.2MB)
//테스트 8 〉	통과 (7.17ms, 88.1MB)
//테스트 9 〉	통과 (26.00ms, 95.2MB)
//테스트 10 〉	통과 (79.89ms, 122MB)
//테스트 11 〉	통과 (354.24ms, 377MB)

// score: 6
class Solution {
	int N;
	boolean[][] board;
	
    public int solution(int n) {
    	this.N = n;
    	this.board = new boolean[n][n];
    	
    	check(0);
    	
        return count;
    }
    
    int count = 0;
    void check(int i) {
    	if (i == N) {
    		count++;
			return;
    	}
    	
    	for (int j = 0; j < N; j++) {
    		if (!board[i][j]) {
    			var temp = new boolean[N][];
    			for (int t = 0; t < N; t++) {
    				temp[t] = Arrays.copyOf(board[t], N);
    			}
	    		mark(i, j, true);
	    		check(i + 1);
	    		
	    		// This is not a correct way of reverting.
//	    		mark(i, j, false);
	    		board = temp;
    		}
    	}
    }
    
    void mark(int i, int j, boolean isBad) {
    	for (int x = i; x < N; x++) {
    		board[x][j] = isBad;
    	}
    	
    	int x = i;
    	int y = j;
    	while (isIn(++x, ++y)) {
    		board[x][y] = isBad;
    	}
    	
    	x = i;
    	y = j;
    	while (isIn(++x, --y)) {
    		board[x][y] = isBad;
    	}
    }
    
    boolean isIn(int i, int j) {
    	return i >= 0 && j >= 0 && i < N && j < N;
    }
}