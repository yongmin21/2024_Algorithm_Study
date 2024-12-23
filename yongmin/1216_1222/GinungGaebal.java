import java.util.*;

class Solution {
    public int[] solution(int[] progresses, int[] speeds) {
        Deque<Integer> days = new LinkedList<>();
        List<Integer> answer = new ArrayList<>();
        
        // 각 작업의 완료 일수를 계산하여 Deque에 추가
        for (int i = 0; i < progresses.length; i++) {
            int remainingWork = 100 - progresses[i];
            int day = (int) Math.ceil((double) remainingWork / speeds[i]);
            days.offerLast(day);
        }

        int can = 0;
        while (!days.isEmpty()) {
            int day = days.pollFirst(); // 첫 번째 기능의 완료 일수
            if (day > can) {
                answer.add(1); // 새로운 배포 그룹
                can = day; // 현재 배포 기준 일수 업데이트
            } else {
                // 같은 배포 그룹에 포함
                int lastIndex = answer.size() - 1;
                answer.set(lastIndex, answer.get(lastIndex) + 1);
            }
        }
        return answer;
    }
}

