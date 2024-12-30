import java.util.*;

public class Solution {
    public int solution(int[][] jobs) {
        // jobs를 요청 시간 기준으로 정렬
        Arrays.sort(jobs, Comparator.comparingInt(o -> o[0]));

        int currentTime = 0; // 현재 시간
        int sumTime = 0; // 작업의 총 소요 시간
        int n = jobs.length; // 작업 개수
        int i = 0; // 작업 배열 인덱스
        PriorityQueue<int[]> heap = new PriorityQueue<>(Comparator.comparingInt(o -> o[0])); // 최소 힙

        while (i < n || !heap.isEmpty()) {
            // 현재 시간 이전에 도착한 작업들을 힙에 추가
            while (i < n && jobs[i][0] <= currentTime) {
                heap.add(new int[]{jobs[i][1], jobs[i][0]}); // [소요 시간, 시작 시간]
                i++;
            }

            if (!heap.isEmpty()) {
                // 힙에서 가장 짧은 소요 시간을 가진 작업 선택
                int[] job = heap.poll();
                int duration = job[0];
                int start = job[1];
                sumTime += duration + currentTime - start;
                currentTime += duration;
            } else {
                // 힙이 비어 있으면 현재 시간을 다음 작업의 시작 시간으로 설정
                currentTime = jobs[i][0];
            }
        }

        return sumTime / n;
    }
}