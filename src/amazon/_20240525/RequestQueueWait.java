package amazon._20240525;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

public class RequestQueueWait {

    public List<Integer> findRequestsInQueue(List<Integer> waitTimes) {
        List<Integer> ans = new ArrayList<>();

        Queue<Integer> firstQ = new ArrayDeque<>(waitTimes);
        Queue<Integer> secondQ = new ArrayDeque<>();

        int requests = waitTimes.size();
        ans.add(requests);

        while (requests > 0) {
            firstQ.poll(); // first item has been processed after 1 sec
            --requests;

            while (!firstQ.isEmpty()) {
                int waitTime = firstQ.poll()-1; // waitTime is one second less
                if (waitTime > 0) {
                    secondQ.add(waitTime);
                } else {
                    --requests;
                }
            }
            ans.add(requests);

            Queue tempQ = firstQ;
            firstQ = secondQ;
            secondQ = tempQ;
        }       


        return ans;
    }

    public static void main(String[] args) {
        RequestQueueWait app = new RequestQueueWait();
        System.out.println(app.findRequestsInQueue(List.of(4,1,1,2,4,3)));
        System.out.println(app.findRequestsInQueue(List.of(2,2,3,1)));
    }
}
