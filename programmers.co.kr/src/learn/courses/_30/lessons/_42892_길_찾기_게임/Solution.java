package learn.courses._30.lessons._42892_��_ã��_����;

import java.util.Arrays;

//��Ȯ��  �׽�Ʈ
//�׽�Ʈ 1 ��	��� (0.68ms, 76.7MB)
//�׽�Ʈ 2 ��	��� (0.72ms, 75.8MB)
//�׽�Ʈ 3 ��	��� (0.58ms, 75.3MB)
//�׽�Ʈ 4 ��	��� (0.67ms, 72.1MB)
//�׽�Ʈ 5 ��	��� (0.63ms, 74.8MB)
//�׽�Ʈ 6 ��	��� (2.12ms, 82.2MB)
//�׽�Ʈ 7 ��	��� (2.10ms, 78MB)
//�׽�Ʈ 8 ��	��� (5.86ms, 86.1MB)
//�׽�Ʈ 9 ��	��� (11.35ms, 98MB)
//�׽�Ʈ 10 ��	��� (3.29ms, 80.1MB)
//�׽�Ʈ 11 ��	��� (10.96ms, 101MB)
//�׽�Ʈ 12 ��	��� (10.90ms, 105MB)
//�׽�Ʈ 13 ��	��� (1.27ms, 73.2MB)
//�׽�Ʈ 14 ��	��� (2.73ms, 87.4MB)
//�׽�Ʈ 15 ��	��� (6.87ms, 82.8MB)
//�׽�Ʈ 16 ��	��� (11.28ms, 109MB)
//�׽�Ʈ 17 ��	��� (2.30ms, 77.9MB)
//�׽�Ʈ 18 ��	��� (11.39ms, 99.5MB)
//�׽�Ʈ 19 ��	��� (3.35ms, 80.8MB)
//�׽�Ʈ 20 ��	��� (6.18ms, 84.4MB)
//�׽�Ʈ 21 ��	��� (7.77ms, 90.1MB)
//�׽�Ʈ 22 ��	��� (10.43ms, 87.4MB)
//�׽�Ʈ 23 ��	��� (10.68ms, 102MB)
//�׽�Ʈ 24 ��	��� (0.63ms, 80MB)
//�׽�Ʈ 25 ��	��� (0.86ms, 77.9MB)
//�׽�Ʈ 26 ��	��� (2.56ms, 84.3MB)
//�׽�Ʈ 27 ��	��� (0.77ms, 76MB)
//�׽�Ʈ 28 ��	��� (0.74ms, 77.2MB)
//�׽�Ʈ 29 ��	��� (0.58ms, 76MB)

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