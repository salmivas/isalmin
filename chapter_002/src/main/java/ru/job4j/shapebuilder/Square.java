package ru.job4j.shapebuilder;
/**
 * @author Ivan Salmin
 * @version 0.1
 * @since 04.11.2018
 * Class overrides method of superclass so that it may fits to certain shape.
 */
public class Square implements Shape {
    /**
     * @return square
     */
    @Override
    public String draw() {
        StringBuilder pic = new StringBuilder();
        pic.append("****");
        pic.append("*  *");
        pic.append("*  *");
        pic.append("****");
        return pic.toString();
    }
}
