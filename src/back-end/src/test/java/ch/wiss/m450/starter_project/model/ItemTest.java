package ch.wiss.m450.starter_project.model;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentCaptor;
import org.mockito.Captor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Spy;

import ch.wiss.m450.starter_project.controller.ItemController;
import ch.wiss.m450.starter_project.repository.ItemRepository;

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
}
