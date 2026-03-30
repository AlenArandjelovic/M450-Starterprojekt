package ch.wiss.m450.starter_project.model;

import java.time.LocalDateTime;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
//import java.time.LocalDateTime;
@Entity
@Table(name = "item")
public class Item {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String name;
    private ItemStatus status;
    private LocalDateTime deadline;

    public Item(){ }

    public Item(String itemName) {
        this.name = itemName;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ItemStatus getStatus(){
        return status;
    }

    public LocalDateTime getDeadline() {
    return deadline;
    }

    public void setDeadline(LocalDateTime deadline) {
    this.deadline = deadline;
}
    public boolean isOverdue() {
    return deadline != null 
        && deadline.isBefore(LocalDateTime.now()) 
        && status != ItemStatus.CLOSED;
    }

    public void setStatus(ItemStatus status) {
    this.status = status;
}
}