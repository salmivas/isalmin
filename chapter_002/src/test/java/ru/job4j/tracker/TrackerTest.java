package ru.job4j.tracker;

import org.junit.Test;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class TrackerTest {

    @Test
    public void whenReplaceNameThenReturnName() {
        Tracker tracker = new Tracker();
        Item previous = new Item("test1","testDescription",123L);
        tracker.add(previous);
        Item next = new Item("test2", "TestDescription2", 1234L);
        next.setId(previous.getId());
        tracker.replace(previous.getId(), next);
        assertThat(tracker.findById(previous.getId()).getName(), is("test2"));
    }

    @Test
    public void deleteItem() {
        Tracker tracker = new Tracker();
        Item firstItem = new Item("test1","testDescription",123L);
        Item secondItem = new Item("test2", "TestDescription2", 1234L);
        Item thirdItem = new Item("test3", "TestDescription3", 12345L);
        tracker.add(firstItem);
        tracker.add(secondItem);
        tracker.add(thirdItem);
        tracker.delete(secondItem.getId());
        assertThat(tracker.findById(thirdItem.getId()), is(thirdItem));
    }

    @Test
    public void findNameByKey() {
        Tracker tracker = new Tracker();
        Item firstItem = new Item("test1","testDescription",123L);
        Item secondItem = new Item("test2", "TestDescription2", 1234L);
        Item thirdItem = new Item("test3", "TestDescription3", 12345L);
        tracker.add(firstItem);
        tracker.add(secondItem);
        tracker.add(thirdItem);
        assertThat(tracker.findByName(thirdItem.getName()), is(thirdItem));
    }

    @Test
    public void findNameById() {
        Tracker tracker = new Tracker();
        Item firstItem = new Item("test1","testDescription",123L);
        Item secondItem = new Item("test2", "TestDescription2", 1234L);
        Item thirdItem = new Item("test3", "TestDescription3", 12345L);
        tracker.add(firstItem);
        tracker.add(secondItem);
        tracker.add(thirdItem);
        assertThat(tracker.findById(thirdItem.getId()), is(thirdItem));
    }
}
