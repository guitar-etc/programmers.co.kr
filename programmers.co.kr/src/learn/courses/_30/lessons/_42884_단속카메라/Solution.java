package learn.courses._30.lessons._42884_단속카메라;

import java.util.Arrays;

//정확성  테스트
//테스트 1 〉	통과 (0.52ms, 73.6MB)
//테스트 2 〉	통과 (0.50ms, 84.5MB)
//테스트 3 〉	통과 (0.53ms, 77.7MB)
//테스트 4 〉	통과 (0.77ms, 76.5MB)
//테스트 5 〉	통과 (0.53ms, 77.3MB)
//효율성  테스트
//테스트 1 〉	통과 (8.54ms, 53.3MB)
//테스트 2 〉	통과 (3.22ms, 52.4MB)
//테스트 3 〉	통과 (10.70ms, 56.8MB)
//테스트 4 〉	통과 (0.99ms, 55.9MB)
//테스트 5 〉	통과 (9.03ms, 56MB)
// score: 2
class Solution {
	public static void main(String[] args) {
		var result = new Solution().solution(new int[][] 
				{{-20, 15}, {-14, -5}, {-18, -13}, {-5, -3}}
				);
		
		log("result", result);
	}
	
	int[][] routes;
	
    public int solution(int[][] routes) {
    	this.routes = routes;
    	
    	Arrays.sort(routes, (lhs, rhs) -> {
    		return lhs[1] - rhs[1];
    	});
    	
    	int curCamera = routes[0][1];
    	int count = 1;
    	
    	for (var route : routes) {
    		log("route", route);
    		if (route[0] > curCamera) {
    			count++;
    			curCamera = route[1];
    		}
    	}
    	
        return count;
    }
    
    public static void log(Object...objects) {
		System.out.println(Arrays.deepToString(objects));
	}
}