package ch.wiss.m450.starter_project.controller;

import java.util.List;

import org.junit.jupiter.api.Test;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import ch.wiss.m450.starter_project.model.Item;
import ch.wiss.m450.starter_project.repository.ItemRepository;

public class ItemControllerTest {

    @Test
    void getItems_returnsItems() {

        ItemRepository repo = mock(ItemRepository.class);

        Item item = new Item("Apple");

        when(repo.findAll()).thenReturn(List.of(item));

        ItemController controller = new ItemController();
        
        // Repository setzen
        controller._itemRepository = repo;

        Iterable<Item> result = controller.getItems();

        assert(result.iterator().next().getName().equals("Apple"));
    }

    @Test
    void addItem_savesItem() {

    ItemRepository repo = mock(ItemRepository.class);

    ItemController controller = new ItemController();
    controller._itemRepository = repo;

    controller.addItem("Banana");

    verify(repo).save(any(Item.class));
    }

    @Test
    void deleteItem_callsDelete() {

    ItemRepository repo = mock(ItemRepository.class);

    ItemController controller = new ItemController();
    controller._itemRepository = repo;

    controller.deleteItem(1);

    verify(repo).deleteById(1);
}
}
