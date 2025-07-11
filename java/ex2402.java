import java.util.Arrays;
import java.util.PriorityQueue;

// test
class Room {
    int startingTime;
    int endingTime;
    int index;
    public Room(int startingTime, int endingTime, int index){
        this.startingTime = startingTime;
        this.endingTime = endingTime;
        this.index = index;
    }
}

class ex2402 {
    public int mostBooked(int n, int[][] meetings) {
        Arrays.sort(meetings, (a,b) -> {
            if (a[0] != b[0]) return a[0] - b[0];
            else return a[1] - b[1];
        });
        int[] timesUsed = new int[n];
        PriorityQueue<Room> pq = new PriorityQueue<>((a, b) -> {
            if (a.endingTime != b.endingTime) return a.endingTime - b.endingTime;
            else return a.index - b.index;
        });
        PriorityQueue<Integer> avaiableRooms = new PriorityQueue<>((a,b) -> a-b);
        for (int i=0;i<n;i++){
            avaiableRooms.offer(i);
        }
        for (int[] meeting : meetings){
            int currentStart = meeting[0];
            int currentEnd = meeting[1];
            int timeSpent = currentEnd - currentStart;
            while (!pq.isEmpty() && pq.peek().endingTime <= currentStart) {
                Room r = pq.poll();
                avaiableRooms.offer(r.index);
            }
            if (!avaiableRooms.isEmpty()) {
                int roomToUse = avaiableRooms.poll();
                pq.offer(new Room(currentStart,currentEnd,roomToUse));
                timesUsed[roomToUse]++;
            }
            else{
                Room r = pq.poll();
                int earliestEnd = r.endingTime;
                int indexRoom = r.index;
                int newEnding = earliestEnd + timeSpent;
                pq.offer(new Room(earliestEnd, newEnding, indexRoom));
                timesUsed[indexRoom]++;
            }
        }
        int max = 0;
        int room =  -1;
        for (int i=0;i<n;i++){
            if (timesUsed[i] > max){
                max = timesUsed[i];
                room = i;
            }
        }
        return room;
    }
    public static void main(String[] args) {
        int[][] meetings = {{1,20},{2,10},{3,5},{4,9},{6,8}};
        ex2402 solution = new ex2402();
        int result = solution.mostBooked(3, meetings);
    }
}