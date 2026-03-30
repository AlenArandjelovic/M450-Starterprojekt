package ch.wiss.m450.starter_project.model;

import java.time.LocalDateTime;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentCaptor;
import org.mockito.Captor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Spy;

import ch.wiss.m450.starter_project.controller.ItemController;
import ch.wiss.m450.starter_project.repository.ItemRepository;
import ch.wiss.m450.starter_project.service.ItemService;

public class ItemTest {

    @Mock
    private ItemRepository itemRepository;
    @Spy
    private Item spyItem = new Item("SpyItem");
    @InjectMocks
    private ItemController controller;
    @Captor
    private ArgumentCaptor<Item> itemCaptor;

    @Test
    void testCtorWorksAsExpected() {
        // Arrange - Vorbedingungen
        final String name = "wussekutz";

        // Act - Testdurchführung
        Item testee = new Item(name);

        // Assert - Nachbedingungen prüfen
        assertEquals(name,
                testee.getName(),
                "name should be " + name);
    }

    @Test
    void constructorShouldSetName() {
        Item item = new Item("Apple");
        assertEquals("Apple", item.getName());
    }

    @Test
    void setterShouldChangeName() {
        Item item = new Item("OldName");
        item.setName("NewName");
        assertEquals("NewName", item.getName());
    }

    @Test
    void idShouldBeSettableAndGettable() {
        Item item = new Item("TestItem");
        item.setId(42);
        assertEquals(42, item.getId());
    }

    @Test
    void shouldDetectOverdueItem() {
        Item item = new Item("Test");
        item.setDeadline(LocalDateTime.now().minusDays(1));

        assertEquals(true, item.isOverdue());
    }

    @Test
    void shouldSortItemsByDeadline() {
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
void shouldReturnTrueIfDeadlinePassedAndNotClosed() {
    Item item = new Item("Test");
    item.setDeadline(LocalDateTime.now().minusDays(1));
    item.setStatus(ItemStatus.OPEN);

    assertEquals(true, item.isOverdue());
}

@Test
void shouldReturnFalseIfDeadlineInFuture() {
    Item item = new Item("Test");
    item.setDeadline(LocalDateTime.now().plusDays(1));
    item.setStatus(ItemStatus.OPEN);

    assertEquals(false, item.isOverdue());
}

@Test
void shouldReturnFalseIfClosed() {
    Item item = new Item("Test");
    item.setDeadline(LocalDateTime.now().minusDays(1));
    item.setStatus(ItemStatus.CLOSED);

    assertEquals(false, item.isOverdue());
}
}
