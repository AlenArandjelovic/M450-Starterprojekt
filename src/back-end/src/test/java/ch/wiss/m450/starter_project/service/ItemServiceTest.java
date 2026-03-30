package ch.wiss.m450.starter_project.service;

import java.time.LocalDateTime;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

import ch.wiss.m450.starter_project.model.Item;

public class ItemServiceTest {

    @Test
    void shouldSortItemsByEarliestDeadline() {
        Item item1 = new Item("Late");
        item1.setDeadline(LocalDateTime.now().plusDays(5));

        Item item2 = new Item("Soon");
        item2.setDeadline(LocalDateTime.now().plusDays(1));

        List<Item> items = List.of(item1, item2);

        ItemService service = new ItemService();
        List<Item> sorted = service.sortItems(items);

        assertEquals("Soon", sorted.get(0).getName());
    }

    @Test
    void shouldHandleNullDeadlines() {
        Item item1 = new Item("No deadline");

        Item item2 = new Item("With deadline");
        item2.setDeadline(LocalDateTime.now());

        List<Item> items = List.of(item1, item2);

        ItemService service = new ItemService();
        List<Item> sorted = service.sortItems(items);

        assertEquals("With deadline", sorted.get(0).getName());
    }

    @Test
    void shouldKeepOrderIfDeadlinesEqual() {
        LocalDateTime now = LocalDateTime.now();

        Item item1 = new Item("A");
        item1.setDeadline(now);

        Item item2 = new Item("B");
        item2.setDeadline(now);

        List<Item> items = List.of(item1, item2);

        ItemService service = new ItemService();
        List<Item> sorted = service.sortItems(items);

        assertEquals("A", sorted.get(0).getName());
    }

    @Test
    void shouldReturnEmptyListIfNoItems() {
        ItemService service = new ItemService();
        List<Item> sorted = service.sortItems(List.of());

        assertEquals(0, sorted.size());
    }
}