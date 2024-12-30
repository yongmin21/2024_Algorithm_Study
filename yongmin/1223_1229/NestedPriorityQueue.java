import java.util.Collections;
import java.util.PriorityQueue;

public class Solution {
    public int[] solution(String[] operations) {
        PriorityQueue<Integer> minQueue = new PriorityQueue();
        PriorityQueue<Integer> maxQueue = new PriorityQueue(Collections.reverseOrder());

        for (String operation : operations) {
            String[] parts = operation.split(" ");
            String command = parts[0];
            int value = parts.length > 1 ? Integer.parseInt(parts[1]) : 0;

            if (command.equals("I")) {
                minQueue.add(value);
                maxQueue.add(value);
            } else{
                if (!minQueue.isEmpty()) {
                    if (value == 1) {
                        // Remove max value
                        int max = maxQueue.poll();
                        minQueue.remove(max);
                    } else if (value == -1) {
                        // Remove min value
                        int min = minQueue.poll();
                        maxQueue.remove(min);
                    }
                }
            }
        }

        if (minQueue.isEmpty()) {
            return new int[]{0, 0};
        } else {
            return new int[]{maxQueue.peek(), minQueue.peek()};
        }
    }
}

// import java.util.ArrayList;
// import java.util.Collections;
// import java.util.List;

// public class Solution {
//     public int[] solution(String[] operations) {
//         List<Integer> queue = new ArrayList<>();

//         for (String o : operations) {
//             if (o.startsWith("I")) {
//                 int value = Integer.parseInt(o.split(" ")[1]);
//                 queue.add(value);
//             }

//             if (queue.isEmpty()) {
//                 continue;
//             }

//             if (o.equals("D -1")) {
//                 // 최소값 삭제
//                 queue.remove(Collections.min(queue));
//             }

//             if (o.equals("D 1")) {
//                 // 최대값 삭제
//                 queue.remove(Collections.max(queue));
//             }
//         }

//         if (queue.isEmpty()) {
//             return new int[]{0, 0};
//         } else {
//             return new int[]{Collections.max(queue), Collections.min(queue)};
//         }
//     }
// }