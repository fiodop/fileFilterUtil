package stats;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class StringStatisticsTest {
    @Test
    void testAddValueUpdatesCounterAndSizes() {
        StringStatistics stats = new StringStatistics();

        stats.addValue("a");
        stats.addValue("hello");
        stats.addValue("hi");

        assertEquals(3, stats.getCounter());

        assertEquals(5, stats.getMaxSize());

        assertEquals(1, stats.getMinSize());
    }
}
