package ch.wiss.m450.starter_project.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ch.wiss.m450.starter_project.model.Item;
import ch.wiss.m450.starter_project.repository.ItemRepository;

@RestController
@RequestMapping("/items")
@CrossOrigin
public class ItemController {
    @Autowired
<<<<<<< HEAD
    public ItemRepository _itemRepository;
=======
    private ItemRepository _itemRepository;
>>>>>>> 3a2eecc674a9e861161d8497deb71f70308d697b

    @GetMapping
    public Iterable<Item> getItems() {
        return _itemRepository.findAll();
    }

    @PostMapping("/{itemName}")
    public void addItem(@PathVariable String itemName) {
        Item newItem = new Item(itemName);
        _itemRepository.save(newItem);
    }

    @DeleteMapping("/{itemId}")
    public void deleteItem(@PathVariable int itemId) {
        _itemRepository.deleteById(itemId);
    }
}
