package ru.job4j.shapebuilder;

import org.junit.Test;
import static org.junit.Assert.*;
import static org.hamcrest.core.Is.is;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

/**
 * @author Ivan Salmin
 * @version 0.1
 * @since 04.11.2018
 */
public class PaintTest {
    @Test
    public void whenDrawSquare() {
        PrintStream stdOut = System.out;
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        System.setOut(new PrintStream(out));
        new Paint().draw(new Square());
        assertThat(new String(out.toByteArray()), is(new StringBuilder()
                .append("****")
                .append("*  *")
                .append("*  *")
                .append("****")
                .append(System.lineSeparator())
                .toString()));
        System.setOut(stdOut);
    }

    @Test
    public void whenDrawTriangle() {
        PrintStream stdOut = System.out;
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        System.setOut(new PrintStream(out));
        new Paint().draw(new Triangle());
        assertThat(new String(out.toByteArray()), is(new StringBuilder()
                .append("  *  ")
                .append(" * * ")
                .append("*****")
                .append(System.lineSeparator())
                .toString()));
        System.setOut(stdOut);
    }
}