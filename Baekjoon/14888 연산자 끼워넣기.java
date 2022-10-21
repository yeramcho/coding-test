import java.io.*;
import java.util.*;

public class Main {
	static int N, max = Integer.MIN_VALUE, min = Integer.MAX_VALUE;
	static int[] nums, oper;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		nums = new int[N];
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			nums[i] = Integer.parseInt(st.nextToken());
		}
		
		oper = new int[4];
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < 4; i++) {
			oper[i] = Integer.parseInt(st.nextToken());
		}
		
		findAll(1, nums[0]);
		
		System.out.println(max);
		System.out.println(min);
	}

	private static void findAll(int idx, int result) {
		if (idx == nums.length) {
			max = Math.max(max, result);
			min = Math.min(min, result);
			return;
		}
		if (oper[0] > 0) {
			oper[0]--;
			findAll(idx + 1, result + nums[idx]);
			oper[0]++;
		}
		if (oper[1] > 0) {
			oper[1]--;
			findAll(idx + 1, result - nums[idx]);
			oper[1]++;
		}
		if (oper[2] > 0) {
			oper[2]--;
			findAll(idx + 1, result * nums[idx]);
			oper[2]++;
		}
		if (oper[3] > 0) {
			oper[3]--;
			findAll(idx + 1, result / nums[idx]);
			oper[3]++;
		}
	}

}
