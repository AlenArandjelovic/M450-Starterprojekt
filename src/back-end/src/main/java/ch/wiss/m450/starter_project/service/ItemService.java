package ch.wiss.m450.starter_project.service;

import java.util.Comparator;
import java.util.List;

import org.springframework.stereotype.Service;

import ch.wiss.m450.starter_project.model.Item;
import ch.wiss.m450.starter_project.model.ItemStatus;
import ch.wiss.m450.starter_project.repository.ItemRepository;

@Service
public class ItemService {

    private final ItemRepository repo;

    public ItemService(ItemRepository repo) {
        this.repo = repo;
    }

    // Items sortieren: offene Items zuerst, nach Deadline, dann CLOSED nach hinten
    public List<Item> sortItems(List<Item> items) {
        return items.stream()
                .sorted(Comparator
                        .comparing((Item i) -> i.getStatus() == ItemStatus.CLOSED)
                        .thenComparing(Item::getDeadline, Comparator.nullsLast(Comparator.naturalOrder()))
                )
                .toList();
    }

    // Item hinzufügen
    public Item addItem(Item item) {
        if (item.getStatus() == null) {
            item.setStatus(ItemStatus.OPEN);
        }
        return repo.save(item);
    }

    // Item löschen
    public void deleteItem(int id) {
        repo.deleteById(id);
    }
}