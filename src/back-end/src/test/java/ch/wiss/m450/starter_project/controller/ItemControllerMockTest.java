package ch.wiss.m450.starter_project.controller;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Captor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.verifyNoInteractions;
import static org.mockito.Mockito.when;
import org.mockito.Spy;
import org.mockito.junit.jupiter.MockitoExtension;

import ch.wiss.m450.starter_project.model.Item;
import ch.wiss.m450.starter_project.repository.ItemRepository;

@ExtendWith(MockitoExtension.class)
public class ItemControllerMockTest {

    // 1. Repository wird gemockt
    @Mock
    private ItemRepository repo;

    // 2. Controller bekommt automatisch das Mock-Repository
    @InjectMocks
    private ItemController controller;

    // 3. Captor um übergebene Items abzufangen
    @Captor
    private ArgumentCaptor<Item> itemCaptor;

    // 4. Spy Beispiel (ein echtes Objekt, das man überwachen kann)
    @Spy
    private Item spyItem = new Item("Cherry");

    // --------------------
    // Mock Test 1: getItems
    // --------------------
    @Test
    void getItems_returnsItems() {
        Item item = new Item("Apple");
        when(repo.findAll()).thenReturn(List.of(item));

        Iterable<Item> result = controller.getItems();

        assertEquals("Apple", result.iterator().next().getName());
        verify(repo).findAll(); // prüft, dass findAll aufgerufen wurde
    }

    // --------------------
    // Mock Test 2: addItem
    // --------------------
    @Test
    void addItem_callsSave() {
        controller.addItem("Banana");

        // prüft, welches Item an save übergeben wurde
        verify(repo).save(itemCaptor.capture());
        assertEquals("Banana", itemCaptor.getValue().getName());
    }

    // --------------------
    // Mock Test 3: deleteItem
    // --------------------
    @Test
    void deleteItem_callsDelete() {
        controller.deleteItem(1);

        verify(repo).deleteById(1); // prüft, dass deleteById aufgerufen wurde
    }

    // --------------------
    // Mock Test 4: Spy Beispiel
    // --------------------
    @Test
    void spyItem_example() {
        spyItem.setName("Cherry Updated");

        assertEquals("Cherry Updated", spyItem.getName()); // Spy überwacht echtes Objekt
        verifyNoInteractions(repo); // Repo wird nicht verwendet
    }
}