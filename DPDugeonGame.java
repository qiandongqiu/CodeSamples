package test;

import java.util.Arrays;

//https://leetcode.com/problems/dungeon-game/

public class DPDugeonGame {
	public int calculateMinimumHP(int[][] dungeon) {
		int R = dungeon.length;
		int C = dungeon[0].length;

		int[][] DP = new int[R][C];
		for (int i = 0; i < R; i++)
			Arrays.fill(DP[i], Integer.MAX_VALUE);

		if (dungeon[R - 1][C - 1] < 0) { //<0
			DP[R - 1][C - 1] = Math.abs(dungeon[R - 1][C - 1]) + 1;
		} else {
			// >=0
			DP[R - 1][C - 1] = dungeon[R - 1][C - 1] * -1 + 1; // plus 1, to make sure it is >0 when enter
			if(DP[R-1][C-1]<=0) DP[R-1][C-1]=1;
		}

		for (int i = R - 1; i >= 0; i--) {
			for (int j = C - 1; j >= 0; j--) {
				if (i >= 1) { // else, there is no Upper
					int upper = DP[i][j] - dungeon[i - 1][j];
					if (upper <= 0)
						upper = 1;
					DP[i - 1][j] = Math.min(DP[i - 1][j], upper);
				}

				// if(i-1==j) System.out.println("set to "+(i-1)+","+j+", value="+ DP[i-1][j]);

				if (j >= 1) { // else, there is no left
					int left = DP[i][j] - dungeon[i][j - 1];
					if (left <= 0)
						left = 1;
					DP[i][j - 1] = Math.min(DP[i][j - 1], left);
					// if(i-1==j) System.out.println("set to "+(i-1)+","+j+", value="+ DP[i-1][j]);
				}
			}
		}
		//printDP(DP);
		return DP[0][0];
	}

	private void printDP(int[][] data) {
		int R = data.length;
		int C = data[0].length;

		for (int i = 0; i < R; i++) {
			for (int j = 0; j < C; j++) {
				System.out.print(data[i][j] + ",");
			}
			System.out.println();
		}
	}

	public static void main(String[] args) {
		int[][] dungeon = { { -2, -3, 3 }, { -5, -10, 1 }, { 10, 30, -5 }, };

		DPDugeonGame ins = new DPDugeonGame();
		System.out.println(ins.calculateMinimumHP(dungeon));
	}

}
