package ru.job4j.shapebuilder;

import org.junit.Test;
import static org.junit.Assert.*;
import static org.hamcrest.core.Is.is;

/**
 * @author Ivan Salmin
 * @version 0.1
 * @since 04.11.2018
 */
public class TriangleTest {
    @Test
    public void whenTriangleThenTrue() {
        Triangle triangle = new Triangle();
        String triangleString = triangle.draw();
        assertThat(triangleString, is("  *   * * *****"));
    }

}