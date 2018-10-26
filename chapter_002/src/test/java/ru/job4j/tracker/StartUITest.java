package ru.job4j.tracker;

import org.junit.Test;

import static org.junit.Assert.*;
import static org.hamcrest.core.Is.is;

public class StartUITest {

    @Test
    public void whenUserAddItemThenTrackerHasNewItemWithSameName() {
        Tracker tracker = new Tracker();
        Input input = new StubInput(new String[]{"0", "test name", "desc", "6"});
        new StartUI(input, tracker).init();
        assertThat(tracker.findAll()[0].getName(), is("test name"));
    }

    @Test
    public void showAllAddedItems() {
        Tracker tracker = new Tracker();
        Item item = tracker.add(new Item("first item name", "first item"));
        Item secondItem = tracker.add(new Item("second item name", "second item"));
        Input input = new StubInput(new String[]{item.getName(), item.getDesc(), secondItem.getName(), secondItem.getDesc(),
                "1", "6"});
        new StartUI(input, tracker).init();
        assertThat(tracker.findAll()[0].getName(), is(item.getName()));
        assertThat(tracker.findAll()[1].getName(), is(secondItem.getName()));

    }

    @Test
    public void whenUpdateThenTrackerHasUpdatedValue() {
        Tracker tracker = new Tracker();
        Item item = tracker.add(new Item("test name", "desc"));
        Input input = new StubInput(new String[]{"2", item.getId(), "test replace", "item nas been replaced", "6"});
        new StartUI(input, tracker).init();
        assertThat(tracker.findById(item.getId()).getName(), is("test replace"));
    }

    @Test
    public void deleteItemWhichHasBeenAdded() {
        Tracker tracker = new Tracker();
        Item item = tracker.add(new Item("tests name", "desc"));
        Input input = new StubInput(new String[]{item.getName(), item.getDesc(), "3", item.getId(), "4",
                item.getId(), "6"});
        new StartUI(input, tracker).init();
        assertThat(tracker.findById(item.getId()).getName(), is("null"));
    }

    @Test
    public void findItemByID() {
        Tracker tracker = new Tracker();
        Item item = tracker.add(new Item("test item", "desc"));
        Item secondItem = tracker.add(new Item("second item", "second desc"));
        Item thirdItem = tracker.add(new Item("test item", "third desc"));
        Input input = new StubInput(new String[]{item.getName(), item.getDesc(),
                secondItem.getName(), secondItem.getDesc(), thirdItem.getName(), thirdItem.getDesc(),
                "4", item.getId(), "6"});
        new StartUI(input, tracker).init();
        assertThat(tracker.findById(secondItem.getId()).getId(), is(secondItem.getId()));
    }

    @Test
    public void findItemByName() {
        Tracker tracker = new Tracker();
        Item item = tracker.add(new Item("test item", "desc"));
        Item secondItem = tracker.add(new Item("second item", "second desc"));
        Item thirdItem = tracker.add(new Item("test item", "third desc"));
        Input input = new StubInput(new String[]{item.getName(), item.getDesc(),
                secondItem.getName(), secondItem.getDesc(), thirdItem.getName(), thirdItem.getDesc(),
                "5", item.getName(), "6"});
        Item[] items = new Item[]{item, thirdItem};
        new StartUI(input, tracker).init();
        assertThat(tracker.findByName("test item"), is(items));
    }
}