package learn.courses._30.lessons._12952_N_Queen;

//�׽�Ʈ 1 ��	��� (0.02ms, 67.2MB)
//�׽�Ʈ 2 ��	��� (0.03ms, 73.9MB)
//�׽�Ʈ 3 ��	��� (0.03ms, 73.7MB)
//�׽�Ʈ 4 ��	��� (0.09ms, 75.6MB)
//�׽�Ʈ 5 ��	��� (0.25ms, 77.5MB)
//�׽�Ʈ 6 ��	��� (0.77ms, 76.6MB)
//�׽�Ʈ 7 ��	��� (1.27ms, 75.4MB)
//�׽�Ʈ 8 ��	��� (3.89ms, 74.4MB)	
//�׽�Ʈ 9 ��	��� (17.64ms, 90.6MB)
//�׽�Ʈ 10 ��	��� (43.01ms, 93.3MB)
//�׽�Ʈ 11 ��	��� (228.68ms, 107MB)

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