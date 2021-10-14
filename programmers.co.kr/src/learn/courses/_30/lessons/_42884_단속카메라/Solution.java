package learn.courses._30.lessons._42884_�ܼ�ī�޶�;

import java.util.Arrays;

//��Ȯ��  �׽�Ʈ
//�׽�Ʈ 1 ��	��� (0.52ms, 73.6MB)
//�׽�Ʈ 2 ��	��� (0.50ms, 84.5MB)
//�׽�Ʈ 3 ��	��� (0.53ms, 77.7MB)
//�׽�Ʈ 4 ��	��� (0.77ms, 76.5MB)
//�׽�Ʈ 5 ��	��� (0.53ms, 77.3MB)
//ȿ����  �׽�Ʈ
//�׽�Ʈ 1 ��	��� (8.54ms, 53.3MB)
//�׽�Ʈ 2 ��	��� (3.22ms, 52.4MB)
//�׽�Ʈ 3 ��	��� (10.70ms, 56.8MB)
//�׽�Ʈ 4 ��	��� (0.99ms, 55.9MB)
//�׽�Ʈ 5 ��	��� (9.03ms, 56MB)
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