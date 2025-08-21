package stats;

import lombok.Data;

@Data
public class LongStatistics {
    private int counter;
    private long max = Long.MIN_VALUE;
    private long min = Long.MAX_VALUE;
    private long sum = 0L;
    private long average = 0L;

    public void addValue(long value) {

    }

}
