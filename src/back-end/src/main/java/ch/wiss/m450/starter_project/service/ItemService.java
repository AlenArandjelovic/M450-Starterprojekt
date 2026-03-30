package ch.wiss.m450.starter_project.service;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import ch.wiss.m450.starter_project.model.Item;

@Service
public class ItemService {

    public List<Item> sortItems(List<Item> items) {
        return items.stream()
                .sorted(Comparator.comparing(Item::getDeadline,
                        Comparator.nullsLast(Comparator.naturalOrder())))
                .collect(Collectors.toList());
    }
}