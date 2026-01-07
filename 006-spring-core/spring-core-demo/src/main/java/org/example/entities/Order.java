package org.example.entities;

import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;

@Data
public class Order {
    @Value("20")
    private int id;

    private Account buyer;

    // Autowired annotation will automatically inject the value where it's needed:
    @Autowired
    private Item item;

    public Order() {
    }

    public Order(int id, Account buyer, Item item) {
        this.id = id;
        this.buyer = buyer;
        this.item = item;
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Account getBuyer() {
        return buyer;
    }

    // Autowire the setter to inject the field for Account
    // @Qualifier - used to specify the id of the bean we want to inject here:
    // For this account, we can configure it in the beans.xml and specify that
    // we want to use that bean here:
    @Autowired
    public void setBuyer(@Qualifier("account1") Account buyer) {
        this.buyer = buyer;
    }

    public Item getItem() {
        return item;
    }

    public void setItem(Item item) {
        this.item = item;
    }
}
