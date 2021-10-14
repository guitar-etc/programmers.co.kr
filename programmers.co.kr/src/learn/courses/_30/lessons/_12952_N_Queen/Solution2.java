package learn.courses._30.lessons._12952_N_Queen;

//테스트 1 〉	통과 (0.02ms, 67.2MB)
//테스트 2 〉	통과 (0.03ms, 73.9MB)
//테스트 3 〉	통과 (0.03ms, 73.7MB)
//테스트 4 〉	통과 (0.09ms, 75.6MB)
//테스트 5 〉	통과 (0.25ms, 77.5MB)
//테스트 6 〉	통과 (0.77ms, 76.6MB)
//테스트 7 〉	통과 (1.27ms, 75.4MB)
//테스트 8 〉	통과 (3.89ms, 74.4MB)	
//테스트 9 〉	통과 (17.64ms, 90.6MB)
//테스트 10 〉	통과 (43.01ms, 93.3MB)
//테스트 11 〉	통과 (228.68ms, 107MB)

class Solution2 {
	int N;
	int[][] queenCoords;

	public int solution(int n) {
		this.N = n;
		this.queenCoords = new int[n][];

		check(0);

		return count;
	}

	int count = 0;
	void check(int i) {
		if (i == N) {
			count++;
			return;
		}

		LOOP:
			for (int j = 0; j < N; j++) {
				for (var queenCoord : queenCoords) {
					if (queenCoord == null) {
						break;
					}
					if (j == queenCoord[1]) {
						continue LOOP;
					}
					else if (Math.abs(j - queenCoord[1]) == Math.abs(i - queenCoord[0])) {
						continue LOOP;
					}
				}

				queenCoords[i] = new int[] {i, j};
				check(i + 1);
				queenCoords[i] = null;
			}
	}
}