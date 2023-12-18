package interviewquestions.calculatesalary;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class TimeClockService {

    private TimeClockService() {
        throw  new AssertionError("Utility classes should not be instantiated");
    }
    public static List<TimeClockEntity> getData() {
        List<TimeClockEntity> list = new ArrayList<>();
        double hourlyRate = 10;

        // Allen works 15 days with varying hours
        list.add(new TimeClockEntity("Allen", LocalDateTime.of(2023, 9, 1, 9, 0), LocalDateTime.of(2023, 9, 1, 17, 30), hourlyRate));
        list.add(new TimeClockEntity("Allen", LocalDateTime.of(2023, 9, 4, 10, 0), LocalDateTime.of(2023, 9, 4, 18, 0), hourlyRate));
        list.add(new TimeClockEntity("Allen", LocalDateTime.of(2023, 9, 6, 9, 30), LocalDateTime.of(2023, 9, 6, 17, 30), hourlyRate));
        list.add(new TimeClockEntity("Allen", LocalDateTime.of(2023, 9, 7, 8, 30), LocalDateTime.of(2023, 9, 7, 20, 30), hourlyRate));
        list.add(new TimeClockEntity("Allen", LocalDateTime.of(2023, 9, 8, 9, 30), LocalDateTime.of(2023, 9, 8, 17, 30), hourlyRate));
        list.add(new TimeClockEntity("Allen", LocalDateTime.of(2023, 9, 11, 9, 30), LocalDateTime.of(2023, 9, 11, 17, 30), hourlyRate));
        list.add(new TimeClockEntity("Allen", LocalDateTime.of(2023, 9, 5, 9, 30), LocalDateTime.of(2023, 9, 5, 17, 30), hourlyRate));
        list.add(new TimeClockEntity("Allen", LocalDateTime.of(2023, 9, 12, 9, 30), LocalDateTime.of(2023, 9, 12, 17, 30), hourlyRate));
        list.add(new TimeClockEntity("Allen", LocalDateTime.of(2023, 9, 13, 9, 30), LocalDateTime.of(2023, 9, 13, 17, 30), hourlyRate));
        list.add(new TimeClockEntity("Allen", LocalDateTime.of(2023, 9, 14, 7, 30), LocalDateTime.of(2023, 9, 14, 17, 30), hourlyRate));
        list.add(new TimeClockEntity("Allen", LocalDateTime.of(2023, 9, 15, 9, 30), LocalDateTime.of(2023, 9, 15, 17, 30), hourlyRate));
        list.add(new TimeClockEntity("Allen", LocalDateTime.of(2023, 9, 18, 9, 30), LocalDateTime.of(2023, 9, 18, 19, 30), hourlyRate));
        list.add(new TimeClockEntity("Allen", LocalDateTime.of(2023, 9, 19, 9, 30), LocalDateTime.of(2023, 9, 19, 17, 30), hourlyRate));
        list.add(new TimeClockEntity("Allen", LocalDateTime.of(2023, 9, 20, 9, 30), LocalDateTime.of(2023, 9, 20, 17, 30), hourlyRate));
        list.add(new TimeClockEntity("Allen", LocalDateTime.of(2023, 9, 21, 9, 30), LocalDateTime.of(2023, 9, 21, 17, 30), hourlyRate));

        list.add(new TimeClockEntity("Allen", LocalDateTime.of(2023, 10, 1, 9, 0), LocalDateTime.of(2023, 10, 1, 17, 30), hourlyRate));
        list.add(new TimeClockEntity("Allen", LocalDateTime.of(2023, 10, 4, 10, 0), LocalDateTime.of(2023, 10, 4, 18, 0), hourlyRate));
        list.add(new TimeClockEntity("Allen", LocalDateTime.of(2023, 10, 6, 9, 30), LocalDateTime.of(2023, 10, 6, 17, 30), hourlyRate));
        list.add(new TimeClockEntity("Allen", LocalDateTime.of(2023, 10, 7, 8, 30), LocalDateTime.of(2023, 10, 7, 20, 30), hourlyRate));
        list.add(new TimeClockEntity("Allen", LocalDateTime.of(2023, 10, 8, 9, 30), LocalDateTime.of(2023, 10, 8, 17, 30), hourlyRate));
        list.add(new TimeClockEntity("Allen", LocalDateTime.of(2023, 10, 11, 9, 30), LocalDateTime.of(2023, 10, 11, 17, 0), hourlyRate));
        list.add(new TimeClockEntity("Allen", LocalDateTime.of(2023, 10, 5, 9, 30), LocalDateTime.of(2023, 10, 5, 17, 30), hourlyRate));
        list.add(new TimeClockEntity("Allen", LocalDateTime.of(2023, 10, 12, 9, 30), LocalDateTime.of(2023, 10, 12, 17, 30), hourlyRate));
        list.add(new TimeClockEntity("Allen", LocalDateTime.of(2023, 10, 13, 9, 30), LocalDateTime.of(2023, 10, 13, 17, 30), hourlyRate));
        list.add(new TimeClockEntity("Allen", LocalDateTime.of(2023, 10, 14, 7, 30), LocalDateTime.of(2023, 10, 14, 19, 30), hourlyRate));
        list.add(new TimeClockEntity("Allen", LocalDateTime.of(2023, 10, 15, 9, 30), LocalDateTime.of(2023, 10, 15, 17, 30), hourlyRate));
        list.add(new TimeClockEntity("Allen", LocalDateTime.of(2023, 10, 18, 9, 30), LocalDateTime.of(2023, 10, 18, 19, 30), hourlyRate));
        list.add(new TimeClockEntity("Allen", LocalDateTime.of(2023, 10, 19, 9, 30), LocalDateTime.of(2023, 10, 19, 17, 30), hourlyRate));
        list.add(new TimeClockEntity("Allen", LocalDateTime.of(2023, 10, 20, 9, 30), LocalDateTime.of(2023, 10, 20, 18, 30), hourlyRate));
        list.add(new TimeClockEntity("Allen", LocalDateTime.of(2023, 10, 21, 9, 30), LocalDateTime.of(2023, 10, 21, 17, 30), hourlyRate));

        list.add(new TimeClockEntity("Allen", LocalDateTime.of(2022, 9, 1, 9, 0), LocalDateTime.of(2022, 9, 1, 17, 30), hourlyRate));
        list.add(new TimeClockEntity("Allen", LocalDateTime.of(2022, 9, 4, 10, 0), LocalDateTime.of(2022, 9, 4, 19, 0), hourlyRate));
        list.add(new TimeClockEntity("Allen", LocalDateTime.of(2022, 9, 6, 9, 30), LocalDateTime.of(2022, 9, 6, 17, 30), hourlyRate));
        list.add(new TimeClockEntity("Allen", LocalDateTime.of(2022, 9, 7, 8, 30), LocalDateTime.of(2022, 9, 7, 20, 30), hourlyRate));
        list.add(new TimeClockEntity("Allen", LocalDateTime.of(2022, 9, 8, 9, 30), LocalDateTime.of(2022, 9, 8, 17, 30), hourlyRate));
        list.add(new TimeClockEntity("Allen", LocalDateTime.of(2022, 9, 11, 9, 30), LocalDateTime.of(2022, 9, 11, 17, 0), hourlyRate));
        list.add(new TimeClockEntity("Allen", LocalDateTime.of(2022, 9, 5, 9, 30), LocalDateTime.of(2022, 9, 5, 17, 30), hourlyRate));
        list.add(new TimeClockEntity("Allen", LocalDateTime.of(2022, 9, 12, 9, 0), LocalDateTime.of(2022, 9, 12, 17, 30), hourlyRate));
        list.add(new TimeClockEntity("Allen", LocalDateTime.of(2022, 9, 13, 9, 30), LocalDateTime.of(2022, 9, 13, 17, 30), hourlyRate));
        list.add(new TimeClockEntity("Allen", LocalDateTime.of(2022, 9, 14, 7, 30), LocalDateTime.of(2022, 9, 14, 19, 30), hourlyRate));
        list.add(new TimeClockEntity("Allen", LocalDateTime.of(2022, 9, 15, 9, 30), LocalDateTime.of(2022, 9, 15, 17, 30), hourlyRate));
        list.add(new TimeClockEntity("Allen", LocalDateTime.of(2022, 9, 18, 9, 30), LocalDateTime.of(2022, 9, 18, 19, 30), hourlyRate));
        list.add(new TimeClockEntity("Allen", LocalDateTime.of(2022, 9, 19, 9, 30), LocalDateTime.of(2022, 9, 19, 17, 30), hourlyRate));
        list.add(new TimeClockEntity("Allen", LocalDateTime.of(2022, 9, 20, 9, 30), LocalDateTime.of(2022, 9, 20, 18, 30), hourlyRate));
        list.add(new TimeClockEntity("Allen", LocalDateTime.of(2022, 9, 21, 9, 0), LocalDateTime.of(2022, 9, 21, 18, 30), hourlyRate));

        list.add(new TimeClockEntity("Allen", LocalDateTime.of(2022, 10, 1, 9, 0), LocalDateTime.of(2022, 10, 1, 17, 30), hourlyRate));
        list.add(new TimeClockEntity("Allen", LocalDateTime.of(2022, 10, 4, 10, 0), LocalDateTime.of(2022, 10, 4, 18, 0), hourlyRate));
        list.add(new TimeClockEntity("Allen", LocalDateTime.of(2022, 10, 6, 9, 30), LocalDateTime.of(2022, 10, 6, 17, 30), hourlyRate));
        list.add(new TimeClockEntity("Allen", LocalDateTime.of(2022, 10, 7, 8, 30), LocalDateTime.of(2022, 10, 7, 20, 30), hourlyRate));
        list.add(new TimeClockEntity("Allen", LocalDateTime.of(2022, 10, 8, 9, 30), LocalDateTime.of(2022, 10, 8, 17, 30), hourlyRate));
        list.add(new TimeClockEntity("Allen", LocalDateTime.of(2022, 10, 11, 9, 30), LocalDateTime.of(2022, 10, 11, 17, 0), hourlyRate));
        list.add(new TimeClockEntity("Allen", LocalDateTime.of(2022, 10, 5, 9, 30), LocalDateTime.of(2022, 10, 5, 18, 30), hourlyRate));
        list.add(new TimeClockEntity("Allen", LocalDateTime.of(2022, 10, 12, 9, 30), LocalDateTime.of(2022, 10, 12, 17, 30), hourlyRate));
        list.add(new TimeClockEntity("Allen", LocalDateTime.of(2022, 10, 13, 9, 30), LocalDateTime.of(2022, 10, 13, 17, 30), hourlyRate));
        list.add(new TimeClockEntity("Allen", LocalDateTime.of(2022, 10, 14, 9, 30), LocalDateTime.of(2022, 10, 14, 20, 30), hourlyRate));
        list.add(new TimeClockEntity("Allen", LocalDateTime.of(2022, 10, 15, 9, 30), LocalDateTime.of(2022, 10, 15, 17, 30), hourlyRate));
        list.add(new TimeClockEntity("Allen", LocalDateTime.of(2022, 10, 18, 9, 30), LocalDateTime.of(2022, 10, 18, 19, 30), hourlyRate));
        list.add(new TimeClockEntity("Allen", LocalDateTime.of(2022, 10, 19, 9, 30), LocalDateTime.of(2022, 10, 19, 17, 30), hourlyRate));
        list.add(new TimeClockEntity("Allen", LocalDateTime.of(2022, 10, 20, 9, 30), LocalDateTime.of(2022, 10, 20, 18, 30), hourlyRate));
        list.add(new TimeClockEntity("Allen", LocalDateTime.of(2022, 10, 21, 9, 30), LocalDateTime.of(2022, 10, 21, 18, 0), hourlyRate));
        // Edward works 15 days with varying hours
        list.add(new TimeClockEntity("Edward", LocalDateTime.of(2023, 9, 1, 9, 0), LocalDateTime.of(2023, 9, 1, 17, 30), hourlyRate));
        list.add(new TimeClockEntity("Edward", LocalDateTime.of(2023, 9, 4, 10, 0), LocalDateTime.of(2023, 9, 4, 18, 0), hourlyRate));
        list.add(new TimeClockEntity("Edward", LocalDateTime.of(2023, 9, 6, 9, 30), LocalDateTime.of(2023, 9, 6, 17, 30), hourlyRate));
        list.add(new TimeClockEntity("Edward", LocalDateTime.of(2023, 9, 7, 8, 30), LocalDateTime.of(2023, 9, 7, 20, 30), hourlyRate));
        list.add(new TimeClockEntity("Edward", LocalDateTime.of(2023, 9, 8, 9, 30), LocalDateTime.of(2023, 9, 8, 17, 30), hourlyRate));
        list.add(new TimeClockEntity("Edward", LocalDateTime.of(2023, 9, 11, 9, 30), LocalDateTime.of(2023, 9, 11, 17, 0), hourlyRate));
        list.add(new TimeClockEntity("Edward", LocalDateTime.of(2023, 9, 5, 9, 30), LocalDateTime.of(2023, 9, 5, 17, 30), hourlyRate));
        list.add(new TimeClockEntity("Edward", LocalDateTime.of(2023, 9, 12, 9, 30), LocalDateTime.of(2023, 9, 12, 17, 30), hourlyRate));
        list.add(new TimeClockEntity("Edward", LocalDateTime.of(2023, 9, 13, 9, 30), LocalDateTime.of(2023, 9, 13, 17, 30), hourlyRate));
        list.add(new TimeClockEntity("Edward", LocalDateTime.of(2023, 9, 14, 7, 30), LocalDateTime.of(2023, 9, 14, 19, 30), hourlyRate));
        list.add(new TimeClockEntity("Edward", LocalDateTime.of(2023, 9, 15, 9, 30), LocalDateTime.of(2023, 9, 15, 17, 30), hourlyRate));
        list.add(new TimeClockEntity("Edward", LocalDateTime.of(2023, 9, 18, 9, 30), LocalDateTime.of(2023, 9, 18, 19, 30), hourlyRate));
        list.add(new TimeClockEntity("Edward", LocalDateTime.of(2023, 9, 19, 9, 30), LocalDateTime.of(2023, 9, 19, 17, 30), hourlyRate));
        list.add(new TimeClockEntity("Edward", LocalDateTime.of(2023, 9, 20, 9, 30), LocalDateTime.of(2023, 9, 20, 18, 30), hourlyRate));
        list.add(new TimeClockEntity("Edward", LocalDateTime.of(2023, 9, 21, 9, 30), LocalDateTime.of(2023, 9, 21, 17, 30), hourlyRate));

        // Ruby works 15 days with varying hours
        list.add(new TimeClockEntity("Ruby", LocalDateTime.of(2023, 9, 1, 9, 0), LocalDateTime.of(2023, 9, 1, 17, 30), hourlyRate));
        list.add(new TimeClockEntity("Ruby", LocalDateTime.of(2023, 9, 4, 10, 0), LocalDateTime.of(2023, 9, 4, 19, 0), hourlyRate));
        list.add(new TimeClockEntity("Ruby", LocalDateTime.of(2023, 9, 6, 9, 30), LocalDateTime.of(2023, 9, 6, 17, 30), hourlyRate));
        list.add(new TimeClockEntity("Ruby", LocalDateTime.of(2023, 9, 7, 8, 30), LocalDateTime.of(2023, 9, 7, 20, 30), hourlyRate));
        list.add(new TimeClockEntity("Ruby", LocalDateTime.of(2023, 9, 8, 9, 30), LocalDateTime.of(2023, 9, 8, 17, 30), hourlyRate));
        list.add(new TimeClockEntity("Ruby", LocalDateTime.of(2023, 9, 11, 9, 30), LocalDateTime.of(2023, 9, 11, 17, 0), hourlyRate));
        list.add(new TimeClockEntity("Ruby", LocalDateTime.of(2023, 9, 5, 9, 30), LocalDateTime.of(2023, 9, 5, 17, 30), hourlyRate));
        list.add(new TimeClockEntity("Ruby", LocalDateTime.of(2023, 9, 12, 9, 0), LocalDateTime.of(2023, 9, 12, 17, 30), hourlyRate));
        list.add(new TimeClockEntity("Ruby", LocalDateTime.of(2023, 9, 13, 9, 30), LocalDateTime.of(2023, 9, 13, 17, 30), hourlyRate));
        list.add(new TimeClockEntity("Ruby", LocalDateTime.of(2023, 9, 14, 7, 30), LocalDateTime.of(2023, 9, 14, 19, 30), hourlyRate));
        list.add(new TimeClockEntity("Ruby", LocalDateTime.of(2023, 9, 15, 9, 30), LocalDateTime.of(2023, 9, 15, 17, 30), hourlyRate));
        list.add(new TimeClockEntity("Ruby", LocalDateTime.of(2023, 9, 18, 9, 30), LocalDateTime.of(2023, 9, 18, 19, 30), hourlyRate));
        list.add(new TimeClockEntity("Ruby", LocalDateTime.of(2023, 9, 19, 9, 30), LocalDateTime.of(2023, 9, 19, 17, 30), hourlyRate));
        list.add(new TimeClockEntity("Ruby", LocalDateTime.of(2023, 9, 20, 9, 30), LocalDateTime.of(2023, 9, 20, 18, 30), hourlyRate));
        list.add(new TimeClockEntity("Ruby", LocalDateTime.of(2023, 9, 21, 9, 0), LocalDateTime.of(2023, 9, 21, 18, 30), hourlyRate));

        // Edward works 15 days with varying hours
        list.add(new TimeClockEntity("Peter", LocalDateTime.of(2023, 9, 1, 9, 0), LocalDateTime.of(2023, 9, 1, 17, 30), hourlyRate));
        list.add(new TimeClockEntity("Peter", LocalDateTime.of(2023, 9, 4, 10, 0), LocalDateTime.of(2023, 9, 4, 18, 0), hourlyRate));
        list.add(new TimeClockEntity("Peter", LocalDateTime.of(2023, 9, 6, 9, 30), LocalDateTime.of(2023, 9, 6, 17, 30), hourlyRate));
        list.add(new TimeClockEntity("Peter", LocalDateTime.of(2023, 9, 7, 8, 30), LocalDateTime.of(2023, 9, 7, 20, 30), hourlyRate));
        list.add(new TimeClockEntity("Peter", LocalDateTime.of(2023, 9, 8, 9, 30), LocalDateTime.of(2023, 9, 8, 17, 30), hourlyRate));
        list.add(new TimeClockEntity("Peter", LocalDateTime.of(2023, 9, 11, 9, 30), LocalDateTime.of(2023, 9, 11, 17, 0), hourlyRate));
        list.add(new TimeClockEntity("Peter", LocalDateTime.of(2023, 9, 5, 9, 30), LocalDateTime.of(2023, 9, 5, 18, 30), hourlyRate));
        list.add(new TimeClockEntity("Peter", LocalDateTime.of(2023, 9, 12, 9, 30), LocalDateTime.of(2023, 9, 12, 17, 30), hourlyRate));
        list.add(new TimeClockEntity("Peter", LocalDateTime.of(2023, 9, 13, 9, 30), LocalDateTime.of(2023, 9, 13, 17, 30), hourlyRate));
        list.add(new TimeClockEntity("Peter", LocalDateTime.of(2023, 9, 14, 9, 30), LocalDateTime.of(2023, 9, 14, 20, 30), hourlyRate));
        list.add(new TimeClockEntity("Peter", LocalDateTime.of(2023, 9, 15, 9, 30), LocalDateTime.of(2023, 9, 15, 17, 30), hourlyRate));
        list.add(new TimeClockEntity("Peter", LocalDateTime.of(2023, 9, 18, 9, 30), LocalDateTime.of(2023, 9, 18, 19, 30), hourlyRate));
        list.add(new TimeClockEntity("Peter", LocalDateTime.of(2023, 9, 19, 9, 30), LocalDateTime.of(2023, 9, 19, 17, 30), hourlyRate));
        list.add(new TimeClockEntity("Peter", LocalDateTime.of(2023, 9, 20, 9, 30), LocalDateTime.of(2023, 9, 20, 18, 30), hourlyRate));
        list.add(new TimeClockEntity("Peter", LocalDateTime.of(2023, 9, 21, 9, 30), LocalDateTime.of(2023, 9, 21, 18, 0), hourlyRate));


        return list;
    }
}
