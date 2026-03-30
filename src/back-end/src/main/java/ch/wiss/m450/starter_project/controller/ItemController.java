package ch.wiss.m450.starter_project.controller;

import java.util.List;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ch.wiss.m450.starter_project.model.Item;
import ch.wiss.m450.starter_project.repository.ItemRepository;
import ch.wiss.m450.starter_project.service.ItemService;

@RestController
@CrossOrigin("http://localhost:5173")
@RequestMapping("/items")
public class ItemController {

    private final ItemRepository itemRepository;

    // Constructor Injection (SonarQube-konform)
    private final ItemService itemService;

    public ItemController(ItemRepository itemRepository, ItemService itemService) {
        this.itemRepository = itemRepository;
        this.itemService = itemService;
    }

    // Optional: Getter für Tests (falls benötigt)
    public ItemRepository getItemRepository() {
        return itemRepository;
    }

    @GetMapping
    public Iterable<Item> getItems() {
        List<Item> items = (List<Item>) itemRepository.findAll();
        return itemService.sortItems(items);
    }
    /*
     * @GetMapping
     * public Iterable<Item> getItems() {
     * return itemRepository.findAll();
     * }
     */

    @PostMapping("/{itemName}")
    public void addItem(@PathVariable String itemName) {
        Item newItem = new Item(itemName);
        itemRepository.save(newItem);
    }

    @DeleteMapping("/{itemId}")
    public void deleteItem(@PathVariable int itemId) {
        itemRepository.deleteById(itemId);
    }
}
