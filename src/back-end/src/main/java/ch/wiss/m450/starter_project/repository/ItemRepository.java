package ch.wiss.m450.starter_project.repository;

import org.springframework.data.repository.CrudRepository;

import ch.wiss.m450.starter_project.model.Item;

public interface ItemRepository extends CrudRepository<Item, Integer> {

}
