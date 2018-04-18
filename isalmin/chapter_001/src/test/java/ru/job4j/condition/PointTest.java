package ru.job4j.condition;

import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class PointTest {

    @Test
    public void whenThen() {
        Point a = new Point(0, 1);
        Point b = new Point(2, 5);
        double result = b.distanceTo(a);
        assertThat(result, is(4.47213595499958));
    }
}
