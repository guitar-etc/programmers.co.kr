package learn.courses._30.lessons._42892_길_찾기_게임;

import java.util.Arrays;

//정확성  테스트
//테스트 1 〉	통과 (0.68ms, 76.7MB)
//테스트 2 〉	통과 (0.72ms, 75.8MB)
//테스트 3 〉	통과 (0.58ms, 75.3MB)
//테스트 4 〉	통과 (0.67ms, 72.1MB)
//테스트 5 〉	통과 (0.63ms, 74.8MB)
//테스트 6 〉	통과 (2.12ms, 82.2MB)
//테스트 7 〉	통과 (2.10ms, 78MB)
//테스트 8 〉	통과 (5.86ms, 86.1MB)
//테스트 9 〉	통과 (11.35ms, 98MB)
//테스트 10 〉	통과 (3.29ms, 80.1MB)
//테스트 11 〉	통과 (10.96ms, 101MB)
//테스트 12 〉	통과 (10.90ms, 105MB)
//테스트 13 〉	통과 (1.27ms, 73.2MB)
//테스트 14 〉	통과 (2.73ms, 87.4MB)
//테스트 15 〉	통과 (6.87ms, 82.8MB)
//테스트 16 〉	통과 (11.28ms, 109MB)
//테스트 17 〉	통과 (2.30ms, 77.9MB)
//테스트 18 〉	통과 (11.39ms, 99.5MB)
//테스트 19 〉	통과 (3.35ms, 80.8MB)
//테스트 20 〉	통과 (6.18ms, 84.4MB)
//테스트 21 〉	통과 (7.77ms, 90.1MB)
//테스트 22 〉	통과 (10.43ms, 87.4MB)
//테스트 23 〉	통과 (10.68ms, 102MB)
//테스트 24 〉	통과 (0.63ms, 80MB)
//테스트 25 〉	통과 (0.86ms, 77.9MB)
//테스트 26 〉	통과 (2.56ms, 84.3MB)
//테스트 27 〉	통과 (0.77ms, 76MB)
//테스트 28 〉	통과 (0.74ms, 77.2MB)
//테스트 29 〉	통과 (0.58ms, 76MB)

// score: 3
class Solution {
	public static void main(String[] args) {
//		var result = new Solution().solution(new int[][] 
//				{{5,3},{10,5},{13,3},{3,5},{6,1},{1,3},{9,6},{7,2},{2,2},{8,1},{12,2},{11,1}}
//				);
//		log("result", result);
	}
	
	public static void log(Object...objects) {
		System.out.println(Arrays.deepToString(objects));
	}
	
	static class Node {
		Node left, right, parent;
		int num, x, y;
		public Node(Node left, Node right, Node parent, int x, int y, int num) {
			super();
			this.left = left;
			this.right = right;
			this.parent = parent;
			this.num = num;
			this.x = x;
			this.y = y;
		}
		@Override
		public String toString() {
			return "Node [left=" + left + ", right=" + right + ", num=" + num + ", y=" + y + "]";
		}
	}
	
    public int[][] solution(int[][] _nodeinfo) {
    	var nodeinfo = new int[_nodeinfo.length][3];
    	
    	for (int i = 0; i < _nodeinfo.length; i++) {
    		nodeinfo[i][0] = _nodeinfo[i][0];
    		nodeinfo[i][1] = _nodeinfo[i][1];
    		nodeinfo[i][2] = i + 1;
    	}
    	
    	Arrays.sort(nodeinfo, (lhs, rhs) -> {
    		return lhs[0] - rhs[0];
    	});
    	
    	Node curNode = new Node(null, null, null, nodeinfo[0][0], nodeinfo[0][1], nodeinfo[0][2]);
    	Node root = curNode;
    	for (int i = 1; i < nodeinfo.length; i++) {
    		int x = nodeinfo[i][0];
    		int y = nodeinfo[i][1];
    		int num = nodeinfo[i][2];
    		
    		if (curNode.y < y) {
    			while (curNode.parent != null && curNode.parent.y < y) {
//    			while (curNode.parent != null && curNode.y != y) {
    				curNode = curNode.parent;
    			}
    			
    			if (curNode.parent == null) {
	    			curNode.parent = new Node(curNode, null, null, x, y, num);
	    			curNode = curNode.parent;
	    			root = curNode;
    			}
    			else {
    				Node grandParent = curNode.parent;
    				if (grandParent.right != curNode) {
    					throw new RuntimeException();
    				}
    				curNode.parent = new Node(curNode, null, grandParent, x, y, num);
    				grandParent.right = curNode.parent;
    				curNode = curNode.parent;
    			}
    		}
    		else {
    			if (curNode.right != null) {
    				throw new RuntimeException();
    			}
    			curNode.right = new Node(null, null, curNode, x, y, num);
    			curNode = curNode.right;
    		}
    	}
    	
    	log("root", root);
    	
        answer = new int[2][nodeinfo.length];
        
        preorder(root);
        postorder(root);
        
        return answer;
    }
    
    int i = 0;
    int i2 = 0;
    int[][] answer;
    void preorder(Node root) {
    	if (root == null) {
    		return;
    	}
    	answer[0][i++] = root.num;
    	preorder(root.left);
    	preorder(root.right);
    }
    
    void postorder(Node root) {
    	if (root == null) {
    		return;
    	}
    	postorder(root.left);
    	postorder(root.right);
    	answer[1][i2++] = root.num;
    }
}