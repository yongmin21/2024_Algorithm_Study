import java.util.Arrays;

public class Solution {

    public static int solution(int[] priorities, int location) {
        int[] answer = new int[priorities.length];
        Arrays.fill(answer, -1); // 초기값 -1로 설정

        int cnt = 1;
        int len = priorities.length;
        int ind = 0;

        while (answer[location] == -1) {
            // 최대값을 계산
            int max = Integer.MIN_VALUE;
            for (int num : priorities) {
                if (num > max) {
                    max = num;
                }
            }

            // 현재 문서가 최대 우선순위인 경우
            if (priorities[ind] == max) {
                answer[ind] = cnt;
                cnt++;
                priorities[ind] = -1; // 처리된 문서는 우선순위를 -1로 변경
            }

            ind++;
            ind %= len; // 인덱스를 배열 길이로 순환
        }

        return answer[location];
    }
}
