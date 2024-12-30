import java.util.PriorityQueue;

public class Solution {
    public static int solution(int[] scoville, int K) {
        int count = 0;
        PriorityQueue<Integer> heap = new PriorityQueue<>();
        
        // 배열을 PriorityQueue로 변환
        for (int s : scoville) {
            heap.add(s);
        }
        
        while (heap.size() > 1) {
            // 가장 작은 두 값을 꺼냄
            int first = heap.poll();
            int second = heap.poll();
            
            // 가장 작은 값이 K 이상이면 종료
            if (first >= K) {
                return count;
            }
            
            // 스코빌 지수 계산
            int newScoville = first + second * 2;
            heap.add(newScoville);
            count++;
        }
        
        // 모든 값 확인 후 조건 만족 여부 반환
        return heap.peek() >= K ? count : -1;
    }
}
