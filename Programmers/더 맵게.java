public static int solution(int[] scoville, int K) {
		PriorityQueue<Integer> pq = new PriorityQueue<>();
		
		for (int i = 0; i < scoville.length; i++) {
			pq.add(scoville[i]);
		}
		
		int count = 0;
		
		while (pq.size() > 1 && pq.peek() < K) {
			int firstFood = pq.poll();
			int secondFood = pq.poll();
			int newFood = firstFood + (secondFood * 2);
			pq.add(newFood);
			count++;
		}
		
		if (pq.peek() < K) count = -1;
		
    return count;
}