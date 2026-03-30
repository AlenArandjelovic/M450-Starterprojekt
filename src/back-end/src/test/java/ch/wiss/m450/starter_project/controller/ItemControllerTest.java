package ch.wiss.m450.starter_project.controller;

import java.util.List;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import ch.wiss.m450.starter_project.model.Item;
import ch.wiss.m450.starter_project.repository.ItemRepository;
import ch.wiss.m450.starter_project.service.ItemService;

public class ItemControllerTest {

    @Test
    void getItems_returnsItems() {

        // Mocks
        ItemService service = mock(ItemService.class);

        Item item = new Item("Apple");
        when(service.sortItems(any())).thenReturn(List.of(item));

        // Controller mit gemocktem Service
        ItemController controller = new ItemController(null, service);

        Iterable<Item> result = controller.getItems();

        // JUnit Assertion
        assertEquals("Apple", result.iterator().next().getName());
    }

    @Test
    void addItem_savesItem() {

        ItemService service = mock(ItemService.class);

        ItemController controller = new ItemController(null, service);

        controller.addItem(new Item("Banana"));

        // Prüft, dass Service.addItem aufgerufen wurde
        verify(service).addItem(any(Item.class));
    }

    @Test
    void deleteItem_callsDelete() {

        ItemService service = mock(ItemService.class);

        ItemController controller = new ItemController(null, service);

        controller.deleteItem(1);

        // Prüft, dass Service.deleteItem aufgerufen wurde
        verify(service).deleteItem(1);
    }
}