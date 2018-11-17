package ru.job4j.shapebuilder;

/**
 * @author Ivan Salmin
 * @version 0.1
 * @since 04.11.2018
 * Program dynamically creates new shape depending on required shape.
 */
public class Paint {
    public void draw(Shape shape) {
        System.out.println(shape.draw());
    }
}
