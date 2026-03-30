package ch.wiss.m450.starter_project.controller;

import java.util.List;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
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
    private final ItemService itemService;

    public ItemController(ItemRepository itemRepository, ItemService itemService) {
        this.itemRepository = itemRepository;
        this.itemService = itemService;
    }

    @GetMapping
    public List<Item> getItems() {
        List<Item> items = (List<Item>) itemRepository.findAll();
        return itemService.sortItems(items);
    }

    // Neues Item hinzufügen (JSON Body: { "name": "Banana", "deadline": "2026-03-31T12:00" })
    @PostMapping
    public Item addItem(@RequestBody Item item) {
        return itemService.addItem(item);
    }

    @DeleteMapping("/{itemId}")
    public void deleteItem(@PathVariable int itemId) {
        itemService.deleteItem(itemId);
    }
}