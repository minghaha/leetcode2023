/**
 * Created on 2023/3/24.
 *
 * @author lichuanming
 */
import java.time.LocalDateTime;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

public class TimeIntervalSplitter {

    public static void main(String[] args) {
        //LocalDateTime startTime = LocalDateTime.of(2023, 3, 24, 9, 0);
        //LocalDateTime endTime = LocalDateTime.of(2023, 3, 24, 18, 0);
        //Duration interval = Duration.ofMinutes(30);
        //
        //List<LocalDateTime> timeIntervals = splitTimeInterval(startTime, endTime, interval);
        //
        //for (LocalDateTime intervalTime : timeIntervals) {
        //    System.out.println(intervalTime);
        //}

        List<Integer> list = new ArrayList<Integer>();
        list.add(10);
        list.add(20);
        list.add(30);
        list.add(40);

        for (int i = 0 ; i < list.size() ; i++) {
            if(list.get(i) == 20){
                list.remove(i);
            }
        }

        for (Integer integer : list) {
            System.out.println(integer);
        }
    }

    public static List<LocalDateTime> splitTimeInterval(LocalDateTime startTime, LocalDateTime endTime, Duration interval) {
        List<LocalDateTime> timeIntervals = new ArrayList<>();

        for (LocalDateTime currentTime = startTime; currentTime.isBefore(endTime); currentTime = currentTime.plus(interval)) {
            timeIntervals.add(currentTime);
        }

        return timeIntervals;
    }
}
