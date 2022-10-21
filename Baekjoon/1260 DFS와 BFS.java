import java.io.*;
import java.util.*;

public class Main {
	static StringBuilder sb = new StringBuilder();
	static HashMap<Integer, List<Integer>> verticies = new HashMap<>();

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] condition = br.readLine().split(" ");
		int N = Integer.parseInt(condition[0]); //정점 개수
		int M = Integer.parseInt(condition[1]); //간선 개수
		int V = Integer.parseInt(condition[2]); //시작 정점
		
		for (int i = 1; i <= N; i++) {
			verticies.put(i, new ArrayList<>());
		}
		for (int i = 1; i <= M; i++) {
			String[] edges = br.readLine().split(" ");
			int a = Integer.parseInt(edges[0]);
			int b = Integer.parseInt(edges[1]);
			
			verticies.get(a).add(b);
			verticies.get(b).add(a);
		}
		for (int i = 1; i <= N; i++) {
			Collections.sort(verticies.get(i));
		}
		
		dfs(V, new boolean[N+1]);
		sb.append("\n");
		bfs(V, new boolean[N+1]);
		
		System.out.println(sb);
	}
	private static void dfs(int num, boolean[] visited) {
		if (visited[num]) return;
		
		visited[num] = true;
		sb.append(num).append(" ");
		
		List<Integer> adjacencies = verticies.get(num);
		for (int adjacency : adjacencies) {
			dfs(adjacency, visited);
		}
	}
	private static void bfs(int num, boolean[] visited) {
		Queue<Integer> queue = new LinkedList<Integer>();
		queue.add(num);
		visited[num] = true;
		
		while (!queue.isEmpty()) {
			int currNum = queue.poll();
			sb.append(currNum).append(" ");
			
			for (int adjacency : verticies.get(currNum)) {
				if(!visited[adjacency]) {
					visited[adjacency] = true;
					queue.add(adjacency);
				}
			}
		}
	}

}

