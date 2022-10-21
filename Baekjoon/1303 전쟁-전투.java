import java.io.*;
import java.util.*;

public class Main {

	static int N, M, count, nextRow, nextCol;
	static char[][] field;
	static Queue<int[]> q = new LinkedList<int[]>();;
	static boolean[][] visited;
	static HashMap<Character, Integer> result = new HashMap<>();
	static int[][] directions = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] fieldSize = br.readLine().split(" ");
		N = Integer.parseInt(fieldSize[0]); //가로
		M = Integer.parseInt(fieldSize[1]); //세로
		field = new char[M][N];
		
		for (int row = 0; row < M; row++) {
			field[row] = br.readLine().toCharArray();
		}
		visited = new boolean[M][N];
		result.put('W', 0);
		result.put('B', 0);
		
		for (int row = 0; row < M; row++) {
			for (int col = 0; col < N; col++) {
				if (!visited[row][col]) {
					bfs(row, col);
				}
			}
		}
		System.out.println(result.get('W')+" "+result.get('B'));
		
	}

	private static void bfs(int row, int col) {
		count = 0;
		int[] currLoc = {row, col};
		
		q.add(currLoc);
		visited[row][col] = true;
		char currSol = field[row][col];
		
		while (!q.isEmpty()) {
			currLoc = q.poll();
			currSol = field[currLoc[0]][currLoc[1]];
			count++;
			
			for (int i = 0; i < 4; i++) {
				nextRow = currLoc[0] + directions[i][0];
				nextCol = currLoc[1] + directions[i][1];
				
				if (nextRow<0 || nextRow>=M || nextCol<0 || nextCol>=N) continue;
				if (visited[nextRow][nextCol]) continue;
				if (field[nextRow][nextCol] != currSol) continue;
				
				q.add(new int[] {nextRow, nextCol});
				visited[nextRow][nextCol] = true;
			}
		}
		
		result.put(currSol, result.get(currSol) + count*count);
	}

}
