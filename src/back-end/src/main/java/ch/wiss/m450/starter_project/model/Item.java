package ch.wiss.m450.starter_project.model;

import java.time.LocalDateTime;

import com.fasterxml.jackson.annotation.JsonFormat;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "item")
public class Item {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String name;

    private ItemStatus status;

    @JsonFormat(pattern="yyyy-MM-dd'T'HH:mm:ss")
    private LocalDateTime deadline;
    // Standard-Konstruktor
    public Item() { }

    // Konstruktor mit Name
    public Item(String itemName) {
        this.name = itemName;
        this.status = ItemStatus.OPEN; // default Status
    }

    // Getter & Setter
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

    public ItemStatus getStatus() {
        return status;
    }

    public void setStatus(ItemStatus status) {
        this.status = status;
    }

    public LocalDateTime getDeadline() {
        return deadline;
    }

    public void setDeadline(LocalDateTime deadline) {
        this.deadline = deadline;
    }

    // Prüft, ob Item überfällig ist
    public boolean isOverdue() {
        return deadline != null 
            && deadline.isBefore(LocalDateTime.now()) 
            && status != ItemStatus.CLOSED;
    }
}